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
                for (int j = i; j < count - 1; j++) {
                    ids[j] = ids[j + 1];
                    names[j] = names[j + 1];
                    grades[j] = grades[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public int getCount() { return count; }
}
