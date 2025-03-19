import java.util.EmptyStackException;

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

    public Node<T> getHead() {
        return head;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
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
        return (size == 0) ? null : head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T item) {
        if (size == capacity) {
            return true;
        }
        Node<T> newNode = new Node<>(item);
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

        return add(item);

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

    public T element() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return head.data;
    }

    public T remove() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return poll();
    }

    public T removeLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
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
        tail = temp;
        temp.next = null;
        size--;
        return value;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Queue is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp.next != null) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.append(temp.data);
        return sb.toString();
    }
}

class MyStack {
    private MyQueue<String> queue1;
    private MyQueue<String> queue2;

    public MyStack() {
        queue1 = new MyQueue<>(10);
        queue2 = new MyQueue<>(10);
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public String push(String item) {
        if (queue1.isEmpty()) {
            queue1.add(item);
        } else {
            while (queue1.size() > 0) {
                queue2.add(queue1.poll());
            }
            queue1.add(item);
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }
        return peek();
    }

    public String pop() throws EmptyStackException {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue1.poll();
    }

    public String peek() throws EmptyStackException {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue1.peek();
    }

    public int search(String item) {
        if (queue1.isEmpty()) {
            return -1;
        }
        Node<String> temp = queue1.getHead();
        int index = 1;
        while (temp != null) {
            if (temp.data.equals(item)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return queue1.toString();
    }

    public int length() {
        return queue1.size();
    }
}