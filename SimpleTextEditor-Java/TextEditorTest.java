
public class TextEditorTest {

    public static void report(boolean condition, String expected, String actual) {
        if (condition) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed: Expected '" + expected + "', got '" + actual + "'.");
        }
    }

    public static void main(String[] args) {

        // Test 1: Insert into empty text buffer.
        TextEditor editor = new TextEditor();
        editor.insert(0, "Hello");
        System.out.print(1);
        report(editor.getText().equals("Hello"), "Hello", editor.getText());

        // Test 2: Invalid insert (index > length).
        editor = new TextEditor();
        boolean result = editor.insert(5, "Hello");
        System.out.print(2);
        report(!result && editor.getText().equals(""), "Invalid index, empty text", editor.getText());

        // Test 3: Insert at beginning of non-empty text.
        editor = new TextEditor();
        editor.insert(0, "World");
        editor.insert(0, "Hello ");
        System.out.print(3);
        report(editor.getText().equals("Hello World"), "Hello World", editor.getText());

        // Test 4: Insert at end of text.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.insert(editor.getText().length(), " World");
        System.out.print(4);
        report(editor.getText().equals("Hello World"), "Hello World", editor.getText());

        // Test 5: Insert in the middle.
        editor = new TextEditor();
        editor.insert(0, "Helo");
        editor.insert(2, "l");
        System.out.print(5);
        report(editor.getText().equals("Hello"), "Hello", editor.getText());

        // Test 6: Valid deletion from the middle.
        editor = new TextEditor();
        editor.insert(0, "Hello World");
        editor.delete(5, 1); // Remove the space.
        System.out.print(6);
        report(editor.getText().equals("HelloWorld"), "HelloWorld", editor.getText());

        // Test 7: Invalid deletion (negative index).
        editor = new TextEditor();
        editor.insert(0, "Hello");
        result = editor.delete(-1, 2);
        System.out.print(7);
        report(!result && editor.getText().equals("Hello"), "Invalid deletion, unchanged text", editor.getText());

        // Test 8: Invalid deletion (length exceeds text length).
        editor = new TextEditor();
        editor.insert(0, "Hello");
        result = editor.delete(2, 10);
        System.out.print(8);
        report(!result && editor.getText().equals("Hello"), "Invalid deletion, unchanged text", editor.getText());

        // Test 9: Deletion with length 0 (should do nothing).
        editor = new TextEditor();
        editor.insert(0, "Hello");
        result = editor.delete(2, 0);
        System.out.print(9);
        report(result && editor.getText().equals("Hello"), "Hello", editor.getText());

        // Test 10: Undo after insertion.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.undo();

        System.out.print(10);
        report(editor.getText().equals(""), "Empty text after undo", editor.getText());

        // Test 11: Undo after deletion.
        editor = new TextEditor();
        editor.insert(0, "Hello World");
        editor.delete(5, 1);
        editor.undo();
        System.out.print(11);
        report(editor.getText().equals("Hello World"), "Hello World after undo", editor.getText());

        // Test 12: Redo after undo of insertion.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        // System.out.println(editor.redoHistory.toString());
        editor.undo();
        // System.out.println(editor.redoHistory.toString());
        editor.redo();
        System.out.print(12);
        report(editor.getText().equals("Hello"), "Hello", editor.getText());

        // Test 13: Redo after undo of deletion.
        editor = new TextEditor();
        editor.insert(0, "Hello World");
        editor.delete(5, 1);
        editor.undo();
        editor.redo();
        System.out.print(13);
        report(editor.getText().equals("HelloWorld"), "HelloWorld", editor.getText());

        // Test 14: Consecutive undos until no more operations.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.insert(5, " World");
        editor.delete(0, 5); // Delete "Hello"
        editor.undo(); // Undo delete -> "Hello World"
        editor.undo(); // Undo second insert -> "Hello"
        editor.undo(); // Undo first insert -> ""
        result = editor.undo(); // Nothing to undo
        System.out.print(14);
        report(editor.getText().equals("") && !result, "Empty text and no undo", editor.getText());

        // Test 15: Consecutive redos after multiple undos.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.insert(5, " World");
        editor.delete(0, 5); // Delete "Hello", text becomes " World"
        editor.undo(); // Undo delete -> "Hello World"
        editor.undo(); // Undo second insert -> "Hello"
        editor.undo(); // Undo first insert -> ""
        editor.redo(); // Redo first insert -> "Hello"
        editor.redo(); // Redo second insert -> "Hello World"
        editor.redo(); // Redo delete -> " World"
        System.out.print(15);
        report(editor.getText().equals(" World"), "' World'", editor.getText());

        // Test 16: Undo with no operations.
        editor = new TextEditor();
        result = editor.undo();
        System.out.print(16);
        report(!result && editor.getText().equals(""), "Nothing to undo", editor.getText());

        // Test 17: Redo with no operations.
        editor = new TextEditor();
        result = editor.redo();
        System.out.print(17);
        report(!result && editor.getText().equals(""), "Nothing to redo", editor.getText());

        // Test 18: Complex sequence of operations.
        editor = new TextEditor();
        editor.insert(0, "abc");
        editor.insert(3, "def");
        editor.delete(2, 2);
        editor.insert(2, "XYZ");
        editor.undo();
        editor.undo();
        editor.redo();
        editor.redo();
        System.out.print(18);
        report(editor.getText().equals("abXYZef"), "abXYZef", editor.getText());

        // Test 19: Insert empty string (should change nothing).
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.insert(3, "");
        System.out.print(18);
        report(editor.getText().equals("Hello"), "Hello", editor.getText());

        // Test 20: Delete entire text.
        editor = new TextEditor();
        editor.insert(0, "Hello World");
        editor.delete(0, editor.getText().length());
        System.out.print(20);
        report(editor.getText().equals(""), "Empty text", editor.getText());

        // Test 21: Undo deletion of entire text.
        editor.undo();
        System.out.print(21);
        report(editor.getText().equals("Hello World"), "Hello World", editor.getText());

        // Test 22: Redo after undo of deletion of entire text.
        editor.redo();
        System.out.print(22);
        report(editor.getText().equals(""), "Empty text", editor.getText());

        // Test 23: Multiple undos/redos with mixed operations.
        editor = new TextEditor();
        editor.insert(0, "Start");
        editor.insert(5, " Middle");
        editor.insert(12, " End");
        editor.delete(0, 5); // Remove "Start"
        editor.undo(); // Undo delete -> "Start Middle End"
        editor.undo(); // Undo insert " End" -> "Start Middle"
        editor.insert(12, " End!"); // New op clears redo history
        result = editor.redo(); // Should fail because redo history cleared
        System.out.print(23);
        report(editor.getText().equals("Start Middle End!") && !result,
                "Start Middle End!", editor.getText());

        // Test 24: Delete with index at end boundary.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.delete(4, 1); // Remove last character ('o')
        System.out.print(24);
        report(editor.getText().equals("Hell"), "Hell", editor.getText());

        // Test 25: Invalid insert with negative index.
        editor = new TextEditor();
        result = editor.insert(-1, "Test");
        System.out.print(25);
        report(!result && editor.getText().equals(""), "Invalid index, empty text", editor.getText());

        // Test 26: Valid deletion where index equals text.length() - deletion length.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.delete(3, 2); // Delete last 2 characters ("lo")
        System.out.print(26);
        report(editor.getText().equals("Hel"), "Hel", editor.getText());

        // Test 27: Check that redo history is cleared after a new operation.
        editor = new TextEditor();
        editor.insert(0, "Hello");
        editor.insert(5, " World");
        editor.undo(); // Undo second insert -> "Hello"
        editor.insert(5, ", there");
        result = editor.redo(); // Should fail because redo history was cleared
        System.out.print(27);
        report(editor.getText().equals("Hello, there") && !result,
                "Hello, there", editor.getText());

        // Test 28: Sequence of multiple operations.
        editor = new TextEditor();
        editor.insert(0, "A");
        editor.insert(1, "B");
        editor.insert(2, "C");
        editor.delete(1, 1); // Remove "B", expect "AC"
        editor.insert(1, "D"); // Expect "ADC"
        System.out.print(28);
        report(editor.getText().equals("ADC"), "ADC", editor.getText());

        // Test 29: Undo/Redo order correctness.
        editor = new TextEditor();
        editor.insert(0, "123");
        editor.insert(3, "456");
        editor.delete(2, 2); // "123456" becomes "1256" (delete characters at index 2 & 3)
        editor.undo(); // Undo delete -> "123456"
        editor.undo(); // Undo second insert -> "123"
        editor.redo(); // Redo second insert -> "123456"
        System.out.print(29);
        report(editor.getText().equals("123456"), "123456", editor.getText());

        // Test 30: Edge condition: All operations undone leading to empty text.
        editor = new TextEditor();
        editor.insert(0, "Edge");
        editor.delete(0, 4); // Now empty
        editor.undo(); // Undo delete -> "Edge"
        editor.undo(); // Undo insert -> ""
        System.out.print(30);
        report(editor.getText().equals(""), "Empty text", editor.getText());
    }
}
