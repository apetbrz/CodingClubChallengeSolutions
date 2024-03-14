public class MeetTwo {

    //lets you turn on/off the display of countMountainPeaks()
    private static final boolean SHOW_PEAKS = true;

    //problem one
    public static int countMountainPeaks(int[][] heights){
        //to solve this problem, we want to iterate through the entire array
        //and for each point, check its 8 surrounding neighbors
        //if any of those are equal to or greater than the current point being checked,
        //we know it is not a peak. otherwise, it is, so we increment the count.

        //this variable stores the number of peaks we've encountered so far
        int peakCount = 0;

        //currentHeight stores the value we are currently checking
        int currentHeight;

        //temporaryCheckValue is used to check the current point's neighbors
        int temporaryCheckValue;

        //isCurrentPeak keeps track of if the current point is a peak or not
        boolean isCurrentPeak;

        if(SHOW_PEAKS) System.out.println();

        //loop through every element:
        for(int row = 0; row < heights.length; row++){
            for(int col = 0; col < heights[row].length; col++){

                //grab the current coordinate's height:
                currentHeight = heights[row][col];

                //assume it is a peak:
                isCurrentPeak = true;

                //this loop is where we check the surrounding elements:
                //this label "checkLoop:" lets us break out of this
                checkLoop:
                for(int horizontalOffset = -1; horizontalOffset <= 1; horizontalOffset++){
                    for(int verticalOffset = -1; verticalOffset <= 1; verticalOffset++){

                        //first, try to grab the neighbor
                        try{
                            temporaryCheckValue = heights[row + verticalOffset][col + horizontalOffset];
                        }
                        //if this fails (by going out of bounds,
                        //we catch the ArrayIndexOutOfBoundsException instead of crashing
                        catch(ArrayIndexOutOfBoundsException e){
                            //and just skip this loop iteration
                            continue;
                        }

                        //if the offsets are both zero, we are checking the coordinate to itself,
                        //which is not what we want to do, so we just skip it
                        if(horizontalOffset == 0 && verticalOffset == 0){
                            continue;
                        }
                        //otherwise, we check if the coordinate we are looking at
                        //is not strictly *higher* than the current neighbor
                        else if(!(currentHeight > temporaryCheckValue)){
                            //if it is not higher (equal or lesser), then we know that the point cannot be a peak.
                            //print this out (if debug info is enabled)
                            if(Main.SHOW_DEBUG_INFO) System.out.println(row + " " + col + " is not a peak.");

                            if(SHOW_PEAKS) System.out.print(". ");

                            //set the boolean value to false,
                            isCurrentPeak = false;

                            //and exit out of the neighbor check loop
                            break checkLoop;
                        }//end comparison conditional

                    }//end verticalOffset loop
                }//end horizontalOffset loop

                //ALTERNATIVE SOLUTION:
                //use 8 individual checks, as in:
                /*
                temporaryCheckValue = heights[row-1][col-1];
                temporaryCheckValue = heights[row-1][col  ];
                temporaryCheckValue = heights[row-1][col+1];
                temporaryCheckValue = heights[row  ][col-1];
                temporaryCheckValue = heights[row  ][col+1];
                temporaryCheckValue = heights[row+1][col-1];
                temporaryCheckValue = heights[row+1][col  ];
                temporaryCheckValue = heights[row+1][col+1];
                 */
                //i felt like using loops. for no reason. either way works, solves the problem,
                //so long as you account for ArrayIndexOutOfBounds errors!!!!!!!!

                //if we made it through the check with the currentHeight being strictly
                //higher than all its neighbors, this boolean remains true,
                //so we increment the peak count.
                if(isCurrentPeak){
                    //log this if debug info is enabled
                    if(Main.SHOW_DEBUG_INFO) System.out.println(row + " " + col + " IS A PEAK!!!!");

                    if(SHOW_PEAKS) System.out.print("X ");

                    //incr.
                    peakCount++;
                }//end peak conditional

            }//end column loop

            if(SHOW_PEAKS) System.out.println();

        }//end row loop

        return peakCount;
    }

    //problem two
    public static double simpleStringCalculator(String expression){
        //we are told that the input will always be in the format:
        //[some integer][some operator][some integer]
        //so what we can do is search through the string until we find
        //a character that is *not* an integer,
        //and then mark that as the operator,
        //split the string on that index to get the two integers on either side,
        //and then perform the operation based on the operator.

        //this variable holds the answer to the problem.
        double result = 0;

        //this variable holds the position of the operator in the string
        char operator = 0;

        //this array will hold two values: the two numbers in the expression
        String[] values = new String[2];

        //loop through the string
        for(int i = 0; i < expression.length(); i++){
            //grab the current character
            char currentChar = expression.charAt(i);

            //check if it is *not* a digit
            if(!Character.isDigit(currentChar)){
                //if its just a whitespace, ignore it lol
                if(currentChar == ' ') continue;

                //if so, store it and exit the loop
                operator = currentChar;
                break;
            }
        }//end string loop

        //split the expression on the operator (returns a String[] with the two sides at [0] and [1])
        //.split() uses Regex (regular expressions) to make the split.
        //regex is *annoying*, we cant just pass the operator character alone, as its likely
        //that the symbol has some special meaning in regex.
        //so instead, we "escape" it with a \ (which needs to be escaped itself, hence \\),
        //as escaping it allows .split() to treat it as simply a plain text character,
        //instead of some extra meaning.
        values = expression.split("\\"+operator);

        //i'll go ahead and take the values and turn them into doubles, for calculation.
        //i call trim() on the String values, just to get rid of any leftover whitespace
        double a = Double.parseDouble(values[0].trim());
        double b = Double.parseDouble(values[1].trim());

        //now, we just use a switch statement to do the appropriate operation for whatever
        //the operator is!
        //this is super easily expandable, you can make your own operations!!!
        switch(operator){
            case '+': result = a + b; break;            //addition
            case '-': result = a - b; break;            //subtraction
            case '*':
            case 'x': result = a * b; break;            //multiplication
            case '/': result = a / b; break;            //division
            case '%': result = a % b; break;            //modulus
            case '^': result = Math.pow(a,b); break;    //power
            default: result = Double.NaN; break;        //if we dont recognize the operator, just return NaN
        }

        //after calculating, just return the result!
        return result;
    }

    //problem three
    public static String recursivePrimeFactorization(int x){
        //output will hold the String that we will be returning.
        String output = "";

        //we wanna find the largest factor of the input number
        //so we start at half of the number, and progress downwards, until
        //we either run into 1 or run into a factor (x % i == 0)

        //if the number is negative, we just treat it as -1 * a positive number, and continue on
        //(to avoid infinite loops of decrementing below zero)
        if(x < 0){
            output += "-1 ";
            output += recursivePrimeFactorization(x * -1);
            return output;
        }
        for(int i = x/2; i > 0; i--){

            //if we hit 1, the input number must be prime,
            //as it means that the largest factor (other than itself)
            //is one
            if(i == 1){

                //therefor, we print this input number out
                //as it must be a prime factor
                output += x + " ";

                //and then return, to exit the loop.
                return output;

            }//end i==1 conditional

            //if we instead hit a different factor of the input number,
            if(x % i == 0) {
                //we know that x has two factors other than 1 and itself
                //the first factor must be i, so therefor the second factor
                //is x / i.
                int j = x / i;

                //these arent guaranteed to be prime, however, so we must
                //factorize these.
                output += recursivePrimeFactorization(j);
                output += recursivePrimeFactorization(i);

                //finally, return to exit the loop.
                return output;

            }//end x % i == 0 conditional

            //if we meet neither of the two above conditionals,
            //there is nothing else to be done.
            //we simply continue the loop with i--

        }//end decrement loop

        //the *only* case in which this section of code is reached, is if x == 0
        //so, just return x, which will be "0"

        return "" + x;
    }

}