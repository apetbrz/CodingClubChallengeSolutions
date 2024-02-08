public class Main {
    public static void main(String[] args) {
        int[] arr;
        String str;

        arr = new int[]{0,1,2,3,4};
        printTestResult("Meet 1, Question 1, Example 1", MeetOne.checkArrayForSum(arr, 7));
        arr = new int[]{0,5,2,13,4};
        printTestResult("Meet 1, Question 1, Example 2", MeetOne.checkArrayForSum(arr, 8));
        arr = new int[]{1,5,7,8,9};
        printTestResult("Meet 1, Question 1, Example 3", MeetOne.checkArrayForSum(arr, 7));
        arr = new int[]{4,7,2,7,8,9,85,42,669,123,548,69,777};
        printTestResult("Meet 1, Question 1, Bonus Test", MeetOne.checkArrayForSum(arr, 590));

        System.out.println();

        arr = new int[]{0,1,2,3,4};
        printTestResult("Meet 1, Question 2, Example 1", MeetOne.largestSubarray(arr, 3));
        arr = new int[]{0,5,2,13,4};
        printTestResult("Meet 1, Question 2, Example 2", MeetOne.largestSubarray(arr, 2));
        arr = new int[]{18,1,1,7,7,7,7,2,1};
        printTestResult("Meet 1, Question 2, Example 3", MeetOne.largestSubarray(arr, 4));
        arr = new int[]{1,2,3,42,999,0,0,0,390,6,700,77};
        printTestResult("Meet 1, Question 2, Bonus Test", MeetOne.largestSubarray(arr, 3));
        arr = new int[]{0,1,2,3,4};
        printTestResult("Meet 1, Question 2, Invalid", MeetOne.largestSubarray(arr, 6));

        System.out.println();

        str = "()";
        printTestResult("Meet 1, Question 3, Example 1", MeetOne.balancedParentheses(str));
        str = "(()(())";
        printTestResult("Meet 1, Question 3, Example 2", MeetOne.balancedParentheses(str));
        str = "(()(()))()((()(())))";
        printTestResult("Meet 1, Question 3, Example 3", MeetOne.balancedParentheses(str));
        str = "())(";
        printTestResult("Meet 1, Question 3, Bonus Test", MeetOne.balancedParentheses(str));
        str = "((())())(()(()()))";
        printTestResult("Meet 1, Question 3, Bonus Test", MeetOne.balancedParentheses(str));

    }
    public static void printTestResult(String title, Object output){
        System.out.println(title + ":\t" + output);
    }
}
