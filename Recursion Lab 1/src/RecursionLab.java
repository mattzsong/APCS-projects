import java.util.Scanner;
public class RecursionLab {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many recursion lengths will it be?");
        int n = sc.nextInt();

        pyramidRecursion(n, 0, "%");
        System.out.println("Factorial of " + n + ": " + factorial(n, 1));

    }

    static void pyramidRecursion(int n, int depth, String s){
        if(depth >= n) return;
        System.out.println(s);
        pyramidRecursion(n, depth+1, s + "%");
    }

    static int factorial(int n, int depth){
        if(depth > n) return n;
        return (depth) * factorial(n, depth+1);

    }
}
