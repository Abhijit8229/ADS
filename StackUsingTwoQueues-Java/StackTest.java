import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackTest {
    // Main method with 25 test cases.
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        int passed = 0;
        int failed = 0;
        
        // Test 1: Stack is empty after creation.
        if (stack.empty()) {
            System.out.println("Test 1 passed");
            passed++;
        } else {
            System.out.println("Test 1 failed: Stack should be empty");
            failed++;
        }
        
        // Test 2: Peek on empty stack should throw exception.
        try {
            stack.peek();
            System.out.println("Test 2 failed: peek() on empty stack did not throw exception");
            failed++;
        } catch (EmptyStackException e) {
            System.out.println("Test 2 passed: peek() threw exception as expected");
            passed++;
        }
        
        // Test 3: Pop on empty stack should throw exception.
        try {
            stack.pop();
            System.out.println("Test 3 failed: pop() on empty stack did not throw exception");
            failed++;
        } catch (EmptyStackException e) {
            System.out.println("Test 3 passed: pop() threw exception as expected");
            passed++;
        }
        
        // Test 4: Push element "A", then check stack is not empty.
        stack.push("A");
        if (!stack.empty()) {
            System.out.println("Test 4 passed: Stack is not empty after push");
            passed++;
        } else {
            System.out.println("Test 4 failed: Stack is empty after push");
            failed++;
        }
        
        // Test 5: Peek should return "A".
        if (stack.peek().equals("A")) {
            System.out.println("Test 5 passed: peek() returned A");
            passed++;
        } else {
            System.out.println("Test 5 failed: peek() did not return A");
            failed++;
        }
        
        // Test 6: Search for "A" should return 1.
        if (stack.search("A") == 1) {
            System.out.println("Test 6 passed: search(A) returned 1");
            passed++;
        } else {
            System.out.println("Test 6 failed: search(A) did not return 1");
            failed++;
        }
        
        // Test 7: Push element "B".
        stack.push("B");
        if (stack.peek().equals("B")) {
            System.out.println("Test 7 passed: After push(B), peek() returned B");
            passed++;
        } else {
            System.out.println("Test 7 failed: After push(B), peek() did not return B");
            failed++;
        }
        
        // Test 8: Search for "B" should return 1.
        if (stack.search("B") == 1) {
            System.out.println("Test 8 passed: search(B) returned 1");
            passed++;
        } else {
            System.out.println("Test 8 failed: search(B) did not return 1");
            failed++;
        }
        
        // Test 9: Search for "A" should return 2.
        if (stack.search("A") == 2) {
            System.out.println("Test 9 passed: search(A) returned 2");
            passed++;
        } else {
            System.out.println("Test 9 failed: search(A) did not return 2");
            failed++;
        }
        
        // Test 10: Push element "C".
        stack.push("C");
        if (stack.peek().equals("C")) {
            System.out.println("Test 10 passed: After push(C), peek() returned C");
            passed++;
        } else {
            System.out.println("Test 10 failed: After push(C), peek() did not return C");
            failed++;
        }
        
        // Test 11: Search for "C" should return 1.
        if (stack.search("C") == 1) {
            System.out.println("Test 11 passed: search(C) returned 1");
            passed++;
        } else {
            System.out.println("Test 11 failed: search(C) did not return 1");
            failed++;
        }
        
        // Test 12: Pop should return "C".
        if (stack.pop().equals("C")) {
            System.out.println("Test 12 passed: pop() returned C");
            passed++;
        } else {
            System.out.println("Test 12 failed: pop() did not return C");
            failed++;
        }
        
        // Test 13: After pop, peek should return "B".
        if (stack.peek().equals("B")) {
            System.out.println("Test 13 passed: After pop(), peek() returned B");
            passed++;
        } else {
            System.out.println("Test 13 failed: After pop(), peek() did not return B");
            failed++;
        }
        
        // Test 14: Pop should return "B".
        if (stack.pop().equals("B")) {
            System.out.println("Test 14 passed: pop() returned B");
            passed++;
        } else {
            System.out.println("Test 14 failed: pop() did not return B");
            failed++;
        }
        
        // Test 15: Pop should return "A".
        if (stack.pop().equals("A")) {
            System.out.println("Test 15 passed: pop() returned A");
            passed++;
        } else {
            System.out.println("Test 15 failed: pop() did not return A");
            failed++;
        }
        
        // Test 16: Stack should be empty now.
        if (stack.empty()) {
            System.out.println("Test 16 passed: Stack is empty after popping all elements");
            passed++;
        } else {
            System.out.println("Test 16 failed: Stack is not empty after popping all elements");
            failed++;
        }
        
        // Test 17: Search for non-existent element "Z" should return -1.
        if (stack.search("Z") == -1) {
            System.out.println("Test 17 passed: search(Z) returned -1");
            passed++;
        } else {
            System.out.println("Test 17 failed: search(Z) did not return -1");
            failed++;
        }
        
        // Test 18: Push multiple elements and check search positions.
        stack.push("X");
        stack.push("Y");
        stack.push("Z");
        if (stack.search("Z") == 1 && stack.search("Y") == 2 && stack.search("X") == 3) {
            System.out.println("Test 18 passed: search positions correct after multiple pushes");
            passed++;
        } else {
            System.out.println("Test 18 failed: search positions incorrect after multiple pushes");
            failed++;
        }
        
        // Test 19: Pop one element and check new top.
        if (stack.pop().equals("Z") && stack.peek().equals("Y")) {
            System.out.println("Test 19 passed: pop and peek worked correctly");
            passed++;
        } else {
            System.out.println("Test 19 failed: pop and peek did not work as expected");
            failed++;
        }
        
        // Test 20: Push duplicate element "Y" and check search returns topmost occurrence.
        stack.push("Y");
        if (stack.search("Y") == 1) {
            System.out.println("Test 20 passed: search returned 1 for the topmost duplicate Y");
            passed++;
        } else {
            System.out.println("Test 20 failed: search did not return correct position for duplicate Y");
            failed++;
        }
        
        // Test 21: Pop and verify duplicate element behavior.
        if (stack.pop().equals("Y") && stack.peek().equals("Y")) {
            System.out.println("Test 21 passed: duplicate Y handling is correct after pop");
            passed++;
        } else {
            System.out.println("Test 21 failed: duplicate Y handling failed after pop");
            failed++;
        }
        
        // Test 22: Push element "M" and check push returns "M".
        if (stack.push("M").equals("M")) {
            System.out.println("Test 22 passed: push() returned M correctly");
            passed++;
        } else {
            System.out.println("Test 22 failed: push() did not return M");
            failed++;
        }
        
        // Test 23: Verify peek returns "M".
        if (stack.peek().equals("M")) {
            System.out.println("Test 23 passed: peek() returned M");
            passed++;
        } else {
            System.out.println("Test 23 failed: peek() did not return M");
            failed++;
        }
        
        // Test 24: Check empty() returns true for newly emptied stack.
        stack.pop(); // pops M
        stack.pop(); // pops M
        stack.pop(); // pops M
        if (stack.empty()) {
            System.out.println("Test 24 passed: empty() returned true for cleared stack");
            passed++;
        } else {
            System.out.println("Test 24 failed: empty() did not return true for cleared stack");
            failed++;
        }


        // Test 25: Clear stack and check multiple pops throwing exception.
        try {
            stack.pop(); // pops M
            stack.pop(); // pops M
            System.out.println("Test 25 failed: pop() did not throw exception on empty stack after clearing");
            failed++;
        } catch (EmptyStackException e) {
            System.out.println("Test 25 passed: pop() threw exception on empty stack after clearing");
            passed++;
        }
        

        
        System.out.println("Total tests passed: " + passed);
        System.out.println("Total tests failed: " + failed);
    }
}
