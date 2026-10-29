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

    public boolean contains(T item) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int frequencyOf(T item) {
        int freq = 0;
        for (int i = 0; i < count; i++) {
            if (items[i].equals(item)) {
                freq++;
            }
        }
        return freq;
    }

    public boolean remove(T item) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(item)) {
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
