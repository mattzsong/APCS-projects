public class PeopleSearch {
    private Person[] people;

    public PeopleSearch(Person[] p) {
        people = p;
        selectionSort();
    }

    public Person[] getPeople() {
        return people;
    }

    private void selectionSort() {
        int minIndex;
        for (int i = 0; i < people.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < people.length; j++) {
                if (people[j].getName().compareTo(people[minIndex].getName()) < 0)
                    minIndex = j;
            }
            Person temp = people[i];
            people[i] = people[minIndex];
            people[minIndex] = temp;
        }
    }

    public void deletePerson(int index) {
        Person[] newPeople = new Person[people.length - 1];
        for (int i = 0; i < index; i++) {
            newPeople[i] = people[i];
        }
        for (int i = index; i < people.length - 1; i++) {
            newPeople[i] = people[i + 1];
        }
        people = newPeople;
        System.out.println("Person deleted successfully.");
    }

    public int[] binarySearch(String n) {
        int left = 0;
        int right = people.length - 1;
        int iterations = 0;
        while (left <= right) {
            iterations++;
            int mid = (left + right) / 2;
            if (people[mid].getName().compareTo(n) > 0)
                right = mid - 1;
            else if (people[mid].getName().compareTo(n) < 0)
                left = mid + 1;
            else
                return new int[] { mid, iterations };
        }
        return new int[] { -1, iterations };
    }

    public int[] sequentialSearch(String n) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getName().equals(n))
                return new int[] { i, i + 1 };
        }
        return new int[] { -1, people.length };
    }

    public void editName(int index, String n) {
        people[index].setName(n);
    }

    public void editAge(int index, int a) {
        people[index].setAge(a);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < people.length; i++) {
            s += people[i].toString() + '\n';
        }
        return s;
    }
}
