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

    public int getCount() { return count; }
}
