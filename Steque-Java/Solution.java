class node<T> {
    T data;
    node<T> next;

    public node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    node<String> head;
    node<String> tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(String data) {
        node<String> newNode = new node<String>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void addFirst(String data) {
        node<String> newNode = new node<String>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public boolean contains(String data) {
        node<String> temp = this.head;
        while (temp != null) {
            if (temp.data == null) {
                temp = temp.next;
            }
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String getFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.data;
    }

    public String getLast() {
        if (this.head == null) {
            return null;
        }
        return this.tail.data;
    }

    public int size() {
        return this.size;
    }

    public String remove() {
        if (this.head == null) {

            return "LinkedList is empty";
        }
        node<String> data = this.head;
        node<String> temp = this.head.next;

        this.head = temp;
        this.size--;
        return data.data;
    }

    public String removeLast() {
        if (this.head == null) {
            return "LinkedList is empty";
        }
        node<String> temp = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return temp.data;
        }
        while (temp.next != this.tail) {
            temp = temp.next;
        }
        String data = temp.next.data;
        temp.next = null;
        this.tail = temp;
        this.size--;
        return data;

    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public String get(int index) {

        node<String> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
        }
        return "";
    }

    public String nthFromEnd(int index) {
        node<String> temp = this.head;
        if (size - index < 0) {
            return null;
        }
        for (int i = 0; i < (this.size - index); i++) {

            temp = temp.next;
        }
        return temp != null ? temp.data : null;
    }

    public String findMiddle() {

        return nthFromEnd(((int) Math.ceil((double) this.size / 2.0)));

    }

    public void insertAtPosition(int index, String s) {
        if (index > this.size) {
            return;
        }
        if (index == 0) {
            addFirst(s);
            return;
        }
        if (index == size) {
            add(s);
            return;
        }
        node<String> temp = this.head;
        node<String> newNode = new node<String>(s);
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;

        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    public void insertBefore(String findval, String setval) {
        node<String> temp = this.head;
        int i = 0;
        while (temp != null) {
            if (temp.data.equals(findval)) {
                insertAtPosition(i, setval);
                return;
            }
            temp = temp.next;
            i++;
        }

    }

    public void deleteAfter(String data) {
        node<String> temp = this.head;
        node<String> tp = null;
        while (temp != null && temp.next != null) {
            if (temp.data.equals(data)) {
                tp = temp.next;
                break;
            }
            temp = temp.next;
        }
        if (tp != null) {
            temp.next = tp.next;
        }

    }

    public String toString() {
        if (this.head == null) {
            return "Steque is empty";
        }
        node<String> temp = this.head;
        String s = "";
        while (temp != null) {

            s += "[" + temp.data + "]";
            temp = temp.next;
        }
        return s;
    }
}

class Steque {
    MyLinkedList list;

    public Steque() {
        this.list = new MyLinkedList();
    }

    public void push(String data) {
        this.list.addFirst(data);
    }

    public void enqueue(String data) {
        this.list.add(data);
    }

    public String pop() {

        return this.list.remove();
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        return this.list.toString();
    }
}