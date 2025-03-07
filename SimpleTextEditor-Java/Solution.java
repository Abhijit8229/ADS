// Package name
class Command {
    // Todo

    String operation;
    int index;
    String text;

    public Command(String operation, int index, String text) {
        this.operation = operation;
        this.index = index;
        this.text = text;
    }
}

// Node class for the custom linked list
class HistoryNode {
    // Todo
    Command value;
    HistoryNode prev;
    HistoryNode next;

    public HistoryNode(Command value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}

// Custom linked list that simulates a last-in-first-out history
class OperationHistory {
    // Todo
    HistoryNode head;
    HistoryNode tail;
    int size;
    // Constructor

    public OperationHistory() {
        // Todo
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Adds an operation record to the history (at the beginning of the list)
    public void addOperation(Command command) {
        // Todo
        HistoryNode newNode = new HistoryNode(command);
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
    // Returns the most recent operation record without removing it.
    // Returns null if the history is empty.

    // Removes and returns the most recent operation record.
    // Returns null if the history is empty.
    public Command removeLastOperation() {
        if (this.head == null) {
            return null;
        }
        HistoryNode value = this.head;
        HistoryNode temp = this.head.next;

        this.head = temp;
        this.size--;
        return value.value;

    }

    // Clears the history.
    public void clear() {
        // Todo
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    // Checks if the history is empty.
    public boolean isEmpty() {
        // Todo
        return this.size == 0 && head == null;
    }

    public String toString() {

        if (this.head == null) {
            return "DoublyLinkedList is empty";
        }
        HistoryNode temp = this.head;
        String s = "";
        while (temp.next != null) {
            System.out.println(7878);
            s += "[" + temp.value.operation + " | " + temp.value.text + " | " + temp.value.index + "]<->";
            System.out.println(s);
            temp = temp.next;
        }
        return s + "[" + temp.value.operation + " | " + temp.value.text + " | " + temp.value.index + "]";

    }
}

class TextEditor {
    // Todo
    StringBuilder text;
    OperationHistory undHistory;
    OperationHistory redoHistory;

    public TextEditor() {
        // Todo
        this.text = new StringBuilder();
        this.undHistory = new OperationHistory();
        this.redoHistory = new OperationHistory();
    }

    /**
     * Inserts newText at the specified index.
     * Returns true if successful, false if the index is invalid.
     */
    public boolean insert(int index, String newText) {
        if (index < 0 || index > text.length()) {
            System.out.println("Invalid index for insert");
            return false;
        }
        undHistory.addOperation(new Command("insert", index, newText));
        text.insert(index, newText);
        redoHistory.clear();
        return true;

    }

    /**
     * Deletes 'length' characters starting at index.
     * Returns true if successful, false if index or length are invalid.
     */
    public boolean delete(int index, int length) {
        // Todo
        if (index < 0 || length > text.length()) {
            System.out.println("Invalid index or length for delete");
            return false;
        }
        // Save the deleted text in the undo history
        undHistory.addOperation(new Command("delete", index, text.substring(index, index + length)));
        text.delete(index, index + length);
        return true;
    }

    /**
     * Undoes the most recent operation.
     * Returns true if successful, false if there is nothing to undo.
     */
    public boolean undo() {
        // Todo
        Command lastOperation = undHistory.removeLastOperation();
        if (lastOperation == null) {
            System.out.println("Nothing to undo");
            return false;
        }
        redoHistory.addOperation(lastOperation);
        if (lastOperation.operation.equals("insert")) {
            int index = lastOperation.index;
            String textToRemove = lastOperation.text;
            text.delete(index, index + textToRemove.length());
        } else if (lastOperation.operation.equals("delete")) {
            int index = lastOperation.index;
            String textToInsert = lastOperation.text;

            text.insert(index, textToInsert);
        }
        return true;
    }

    /**
     * Redoes the most recently undone operation.
     * Returns true if successful, false if there is nothing to redo.
     */
    public boolean redo() {
        // Todo
        Command lastOperation = redoHistory.removeLastOperation();
        if (lastOperation == null) {
            System.out.println("Nothing to redo");
            return false;
        }
        // undHistory.addOperation(lastOperation);
        // System.out.println(lastOperation.operation);
        if (lastOperation.operation.equals("insert")) {
            int index = lastOperation.index;
            String textToInsert = lastOperation.text;
            text.insert(index, textToInsert);
        } else if (lastOperation.operation.equals("delete")) {
            int index = lastOperation.index;
            String textToRemove = lastOperation.text;
            text.delete(index, index + textToRemove.length());
        }
        return true;

    }

    /**
     * H
     * Returns the current text buffer.
     */
    public String getText() {
        return text.toString();
    }
}

public class Solution {
    public static void main(String[] args) {

    }
}
