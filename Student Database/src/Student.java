public class Student extends Person {
    private int id;
    public static int studentCount = 0;

    public Student(String n) {
        super(n);
        id = (int) (Math.random() * 100000);
        studentCount++;
    }

    public int getID() {
        return id;
    }

    public String toString() {
        return getName() + "; ID: " + id;
    }
}
