public class ComplexDouble implements Number {
    private Double real, imag;
    public ComplexDouble(Double r, Double i){
        real = r;
        imag = i;
    }

    public Double getReal(){
        return real;
    }

    public Double getImag(){
        return imag;
    }

    public void setReal(double d){
        real = d;
    }

    public void setImag(double d){
        imag = d;
    }

    public ComplexDouble getConjugate(){
        return new ComplexDouble(real, -1 * imag);
    }

    public Number add(Number o){
        ComplexDouble n = (ComplexDouble) o;
        return new ComplexDouble(real + n.getReal(), imag + n.getImag());
    }

    public Number subtract(Number o){
        ComplexDouble n = (ComplexDouble) o;
        return new ComplexDouble(real - n.getReal(), imag - n.getImag());
    }

    public Number multiply(Number o){
        ComplexDouble n = (ComplexDouble) o;
        return new ComplexDouble(real * n.getReal() - imag * n.getImag(), imag * n.getReal() + real * n.getImag());
    }

    public Number divide(Number o){
        ComplexDouble n = (ComplexDouble) o;
        ComplexDouble newDenominator = (ComplexDouble) n.multiply(n.getConjugate());
        ComplexDouble newNumerator = (ComplexDouble) multiply(n.getConjugate());
        return new ComplexDouble(newNumerator.getReal() / newDenominator.getReal(), newNumerator.getImag() / newDenominator.getReal()); 
    }

    public String toString(){
        if(imag > 0){
            return real.toString() + "+" + imag.toString() + "i";
        }
        return real.toString() + "-" +  imag.toString() + "i";
    }
}
