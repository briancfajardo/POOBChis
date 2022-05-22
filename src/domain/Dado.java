package domain;

import java.io.Serializable;
import java.util.Random;

public class Dado implements Serializable {
    int valor;
    Random random;
    public Dado(){
        valor = 1;
        random = new Random();
    }
    public int tirarDado() {
        valor = random.nextInt(6)+1;
        return valor;
    }
}

