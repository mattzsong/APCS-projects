public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;
    private int[] daysPerMonth;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
        if (isLeapYear(y))
            daysPerMonth = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        else
            daysPerMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    }

    public boolean checkValid() {
        if (year > 0 && month > 0 && month <= 12 && day > 0 && day <= daysPerMonth[month - 1])
            return true;
        return false;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int[] getDaysPerMonth() {
        return daysPerMonth;
    }

    public void setYear(int y) {
        year = y;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setDay(int d) {
        day = d;
    }

    public int compareTo(Date other) {
        if (year == other.getYear()) {
            if (month == other.getMonth())
                return day - other.getDay();
            return month - other.getMonth();
        }
        return year - other.getYear();
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public int dayDifference(Date prev) {
        int diff = 0;
        for (int i = prev.getYear(); i < year; i++) {
            //TODO: Fix year logic
            if (isLeapYear(i-1) && new Date(prev.getDay(), prev.getMonth(), i-1).compareTo(new Date(2, 29, i-1)) < 0)
                diff += 366;
            else diff += 365;
            if (isLeapYear(i) && new Date(prev.getDay(), prev.getMonth(), i-1).compareTo(new Date(2, 28, i)) > 0)
                diff += 366;
            else diff += 365;
        }

        if (prev.getMonth() > month) {
            for (int i = month; i < prev.getMonth(); i++) {
                diff -= daysPerMonth[i - 1];
            }
        } else {
            for (int i = prev.getMonth(); i < month; i++) {
                diff += daysPerMonth[i - 1];
            }
        }

        if (prev.getDay() > day) {
            diff -= prev.getDay() - day;
        } else {
            diff += day - prev.getDay();
        }

        return diff;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0 || year % 100 != 0) {
                return true;
            }
        }
        return false;
    }
}
