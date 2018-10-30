package by.etc.repository.exception;

public class RepositoryException extends Exception {
    private static final long serialVersionUID = 4424532489990394478L;

    public RepositoryException() {
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Exception e) {
        super(message, e);
    }

    public RepositoryException(Exception e) {
        super(e);
    }
}
