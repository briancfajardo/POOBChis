package presentation;

import domain.Parchis;
import domain.Tablero;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Clase RandomEleccion
 */
public class randomEleccion extends JFrame {
    private int ancho = 900;
    private int alto = 500;
    private Fondo fondo = new Fondo();
    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JLabel turno;

    private String[] posiblesTipos = {"Borde", "Aspiradora", "Ventajosa", "Ingeniera", "Saltarina",
                                        "Cohete"};
    private int jugadores;
    private JPanel fichas;


    /**
     * Constructor de la clase randomEleccion
     */
    public randomEleccion(int jugadores){
        this.setContentPane(fondo);
        this.jugadores = jugadores;
        setTitle("POOBChis");
        prepareElements();
        prepareActions();
        setVisible(true);

    }

    /**
     * Método que genera tipos aleatoriamente
     * @return Array de tipos generados
     */
    private ArrayList<String> generarTipos(){
        ArrayList<String> tipos = new ArrayList<String>();
        int numero = (int)(Math.random()*4);
        tipos.add(posiblesTipos[numero]);
        numero = (int)(Math.random()*4);
        tipos.add(posiblesTipos[numero]);
        numero = (int)(Math.random()*4);
        tipos.add(posiblesTipos[numero]);
        numero = (int)(Math.random()*4);
        tipos.add(posiblesTipos[numero]);

        return tipos;
    }

    /**
     * Método que prepara las configuraciones iniciales
     */
    private void conf() {
        constraints.fill = GridBagConstraints.BOTH;
        tituloConfig();
        prepareRandom();
    }

    /**
     * método que configura la estructura del título de la ventana
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
        turno.setText("Escoger cómo se desea configurar los tipos de fichas");
        turno.setForeground(new Color(0, 248, 103));
        add(turno, constraints);
    }

    /**
     * Método que prepara la elección aleatoria
     */
    private void prepareRandom(){
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

        Button random = new Button("Random");
        random.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        random.setSize(30,30);
        random.setCursor(new Cursor(Cursor.HAND_CURSOR));
        random.addActionListener(e -> {
            FormatoComodin jugador = new FormatoComodin(generarTipos(), generarTipos(), generarTipos(), generarTipos(),
                    jugadores, "Amarillo", "Azul", "Verde", "Rojo");
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
            //System.out.println(jugadores);
        });


        Button manual = new Button("Manual");
        manual.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        manual.setSize(30,30);
        manual.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manual.addActionListener(e -> {
            eleccionJugadorConfig jugador = new eleccionJugadorConfig(jugadores);
            jugador.setResizable(false);
            jugador.setLocationRelativeTo(null);
            dispose();
        });
        //opcionFichas();
        panelJugadores.add(random);
        panelJugadores.add(manual);
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
