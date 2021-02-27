import java.util.*;

public class ComplexCalculatorUserInterface {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Mode of calculator (d for double or f for fraction): ");
        System.out.print(
                "Enter the number as a string, with the real part first and imaginary part following, " +
                "separated by a space. Real and imaginary parts must be represented by whole number or fraciton as 1 or -5/2.");
        

    }

    public char retrieveOperation(char op, char[] valid){
        for(int i = 0; i < valid.length; i++){
            if(op == valid[i]) return op;
        }
        return ' ';
    }

    public ComplexNumber parseFractions(String real, String imag) throws Exception{
        int slashFreq = 0;
        int slashIndex = -1;
        for(int i = 0; i < real.length(); i++){
            if(real.charAt(i) == '/'){
                if(slashFreq == 1){
                    throw new NumberFormatException("Input error: Extra slashes entered.");
                }
                slashFreq++;
                slashIndex = i;
            }
        }
        Fraction r;
        if(slashIndex > -1){
            r = new Fraction(Integer.parseInt(real.substring(0, slashIndex)), Integer.parseInt(real.substring(slashIndex+1, real.length())));
        }
        else{
            r = new Fraction(Integer.parseInt(real.substring(0, slashIndex)), 1);
        }

        slashFreq = 0;
        slashIndex = -1;
        for(int i = 0; i < imag.length(); i++){
            if(imag.charAt(i) == '/'){
                if(slashFreq == 1){
                    throw new NumberFormatException("Input error: Extra slashes entered.");
                }
                slashFreq++;
                slashIndex = i;
            }
        }
        Fraction i;
        if(slashIndex > -1){
            i = new Fraction(Integer.parseInt(imag.substring(0, slashIndex)), Integer.parseInt(imag.substring(slashIndex+1, imag.length())));
        }
        else{
            i = new Fraction(Integer.parseInt(imag.substring(0, slashIndex)), 1);
        }

        return new ComplexNumber(r, i);

    }

    public ComplexDouble parseDoubles(String real, String imag) throws Exception{
        return new ComplexDouble(Double.parseDouble(real), Double.parseDouble(imag));
    }
}
