package by.etc.specification.exception;

public class SpecificationException extends Exception {

    private static final long serialVersionUID = -1489892848729832414L;

    public SpecificationException() {
    }

    public SpecificationException(String message) {
        super(message);
    }

    public SpecificationException(String message, Exception e) {
        super(message, e);
    }

    public SpecificationException(Exception e) {
        super(e);
    }
}
