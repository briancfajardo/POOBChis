package domain;

public class ParchisException extends Exception {
    public static final String GENERAL_EXCEPTION= "No se escribió un nombre para guardar el archivo";
    public static final String CARACTERES_EXCEPTION= "El mensaje ingresado no es válido debido a que contiene caracteres especiales no compatibles";
    public static final String ERR_EXTENSION_GUARDAR= "No contiene la extensión determinada para guardar el archivo";
    public static final String ERR_EXTENSION_ABRIR= "No contiene la extensión determinada para guardar el archivo";
    public static final String SIN_NOMBRE_EXCEPTION = "No has ingresado un nombre";

    public static final String FALTA_CONFIGURACION = "No has completado la configuración de tus fichas";
    public ParchisException(String msg){
        super(msg);
    }
}
