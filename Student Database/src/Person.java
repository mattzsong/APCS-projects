public class Person {
    private String name;
    public static int personCount = 0;

    public Person(String n) {
        name = n;
        personCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString() {
        return name;
    }
}