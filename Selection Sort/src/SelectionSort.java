import java.util.*;
public class SelectionSort {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n;
        while(true){
            try{
                n = retrieveStudentNumber(sc);
                break;
            } catch(InvalidOperationException e){
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Not an integer input.");
            }
        }

        AllStudents as = new AllStudents(n);
        while(true){
            try{
                for(int i = 0; i < n; i++){
                    StudentInfo s = retrieveStudentInfo(sc);
                    as.addStudents(s, i);
                }
                break;
            } catch(InvalidOperationException e){
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println("Not an integer input.");
            }
        }

        Statistics s = new Statistics(as);
        while(true){
            System.out.println("Enter n for sorted by names, f for sorted by final averages, m for mean, e for median, o for modes, s for standard deviation, q for quit");
            try{
                char op = retrieveOperation(sc, new char[]{'n','f','m','e','o','s','q'});
                if(op == 'n'){
                    as.sortByName();
                    for(int i = 0; i < as.getStudentInfo().length; i++){
                        System.out.println(as.getStudentInfo()[i]);
                    }
                }
                else if(op == 'f'){
                    as.sortByFinalAverage();
                    for(int i = 0; i < as.getStudentInfo().length; i++){
                        System.out.println(as.getStudentInfo()[i]);
                    }
                }
                else if(op == 'm'){
                    double[] means = s.getMeans();
                    for(int i = 1; i <= 4; i++){
                        System.out.print("Q" + i + " " + means[i-1] + " ");
                    }
                }
                else if(op == 'e'){
                    double[] medians = s.getMedians();
                    for(int i = 1; i <= 4; i++){
                        System.out.print("Q" + i + " " + medians[i-1] + " ");
                    }
                }
                else if(op == 'o'){
                    ArrayList<Integer>[] modes = s.getModes();
                    for(int i = 1; i <= 4; i++){
                        if(modes[i-1] == null){
                            System.out.println("Q" + i + ": NONE");
                        }
                        else    System.out.println("Q" + i + ": " + modes[i-1]);
                    }
                }
                else if(op == 's'){
                    double[] sds = s.getStandardDeviations();
                    for(int i = 1; i <= 4; i++){
                        System.out.print("Q" + i + " " + sds[i-1] + " ");
                    }
                }
            } catch (InvalidOperationException e) {
                System.out.println(e);
            }
        }
    }

    static StudentInfo retrieveStudentInfo(Scanner sc) throws Exception{
        System.out.print("Name: ");
        String name = sc.next();
        System.out.println("Year of graduation: ");
        int yog = sc.nextInt();
        System.out.println("Enter the quarter grades as integers separated by a space.");
        int[] quarterAvgs = new int[4];
        for(int i = 0; i < 4; i++){
            quarterAvgs[i] = sc.nextInt();
        }
        return new StudentInfo(name, yog, quarterAvgs);
    }

    static int retrieveStudentNumber(Scanner sc) throws Exception{
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        if(n < 1 || n > 15) throw new InvalidOperationException("Number of students has to be between 1 and 15");
        return n;
    }

    static char retrieveOperation(Scanner sc, char[] valid) throws Exception {
        char op = sc.next().charAt(0);
        for (int i = 0; i < valid.length; i++) {
            if (op == valid[i])
                return op;
        }
        throw new InvalidOperationException("Invalid input: Not a valid operation.");
    }

    public static class InvalidOperationException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidOperationException(String string) {
            super(string);
        }
    }
}
