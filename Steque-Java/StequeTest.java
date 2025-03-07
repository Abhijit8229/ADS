
public class StequeTest {
    // Main method for testing all steque methods.
    public static void main(String[] args) {
        Steque steque = new Steque();
        int count = 0;

        // Test case 1: push one element.
        steque.push("A");
        if (steque.toString().equals("[A]") && steque.size() == 1) {
            System.out.println("Test case 1 passed");
            count++;
        } else {
            System.out.println("Test case 1 failed");
        }

        // Test case 2: push another element.
        steque.push("B");
        if (steque.toString().equals("[B][A]") && steque.size() == 2) {
            System.out.println("Test case 2 passed");
            count++;
        } else {
            System.out.println("Test case 2 failed");
        }

        // Test case 3: enqueue element.
        steque.enqueue("C");
        if (steque.toString().equals("[B][A][C]") && steque.size() == 3) {
            System.out.println("Test case 3 passed");
            count++;
        } else {
            System.out.println("Test case 3 failed");
        }

        // Test case 4: pop element.
        String popped = steque.pop();
        if (popped.equals("B") && steque.toString().equals("[A][C]") && steque.size() == 2) {
            System.out.println("Test case 4 passed");
            count++;
        } else {
            System.out.println("Test case 4 failed");
        }

        // Test case 5: pop again.
        popped = steque.pop();
        if (popped.equals("A") && steque.toString().equals("[C]") && steque.size() == 1) {
            System.out.println("Test case 5 passed");
            count++;
        } else {
            System.out.println("Test case 5 failed");
        }

        // Test case 6: pop last element.
        popped = steque.pop();
        if (popped.equals("C") && steque.toString().equals("Steque is empty") && steque.size() == 0) {
            System.out.println("Test case 6 passed");
            count++;
        } else {
            System.out.println("Test case 6 failed");
        }

        // Test case 7: enqueue and push mix.
        steque.enqueue("D"); // steque: [D]
        steque.push("E");    // steque: [E][D]
        steque.enqueue("F"); // steque: [E][D][F]
        if (steque.toString().equals("[E][D][F]") && steque.size() == 3) {
            System.out.println("Test case 7 passed");
            count++;
        } else {
            System.out.println("Test case 7 failed");
        }

        System.out.println("Total testcases passed: " + count);
    }
}

