package presentation;

import javax.swing.*;
import java.awt.*;

public class ElementoGUI {

    protected Image imagen;
    protected String color;
    protected String tipo;

    public ElementoGUI(String tipo){
        this.tipo = tipo;
    }

    public void cambiarTipo(String tipo){
        this.tipo = tipo;
    }

    protected Image creadorImagen(String color){
        this.color = color;
        if (color.equals("noTiene")){
            imagen = new ImageIcon(getClass().getResource("/imagenes/Comodin"+tipo+".png")).getImage();
        }else{
            imagen = new ImageIcon(getClass().getResource("/imagenes/CircleP10"+color+tipo+".png")).getImage();
        }
        return imagen;
    }
}
