package domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ParchisTest extends Parchis{
    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoRojo = new ArrayList<>();
    private int cantJugadores = 2;


    public ParchisTest() {
        super(new ArrayList<String>() {{
            add("Borde");
            add("Borde");
            add("Borde");
            add("Borde");
        }}, new ArrayList<String>() {{
            add("Borde");
            add("Borde");
            add("Borde");
            add("Borde");
        }}, new ArrayList<String>() {{
            add("Borde");
            add("Borde");
            add("Borde");
            add("Borde");
        }}, new ArrayList<String>() {{
            add("Borde");
            add("Borde");
            add("Borde");
            add("Borde");
        }}, 2);
    }
    @Test
    void DeberiaMoverLaFicha(){

    }
}
