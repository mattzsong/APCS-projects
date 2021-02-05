public class Graduate extends Student {
    private String major;
    public static int gradCount = 0;

    public Graduate(String n, String m) {
        super(n);
        major = m;
        gradCount++;
    }

    public String getMajor() {
        return major;
    }

    public String toString() {
        return getName() + "; ID: " + getID() + "; Major: " + major;
    }

    public boolean equals(Graduate o) {
        return major.equals(o.getMajor());
    }
}
