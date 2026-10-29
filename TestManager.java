public class TestManager {
    public static void main(String[] args) {
        testInitialState();
        System.out.println("=== All manager tests done ===");
    }

    static void testInitialState() {
        StudentManager m = new StudentManager();
        System.out.println("count: " + m.getCount());
    }
}
