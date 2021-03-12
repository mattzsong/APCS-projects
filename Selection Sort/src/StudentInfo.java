public class StudentInfo {
    private String name;
    private int yog;
    private int[] quarterAverages;

    public StudentInfo(String n, int yog, int[] qA){
        name = n;
        this.yog = yog;
        quarterAverages = qA;
    }

    public String getName(){
        return name;
    }

    public int getYOG(){
        return yog;
    }
    
    public int[] getQuarterAverages(){
        return quarterAverages;
    }
     
    public double getFinalAverage(){
        int sum = 0;
        for(int i = 0; i < 4; i++) sum += quarterAverages[i];
        return sum / 4.0;
    }

    public String toString(){
        return name + ", " + yog + ", " + getFinalAverage();
    }
}
