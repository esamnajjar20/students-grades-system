import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {
    private StudentManager manager = new StudentManager();
    private ObservableList<Student> tableData = FXCollections.observableArrayList();
    private TextField idField = new TextField();
    private TextField nameField = new TextField();
    private TextField gradeField = new TextField();
    private TextField freqField = new TextField();
    
    private Label countLabel = new Label("0");
    private Label avgLabel = new Label("0.0");
    private Label highLabel = new Label("-");
    private Label lowLabel = new Label("-");
    private Label freqResult = new Label("-");
    
    private TableView<Student> table = new TableView<>();
    private BarChart<String, Number> chart;

    @Override
    public void start(Stage stage) {
        idField.setPromptText("ID"); 
        nameField.setPromptText("Name"); 
        gradeField.setPromptText("Grade");
        
        Button addBtn = new Button("Add"); 
        Button searchBtn = new Button("Search");
        Button removeBtn = new Button("Remove"); 
        Button clearBtn = new Button("Clear");

        addBtn.setOnAction(e -> handleAdd()); 
        searchBtn.setOnAction(e -> handleSearch());
        removeBtn.setOnAction(e -> handleRemove()); 
        clearBtn.setOnAction(e -> clearFields());

        HBox inputRow = new HBox(8, idField, nameField, gradeField, addBtn, searchBtn, removeBtn, clearBtn);
        inputRow.setPadding(new Insets(10));

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, Integer> gradeCol = new TableColumn<>("Grade");
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        table.getColumns().addAll(idCol, nameCol, gradeCol);
        table.setItems(tableData);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        GridPane stats = new GridPane();
        stats.setHgap(10); stats.setVgap(5); stats.setPadding(new Insets(10));
        stats.add(new Label("Total:"), 0, 0); stats.add(countLabel, 1, 0);
        stats.add(new Label("Avg:"), 2, 0); stats.add(avgLabel, 3, 0);
        stats.add(new Label("High:"), 0, 1); stats.add(highLabel, 1, 1);
        stats.add(new Label("Low:"), 2, 1); stats.add(lowLabel, 3, 1);

        freqField.setPromptText("Grade");
        Button freqBtn = new Button("Bag Check");
        freqBtn.setOnAction(e -> {
            try {
                int g = Integer.parseInt(freqField.getText().trim());
                freqResult.setText("Freq: " + manager.getFrequency(g) + ", Exists: " + manager.containsGrade(g));
            } catch (Exception ex) { showAlert("Error", "Enter valid grade"); }
        });
        HBox freqRow = new HBox(8, new Label("Check:"), freqField, freqBtn, freqResult);
        freqRow.setPadding(new Insets(10));

        CategoryAxis xAxis = new CategoryAxis(); NumberAxis yAxis = new NumberAxis();
        chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Grade Distribution"); chart.setLegendVisible(false);

        VBox rightPanel = new VBox(10, stats, freqRow, chart);
        rightPanel.setPadding(new Insets(10)); rightPanel.setPrefWidth(450);

        BorderPane root = new BorderPane();
        root.setTop(inputRow); root.setCenter(table); root.setRight(rightPanel);

        stage.setTitle("Student Grades System");
        stage.setScene(new Scene(root, 1050, 600));
        stage.show();
        refreshAll();
    }

    private void handleAdd() {
        String idText = idField.getText().trim(); 
        String name = nameField.getText().trim(); 
        String gradeText = gradeField.getText().trim();
        if (idText.isEmpty() || name.isEmpty() || gradeText.isEmpty()) { 
            showAlert("Error", "All fields required"); return; 
        }
        try {
            int id = Integer.parseInt(idText); 
            int grade = Integer.parseInt(gradeText);
            String err = manager.addStudent(id, name, grade);
            if (err != null) { showAlert("Error", err); return; }
            clearFields(); refreshAll();
        } catch (Exception e) { showAlert("Error", "ID and Grade must be numbers"); }
    }

    private void handleSearch() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            Student s = manager.searchById(id);
            if (s == null) { showAlert("Info", "Not found"); return; }
            nameField.setText(s.getName()); 
            gradeField.setText(String.valueOf(s.getGrade()));
        } catch (Exception e) { showAlert("Error", "Invalid ID"); }
    }

    private void handleRemove() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            if (manager.removeById(id)) { clearFields(); refreshAll(); }
            else { showAlert("Info", "Not found"); }
        } catch (Exception e) { showAlert("Error", "Invalid ID"); }
    }

    private void clearFields() { 
        idField.clear(); nameField.clear(); gradeField.clear(); 
    }

    private void refreshAll() {
        tableData.clear();
        for (int i = 0; i < manager.getCount(); i++) {
            tableData.add(new Student(manager.getIds()[i], manager.getNames()[i], manager.getGrades()[i]));
        }
        countLabel.setText(String.valueOf(manager.getCount()));
        avgLabel.setText(String.format("%.2f", manager.getAverage()));
        highLabel.setText(manager.getHighest() < 0 ? "-" : String.valueOf(manager.getHighest()));
        lowLabel.setText(manager.getLowest() < 0 ? "-" : String.valueOf(manager.getLowest()));

        chart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        String[] cats = {"Fail", "Pass", "Good", "V.Good", "Excellent"};
        for (int i = 0; i < 5; i++) {
            series.getData().add(new XYChart.Data<>(cats[i], manager.getCategoryCount(i)));
        }
        chart.getData().add(series);
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title); 
        a.setHeaderText(null); 
        a.setContentText(msg); 
        a.showAndWait();
    }
    
    public static void main(String[] args) { 
        launch(args); 
    }
}
