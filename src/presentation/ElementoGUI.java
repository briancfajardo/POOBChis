package presentation;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Clase ElementoGUI la cual está encargada de crear las imágenes necesarias desde la carpeta imagenes
 */
public class ElementoGUI  implements Serializable {

    private Image imagen;
    private String color;
    protected String tipo;

    /**
     * Constructor de la clase ElementoGUI
     * @param tipo tipo de elemento del que se le desea crear la imagen
     */
    public ElementoGUI(String tipo){
        this.tipo = tipo;
    }

    /**
     * Método que sirve para cambiar el tipo de elemento
     * @param tipo
     */
    public void cambiarTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Creador de imagenes a partir del color y tipo de elemento
     * @param color color del elemento que se desea
     * @return imagen ya creada
     */
    public Image creadorImagen(String color){
        this.color = color;
        if (color.equals("noTiene")){
            imagen = new ImageIcon(getClass().getResource("/imagenes/Comodin"+tipo+".png")).getImage();
        }else{
            imagen = new ImageIcon(getClass().getResource("/imagenes/CircleP10"+color+tipo+".png")).getImage();
        }
        return imagen;
    }
}
