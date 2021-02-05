import java.util.*;

public class Undergraduate extends Student {
    private char grade;
    private HashMap<Character, String> gradeKey;
    public static int undergradCount = 0;

    public Undergraduate(String n, char g) {
        super(n);
        grade = g;
        gradeKey = new HashMap<>();
        gradeKey.put('f', "Freshman");
        gradeKey.put('o', "Sophomore");
        gradeKey.put('j', "Junior");
        gradeKey.put('s', "Senior");
        undergradCount++;
    }

    public char getGrade() {
        return grade;
    }

    public String toString() {
        return getName() + "; ID: " + getID() + "; Grade: " + gradeKey.get(grade);
    }

    public boolean equals(Undergraduate o) {
        return grade == o.grade;
    }
}
