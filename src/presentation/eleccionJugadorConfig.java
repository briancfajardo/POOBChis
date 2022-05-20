package presentation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class eleccionJugadorConfig extends JFrame {
    private int ancho = 900;
    private int alto = 500;

    private eleccionJugadorConfig.Fondo fondo = new eleccionJugadorConfig.Fondo();


    /**
     * Constructor de la clase KalahGUI
     */
    public eleccionJugadorConfig(){
        this.setContentPane(fondo);
        setTitle("Escoger el jugador que se configurará");
        prepareElements();
        prepareActions();
        setVisible(true);

    }

    /**
     * Prepara los elementos de la ventana inicial
     * Modifica el tamaño y añade el menú y los botones iniciales
     */
    private void prepareElements(){
        setSize(ancho,alto);
        prepareElementsBeginning();
    }


    /**
     * Prepara los elementos necesarios para los botones principales
     * dentro de la pantalla de inicio, incluyendo el título y dos botones
     *
     * Le agrega a cada botón su propio oyente para que realiza el evento
     * correspondiente
     */
    private void prepareElementsBeginning(){
        JPanel panelBotones = new JPanel();
        Button jugador1 = new Button("Jugador1");
        Button jugador2 = new Button("Jugador2");
        Button jugador3 = new Button("Jugador3");
        Button jugador4 = new Button("Jugador4");

        jugador1.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        jugador1.setBackground(new Color(248, 197, 27));
        jugador1.setSize(30,30);
        jugador1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormatoJugador formato1 = new FormatoJugador(4);
                formato1.setResizable(false);
                formato1.setLocationRelativeTo(null);
                dispose();
            }
        });

        jugador2.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        jugador2.setBackground(new Color(248, 197, 27));
        jugador2.setSize(30,30);
        jugador2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormatoJugador formato1 = new FormatoJugador(4);
                formato1.setResizable(false);
                formato1.setLocationRelativeTo(null);
                dispose();
            }
        });

        jugador3.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        jugador3.setBackground(new Color(248, 197, 27));
        jugador3.setSize(30,30);
        jugador3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugador3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormatoJugador formato1 = new FormatoJugador(4);
                formato1.setResizable(false);
                formato1.setLocationRelativeTo(null);
                dispose();
            }
        });

        jugador4.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        jugador4.setBackground(new Color(248, 197, 27));
        jugador4.setSize(30,30);
        jugador4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugador4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormatoJugador formato1 = new FormatoJugador(4);
                formato1.setResizable(false);
                formato1.setLocationRelativeTo(null);
                dispose();
            }
        });


        panelBotones.setBorder(new CompoundBorder(new EmptyBorder(100,1000,30,1000),
                new TitledBorder("")));
        panelBotones.setLayout(new GridLayout(1,2));
        panelBotones.add(jugador1);
        panelBotones.add(jugador2);
        panelBotones.add(jugador3);
        panelBotones.add(jugador4);
        panelBotones.setOpaque(false);

        setLayout(new FlowLayout());

        add(panelBotones);


    }

    /**
     * Modifica la acción de cerrar
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        InicioGUI inicio = new InicioGUI();
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);
    }
    class Fondo extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagenes/Fondo2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
