public class EmptyListException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmptyListException() {
        super("Empty list. Cannot do calculations.");
    }
}
