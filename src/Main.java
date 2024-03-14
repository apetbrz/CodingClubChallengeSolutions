public class Main {
    public static final boolean SHOW_DEBUG_INFO = false;
    public static final int MEETING_SELECTION = 2;
    public static void main(String[] args) {

        switch(MEETING_SELECTION) {
            case 1 -> meetOne();
            case 2 -> meetTwo();
            case 3 -> meetThree();
        }
    }

    public static void meetOne(){
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

    public static void meetTwo(){
        int[][] heights =  {{1,1,1,2,2,2,2,2,2,1},
                            {1,2,2,3,4,3,3,3,2,2},
                            {1,1,2,2,2,3,4,3,2,2},
                            {1,1,2,3,2,3,3,2,2,2},
                            {1,1,1,2,1,1,2,2,2,2}};
        printTestResult("Meet 2, Question 1, Example 1", MeetTwo.countMountainPeaks(heights));

        heights = new int[][]  {{1,1,1,1,1,1,1,1,1,1},
                                {1,1,2,2,2,3,2,2,2,1},
                                {1,1,1,2,3,3,3,4,2,1},
                                {1,2,1,2,3,2,2,2,2,1},
                                {1,1,1,1,1,1,1,1,1,1}};
        printTestResult("Meet 2, Question 1, Example 2", MeetTwo.countMountainPeaks(heights));

        heights = new int[][]  {{1,1,1,1,1,1,1,1,4,1},
                                {1,2,2,2,2,2,2,2,2,1},
                                {1,2,3,2,3,2,3,2,2,1},
                                {1,2,2,2,2,2,2,7,2,1},
                                {1,2,2,5,4,5,2,2,2,1},
                                {1,2,2,6,2,2,2,2,2,1},
                                {1,2,2,2,2,3,2,7,2,1},
                                {1,2,2,2,2,2,2,2,2,1}};
        printTestResult("Meet 2, Question 1, Bonus Test", MeetTwo.countMountainPeaks(heights));

        System.out.println();

        String expression = "2+2";
        printTestResult("Meet 2, Question 2, Example 1", MeetTwo.simpleStringCalculator(expression));
        expression = "50-19";
        printTestResult("Meet 2, Question 2, Example 2", MeetTwo.simpleStringCalculator(expression));
        expression = "123*456";
        printTestResult("Meet 2, Question 2, Example 3", MeetTwo.simpleStringCalculator(expression));
        expression = "85/8";
        printTestResult("Meet 2, Question 2, Example 4", MeetTwo.simpleStringCalculator(expression));
        expression = "2^8";
        printTestResult("Meet 2, Question 2, Example 5", MeetTwo.simpleStringCalculator(expression));
        expression = "22/7";
        printTestResult("Meet 2, Question 2, Example 6", MeetTwo.simpleStringCalculator(expression));
        expression = "99999%4";
        printTestResult("Meet 2, Question 2, Bonus Test", MeetTwo.simpleStringCalculator(expression));

        System.out.println();

        int value = 12;
        printTestResult("Meet 2, Question 3, Example 1", MeetTwo.recursivePrimeFactorization(value));
        value = 11;
        printTestResult("Meet 2, Question 3, Example 2", MeetTwo.recursivePrimeFactorization(value));
        value = 42;
        printTestResult("Meet 2, Question 3, Example 3", MeetTwo.recursivePrimeFactorization(value));
        value = 56823;
        printTestResult("Meet 2, Question 3, Example 4", MeetTwo.recursivePrimeFactorization(value));
        value = 999999;
        printTestResult("Meet 2, Question 3, Example 5", MeetTwo.recursivePrimeFactorization(value));
        value = -897468435;
        printTestResult("Meet 2, Question 3, Bonus Test", MeetTwo.recursivePrimeFactorization(value));
        value = 0;
        printTestResult("Meet 2, Question 3, Bonus Test", MeetTwo.recursivePrimeFactorization(value));
    }

    public static void meetThree(){

    }

    public static void printTestResult(String title, Object output){
        System.out.println(title + ":\t" + output);
    }
}
