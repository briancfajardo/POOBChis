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
 * Clase ConfiguracionInicialGUI que hereda de Jframe
 */
public class ConfigInicialGUI extends JFrame {
    private int ancho = 900;
    private int alto = 500;
    private Fondo fondo = new Fondo();
    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JLabel turno;
    private int jugadores = 4;
    private JPanel fichas;


    /**
     * Constructor de la clase ConfInicialGUI el cual se encarga de actualizar todos los elementos necesarios iniciales como el fondo título entre otros
     */
    public ConfigInicialGUI(){
        this.setContentPane(fondo);
        setTitle("POOBChis");
        prepareElements();
        prepareActions();
        setVisible(true);

    }

    /**
     * Método usado para agregar elementos al frame como el título
     */
    private void conf() {
        constraints.fill = GridBagConstraints.BOTH;
        tituloConfig();
        numJugadores();
    }

    /**
     * Método que configura y agrega el título al frame
     */
    private void tituloConfig(){
        constraints.gridx = 0;
        constraints.gridwidth = 8;
        constraints.gridheight = 3;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        turno = new JLabel();
        Font letra = new Font("Sans Serif", Font.CENTER_BASELINE, 30);
        turno.setFont(letra);
        turno.setText("Configuración POOBChis");
        turno.setForeground(new Color(0, 248, 103));
        add(turno, constraints);
    }

    /**
     * Método que agrega los JPanel que contienen los botones que contienen las opciones de la cantidad de jugadores
     */
    private void numJugadores(){
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

        Button dosJugadores = new Button("2 Jugadores");
        dosJugadores.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        dosJugadores.setSize(30,30);
        dosJugadores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dosJugadores.addActionListener(e -> {
            jugadores = 2;
            TipoJugador jugador = new TipoJugador();
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
            //System.out.println(jugadores);
        });


        Button cuatroJugadores = new Button("4 Jugadores");
        cuatroJugadores.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        cuatroJugadores.setSize(30,30);
        cuatroJugadores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cuatroJugadores.addActionListener(e -> {
            jugadores = 4;
            randomEleccion jugador = new randomEleccion(jugadores);
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
        });
        //opcionFichas();
        panelJugadores.add(dosJugadores);
        panelJugadores.add(cuatroJugadores);
        add(panelJugadores, constraints);
        repaint();
    }
    /**
     * Prepara los elementos de la ventana ConfigInicialGUI
     * Modifica el tamaño y configura el Layout correspondiente
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

    /**
     * Clase auxiliar que configura el fondo para poderlo usar
     */
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
