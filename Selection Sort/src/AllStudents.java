public class AllStudents{
    private int studentNumber;
    private StudentInfo[] students;

    public AllStudents(int sN){
        studentNumber = sN;
        students = new StudentInfo[studentNumber];
    }

    public int getStudentNumber(){
        return studentNumber;
    }

    public StudentInfo[] getStudentInfo(){
        return students;
    }

    public void addStudents(StudentInfo s, int index){
        students[index] = s;
    }

    public void sortByName(){
        int minIndex;
        for(int i = 0; i < studentNumber; i++){
            minIndex = i;
            for(int j = i+1; j < studentNumber; j++){
                if(students[j].getName().compareTo(students[minIndex].getName()) < 0) minIndex = j; 
            }
            StudentInfo temp = students[i];
            students[i] = students[minIndex];
            students[minIndex] = temp;
        }
    }

    public void sortByFinalAverage(){
        int maxIndex;
        for(int i = 0; i < studentNumber; i++){
            maxIndex = i;
            for(int j = i+1; j < studentNumber; j++){
                if(students[j].getFinalAverage() > students[maxIndex].getFinalAverage()) maxIndex = j; 
            }
            StudentInfo temp = students[i];
            students[i] = students[maxIndex];
            students[maxIndex] = temp;
        }
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < studentNumber; i++){
            s += students[i].toString() + '\n';
        }
        return s;
    }
}