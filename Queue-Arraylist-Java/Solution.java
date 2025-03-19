import java.util.Arrays;
import java.util.NoSuchElementException;

class ArrayListADT<T> {
    private Object[] data;
    private int size;

    public ArrayListADT() {
        this.data = new Object[10];
        this.size = 0;
    }

    private void resizeIfNeeded() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public void add(T value) {
        resizeIfNeeded();
        data[size++] = value;
    }

    public void addAt(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        resizeIfNeeded();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            data = Arrays.copyOf(data, capacity);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removed;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = element;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}

class MyQueue<T> {
    private ArrayListADT<T> list;
    private int size;

    public MyQueue(int size) {
        this.list = new ArrayListADT<>();
        this.size = size;
    }

    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeAt(0);
    }

    public T element() throws NoSuchElementException {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0);
    }

    public boolean add(T value) throws IllegalStateException {
        if (list.size() == size) {
            throw new IllegalStateException("Queue is full");
        }
        list.add(value);
        return true;
    }

    public T remove() throws NoSuchElementException {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeAt(0);
    }

    public boolean offer(T value) {
        if (list.size() == size) {
            return false;
        }
        list.add(value);
        return true;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}