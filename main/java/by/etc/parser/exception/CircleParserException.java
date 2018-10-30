package by.etc.parser.exception;

import java.io.Serializable;

public class CircleParserException extends Exception implements Serializable {

    private static final long serialVersionUID = -6022073655662259076L;

    public CircleParserException() {
    }

    public CircleParserException(String s) {
        super(s);
    }

    public CircleParserException(String s, Exception e) {
        super(s, e);
    }

    public CircleParserException(Exception e) {
        super(e);
    }
}
