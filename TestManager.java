public class TestManager {
    public static void main(String[] args) {
        testInitialState();
        testAddStudent();
        System.out.println("=== All manager tests done ===");
    }

    static void testInitialState() {
        StudentManager m = new StudentManager();
        System.out.println("count: " + m.getCount());
    }

    static void testAddStudent() {
        StudentManager m = new StudentManager();

        System.out.println("add valid: " + m.addStudent(1, "Ali", 85));
        System.out.println("count: " + m.getCount());

        System.out.println("add duplicate: " + m.addStudent(1, "X", 50));
        System.out.println("add grade 150: " + m.addStudent(2, "Y", 150));
        System.out.println("add grade -5: " + m.addStudent(2, "Y", -5));

        System.out.println("count: " + m.getCount());
    }
}
