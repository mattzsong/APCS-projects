import java.util.*;

public class ComplexCalculatorUserInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mode of calculator (d for double or f for fraction): ");
        char mode;
        while (true) {
            try {
                mode = retrieveOperation(sc, new char[] { 'd', 'f' });
                break;
            } catch (InvalidOperationException e) {
                System.out.println(e);
            }
        }

        Number first;
        Number second;
        char operation;
        while (true) {
            try {
                if (mode == 'd') {
                    System.out.println(
                            "Enter the expression as a string, with each real and imaginary part represented by a double, "
                                    + "and operation separated by a space. " + "Ex: 3.25 + 0.5i * 3.5 - 1.25i");
                    String firstDouble = sc.next();
                    char firstOperation = retrieveOperation(sc, new char[]{'+','-'});
                    String secondDouble = sc.next();
                    char secondOperation = retrieveOperation(sc, new char[] { '+', '-', '*', '/' });
                    String thirdDouble = sc.next();
                    char thirdOperation = retrieveOperation(sc, new char[] { '+', '-',});
                    String fourthDouble = sc.next();
                    first = parseDoubles(firstDouble, firstOperation, secondDouble);
                    operation = secondOperation;
                    second = parseDoubles(thirdDouble, thirdOperation, fourthDouble);

                } else {
                    System.out.println(
                            "Enter the numbers as a string, with the real part first and imaginary part following, "
                                    + "separated by a space. Real and imaginary parts must be represented by whole number or fraciton as 1 or -5/2."
                                    + " Then separate each number with a space and an operation between each number. Ex: 5/2 - 1/2i / 0/1 - 7/3i");
                    String firstFraction = sc.next();
                    char firstOperation = retrieveOperation(sc, new char[]{'+','-'});
                    String secondFraction = sc.next();
                    char secondOperation = retrieveOperation(sc, new char[] { '+', '-', '*', '/' });
                    String thirdFraction = sc.next();
                    char thirdOperation = retrieveOperation(sc, new char[] { '+', '-',});
                    String fourthFraction = sc.next();
                    first = parseFractions(firstFraction, firstOperation, secondFraction);
                    operation = secondOperation;
                    second = parseFractions(thirdFraction, thirdOperation, fourthFraction);
                }
                break;
            } catch (InvalidOperationException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type.");
            } catch (NoSuchElementException e) {
                System.out.println("Not enough inputs entered.");
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
        Number res;
        try {
            if (operation == '+') 
                res = first.add(second);
            else if (operation == '-')
                res = first.subtract(second);
            else if (operation == '*')
                res = first.multiply(second);
            else
                res = first.divide(second);
            System.out.println(res);
        } catch (ArithmeticException e) {
            System.out.println("Error with arithmetic.");
        }
    }

    public static class InvalidOperationException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidOperationException(String string) {
            super(string);
        }
    }

    static char retrieveOperation(Scanner sc, char[] valid) throws Exception {
        char op = sc.next().charAt(0);
        for (int i = 0; i < valid.length; i++) {
            if (op == valid[i])
                return op;
        }
        throw new InvalidOperationException("Invalid input: Not a valid operation.");
    }

    static ComplexNumber parseFractions(String real, char operationBetween, String imag) throws Exception {
        int slashFreq = 0;
        int slashIndex = -1;
        for (int i = 0; i < real.length(); i++) {
            if (real.charAt(i) == '/') {
                if (slashFreq == 1) {
                    throw new NumberFormatException("Extra slashes entered.");
                }
                slashFreq++;
                slashIndex = i;
            }
        }
        Fraction r;
        if (slashIndex > -1) {
            r = new Fraction(Integer.parseInt(real.substring(0, slashIndex)),
                    Integer.parseInt(real.substring(slashIndex + 1, real.length())));
        } else {
            r = new Fraction(Integer.parseInt(real), 1);
        }

        slashFreq = 0;
        slashIndex = -1;
        if (!(imag.charAt(imag.length() - 1) == 'i'))
            throw new NumberFormatException("No imaginary part entered.");

        for (int i = 0; i < imag.length() - 1; i++) {
            if (imag.charAt(i) == '/') {
                if (slashFreq == 1) {
                    throw new NumberFormatException("Input error: Extra slashes entered.");
                }
                slashFreq++;
                slashIndex = i;
            }
        }
        Fraction i;
        if (slashIndex > -1) {
            i = new Fraction(Integer.parseInt(imag.substring(0, slashIndex)),
                    Integer.parseInt(imag.substring(slashIndex + 1, imag.length()-1)));
        } else {
            i = new Fraction(Integer.parseInt(imag.substring(imag.length()-1)),1);
        }
        if(operationBetween == '-') i.setNum(i.getNum() * -1);

        if(r.getDenom() == 0 || i.getDenom() == 0) throw new ArithmeticException("Zero denominator.");

        return new ComplexNumber(r, i);

    }

    static ComplexDouble parseDoubles(String real, char operationBetween, String imag) throws Exception {
        if (!(imag.charAt(imag.length() - 1) == 'i'))
            throw new NumberFormatException("No imaginary part entered.");
        ComplexDouble c = new ComplexDouble(Double.parseDouble(real), Double.parseDouble(imag.substring(0, imag.length() - 1)));
        if(operationBetween == '-') c.setImag(c.getImag() * -1.0);
        return c;
    }
}
