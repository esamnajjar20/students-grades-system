public class StudentManager {
    private static final int MAX = 100;

    private int[] ids;
    private String[] names;
    private int[] grades;
    private int count;

    public StudentManager() {
        ids = new int[MAX];
        names = new String[MAX];
        grades = new int[MAX];
        count = 0;
    }

    public String addStudent(int id, String name, int grade) {
        if (grade < 0 || grade > 100) {
            return "Grade must be between 0 and 100";
        }
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) {
                return "Student ID already exists";
            }
        }
        if (count == MAX) {
            return "Storage is full";
        }

        ids[count] = id;
        names[count] = name;
        grades[count] = grade;
        count++;
        return null;
    }

    public int getCount() { return count; }
}
