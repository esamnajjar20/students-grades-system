public class TestManager {
    public static void main(String[] args) {
        testInitialState();
        testAddStudent();
        testSearch();
        testRemove();
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
        System.out.println("count: " + m.getCount());
    }

    static void testSearch() {
        StudentManager m = new StudentManager();
        m.addStudent(1, "Ali", 85);
        m.addStudent(2, "Sara", 72);
        Student s1 = m.searchById(2);
        System.out.println("search 2: " + s1.getName() + " (" + s1.getGrade() + ")");
        Student s2 = m.searchById(999);
        System.out.println("search 999: " + s2);
    }

    static void testRemove() {
        StudentManager m = new StudentManager();
        m.addStudent(1, "Ali", 85);
        m.addStudent(2, "Sara", 72);
        m.addStudent(3, "Omar", 55);
        System.out.println("remove 2: " + m.removeById(2));
        System.out.println("count: " + m.getCount());
        System.out.println("search 2 after remove: " + m.searchById(2));
        System.out.println("search 3 still there: " + m.searchById(3).getName());
        System.out.println("remove 999: " + m.removeById(999));
        System.out.println("count: " + m.getCount());
    }
}
