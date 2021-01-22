public class Date implements Comparable<Date>{
    private int day;
    private int month;
    private int year;
    private int[] daysPerMonth;
    
    public Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
        if(isLeapYear(y)) daysPerMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else              daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public int compareTo(Date other){
        if(y == other.y){
            if(m == other.m) return d-other.d;
            return m-other.m;
        }
        return y-other.y;
    }

    public String toString(){
        
    }

    private boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 400 == 0 || year % 100 != 0){
                return true;
            }
        }
        return false;
    }
}
