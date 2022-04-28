package presentation;

import domain.prueba;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    public Game() {
        super("POOBChisGame");
        prepareElements();
    }

    public void prepareElements() {
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(grid);

        setSize(900, 900);
        //init();
        //crearBoton();
        //crearPanel();
        tab();

        setVisible(true);
        //repaint();

    }

    protected void makebutton(String name) {
        Button button = new Button(name);
        grid.setConstraints(button, constraints);
        add(button);
    }

    public void tab(){
        constraints.fill = GridBagConstraints.BOTH;

        carcel();

        //Casillas primera parte
        int cont = 0;
        constraints.gridx = 8;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        int cont2 = 0;
        int cont3 = 1;
        //constraints.gridwidth = GridBagConstraints.RELATIVE;

        for (int i = 0; i <= 47; i++){
            makebutton("Casilla");
            constraints.gridx += 2;
            cont += 1;

            if (cont == 3) {
                constraints.gridx = 8;
                constraints.gridy = 14 + cont2;
            }

            if (cont == 6){
                cont2 += 1;
                constraints.gridy = cont3;
                cont3 += 1;
                cont = 0;
                constraints.gridx = 8;
            }
        }


        //Casillas segunda parte
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.gridy = 8;
        constraints.gridx = 0;
        cont = 0;

        for (int i = 0; i <= 47; i++){
            makebutton("1");
            constraints.gridx += 1;
            cont += 1;

            if (cont == 8){
                constraints.gridx = 14;
            }

            if (cont == 16){
                constraints.gridy += 2;
                constraints.gridx = 0;
                cont = 0;
            }
        }
    }

    public void carcel(){
        //Primera carcel
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        makebutton("Carcel");

        //Segunda carcel
        constraints.gridx = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        makebutton("Carcel");

        //Centro
        constraints.gridx = 8;
        constraints.gridwidth = 6;
        constraints.gridheight = 6;
        constraints.gridy = 8;
        makebutton("Colores");

        //Tercera carcel
        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        makebutton("Carcel");

        //Cuarta carcel
        constraints.gridx = 14;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        makebutton("Carcel");


    }

    public static void main (String args[]){
        Game u = new Game();
    }
}
