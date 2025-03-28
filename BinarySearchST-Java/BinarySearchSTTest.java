import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class BinarySearchSTTest {

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>();
        if (st.isEmpty()) {
            System.out.println("Symbol table is empty initially. (PASS)");
        } else {
            System.out.println("Symbol table should be empty but is not. (FAIL)");
        }

        if (st.size() == 0) {
            System.out.println("Size is 0 initially. (PASS)");
        } else {
            System.out.println("Size should be 0 but is not. (FAIL)");
        }

        // Insert some values
        st.put(3, "three");
        st.put(1, "one");
        st.put(2, "two");
        st.put(4, "four");

        // Check size
        if (st.size() == 4) {
            System.out.println("Size is 4 after inserts. (PASS)");
        } else {
            System.out.println("Size should be 4 but is not. (FAIL)");
        }

        // Test get
        if ("two".equals(st.get(2))) {
            System.out.println("Value for key 2 is 'two'. (PASS)");
        } else {
            System.out.println("Value for key 2 should be 'two' but is not. (FAIL)");
        }

        // Test update
        st.put(2, "TWO");
        if ("TWO".equals(st.get(2))) {
            System.out.println("Updated value for key 2 is 'TWO'. (PASS)");
        } else {
            System.out.println("Value for key 2 should be 'TWO' but is not. (FAIL)");
        }

        // Test contains
        if (st.contains(3)) {
            System.out.println("Key 3 is in the table. (PASS)");
        } else {
            System.out.println("Key 3 should be in the table but is not. (FAIL)");
        }

        // Test delete
        st.delete(3);
        if (!st.contains(3)) {
            System.out.println("Key 3 is removed from the table. (PASS)");
        } else {
            System.out.println("Key 3 should be removed but is still present. (FAIL)");
        }

        // Test min, max
        if (st.min() == 1) {
            System.out.println("Min key is 1. (PASS)");
        } else {
            System.out.println("Min key should be 1 but is not. (FAIL)");
        }
        if (st.max() == 4) {
            System.out.println("Max key is 4. (PASS)");
        } else {
            System.out.println("Max key should be 4 but is not. (FAIL)");
        }

        // Test floor, ceiling
        if (st.floor(2) == 2) {
            System.out.println("Floor of 2 is 2. (PASS)");
        } else {
            System.out.println("Floor of 2 should be 2 but is not. (FAIL)");
        }
        if (st.ceiling(2) == 2) {
            System.out.println("Ceiling of 2 is 2. (PASS)");
        } else {
            System.out.println("Ceiling of 2 should be 2 but is not. (FAIL)");
        }

        // Test rank
        int rankOf2 = st.rank(2);
        if (rankOf2 == 1) {
            System.out.println("Rank of 2 is 1. (PASS)");
        } else {
            System.out.println("Rank of 2 should be 1 but is " + rankOf2 + ". (FAIL)");
        }

        // Test select
        Integer keyAtRank1 = st.select(1);
        if (keyAtRank1 == 2) {
            System.out.println("Key at rank 1 is 2. (PASS)");
        } else {
            System.out.println("Key at rank 1 should be 2 but is " + keyAtRank1 + ". (FAIL)");
        }

        // Test deleteMin, deleteMax
        st.deleteMin();
        if (!st.contains(1)) {
            System.out.println("Min key 1 is deleted. (PASS)");
        } else {
            System.out.println("Min key 1 should be deleted but is not. (FAIL)");
        }
        st.deleteMax();
        if (!st.contains(4)) {
            System.out.println("Max key 4 is deleted. (PASS)");
        } else {
            System.out.println("Max key 4 should be deleted but is not. (FAIL)");
        }

        // Test size(lo, hi)
        st.put(5, "five");
        st.put(6, "six");
        st.put(7, "seven");
        int rangeSize = st.size(2, 6);
        if (rangeSize == 3) {
            System.out.println("Keys between 2 and 6 inclusive are 2,5,6. (PASS)");
        } else {
            System.out.println("size(2,6) should be 3 but is " + rangeSize + ". (FAIL)");
        }

        // Test keys() and keys(lo, hi)
        System.out.println("All keys in sorted order: " + st.keys());
        System.out.println("Keys between 2 and 6 in sorted order: " + st.keys(2, 6));

        System.out.println("Testing completed.");
    }
}
