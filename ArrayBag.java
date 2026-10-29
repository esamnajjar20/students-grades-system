public class ArrayBag<T> {
    private T[] items;      // مصفوفة عادية لتخزين العناصر
    private int count;      // عدد العناصر الحالي

    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        items = (T[]) new Object[capacity];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
