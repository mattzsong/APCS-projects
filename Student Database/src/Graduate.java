public class Graduate extends Student {
    private String major;

    public Graduate(String n, String m) {
        super(n);
        major = m;
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
