package domain;

public class ParchisException extends Exception {
    public static final String GENERAL_EXCEPTION= "Excepcion general del usuario";
    public static final String CARACTERES_EXCEPTION= "El mensaje ingresado no es válido debido a que contiene caracteres especiales no compatibles";

    public ParchisException(String msg){
        super(msg);
    }
}
