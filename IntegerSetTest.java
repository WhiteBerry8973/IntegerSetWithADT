public class IntegerSetTest {
    public static void main(String[] args) {
        int passedCount = 0, failedCount = 0;
        IntegerSet a = new IntegerSet();

        a.add(9);
        a.add(2);
        a.add(5);
        String s = "[2, 5, 9]" ; //ผลลัพธ์ที่คาดหวัง

        //Test 1: Add and sort
        System.out.println("--- Test 1 Add and sort ---");
        if (a.toString().equals(s)) {
            System.out.println("PASSED: Should be return [2, 5, 9]");
        } else {
            System.out.println("FAILED: Expected result [2, 5, 9] but got "+ a);
        }

        //Test 2: Duplicate
        System.out.println("--- Test 2 Duplicate ---");
        a.add(9); // ไม่ควรเพิ่มซ้ำ
        if (a.size() == 3) {
            System.out.println("PASSED: Should be return [2, 5, 9]");
        } else {
            System.out.println("FAILED: Expected result [2, 5, 9] but got "+ a);
        }

        //Test 3: Remove
        System.out.println("--- Test 3 Remove ---");
        a.remove(9);
        String s1 = "[2, 5]";
        if (a.toString().equals(s1)) {
            System.out.println("PASSED: Should be return [2, 5]");
        } else {
            System.out.println("FAILED: Expected result [2, 5] but got "+ a);
        }

        //Test 4: Contains
        System.out.println("--- Test 4 Contains ---");
        if (a.contains(5) && !a.contains(9)) {
            System.out.println("PASSED: Contains correctly after removal [2, 5]");
        } else {
            System.out.println("FAILED: Contains is incorrect");
        }

        //Test Summary
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}