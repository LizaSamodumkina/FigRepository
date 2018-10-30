package by.etc.action.exception;

import java.io.Serializable;

public class ActionException extends Exception implements Serializable {

    private static final long serialVersionUID = 6866480342527517232L;

    public ActionException() {
    }

    public ActionException(String s) {
        super(s);
    }

    public ActionException(String s, Exception e) {
        super(s, e);
    }

    public ActionException(Exception e) {
        super(e);
    }
}
