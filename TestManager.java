public class TestManager {
    public static void main(String[] args) {
        testAddAndValidation();
        testSearchAndRemove();
        testStatsAndBag();
    }

    static void testAddAndValidation() {
        System.out.println("--- Test Add & Validation ---");
        StudentManager m = new StudentManager();
        System.out.println("Add valid: " + m.addStudent(1, "Ali", 85));
        System.out.println("Add duplicate: " + m.addStudent(1, "Sara", 90));
        System.out.println("Add grade 150: " + m.addStudent(2, "Omar", 150));
        System.out.println("Count after add: " + m.getCount()); // 1
    }

    static void testSearchAndRemove() {
        System.out.println("\n--- Test Search & Remove ---");
        StudentManager m = new StudentManager();
        m.addStudent(1, "Ali", 85);
        m.addStudent(2, "Sara", 72);
        
        Student s = m.searchById(2);
        System.out.println("Search 2: " + s.getName() + " (" + s.getGrade() + ")");
        
        System.out.println("Remove 2: " + m.removeById(2));
        System.out.println("Search 2 after remove: " + m.searchById(2));
        System.out.println("Count after remove: " + m.getCount()); // 1
    }

    static void testStatsAndBag() {
        System.out.println("\n--- Test Stats, Categories & Bag ---");
        StudentManager m = new StudentManager();
        m.addStudent(1, "Ali", 85);   // Very Good
        m.addStudent(2, "Sara", 72);  // Good
        m.addStudent(3, "Omar", 55);  // Fail
        m.addStudent(4, "Layla", 85); // Very Good
        m.addStudent(5, "Sami", 95);  // Excellent

        System.out.println("Average: " + m.getAverage());
        System.out.println("Highest: " + m.getHighest());
        System.out.println("Lowest: " + m.getLowest());

        System.out.println("Fail Count (0): " + m.getCategoryCount(0));
        System.out.println("Pass Count (1): " + m.getCategoryCount(1));
        System.out.println("Good Count (2): " + m.getCategoryCount(2));
        System.out.println("V.Good Count (3): " + m.getCategoryCount(3));
        System.out.println("Excellent Count (4): " + m.getCategoryCount(4));

        System.out.println("Frequency of 85: " + m.getFrequency(85));
        System.out.println("Contains 72: " + m.containsGrade(72));
        System.out.println("Contains 100: " + m.containsGrade(100));

        m.removeById(1); 
        System.out.println("V.Good Count after removing Ali: " + m.getCategoryCount(3));
        System.out.println("Frequency of 85 after remove: " + m.getFrequency(85));
    }
}
