public class MagicSquareCreator extends MagicSquare {

    public MagicSquareCreator(int sL) {
        super(sL);
    }

    public void generateMagicSquare(int startNumber) {
        //magic square generation method from "The problem of the magical square according to the Indians"
        // in the book "A new historical relation of the kingdom of Siam (Du Royaume de Siam, 1693)"
        // https://en.wikipedia.org/wiki/Magic_square#A_method_for_constructing_a_magic_square_of_odd_order
        
        int rowIndex = getSideLength() * getSideLength();
        int columnIndex = getSideLength() / 2;
        for(int i = 0; i < getSideLength(); i++){
            for(int j = 0; j < getSideLength(); j++){
                setElement(rowIndex % getSideLength(), columnIndex % getSideLength(), startNumber);
                startNumber++;
                rowIndex--;
                columnIndex++;
            }
            rowIndex += 2;
            columnIndex--;
        }
    }
}
