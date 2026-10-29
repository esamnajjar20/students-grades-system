public class StudentManager {
    private static final int MAX = 100;
    private static final int NUM_CATEGORIES = 5;

    private int[] ids;
    private String[] names;
    private int[] grades;
    private int[][] categories;
    private int count;
    private ArrayBag<Integer> gradeBag;

    public StudentManager() {
        ids = new int[MAX];
        names = new String[MAX];
        grades = new int[MAX];
        categories = new int[2][NUM_CATEGORIES];
        count = 0;
        gradeBag = new ArrayBag<>(MAX);
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
        
        gradeBag.add(grade);
        computeCategories();
        return null;
    }

    public Student searchById(int id) {
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) {
                return new Student(ids[i], names[i], grades[i]);
            }
        }
        return null;
    }

    public boolean removeById(int id) {
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) {
                int removedGrade = grades[i];
                for (int j = i; j < count - 1; j++) {
                    ids[j] = ids[j + 1];
                    names[j] = names[j + 1];
                    grades[j] = grades[j + 1];
                }
                count--;
                
                gradeBag.remove(removedGrade);
                computeCategories();
                return true;
            }
        }
        return false;
    }

    public double getAverage() {
        if (count == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < count; i++) sum += grades[i];
        return (double) sum / count;
    }

    public int getHighest() {
        if (count == 0) return -1;
        int max = grades[0];
        for (int i = 1; i < count; i++) if (grades[i] > max) max = grades[i];
        return max;
    }

    public int getLowest() {
        if (count == 0) return -1;
        int min = grades[0];
        for (int i = 1; i < count; i++) if (grades[i] < min) min = grades[i];
        return min;
    }

    public void computeCategories() {
        for (int c = 0; c < NUM_CATEGORIES; c++) categories[1][c] = 0;
        for (int i = 0; i < count; i++) {
            int cat = getCategoryIndex(grades[i]);
            categories[1][cat]++;
        }
    }

    public int getCategoryIndex(int grade) {
        if (grade < 60) return 0;
        if (grade < 70) return 1;
        if (grade < 80) return 2;
        if (grade < 90) return 3;
        return 4;
    }

    public int getCategoryCount(int index) {
        return categories[1][index];
    }

    public int getFrequency(int grade) {
        return gradeBag.frequencyOf(grade);
    }

    public boolean containsGrade(int grade) {
        return gradeBag.contains(grade);
    }

    public int getCount() { return count; }
    public int[] getIds() { return ids; }
    public String[] getNames() { return names; }
    public int[] getGrades() { return grades; }
}
