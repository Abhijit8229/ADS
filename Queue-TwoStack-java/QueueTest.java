import java.util.NoSuchElementException;

public class QueueTest {
    // Main method with 25 test cases
    public static void main(String[] args) {
        int testsPassed = 0;
        int testsFailed = 0;
        MyQueue<String> queue = new MyQueue<>(3);

        // Test 1: peek() on empty queue returns null.
        if (queue.peek() == null) {
            System.out.println("Test 1 passed");
            testsPassed++;
        } else {
            System.out.println("Test 1 failed: peek on empty queue should return null");
            testsFailed++;
        }

        // Test 2: poll() on empty queue returns null.
        if (queue.poll() == null) {
            System.out.println("Test 2 passed");
            testsPassed++;
        } else {
            System.out.println("Test 2 failed: poll on empty queue should return null");
            testsFailed++;
        }

        // Test 3: element() on empty queue throws exception.
        try {
            queue.element();
            System.out.println("Test 3 failed: element() should throw exception on empty queue");
            testsFailed++;
        } catch (NoSuchElementException e) {
            System.out.println("Test 3 passed: element() threw exception on empty queue");
            testsPassed++;
        }

        // Test 4: remove() on empty queue throws exception.
        try {
            queue.remove();
            System.out.println("Test 4 failed: remove() should throw exception on empty queue");
            testsFailed++;
        } catch (NoSuchElementException e) {
            System.out.println("Test 4 passed: remove() threw exception on empty queue");
            testsPassed++;
        }

        // Test 5: add() element "A", should return true.
        try {
            if (queue.add("A")) {
                System.out.println("Test 5 passed: add() returned true for element A");
                testsPassed++;
            } else {
                System.out.println("Test 5 failed: add() did not return true for element A");
                testsFailed++;
            }
        } catch (Exception ex) {
            System.out.println("Test 5 failed: add() threw an exception for element A");
            testsFailed++;
        }

        // Test 6: element() returns head "A".
        if (queue.element().equals("A")) {
            System.out.println("Test 6 passed: element() returned A");
            testsPassed++;
        } else {
            System.out.println("Test 6 failed: element() did not return A");
            testsFailed++;
        }

        // Test 7: peek() returns head "A".
        if (queue.peek().equals("A")) {
            System.out.println("Test 7 passed: peek() returned A");
            testsPassed++;
        } else {
            System.out.println("Test 7 failed: peek() did not return A");
            testsFailed++;
        }

        // Test 8: offer() should add "B" and return true.
        if (queue.offer("B")) {
            System.out.println("Test 8 passed: offer() returned true for element B");
            testsPassed++;
        } else {
            System.out.println("Test 8 failed: offer() did not return true for element B");
            testsFailed++;
        }

        // Test 9: offer() should add "C" and return true.
        if (queue.offer("C")) {
            System.out.println("Test 9 passed: offer() returned true for element C");
            testsPassed++;
        } else {
            System.out.println("Test 9 failed: offer() did not return true for element C");
            testsFailed++;
        }

        // Queue is now full.
        // Test 10: add() should throw exception when queue is full.
        try {
            queue.add("D");
            System.out.println("Test 10 failed: add() should throw exception when queue is full");
            testsFailed++;
        } catch (IllegalStateException ex) {
            System.out.println("Test 10 passed: add() threw exception when queue is full");
            testsPassed++;
        }

        // Test 11: offer() should return false when queue is full.
        if (!queue.offer("D")) {
            System.out.println("Test 11 passed: offer() returned false when queue is full");
            testsPassed++;
        } else {
            System.out.println("Test 11 failed: offer() did not return false when queue is full");
            testsFailed++;
        }

        // Test 12: element() should still return "A".
        if (queue.element().equals("A")) {
            System.out.println("Test 12 passed: element() still returned A");
            testsPassed++;
        } else {
            System.out.println("Test 12 failed: element() did not return A");
            testsFailed++;
        }

        // Test 13: remove() should remove and return "A".
        if (queue.remove().equals("A")) {
            System.out.println("Test 13 passed: remove() returned A");
            testsPassed++;
        } else {
            System.out.println("Test 13 failed: remove() did not return A");
            testsFailed++;
        }

        // Test 14: poll() should remove and return "B".
        if (queue.poll().equals("B")) {
            System.out.println("Test 14 passed: poll() returned B");
            testsPassed++;
        } else {
            System.out.println("Test 14 failed: poll() did not return B");
            testsFailed++;
        }

        // Test 15: Now queue should have one element "C". Check element().
        if (queue.element().equals("C")) {
            System.out.println("Test 15 passed: element() returned C");
            testsPassed++;
        } else {
            System.out.println("Test 15 failed: element() did not return C");
            testsFailed++;
        }

        // Test 16: remove() should remove and return "C".
        if (queue.remove().equals("C")) {
            System.out.println("Test 16 passed: remove() returned C");
            testsPassed++;
        } else {
            System.out.println("Test 16 failed: remove() did not return C");
            testsFailed++;
        }

        // Queue is empty now.
        // Test 17: peek() on empty queue returns null.
        if (queue.peek() == null) {
            System.out.println("Test 17 passed: peek() returned null on empty queue");
            testsPassed++;
        } else {
            System.out.println("Test 17 failed: peek() did not return null on empty queue");
            testsFailed++;
        }

        // Test 18: poll() on empty queue returns null.
        if (queue.poll() == null) {
            System.out.println("Test 18 passed: poll() returned null on empty queue");
            testsPassed++;
        } else {
            System.out.println("Test 18 failed: poll() did not return null on empty queue");
            testsFailed++;
        }

        // Test 19: element() on empty queue throws exception.
        try {
            queue.element();
            System.out.println("Test 19 failed: element() should throw exception on empty queue");
            testsFailed++;
        } catch (NoSuchElementException ex) {
            System.out.println("Test 19 passed: element() threw exception on empty queue");
            testsPassed++;
        }

        // Test 20: remove() on empty queue throws exception.
        try {
            queue.remove();
            System.out.println("Test 20 failed: remove() should throw exception on empty queue");
            testsFailed++;
        } catch (NoSuchElementException ex) {
            System.out.println("Test 20 passed: remove() threw exception on empty queue");
            testsPassed++;
        }

        // Test 21: offer() to add "X" then poll() to remove it.
        if (queue.offer("X")) {
            if (queue.poll().equals("X")) {
                System.out.println("Test 21 passed: offer() and poll() worked correctly for X");
                testsPassed++;
            } else {
                System.out.println("Test 21 failed: poll() did not return X after offer()");
                testsFailed++;
            }
        } else {
            System.out.println("Test 21 failed: offer() did not add element X");
            testsFailed++;
        }

        // Test 22: Add two elements ("Y", "Z") and check order.
        queue.offer("Y");
        queue.offer("Z"); // Queue now: Y, Z.
        if (queue.element().equals("Y") && queue.remove().equals("Y") && queue.element().equals("Z")) {
            System.out.println("Test 22 passed: Queue order maintained correctly");
            testsPassed++;
        } else {
            System.out.println("Test 22 failed: Queue order not maintained correctly");
            testsFailed++;
        }

        // Test 23: Fill queue with capacity 3: add "P", "Q", "R".
        queue = new MyQueue<>(3);
        queue.add("P");
        queue.add("Q");
        queue.add("R");
        try {
            queue.add("S");
            System.out.println("Test 23 failed: add() should throw exception when queue is full");
            testsFailed++;
        } catch (IllegalStateException ex) {
            System.out.println("Test 23 passed: add() threw exception when queue is full");
            testsPassed++;
        }

        // Test 24: offer() should return false when queue is full.
        if (!queue.offer("S")) {
            System.out.println("Test 24 passed: offer() returned false on full queue");
            testsPassed++;
        } else {
            System.out.println("Test 24 failed: offer() did not return false on full queue");
            testsFailed++;
        }

        // Test 25: After removals, verify queue functions correctly.
        queue.remove(); // removes "P"
        queue.remove(); // removes "Q", leaving "R".
        if (queue.peek().equals("R")) {
            System.out.println("Test 25 passed: Queue functions correctly after removals");
            testsPassed++;
        } else {
            System.out.println("Test 25 failed: Queue did not function correctly after removals");
            testsFailed++;
        }

        System.out.println("Total tests passed: " + testsPassed);
        System.out.println("Total tests failed: " + testsFailed);
    }
}