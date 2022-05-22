package domain;

import java.io.Serializable;

public abstract class Comodin extends Elemento implements Serializable {
    public Comodin(){

    }

    public abstract void mostrarPoder();
    public abstract void usarPoder();

}
