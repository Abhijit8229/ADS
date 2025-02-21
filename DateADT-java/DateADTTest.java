public class DateADTTest {

    public static void main(String[] args) {
        boolean allTestsPassed = true;

        // ---------------------------
        // Test 1: Constructor with year, month, day
        // ---------------------------
        try {
            DateADT d1 = new DateADT(2023, 2, 28);
            if (d1.getYear() != 2023) {
                System.out.println("Test 1 Failed: getYear() returned " + d1.getYear());
                allTestsPassed = false;
            }
            if (d1.getMonth() != 2) {
                System.out.println("Test 1 Failed: getMonth() returned " + d1.getMonth());
                allTestsPassed = false;
            }
            if (d1.getDay() != 28) {
                System.out.println("Test 1 Failed: getDay() returned " + d1.getDay());
                allTestsPassed = false;
            }
            if (d1.getHours() != 0 || d1.getMinutes() != 0 || d1.getSeconds() != 0) {
                System.out.println("Test 1 Failed: Default time values are not 0");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 1 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 2: Constructor with full date/time
        // ---------------------------
        try {
            DateADT d2 = new DateADT(2024, 1, 15, 13, 45, 50);
            if (d2.getYear() != 2024) {
                System.out.println("Test 2 Failed: getYear() returned " + d2.getYear());
                allTestsPassed = false;
            }
            if (d2.getMonth() != 1) {
                System.out.println("Test 2 Failed: getMonth() returned " + d2.getMonth());
                allTestsPassed = false;
            }
            if (d2.getDay() != 15) {
                System.out.println("Test 2 Failed: getDay() returned " + d2.getDay());
                allTestsPassed = false;
            }
            if (d2.getHours() != 13 || d2.getMinutes() != 45 || d2.getSeconds() != 50) {
                System.out.println("Test 2 Failed: Time values are incorrect");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 2 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 3: String-based constructor
        // ---------------------------
        try {
            DateADT d3 = new DateADT("2025-10-30 23:59:60");
            if (d3.getYear() != 2025) {
                System.out.println("Test 3 Failed: getYear() returned " + d3.getYear());
                allTestsPassed = false;
            }
            // Note: In this implementation, the string-based constructor uses the numeric
            // value for month.
            if (d3.getMonth() != 10) {
                System.out.println("Test 3 Failed: getMonth() returned " + d3.getMonth());
                allTestsPassed = false;
            }
            if (d3.getDay() != 30) {
                System.out.println("Test 3 Failed: getDay() returned " + d3.getDay());
                allTestsPassed = false;
            }
            if (d3.getHours() != 23 || d3.getMinutes() != 59 || d3.getSeconds() != 60) {
                System.out.println("Test 3 Failed: Time values are incorrect");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 3 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 4: toString method
        // ---------------------------
        try {
            DateADT d2 = new DateADT(2024, 1, 15, 13, 45, 50);
            String expected = "2024-01-15 13:45:50";
            if (!d2.toString().equals(expected)) {
                System.out.println("Test 4 Failed: toString() returned " + d2.toString() + ", expected " + expected);
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 4 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 5: getTime and setTime methods
        // ---------------------------
        try {
            DateADT d2 = new DateADT(2024, 1, 15, 13, 45, 50);
            long ms = d2.getTime();
            DateADT d4 = new DateADT(1970, 0, 1);
            d4.setTime(ms);
            // System.out.println(d2.toString());
            // System.out.println(d4.toString());
            if (!d4.toString().equals(d2.toString())) {
                System.out.println("Test 5 Failed: setTime() did not properly update the date.");
                System.out.println("Expected: " + d2.toString() + ", Got: " + d4.toString());
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 5 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 6: before and after methods
        // ---------------------------
        try {
            DateADT d1 = new DateADT(2023, 2, 28);
            DateADT d2 = new DateADT(2024, 1, 15, 13, 45, 50);
            if (!d1.before(d2)) {
                System.out.println("Test 6 Failed: d1 should be before d2.");
                allTestsPassed = false;
            }
            if (!d2.after(d1)) {
                System.out.println("Test 6 Failed: d2 should be after d1.");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 6 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 7: Setter methods
        // ---------------------------
        try {
            DateADT d = new DateADT(2023, 3, 10, 10, 10, 10);
            d.setYear(2022);
            if (d.getYear() != 2022) {
                System.out.println("Test 7 Failed: setYear() did not update correctly.");
                allTestsPassed = false;
            }
            d.setMonth(5);
            if (d.getMonth() != 5) {
                System.out.println("Test 7 Failed: setMonth() did not update correctly.");
                allTestsPassed = false;
            }
            d.setDay(15);
            if (d.getDay() != 15) {
                System.out.println("Test 7 Failed: setDay() did not update correctly.");
                allTestsPassed = false;
            }
            d.setHours(20);
            if (d.getHours() != 20) {
                System.out.println("Test 7 Failed: setHours() did not update correctly.");
                allTestsPassed = false;
            }
            d.setMinutes(30);
            if (d.getMinutes() != 30) {
                System.out.println("Test 7 Failed: setMinutes() did not update correctly.");
                allTestsPassed = false;
            }
            d.setSeconds(55);
            if (d.getSeconds() != 55) {
                System.out.println("Test 7 Failed: setSeconds() did not update correctly.");
                allTestsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("Test 7 Exception: " + e.getMessage());
            allTestsPassed = false;
        }

        // ---------------------------
        // Test 8: Invalid input tests
        // ---------------------------
        // 8a: Month out of range
        try {
            DateADT invalid = new DateADT(2023, 12, 10); // month 12 is invalid (valid: 0-11)
            System.out.println("Test 8a Failed: Month out of range not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // 8b: Day out of range (e.g., February 29 in a non-leap year)
        try {
            DateADT invalid = new DateADT(2023, 1, 29);
            System.out.println("Test 8b Failed: Day out of range not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // 8c: Hour out of range
        try {
            DateADT invalid = new DateADT(2023, 5, 10, 24, 0, 0);
            System.out.println("Test 8c Failed: Hour out of range not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // 8d: Minute out of range
        try {
            DateADT invalid = new DateADT(2023, 5, 10, 12, 60, 0);
            System.out.println("Test 8d Failed: Minute out of range not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // 8e: Second out of range
        try {
            DateADT invalid = new DateADT(2023, 5, 10, 12, 30, 61);
            System.out.println("Test 8e Failed: Second out of range not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // 8f: Invalid string format
        try {
            DateADT invalid = new DateADT("2023/05/10 12:30:30");
            System.out.println("Test 8f Failed: Invalid string format not caught.");
            allTestsPassed = false;
        } catch (IllegalArgumentException e) {
            // Expected
        }

        // ---------------------------
        // Final output
        // ---------------------------
        if (allTestsPassed) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println("Some tests failed. Please review the error messages above.");
        }
    }
}
