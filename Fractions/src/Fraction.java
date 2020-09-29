public class Fraction{
    //class variables
    private int num, denom;

    //constructor
    public Fraction(int num, int denom){
        this.num = num;
        this.denom = denom;
    }

    //getter and setter methods
    public int getNum(){
        return num;
    }
    public int getDenom(){
        return denom;
    }

    public void setNum(int num){
        this.num = num;
    }
    public void setDenom(int denom){
        this.denom = denom;
    }
    
    //operation methods with other fractions
    public Fraction addFrac(Fraction other){
        int resultDenominator = this.denom * other.getDenom();
        int resultNumerator = this.num * other.getDenom() + other.getNum() * this.denom;
        return new Fraction(resultNumerator, resultDenominator);
    }
    public Fraction subtractFrac(Fraction other){
        int resultDenominator = this.denom * other.getDenom();
        int resultNumerator = this.num * other.getDenom() - other.getNum() * this.denom;
        return new Fraction(resultNumerator, resultDenominator);
    }
    public Fraction multiplyFrac(Fraction other){
        int resultDenominator = this.denom * other.getDenom();
        int resultNumerator = this.num * other.getNum();
        return new Fraction(resultNumerator, resultDenominator);
    }
    public Fraction divideFrac(Fraction other){ 
        int resultDenominator = this.denom * other.getNum();
        int resultNumerator = this.num * other.getDenom();
        return new Fraction(resultNumerator, resultDenominator);
    }
    public void reduce(){
        //reduces fraction to lowest terms 
        int gcf = Math.min(Math.abs(this.num), Math.abs(this.denom));   //smaller absolute value integer between numerator and denominator
        boolean found = false;
        while(!found){                                                  //decrement gcf until one is found, and divide the gcf by numerator and denominator
            if(this.num % gcf == 0 && this.denom % gcf == 0){
                found = true;
                this.num /= gcf;  
                this.denom /= gcf;
            }
            else    gcf--;
        }
        if(this.denom < 0){                                              //correct for negative denominator
            this.num *= -1;
            this.denom *= -1;
        }
    }
}