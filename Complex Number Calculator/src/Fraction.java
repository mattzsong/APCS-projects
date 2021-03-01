public class Fraction implements Number{
    private int num, denom;

    public Fraction(int num, int denom){
        this.num = num;
        this.denom = denom;
    }

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
    
    public void reduce(){
        //reduces fraction to lowest terms 
        if(this.num == 0) return;
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

    public String toString(){
        return num + "/" + denom;
    }

    @Override
    public Number add(Number o) {
        Fraction n = (Fraction) o;
        int resultDenominator = this.denom * n.getDenom();
        int resultNumerator = this.num * n.getDenom() + n.getNum() * this.denom;
        return new Fraction(resultNumerator, resultDenominator);

    }

    @Override
    public Number subtract(Number o) {
        Fraction n = (Fraction) o;
        int resultDenominator = this.denom * n.getDenom();
        int resultNumerator = this.num * n.getDenom() - n.getNum() * this.denom;
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public Number multiply(Number o) {
        Fraction n = (Fraction) o;
        int resultDenominator = this.denom * n.getDenom();
        int resultNumerator = this.num * n.getNum();
        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public Number divide(Number o) {
        Fraction n = (Fraction) o;
        int resultDenominator = this.denom * n.getNum();
        int resultNumerator = this.num * n.getDenom();
        return new Fraction(resultNumerator, resultDenominator);
    }
}