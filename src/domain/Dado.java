package domain;

import java.io.Serializable;
import java.util.Random;

/**
 * Clase Dado que representa un dado del juego POOBChis
 */
public class Dado implements Serializable {
    int valor;
    Random random;
    /**
     * Constructor de la clase Dado, el cual inicializa su valor en 1 y crea un random que se usará luego para actualizar su valor
     */
    public Dado(){
        valor = 1;
        random = new Random();
    }
    /**
     * Método que emula la acción de tirar un dado ejecutando un random con valores posibles desde 1 a 6
     * @return retorna el valor actualizado
     */
    public int tirarDado() {
        valor = random.nextInt(6)+1;
        return valor;
    }
}

