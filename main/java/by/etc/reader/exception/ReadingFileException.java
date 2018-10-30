package by.etc.reader.exception;

import java.io.Serializable;

public class ReadingFileException extends Exception implements Serializable {

    private static final long serialVersionUID = -6020031319344641820L;

    public ReadingFileException() {
    }

    public ReadingFileException(String s) {
        super(s);
    }

    public ReadingFileException(String s, Exception e) {
        super(s, e);
    }

    public ReadingFileException(Exception e) {
        super(e);
    }
}
