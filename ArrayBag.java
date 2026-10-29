public class ArrayBag<T> {
    private T[] items;
    private int count;

    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        items = (T[]) new Object[capacity];
        count = 0;
    }

    public void add(T item) {
        if (count == items.length) {
            System.out.println("Bag is full");
            return;
        }
        items[count] = item;
        count++;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
