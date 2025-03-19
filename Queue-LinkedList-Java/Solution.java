import java.util.NoSuchElementException;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class FullQueueException extends Exception {
    public FullQueueException(String message) {
        super(message);
    }
}

class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private int capacity;

    public MyQueue(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T item) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean offer(T item) {
        if (size == capacity) {
            return false;
        }
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        T value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T element() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public T remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            T value = head.data;
            head = null;
            tail = null;
            size--;
            return value;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T value = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return value;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Deque is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data).append(temp.next != null ? ", " : "");
            temp = temp.next;
        }
        return sb.toString();
    }
}