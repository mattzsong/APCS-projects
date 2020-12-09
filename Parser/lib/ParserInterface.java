import java.util.*;

public class ParserInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the arithmetic expresssion: ");
        String expression = sc.next();
        sc.close();

        ArrayList<Double> numberList = new ArrayList<>();
        ArrayList<Character> operationList = new ArrayList<>();
        int elements = 0;
        int stringIndex = 1;
        try {
            if (expression.charAt(0) != '=')
                throw new NoEqualSignException("Expression doesn't start with equal sign.");
            

        } catch (NoEqualSignException e) {
            System.out.println(expression);
            System.out.println(e);

        } catch (InvalidOperatorException e) {

        } catch (OperatorEndingException e) {

        } catch (NumberFormatException e){

        } catch (ArithmeticException e){
            
        }
    }

    class NoEqualSignException extends Exception {
        NoEqualSignException(String s) {
            super(s);
        }
    }

    class InvalidOperatorException extends Exception {
        InvalidOperatorException(String s) {
            super(s);
        }
    }

    class OperatorEndingException extends Exception {
        OperatorEndingException(String s) {
            super(s);
        }
    }

}