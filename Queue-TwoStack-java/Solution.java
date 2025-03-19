import java.util.*;

interface ListADT<T> {
    void add(T value);

    void addAt(int index, T value);

    void addAllAt(int index, Collection<T> collection);

    void addAll(Collection<T> collection);

    boolean contains(T value);

    T get(int index);

    int indexOf(T element);

    int lastIndexOf(T element);

    void ensureCapacity(int capacity);

    boolean isEmpty();

    int size();

    void clear();

    T removeAt(int index);

    T remove(T element);

    T set(int index, T element);

    void trimToSize();

    String toString();
}

class ArrayListADT<T> implements ListADT<T> {
    private List<T> data;
    private int size;

    public ArrayListADT() {
        this.data = new ArrayList<>();
        this.size = 0;
    }

    private void fixSize() {
        List<T> newData = new ArrayList<>();
        for (T item : data) {
            if (item != null) {
                newData.add(item);
            }
        }
        data = newData;
        size = data.size();
    }

    public void add(T value) {
        fixSize();
        data.add(value);
        size = data.size();
    }

    public void addAt(int index, T value) {
        fixSize();
        data.add(index, value);
        size = data.size();
    }

    public void addAllAt(int index, Collection<T> collection) {
        fixSize();
        for (T item : collection) {
            addAt(index++, item);
        }
        size = data.size();
    }

    public void addAll(Collection<T> collection) {
        addAllAt(data.size(), collection);
    }

    public boolean contains(T value) {
        return data.contains(value);
    }

    public T get(int index) {
        return data.get(index);
    }

    public int indexOf(T element) {
        return data.indexOf(element);
    }

    public int lastIndexOf(T element) {
        return data.lastIndexOf(element);
    }

    public void ensureCapacity(int capacity) {
        ((ArrayList<T>) data).ensureCapacity(capacity);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public void clear() {
        data.clear();
        size = 0;
    }

    public T removeAt(int index) {
        if (index >= 0 && index < data.size()) {
            T removed = data.remove(index);
            size = data.size();
            return removed;
        }
        return null;
    }

    public T remove(T element) {
        int index = indexOf(element);
        return (index != -1) ? removeAt(index) : null;
    }

    public T set(int index, T element) {
        return data.set(index, element);
    }

    public void trimToSize() {
        fixSize();
    }

    public String toString() {
        return data.toString();
    }
}

class Stack<T> {
    private ArrayListADT<T> stack;

    public Stack() {
        stack = new ArrayListADT<>();
    }

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {
        if (stack.isEmpty())
            throw new EmptyStackException();
        return stack.removeAt(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty())
            throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public int search(T value) {
        int index = stack.indexOf(value);
        return (index != -1) ? stack.size() - index : -1;
    }

    public int size() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}

class FullQueueException extends RuntimeException {
    public FullQueueException(String message) {
        super(message);
    }
}

class MyQueue<T> {
    private Stack<T> st1;
    private Stack<T> st2;
    private int size;

    public MyQueue(int size) {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
        this.size = size;
    }

    public T peek() {
        if (st2.empty())
            return null;
        return st2.peek();
    }

    public T poll() {
        if (st1.empty() && st2.empty())
            return null;
        if (st2.empty())
            transfer();
        return st2.pop();
    }

    public T element() {
        if (st1.empty() && st2.empty())
            throw new NoSuchElementException();
        if (st2.empty())
            transfer();
        return st2.peek();
    }

    public T remove() {
        if (st1.empty() && st2.empty())
            throw new NoSuchElementException();
        if (st2.empty())
            transfer();
        return st2.pop();
    }

    public boolean add(T value) {
        if (st1.size() + st2.size() == size)
            throw new IllegalStateException("Queue is full");
        st1.push(value);
        return true;
    }

    public boolean offer(T value) {
        if (st1.size() + st2.size() == size)
            return false;
        st1.push(value);
        return true;
    }

    private void transfer() {
        while (!st1.empty()) {
            st2.push(st1.pop());
        }
    }
}
