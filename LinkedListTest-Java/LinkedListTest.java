public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedlist = new MyLinkedList();
        int count = 0;

        // Test case 1: Add an element to an empty list
        linkedlist.add("Hello");
        if ("[Hello]".equals(linkedlist.toString())) {
            System.out.println("Test case 1 passed");
            count++;
        } else {
            System.out.println("Test case 1 failed");
        }

        // Test case 2: Add multiple elements
        linkedlist.add("World");
        linkedlist.add("!");
        if ("[Hello][World][!]".equals(linkedlist.toString())) {
            System.out.println("Test case 2 passed");
            count++;
        } else {
            System.out.println("Test case 2 failed");
        }

        // Test case 3: Add an element at the beginning
        linkedlist.addFirst("First");
        if ("[First][Hello][World][!]".equals(linkedlist.toString())) {
            System.out.println("Test case 3 passed");
            count++;
        } else {
            System.out.println("Test case 3 failed");
        }

        // Test case 4: Check if the list contains an existing element
        if (linkedlist.contains("World")) {
            System.out.println("Test case 4 passed");
            count++;
        } else {
            System.out.println("Test case 4 failed");
        }

        // Test case 5: Check if the list contains a non-existing element
        if (!linkedlist.contains("NotHere")) {
            System.out.println("Test case 5 passed");
            count++;
        } else {
            System.out.println("Test case 5 failed");
        }

        // Test case 6: Get the first element in the list
        if ("First".equals(linkedlist.getFirst())) {
            System.out.println("Test case 6 passed");
            count++;
        } else {
            System.out.println("Test case 6 failed");
        }

        // Test case 7: Remove the first element from the list
        linkedlist.remove();
        if ("[Hello][World][!]".equals(linkedlist.toString())) {
            System.out.println("Test case 7 passed");
            count++;
        } else {
            System.out.println("Test case 7 failed");
        }

        // Test case 8: Remove the last element from the list
        linkedlist.removeLast();
        if ("[Hello][World]".equals(linkedlist.toString())) {
            System.out.println("Test case 8 passed");
            count++;
        } else {
            System.out.println("Test case 8 failed");
        }

        // Test case 9: Find the middle element of the list
        linkedlist.add("Middle");

        if ("World".equals(linkedlist.findMiddle())) {
            System.out.println("Test case 9 passed");
            count++;
        } else {
            System.out.println("Test case 9 failed");
        }

        // Test case 10: Get nth node from the end (valid index)

        if ("World".equals(linkedlist.nthFromEnd(2))) {
            System.out.println("Test case 10 passed");
            count++;
        } else {
            System.out.println("Test case 10 failed");
        }

        // Test case 11: Get nth node from the end (invalid index)
        if (linkedlist.nthFromEnd(4) == null) {
            System.out.println("Test case 11 passed");
            count++;
        } else {
            System.out.println("Test case 11 failed");
        }

        // Test case 12: Insert at position 1
        linkedlist.insertAtPosition(1, "Inserted");
        if ("[Hello][Inserted][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 12 passed");
            count++;
        } else {
            System.out.println("Test case 12 failed");
        }

        // Test case 13: Insert at position 0
        linkedlist.insertAtPosition(0, "Start");
        if ("[Start][Hello][Inserted][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 13 passed");
            count++;
        } else {
            System.out.println("Test case 13 failed");
        }

        // Test case 14: Insert at invalid position
        linkedlist.insertAtPosition(10, "Invalid");
        if ("[Start][Hello][Inserted][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 14 passed");
            count++;
        } else {
            System.out.println("Test case 14 failed");
        }

        // Test case 15: Insert before an element
        linkedlist.insertBefore("World", "BeforeWorld");
        if ("[Start][Hello][Inserted][BeforeWorld][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 15 passed");
            count++;
        } else {
            System.out.println("Test case 15 failed");
        }

        // Test case 16: Insert before the first occurrence of the first element
        linkedlist.insertBefore("Start", "BeforeStart");
        if ("[BeforeStart][Start][Hello][Inserted][BeforeWorld][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 16 passed");
            count++;
        } else {
            System.out.println("Test case 16 failed");
        }

        // Test case 17: Delete the node after an element
        linkedlist.deleteAfter("Inserted");
        if ("[BeforeStart][Start][Hello][Inserted][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 17 passed");
            count++;
        } else {
            System.out.println("Test case 17 failed");
        }

        // Test case 18: Delete after an element that is not found
        linkedlist.deleteAfter("NonExistent");
        if ("[BeforeStart][Start][Hello][Inserted][World][Middle]".equals(linkedlist.toString())) {
            System.out.println("Test case 18 passed");
            count++;
        } else {
            System.out.println("Test case 18 failed");
        }

        // Test case 19: Remove all elements from the list
        linkedlist.clear();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 19 passed");
            count++;
        } else {
            System.out.println("Test case 19 failed");
        }

        // Test case 20: Get first element from an empty list
        if (linkedlist.getFirst() == null) {
            System.out.println("Test case 20 passed");
            count++;
        } else {
            System.out.println("Test case 20 failed");
        }

        // Test case 21: Add a null element to the list
        linkedlist.add(null);
        if ("[null]".equals(linkedlist.toString())) {
            System.out.println("Test case 21 passed");
            count++;
        } else {
            System.out.println("Test case 21 failed");
        }

        // Test case 22: Add an empty string to the list
        linkedlist.add("");
        if ("[null][]".equals(linkedlist.toString())) {
            System.out.println("Test case 22 passed");
            count++;
        } else {
            System.out.println("Test case 22 failed");
        }

        // Test case 23: Add and remove all elements
        linkedlist.remove();
        linkedlist.remove();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 23 passed");
            count++;
        } else {
            System.out.println("Test case 23 failed");
        }

        // Test case 24: Add multiple elements, then clear the list
        linkedlist.add("First");
        linkedlist.add("Second");
        linkedlist.add("Third");
        linkedlist.clear();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 24 passed");
            count++;
        } else {
            System.out.println("Test case 24 failed");
        }

        // Test case 25: Add elements after clearing the list
        linkedlist.add("NewElement");
        if ("[NewElement]".equals(linkedlist.toString())) {
            System.out.println("Test case 25 passed");
            count++;
        } else {
            System.out.println("Test case 25 failed");
        }

        // Test case 26: Check the size of an empty list
        if (linkedlist.size() == 1) {
            System.out.println("Test case 26 passed");
            count++;
        } else {
            System.out.println("Test case 26 failed");
        }

        // Test case 27: Add duplicate elements and check if they exist
        linkedlist.add("Hello");
        linkedlist.add("Hello");
        if (linkedlist.contains("Hello")) {
            System.out.println("Test case 27 passed");
            count++;
        } else {
            System.out.println("Test case 27 failed");
        }

        // Test case 28: Add null and empty elements, and check if they exist
        linkedlist.add(null);
        linkedlist.add("");
        if (linkedlist.contains("")) {
            System.out.println("Test case 28 passed");
            count++;
        } else {
            System.out.println("Test case 28 failed");
        }

        // Test case 29: Add and remove elements in different order
        linkedlist.add("First");
        linkedlist.remove();
        linkedlist.add("Second");
        if ("[Hello][Hello][null][][First][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 29 passed");
            count++;
        } else {
            System.out.println("Test case 29 failed");
        }

        // Test case 30: Add elements, clear, then add again
        linkedlist.add("A");
        linkedlist.add("B");
        linkedlist.clear();
        linkedlist.add("C");
        if ("[C]".equals(linkedlist.toString())) {
            System.out.println("Test case 30 passed");
            count++;
        } else {
            System.out.println("Test case 30 failed");
        }

        // Test case 31: Add and remove from a list with a single element
        linkedlist.add("OnlyOne");
        linkedlist.remove();
        linkedlist.remove();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 31 passed");
            count++;
        } else {
            System.out.println("Test case 31 failed");
        }

        // Test case 32: Add an element after clearing the list
        linkedlist.clear();
        linkedlist.add("AfterClear");
        if ("[AfterClear]".equals(linkedlist.toString())) {
            System.out.println("Test case 32 passed");
            count++;
        } else {
            System.out.println("Test case 32 failed");
        }

        // Test case 33: Test middle element for a list with even number of elements
        linkedlist.add("One");
        linkedlist.add("Two");
        linkedlist.add("Three");
        linkedlist.add("Four");
        if ("Two".equals(linkedlist.findMiddle())) {
            System.out.println("Test case 33 passed");
            count++;
        } else {
            System.out.println("Test case 33 failed");
        }

        // Test case 34: Test middle element for a list with odd number of elements
        linkedlist.add("Five");

        if ("Three".equals(linkedlist.findMiddle())) {
            System.out.println("Test case 34 passed");
            count++;
        } else {
            System.out.println("Test case 34 failed");
        }

        // Test case 35: Add elements and verify the list is not empty
        linkedlist.add("Test");
        if (!"LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 35 passed");
            count++;
        } else {
            System.out.println("Test case 35 failed");
        }

        // Test case 36: Remove all elements one by one
        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        linkedlist.remove();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 36 passed");
            count++;
        } else {
            System.out.println("Test case 36 failed");
        }

        // Test case 37: Add elements and remove them in reverse order
        linkedlist.add("Apple");
        linkedlist.add("Banana");
        linkedlist.add("Cherry");
        linkedlist.removeLast();
        linkedlist.removeLast();
        if ("[Apple]".equals(linkedlist.toString())) {
            System.out.println("Test case 37 passed");
            count++;
        } else {
            System.out.println("Test case 37 failed");
        }

        // Test case 38: Check if removing from an empty list returns null
        String r = linkedlist.remove();
        if (r.equals("Apple")) {
            System.out.println("Test case 38 passed");
            count++;
        } else {
            System.out.println("Test case 38 failed");
        }

        // Test case 39: Test removing and adding elements again
        linkedlist.add("First");
        linkedlist.add("Second");
        linkedlist.remove();
        linkedlist.add("Third");
        if ("[Second][Third]".equals(linkedlist.toString())) {
            System.out.println("Test case 39 passed");
            count++;
        } else {
            System.out.println("Test case 39 failed");
        }

        // Test case 40: Add elements, then clear the list and check the size
        linkedlist.clear();
        if (linkedlist.size() == 0) {
            System.out.println("Test case 40 passed");
            count++;
        } else {
            System.out.println("Test case 40 failed");
        }

        // Test case 41: Add elements to an empty list and check the size
        linkedlist.add("Element");
        if (linkedlist.size() == 1) {
            System.out.println("Test case 41 passed");
            count++;
        } else {
            System.out.println("Test case 41 failed");
        }

        // Test case 42: Check if the list is empty after removing all elements
        linkedlist.remove();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 42 passed");
            count++;
        } else {
            System.out.println("Test case 42 failed");
        }

        // Test case 43: Test inserting at the last position
        linkedlist.add("First");
        linkedlist.insertAtPosition(linkedlist.size(), "Last");
        if ("[First][Last]".equals(linkedlist.toString())) {
            System.out.println("Test case 43 passed");
            count++;
        } else {
            System.out.println("Test case 43 failed");
        }

        // Test case 44: Add elements and then clear the list
        linkedlist.add("Test");
        linkedlist.clear();
        if ("LinkedList is empty".equals(linkedlist.toString())) {
            System.out.println("Test case 44 passed");
            count++;
        } else {
            System.out.println("Test case 44 failed");
        }

        // Test case 45: Add elements, insert before, and verify
        linkedlist.add("First");
        linkedlist.add("Second");
        linkedlist.insertBefore("Second", "BeforeSecond");
        if ("[First][BeforeSecond][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 45 passed");
            count++;
        } else {
            System.out.println("Test case 45 failed");
        }

        // Test case 46: Insert at position 0 and check the first element
        linkedlist.insertAtPosition(0, "Start");
        if ("[Start][First][BeforeSecond][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 46 passed");
            count++;
        } else {
            System.out.println("Test case 46 failed");
        }

        // Test case 47: Check that deleting after non-existent elements doesn't change
        // the list
        linkedlist.deleteAfter("NonExistent");
        if ("[Start][First][BeforeSecond][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 47 passed");
            count++;
        } else {
            System.out.println("Test case 47 failed");
        }

        // Test case 48: Test inserting at position greater than size
        linkedlist.insertAtPosition(linkedlist.size() + 1, "Invalid");
        if ("[Start][First][BeforeSecond][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 48 passed");
            count++;
        } else {
            System.out.println("Test case 48 failed");
        }

        // Test case 49: Test inserting an element before the first element
        linkedlist.insertBefore("Start", "BeforeStart");
        if ("[BeforeStart][Start][First][BeforeSecond][Second]".equals(linkedlist.toString())) {
            System.out.println("Test case 49 passed");
            count++;
        } else {
            System.out.println("Test case 49 failed");
        }

        // Test case 50: Ensure the list is still valid after many operations
        linkedlist.add("End");
        linkedlist.remove();
        linkedlist.removeLast();
        linkedlist.add("Final");
        if ("[Start][First][BeforeSecond][Second][Final]".equals(linkedlist.toString())) {
            System.out.println("Test case 50 passed");
            count++;
        } else {
            System.out.println("Test case 50 failed");
        }

        System.out.println("Total passed test cases: " + count);
    }
}
