import java.util.*;

public class NonDecreasingSequence {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        int[] setArray = new int[0];

        //keep asking for operations until the user wants to end
        while(!end){
            System.out.print("What would you like to do?" + 
            "(a to add number to set, p to print the number set, i to determine longest non-decreasing sequence," +
            "i to determine longest non-increasing sequence, r to reset set of numbers, e to end program): ");
            char action = retrieveOperation(sc);

            if(action == 'a'){
                System.out.print("Enter the number you would like to add: ");
                int element = retrieveInteger(sc);
                setArray = addElement(setArray, element);
            }

            else if(action == 'p')  printSet(setArray);

            else if(action == 'i') longestNonIncreasing(setArray);

            else if(action == 'd') longestNonDecreasing(setArray);

            else if(action == 'r') setArray = new int[0];

            else                   end = true;

        }
    }

    static int[] addElement(int[] set, int element){
        int[] newArray = Arrays.copyOf(set, set.length+1);
        newArray[newArray.length-1] = element;
        return newArray; 
    }

    static char retrieveOperation(Scanner sc){
        //obtaining and error checking action input
        while(true){
            char op = sc.next().charAt(0);
            if(op == 'a' || op == 'p' || op == 'i' || op == 'd' || op == 'i' || op == 'r' || op == 'e') return op;
            else                System.out.println("Invalid input: the input does not correspond to an operation. Try again.");
        }
    }

    //print the current sequence
    static void printSet(int[] set){
        for(int i = 0; i < set.length; i++){
            System.out.print(set[i] + " ");
        }
        System.out.println();
    }

    static int retrieveInteger(Scanner sc){
        //obtaining and error checking integer input
        while(true){
            String s = sc.next();
            try{ 
                return Integer.parseInt(s);
            }  
            catch (NumberFormatException e) { 
                System.out.println("Invalid input: the input was not an integer. Try again.");
            } 
        }
    }

    static void longestNonIncreasing(int[] set){
        int sequenceStartIndex = 0;
        int currentSequenceLength = 1;
        int maxSequenceLength = 0;
        int[] answerArray = new int[0];

        //continue to traverse a non-increasing sequence
        //until the sequence ends, and check the length
        for(int i = 1; i < set.length; i++){
            if(set[i] <= set[i-1]) currentSequenceLength++;
            else{
                //store the starting index of the longest sequence(s)
                if(currentSequenceLength > maxSequenceLength){
                    maxSequenceLength = currentSequenceLength;
                    answerArray = new int[1];
                    answerArray[0] = sequenceStartIndex;
                }
                else if(currentSequenceLength == maxSequenceLength){
                    answerArray = addElement(answerArray, sequenceStartIndex);
                }
                sequenceStartIndex = i;
                currentSequenceLength = 1;
            }
        }

        //last check for sequence
        if(currentSequenceLength > maxSequenceLength){
            maxSequenceLength = currentSequenceLength;
            answerArray = new int[1];
            answerArray[0] = sequenceStartIndex;
        }
        else if(currentSequenceLength == maxSequenceLength){
            answerArray = addElement(answerArray, sequenceStartIndex);
        }

        for(int i = 0; i < answerArray.length; i++){
            for(int j = answerArray[i]; j < answerArray[i] + maxSequenceLength; j++){
                System.out.print(set[j] + " ");
            }
            System.out.println();
        }
    }

    static void longestNonDecreasing(int[] set){
        int sequenceStartIndex = 0;
        int currentSequenceLength = 1;
        int maxSequenceLength = 0;
        int[] answerArray = new int[0];

        //continue to traverse a non-decreasing sequence
        //until the sequence ends, and check the length
        for(int i = 1; i < set.length; i++){
            if(set[i] >= set[i-1]) currentSequenceLength++;
            else{
                //store the starting index of the longest sequence(s)
                if(currentSequenceLength > maxSequenceLength){
                    maxSequenceLength = currentSequenceLength;
                    answerArray = new int[1];
                    answerArray[0] = sequenceStartIndex;
                }
                else if(currentSequenceLength == maxSequenceLength){
                    answerArray = addElement(answerArray, sequenceStartIndex);
                }
                sequenceStartIndex = i;
                currentSequenceLength = 1;
            }
        }

        //last check for sequence
        if(currentSequenceLength > maxSequenceLength){
            maxSequenceLength = currentSequenceLength;
            answerArray = new int[1];
            answerArray[0] = sequenceStartIndex;
        }
        else if(currentSequenceLength == maxSequenceLength){
            answerArray = addElement(answerArray, sequenceStartIndex);
        }

        for(int i = 0; i < answerArray.length; i++){
            for(int j = answerArray[i]; j < answerArray[i] + maxSequenceLength; j++){
                System.out.print(set[j] + " ");
            }
            System.out.println();
        }
    }
}
