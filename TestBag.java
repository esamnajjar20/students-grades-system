public class TestBag {
    public static void main(String[] args) {
        testSizeAndIsEmpty();
        testAdd();
        testContains();
        testFrequencyOf();
        testRemove();
        System.out.println("=== All tests done ===");
    }

    static void testSizeAndIsEmpty() {
        ArrayBag<Integer> bag = new ArrayBag<>(5);
        System.out.println("size: " + bag.size());
        System.out.println("isEmpty: " + bag.isEmpty());
    }

    static void testAdd() {
        ArrayBag<Integer> bag = new ArrayBag<>(3);
        bag.add(10);
        bag.add(20);
        bag.add(30);
        System.out.println("size: " + bag.size());
        bag.add(40);
        System.out.println("size: " + bag.size());
    }

    static void testContains() {
        ArrayBag<Integer> bag = new ArrayBag<>(5);
        bag.add(10);
        bag.add(20);
        bag.add(30);
        System.out.println("contains 20: " + bag.contains(20));
        System.out.println("contains 99: " + bag.contains(99));
    }

    static void testFrequencyOf() {
        ArrayBag<Integer> bag = new ArrayBag<>(10);
        bag.add(85);
        bag.add(90);
        bag.add(85);
        bag.add(70);
        bag.add(85);
        System.out.println("freq 85: " + bag.frequencyOf(85));
        System.out.println("freq 90: " + bag.frequencyOf(90));
        System.out.println("freq 100: " + bag.frequencyOf(100));
    }

    static void testRemove() {
        ArrayBag<Integer> bag = new ArrayBag<>(10);
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(2);
        System.out.println("remove 2: " + bag.remove(2));
        System.out.println("size: " + bag.size());
        System.out.println("freq 2: " + bag.frequencyOf(2));
        System.out.println("remove 99: " + bag.remove(99));
        System.out.println("size: " + bag.size());
    }
}
