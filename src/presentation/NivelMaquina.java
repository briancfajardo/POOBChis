package presentation;

import domain.Parchis;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Clase NivelMaquina que se encarga de la elección de las dificultades de la máquina
 */
public class NivelMaquina extends JFrame {
    private int ancho = 900;
    private int alto = 500;
    private Fondo fondo = new Fondo();
    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JLabel turno;
    private int jugadores = 2;
    private JPanel fichas;


    /**
     * Constructor de la clase NivelMáquina
     */
    public NivelMaquina(){
        this.setContentPane(fondo);
        setTitle("POOBChis");
        prepareElements();
        prepareActions();
        setVisible(true);
    }

    /**
     * Método que configura las opciones iniciales
     */
    private void conf() {
        constraints.fill = GridBagConstraints.BOTH;
        tituloConfig();
        modoJugadores();
    }

    /**
     * configura el título de la ventana
     */
    private void tituloConfig(){
        constraints.gridx = 0;
        constraints.gridwidth = 10;
        constraints.gridheight = 3;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        turno = new JLabel();
        Font letra = new Font("Sans Serif", Font.CENTER_BASELINE, 30);
        turno.setFont(letra);
        turno.setText("Perfiles de las máquinas");
        turno.setForeground(new Color(0, 248, 103));
        add(turno, constraints);
    }

    /**
     * Método que configura el modo de juego de los jugadores
     */
    private void modoJugadores(){
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 3;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.BOTH;
        JPanel panelJugadores = new JPanel();
        panelJugadores.setOpaque(false);

        panelJugadores.setBorder(new CompoundBorder(new EmptyBorder(20,100,20,50),
                new TitledBorder("")));
        panelJugadores.setLayout(new GridLayout(1,2));
        //panelJugadores.setLayout(new FlowLayout());

        Button dosJugadores = new Button("Principiante");
        dosJugadores.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        dosJugadores.setSize(30,30);
        dosJugadores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dosJugadores.addActionListener(e -> {
            randomEleccion jugador = new randomEleccion(jugadores);
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
            //System.out.println(jugadores);
        });


        Button jugMaquina = new Button("Experto");
        jugMaquina.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        jugMaquina.setSize(30,30);
        jugMaquina.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugMaquina.addActionListener(e -> {
            randomEleccion jugador = new randomEleccion(jugadores);
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
        });
        //opcionFichas();
        panelJugadores.add(dosJugadores);
        panelJugadores.add(jugMaquina);
        add(panelJugadores, constraints);
        repaint();
    }
    /**
     * Prepara los elementos de la ventana inicial
     * Modifica el tamaño y añade el menú y los botones iniciales
     */
    private void prepareElements() {
        setSize(ancho, alto);
        setLayout(grid);
        conf();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }



    /**
     * Modifica la acción de cerrar
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
