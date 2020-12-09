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
            while (stringIndex < expression.length()) {
                if (elements % 2 == 0) {
                    String num = retrieveNumber(expression, stringIndex);
                    stringIndex += num.length();
                    numberList.add(Double.parseDouble(num));
                } else {
                    operationList.add(retrieveOperation(expression, stringIndex));
                    stringIndex++;
                }
                elements++;
            }
            if (elements % 2 == 0)
                throw new OperatorEndingException("Expression ends with an operation.");
            Parser p = new Parser(numberList, operationList);
            System.out.println(p.evaluate());

        } catch (NoEqualSignException e) {
            System.out.println(expression);
            System.out.println(e);
        } catch (OperatorEndingException e) {
            System.out.println("Error: " + e);
        } catch (ExtraneousCharacterException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("Error: User-defined number is not able to be parsed as a double.");
        } catch (ArithmeticException e) {
            System.out.println("The statement is evaluated as undefined.");
        }
    }

    static char retrieveOperation(String exp, int stringIndex) throws ExtraneousCharacterException {
        char op = exp.charAt(stringIndex);
        if (!(op == '+' || op == '-' || op == '*' || op == '/'))
            throw new ExtraneousCharacterException("There is an extraneous character in the expresion.");
        return op;
    }

    static String retrieveNumber(String exp, int stringIndex) {
        int beginIndex = stringIndex;
        String num = "";
        boolean hasDecimal = false;
        while (stringIndex < exp.length()) {
            if (exp.charAt(stringIndex) >= '0' && exp.charAt(stringIndex) <= '9')
                num += exp.charAt(stringIndex);
            else if (exp.charAt(stringIndex) == '-' && stringIndex == beginIndex)
                num += exp.charAt(stringIndex);
            else if (exp.charAt(stringIndex) == '.' && !hasDecimal) {
                num += exp.charAt(stringIndex);
                hasDecimal = true;
            } else
                break;
            stringIndex++;
        }
        return num;
    }

    static class NoEqualSignException extends Exception {
        NoEqualSignException(String s) {
            super(s);
        }
    }

    static class OperatorEndingException extends Exception {
        OperatorEndingException(String s) {
            super(s);
        }
    }

    static class ExtraneousCharacterException extends Exception {
        ExtraneousCharacterException(String s) {
            super(s);
        }
    }

}