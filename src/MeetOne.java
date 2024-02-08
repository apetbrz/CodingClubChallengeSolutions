public class MeetOne {
    //problem one
    public static boolean checkArrayForSum(int[] arr, int target){

        //loop through the list
        for(int i = 0; i < arr.length; i++) {

            //the second check starts at i + 1, so we dont add the same number to itself
            //we start at i + 1 instead of 0 to avoid duplicate checks (optimization)
            for (int j = i + 1; j < arr.length; j++) {
                //check, return true if found
                if (arr[i] + arr[j] == target) return true;

            }//end inner for loop

        }//end outer for loop

        //if we make it through the whole loop without returning true,
        //there must be no solution. in this case, return false.
        return false;
    }

    //problem two
    public static int largestSubarray(int[] arr, int n){
        //we initialize three variables:
        //currentSum is our temporary sum, when checking each block of the array
        //maxSum holds on to the highest sum we've found so far
        //maxIndex keeps track of where this highest sum is located
        int currentSum;
        int maxSum = Integer.MIN_VALUE;
        int maxIndex = -1;

        //we iterate through the array, but only up until arr.length - n + 1
        //this iterates through every n-sized block in the array, since we stop at
        //the last n-sized block, without missing any elements at the end.
        //this avoids an ArrayIndexOutOfBounds exception, since we access
        //the element arr[j + i], and we want to avoid i == arr.length - 1 and j > 0
        for(int i = 0; i < arr.length - n + 1; i++){

            //reset the temporary sum
            currentSum = 0;

            //loop through the next n elements
            for(int j = i; j < i + n; j++){

                //add up the elements
                currentSum += arr[j];
            }//end n for loop

            //check our new sum against the maximum sum
            //since we initialized maxSum to Integer.MIN_VALUE,
            //this will always be true at least once
            //(except for silly edge cases, if u wanted to figure that out :P )
            if(currentSum > maxSum){

                //save the new max sum
                maxSum = currentSum;

                //save the new max index
                maxIndex = i;

            }//end sum check conditional

        }//end array for loop

        //finally, after looping, we return the maxIndex as requested.
        //since we initialized this to -1, any invalid combination of
        //array length and n value will skip the loop, and return a value of
        //-1, which is invalid, and implies something went wrong.
        return maxIndex;
    }

    //problem three
    public static boolean balancedParentheses(String input){
        //we only need one variable in this:
        //to keep track of how many open parentheses there are so far
        //its very simple, whenever we find a '(', we add one to this variable,
        //and whenever we find a ')', we subtract one. this way,
        //after the loop, we know whether there are any remaining
        //open parentheses!
        int openParenthesesCount = 0;

        //to loop through the array, i actually use a
        //"foreach" loop, which is similar to a standard for loop,
        //except it specifically iterates through each and every element
        //in an array of a specific type. this makes it easier to
        //do things to everything in an array, for cases where
        //you do *not* need to keep track of where you are in the loop,
        //and do *not* need to only iterate through a portion of the array
        //read this as: "for each character 'c' in the character array 'input.toCharArray()'"
        for(char c : input.toCharArray()){

            //here is where we check the parentheses.
            //if the character 'c' is a left parenthesis, we increment the count variable
            if(c == '(') openParenthesesCount++;

            //otherwise, if its a right parenthesis, we decrement instead.
            else if(c == ')') openParenthesesCount--;

            //now, what happens if we have a right parentheses on its own without
            //any left parentheses before it?? we need to immediately stop, as
            //it cannot be possible for this case to be balanced.
            //consider the string "( ) ) ("
            //if we simply went off the openParenthesesCount variable,
            //we would finish this string with a count of 0! we would return true, as if this was valid!
            //as soon as we detect that we decremented below zero, we should
            //immediately know that something went wrong!
            if(openParenthesesCount < 0) return false;

        }//end foreach loop

        //after finishing the loop, we simply check whether the final count value equals zero
        //this is our answer!
        boolean isBalanced = openParenthesesCount == 0;
        return isBalanced;
    }
}
