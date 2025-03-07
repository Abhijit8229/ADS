class node<T> {
    T value;
    node<T> prev;
    node<T> next;

    public node(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    node<Integer> head;
    node<Integer> tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToEnd(Integer value) {
        node<Integer> newNode = new node<Integer>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public void addToFront(Integer value) {
        node<Integer> newNode = new node<Integer>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertAt(int index, Integer value) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addToFront(value);
            return;
        }
        if (index == size) {
            addToEnd(value);
            return;
        }
        node<Integer> temp = this.head;
        node<Integer> newnode = new node<Integer>(value);

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newnode.next = temp.next;
        newnode.prev = temp;
        temp.next = newnode;
        size++;
    }

    public boolean find(Integer value) {
        node<Integer> temp = this.head;
        while (temp != null) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Integer getFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.value;
    }

    public Integer getLast() {
        if (this.head == null) {
            return null;
        }
        return this.tail.value;
    }

    public int getSize() {
        return this.size;
    }

    public boolean checkEmpty() {
        // System.out.println(7878 + " " + this.size);
        return this.size == 0 && head == null;
    }

    public Integer removeFromFront() {
        if (this.head == null) {
            return null;
        }
        node<Integer> value = this.head;
        node<Integer> temp = this.head.next;

        this.head = temp;
        this.size--;
        return value.value;
    }

    public Integer removeFromEnd() {
        if (this.head == null) {
            return null;
        }
        node<Integer> temp = this.tail.prev;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return temp.value;
        }
        Integer value = temp.next.value;
        temp.next = null;
        this.tail = temp;
        this.size--;
        return value;

    }

    public Integer removeAt(int index) {
        node<Integer> temp = this.tail.prev;
        if (size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return temp.value;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Integer tp = temp.next.value;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return tp;
    }

    public void clearList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Integer getAt(int index) {

        node<Integer> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void reverseTraversal() {
        node<Integer> temp = tail;
        while (temp != null) {
            System.out.printf("%s ", temp.value);
            temp = temp.prev;
        }

        System.out.println();
    }

    public void swapNodes(int index1, int index2) {

        if (index1 == index2)
            return;

        node<Integer> first = head, second = head;
        int count1 = 0, count2 = 0;

        while (first != null && count1 < index1) {
            first = first.next;
            count1++;
        }

        while (second != null && count2 < index2) {
            second = second.next;
            count2++;
        }

        if (first == null || second == null)
            return;

        int temp = first.value;
        first.value = second.value;
        second.value = temp;

    }

    public boolean detectCycle() {
        node<Integer> slow = head;
        node<Integer> fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            if (fast == slow)
                return true;
            slow = slow.next;
        }
        return false;
    }

    public void printList() {
        node<Integer> temp = head;
        while (temp != null) {
            System.out.printf("%s ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public String toString() {
        if (this.head == null) {
            return "DoublyLinkedList is empty";
        }
        node<Integer> temp = this.head;
        String s = "";
        while (temp.next != null) {
            System.out.println(7878);
            s += "[" + temp.value + "]<->";
            System.out.println(s);
            temp = temp.next;
        }
        return s + "[" + temp.value + "]";
    }

}