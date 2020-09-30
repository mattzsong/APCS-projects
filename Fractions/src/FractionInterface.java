import java.util.*;

public class FractionInterface {
    public static void main(String[] args) {

        //gather and check inputs from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first fraction's numerator: ");
        int fracOneNum = retrieveNumerator(sc);
        System.out.println("Enter the first fraction's denominator: ");
        int fracOneDenom = retrieveDenominator(sc);
        System.out.println("Enter the second fraction's numerator: ");
        int fracTwoNum = retrieveNumerator(sc);
        System.out.println("Enter the second fraction's denominator: ");
        int fracTwoDenom = retrieveDenominator(sc);

        System.out.println("Enter the operation you want to perform (a for addition, s for subtraction, m for multiplication, d for divison): ");
        char operation = retrieveOperation(sc);

        //create fractions from input, and initialize result fraction
        Fraction fracOne = new Fraction(fracOneNum, fracOneDenom);
        Fraction fracTwo = new Fraction(fracTwoNum, fracTwoDenom);
        Fraction result;

        //perform operation according to operation character
        if(operation == 'a') result = fracOne.addFrac(fracTwo);
        else if (operation == 's') result = fracOne.subtractFrac(fracTwo);
        else if (operation == 'm') result = fracOne.multiplyFrac(fracTwo);
        else                       result = fracOne.divideFrac(fracTwo);

        //simplify result and print
        result.reduce();
        System.out.print("The result is: ");
        if(result.getDenom() == 1) System.out.println(result.getNum());
        else                       System.out.println(result.getNum() + "/" + result.getDenom());
    }

    static int retrieveNumerator(Scanner sc){
        //obtaining and error checking numerator input
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

    static int retrieveDenominator(Scanner sc){
        //obtaining and error checking denominator input
        while(true){
            String s = sc.next();              
            try{ 
                int denom = Integer.parseInt(s);
                if(denom != 0) return denom;
                else   System.out.println("Invalid input: the denominator had an input of 0. Try again.");
            }  
            catch (NumberFormatException e) { 
                System.out.println("Invalid input: the input was not an integer. Try again.");
            }                        
        }
    }

    static char retrieveOperation(Scanner sc){
        //obtaining and error checking operation input
        while(true){
            char op = sc.next().charAt(0);
            if(op == 'a' || op == 's' || op == 'm' || op == 'd') return op;
            else                System.out.println("Invalid input: the input does not correspond to an operation. Try again.");
        }
    }

}
