public class Student extends Person {
    private int id;

    public Student(String n) {
        super(n);
        id = (int) (Math.random() * 100000);
    }

    public int getID() {
        return id;
    }

    public String toString() {
        return getName() + "; ID: " + id;
    }
}
