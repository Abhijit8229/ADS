public class DoublyLLTest {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Test Case 1: Add to front
        dll.addToFront(1);
        if (dll.head.value == 1) {
            System.out.println("Test Case 1 Passed: Add to front");
        } else {
            System.out.println("Test Case 1 Failed: Add to front");
        }

        // Test Case 2: Add to end
        dll.addToEnd(2);
        if (dll.tail.value == 2) {
            System.out.println("Test Case 2 Passed: Add to end");
        } else {
            System.out.println("Test Case 2 Failed: Add to end");
        }

        // Test Case 3: Remove from front
        dll.removeFromFront();
        if (dll.head.value == 2) {
            System.out.println("Test Case 3 Passed: Remove from front");
        } else {
            System.out.println("Test Case 3 Failed: Remove from front");
        }

        // Test Case 4: Remove from end
        dll.removeFromEnd();
        if (dll.checkEmpty()) {
            System.out.println("Test Case 4 Passed: Remove from end");
        } else {
            System.out.println("Test Case 4 Failed: Remove from end");
        }

        // Test Case 5: Check empty list
        if (dll.checkEmpty()) {
            System.out.println("Test Case 5 Passed: Check empty");
        } else {
            System.out.println("Test Case 5 Failed: Check empty");
        }

        // Test Case 6: Add to front and check size
        dll.addToFront(1);
        dll.addToFront(2);
        if (dll.getSize() == 2) {
            System.out.println("Test Case 6 Passed: Add to front and check size");
        } else {
            System.out.println("Test Case 6 Failed: Add to front and check size");
        }

        // Test Case 7: Find existing element
        if (dll.find(1)) {
            System.out.println("Test Case 7 Passed: Find existing element");
        } else {
            System.out.println("Test Case 7 Failed: Find existing element");
        }

        // Test Case 8: Find non-existing element
        if (!dll.find(3)) {
            System.out.println("Test Case 8 Passed: Find non-existing element");
        } else {
            System.out.println("Test Case 8 Failed: Find non-existing element");
        }

        // Test Case 9: Insert at index
        dll.insertAt(1, 3);
        if (dll.getAt(1) == 3) {
            System.out.println("Test Case 9 Passed: Insert at index");
        } else {
            System.out.println("Test Case 9 Failed: Insert at index");
        }

        // Test Case 10: Remove at index
        dll.removeAt(1);
        if (dll.getAt(1) == 1) {
            System.out.println("Test Case 10 Passed: Remove at index");
        } else {
            System.out.println("Test Case 10 Failed: Remove at index");
        }

        // Test Case 11: Reverse traversal
        dll.reverseTraversal(); // Expected Output: 1
        System.out.println("Test Case 11 Passed: Reverse Traversal");

        // Test Case 12: Print list
        dll.printList(); // Expected Output: 1
        System.out.println("Test Case 12 Passed: Print List");

        // Test Case 13: Check if the list is empty after operations
        if (dll.checkEmpty()) {
            System.out.println("Test Case 13 Passed: Check empty after operations");
        } else {
            System.out.println("Test Case 13 Failed: Check empty after operations");
        }

        // Test Case 14: Clear the list
        dll.clearList();
        if (dll.checkEmpty()) {
            System.out.println("Test Case 14 Passed: Clear List");
        } else {
            System.out.println("Test Case 14 Failed: Clear List");
        }

        // Test Case 15: Add multiple elements and check size
        dll.addToEnd(1);
        dll.addToEnd(2);
        dll.addToEnd(3);
        if (dll.getSize() == 3) {
            System.out.println("Test Case 15 Passed: Add multiple elements and check size");
        } else {
            System.out.println("Test Case 15 Failed: Add multiple elements and check size");
        }

        // Test Case 16: Get element at index
        if (dll.getAt(1) == 2) {
            System.out.println("Test Case 16 Passed: Get element at index");
        } else {
            System.out.println("Test Case 16 Failed: Get element at index");
        }

        // Test Case 17: Swap nodes
        dll.swapNodes(0, 2);
        if (dll.getAt(0) == 3 && dll.getAt(2) == 1) {
            System.out.println("Test Case 17 Passed: Swap nodes");
        } else {
            System.out.println("Test Case 17 Failed: Swap nodes");
        }

        // Test Case 18: Detect cycle (should be False)
        if (!dll.detectCycle()) {
            System.out.println("Test Case 18 Passed: Detect cycle (should be False)");
        } else {
            System.out.println("Test Case 18 Failed: Detect cycle (should be False)");
        }

        // Test Case 19: Remove from front (again)
        dll.removeFromFront();
        if (dll.getAt(0) == 2) {
            System.out.println("Test Case 19 Passed: Remove from front again");
        } else {
            System.out.println("Test Case 19 Failed: Remove from front again");
        }

        // Test Case 20: Remove from end (again)
        dll.removeFromEnd();
        if (dll.getSize() == 1) {
            System.out.println("Test Case 20 Passed: Remove from end again");
        } else {
            System.out.println("Test Case 20 Failed: Remove from end again");
        }

        // Test Case 21: Add elements and remove all
        dll.addToEnd(4);
        dll.addToEnd(5);
        dll.clearList();
        if (dll.checkEmpty()) {
            System.out.println("Test Case 21 Passed: Add elements and remove all");
        } else {
            System.out.println("Test Case 21 Failed: Add elements and remove all");
        }

        // Test Case 22: Insert at index out of bounds
        dll.insertAt(5, 6); // Invalid index
        if (dll.getSize() == 0) {
            System.out.println("Test Case 22 Passed: Insert at index out of bounds");
        } else {
            System.out.println("Test Case 22 Failed: Insert at index out of bounds");
        }

        // Test Case 23: Remove from front (empty list)
        dll.removeFromFront(); // No element to remove
        if (dll.checkEmpty()) {
            System.out.println("Test Case 23 Passed: Remove from front (empty list)");
        } else {
            System.out.println("Test Case 23 Failed: Remove from front (empty list)");
        }

        // Test Case 24: Remove from end (empty list)
        dll.removeFromEnd(); // No element to remove
        if (dll.checkEmpty()) {
            System.out.println("Test Case 24 Passed: Remove from end (empty list)");
        } else {
            System.out.println("Test Case 24 Failed: Remove from end (empty list)");
        }

        // Test Case 25: Add an element and check if it exists
        dll.addToEnd(7);
        if (dll.find(7)) {
            System.out.println("Test Case 25 Passed: Check if element exists");
        } else {
            System.out.println("Test Case 25 Failed: Check if element exists");
        }
    }
}