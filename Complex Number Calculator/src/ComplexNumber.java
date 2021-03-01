public class ComplexNumber implements Number{
    private Fraction real, imag;

    public ComplexNumber(Fraction r, Fraction i){
        real = r;
        imag = i;
    }

    public Fraction getReal(){
        return real;
    }

    public Fraction getImag(){
        return imag;
    }

    public ComplexNumber getConjugate(){
        Fraction newImag = new Fraction(imag.getNum()*-1, imag.getDenom());
        return new ComplexNumber(real, newImag);
    }
    @Override
    public Number add(Number o){
        ComplexNumber n = (ComplexNumber) o;
        Fraction realResult = (Fraction) real.add(n.getReal());
        Fraction imagResult = (Fraction) imag.add(n.getImag());
        realResult.reduce();
        imagResult.reduce();
        return new ComplexNumber(realResult, imagResult);
    }
    @Override
    public Number subtract(Number o){
        ComplexNumber n = (ComplexNumber) o;
        Fraction realResult = (Fraction) real.subtract(n.getReal());
        Fraction imagResult = (Fraction) imag.subtract(n.getImag());
        realResult.reduce();
        imagResult.reduce();
        return new ComplexNumber(realResult, imagResult);
    }
    
    @Override
    public Number multiply(Number o){
        ComplexNumber n = (ComplexNumber) o;
        Fraction realResult = (Fraction) real.multiply(n.getReal()).subtract(imag.multiply(n.getImag()));
        Fraction imagResult = (Fraction) real.multiply(n.getImag()).add(imag.multiply(n.getReal()));
        realResult.reduce();
        imagResult.reduce();
        return new ComplexNumber(realResult, imagResult);
    }

    @Override
    public Number divide(Number o){
        ComplexNumber n = (ComplexNumber) o;
        ComplexNumber conjugate = n.getConjugate();
        ComplexNumber numerator = (ComplexNumber) multiply(conjugate);
        ComplexNumber denominator = (ComplexNumber) n.multiply(conjugate);
        Fraction realResult = (Fraction) numerator.getReal().divide(denominator.getReal());
        Fraction imagResult = (Fraction) numerator.getImag().divide(denominator.getReal());
        realResult.reduce();
        imagResult.reduce();
        return new ComplexNumber(realResult, imagResult);
    }

    public String toString(){
        if(imag.getNum() > 0){
            return real.toString() + "+" + imag.toString() + "i";
        }
        return real.toString() + "-" +  imag.toString() + "i";
    }
}
