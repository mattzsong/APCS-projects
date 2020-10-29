public class MagicSquare {

    private int[][] square;
    private int sideLength;

    //constructor
    public MagicSquare(int sL) {
        this.sideLength = sL;
        this.square = new int[sL][sL];
    }

    //getters and setters
    public void setSideLength(int sL){
        this.sideLength = sL;
    }

    public void setElement(int i, int j, int element) {
        square[i][j] = element;
    }

    public int getSideLength() {
        return sideLength;
    }

    //check for magic square
    public int checkMagic() {
        //returns the magic square sum, or -1 if it is not a magic square
        
        //check rows
        int rowSum = 0;
        for (int i = 0; i < sideLength; i++) {
            rowSum += square[0][i];
        }
        for (int i = 1; i < sideLength; i++) {
            int currentRow = 0;
            for (int j = 0; j < sideLength; j++) {
                currentRow += square[i][j];
            }
            if (currentRow != rowSum)
                return -1;
        }

        //check columns
        int columnSum = 0;
        for (int i = 0; i < sideLength; i++) {
            columnSum += square[i][0];
        }
        for (int i = 1; i < sideLength; i++) {
            int currentColumn = 0;
            for (int j = 0; j < sideLength; j++) {
                currentColumn += square[j][i];
            }
            if (currentColumn != columnSum)
                return -1;
        }

        //check diagonals
        int diagonalLeft = 0;
        int diagonalRight = 0;
        for (int i = 0; i < sideLength; i++) {
            diagonalLeft += square[i][i];
            diagonalRight += square[i][sideLength - i - 1];
        }
        if (diagonalLeft != diagonalRight)
            return -1;

        //compare sums
        if (diagonalLeft == rowSum && rowSum == columnSum)
            return rowSum;
        return -1;
    }

    public void printSquare() {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

}