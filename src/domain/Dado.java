package domain;

import java.util.Random;

public class Dado {
    int valor;
    Random random;
    public Dado(){
        valor = 1;
        random = new Random();
    }
    public int tirarDado() {
        valor = random.nextInt(6)+1;
        valor = 5;
        return valor;
    }
}

