package by.etc.creator.exception;

import java.io.Serializable;

public class FillDataException extends Exception implements Serializable {

    private static final long serialVersionUID = 4429633975289738680L;

    public FillDataException() {
    }

    public FillDataException(String s) {
        super(s);
    }

    public FillDataException(String s, Exception e) {
        super(s, e);
    }

    public FillDataException(Exception e) {
        super(e);
    }
}
