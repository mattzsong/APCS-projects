import java.util.*;

public class MagicSquareInterface {
    public static void main(String[] args) {
        int sideLength;
        char moveInput;
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to check or generate a magic square? (g for generate, c for check)");
        moveInput = retrieveOperation(sc, new char[] { 'g', 'c' });

        if (moveInput == 'g') {                                         //generating magic square
            System.out.print("Enter the side length of the square: ");
            sideLength = retrieveSideLength(sc, moveInput);
            MagicSquareCreator square = new MagicSquareCreator(sideLength);
            System.out.print("Enter the starting number: ");
            int startNumber = retrieveStartNumber(sc);
            square.generateMagicSquare(startNumber);
            System.out.println("Generated Magic Square: ");
            square.printSquare();
        } else {                                                       //checking magic square
            System.out.print("Enter the side length of the square: ");
            sideLength = retrieveSideLength(sc, moveInput);
            MagicSquare square = new MagicSquare(sideLength);
            fillSquare(square, sc);
            System.out.println("Inputted Square: ");
            square.printSquare();
            if (square.checkMagic() == -1)
                System.out.println("The square is not a magic square.");
            else
                System.out.println("The square is a magic square with a sum of " + square.checkMagic() + ".");
        }
    }

    static void fillSquare(MagicSquare s, Scanner sc) {
        // putting user inputs into square
        HashSet<Integer> checkSet = new HashSet<>();
        for (int i = 0; i < s.getSideLength(); i++) {
            for (int j = 0; j < s.getSideLength(); j++) {
                System.out.print("Enter a number for row " + (i + 1) + " and column " + (j + 1) + ": ");
                s.setElement(i, j, retrieveSquareElement(sc, checkSet));
            }
        }
    }

    static int retrieveSquareElement(Scanner sc, HashSet<Integer> checkSet) {
        // obtaining and error checking an element for checking magic square
        while (true) {
            String s = sc.next();
            try {
                int element = Integer.parseInt(s);
                if (element > 0) {
                    if (!checkSet.contains(element)) {
                        checkSet.add(element);
                        return element;
                    } else
                        System.out.print("Invalid input: magic squares do not have repeats. Try again: ");
                } else
                    System.out.print("Invalid input: magic square element is positive. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input: the input was not an integer. Try again: ");
            }
        }
    }

    static int retrieveStartNumber(Scanner sc) {
        // obtaining and error checking starting number for generating square
        while (true) {
            String s = sc.next();
            try {
                int start = Integer.parseInt(s);
                if (start > 0) {
                    return start;
                } else
                    System.out.print("Invalid input: magic square element is positive. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input: the input was not an integer. Try again: ");
            }
        }
    }

    static char retrieveOperation(Scanner sc, char[] validOps) {
        // obtaining and error checking action input
        while (true) {
            char op = sc.next().charAt(0);
            for (int i = 0; i < validOps.length; i++) {
                if (op == validOps[i])
                    return op;
            }
            System.out.print("Invalid input: the input does not correspond to an operation. Try again: ");
        }
    }

    static int retrieveSideLength(Scanner sc, char moveInput) {
        // obtaining and error checking side length input
        if (moveInput == 'g') {
            while (true) {
                String s = sc.next();
                try {
                    int sL = Integer.parseInt(s);
                    if (sL >= 3 && sL % 2 == 1)
                        return sL;
                    else
                        System.out.print("Invalid input: the side length is an odd number greater than 3. Try again: ");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input: the input was not an integer. Try again: ");
                }
            }
        } else

        {
            while (true) {
                String s = sc.next();
                try {
                    int sL = Integer.parseInt(s);
                    if (sL >= 2 && sL <= 8)
                        return sL;
                    else
                        System.out.print("Invalid input: the side length has to be between 2 and 8. Try again: ");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input: the input was not an integer. Try again: ");
                }
            }
        }
    }
}
