import java.util.Scanner;
public class CharactersInterface {
    public static void main(String[] args) throws Exception {
        //get the user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        sc.close();

        //create the calculator and display counts and frequencies of input
        CharacterCalculator calc = new CharacterCalculator(input);
        calc.displayInfo();
    }
}
