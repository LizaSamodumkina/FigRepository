package by.etc.warehouse.exception;

public class WarehouseException extends Exception {

    private static final long serialVersionUID = 3221849656045239704L;

    public WarehouseException() {
    }

    public WarehouseException(String message) {
        super(message);
    }

    public WarehouseException(String message, Exception e) {
        super(message, e);
    }

    public WarehouseException(Exception e) {
        super(e);
    }
}
