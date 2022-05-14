package domain;

public class ParchisException extends Exception {
    public static final String GENERAL_EXCEPTION= "Excepcion general del usuario";

    public ParchisException(String msg){
        super(msg);
    }
}
