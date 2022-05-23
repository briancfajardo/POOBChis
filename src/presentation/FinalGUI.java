package presentation;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Clase que genera la pestaña de finalización del juego con la información
 * acerca del ganador
 */
public class FinalGUI extends JFrame implements ActionListener {

    private int ancho = 960;
    private int alto = 540;
    private FinalGUI.Fondo fondo = new FinalGUI.Fondo();
    private Button aceptar;

    private String nombre;

    private JMenuBar menu;
    private JMenu archivoM;
    private JMenuItem nuevo;
    private JMenuItem salir;

    /**
     * Constructor de la clase FinalGUI que inicializada con el nombre del ganador del juego
     * @param nombre nombre del ganador
     */
    public FinalGUI(String nombre){
        this.setContentPane(fondo);
        setTitle("POOBChis");
        this.nombre = nombre;
        prepareElements();
        prepareActions();
        setVisible(true);
    }

    /**
     * Prepara los elementos necesarios para la creación de la pestaña
     */
    private void prepareElements(){
        setSize(ancho,alto);
        prepareElementsMenu();
        prepareElementsFinal();

    }

    /**
     * Prepara los elementos necesarios para el menú, los botones y los
     * layouts correspondientes
     *
     * Crea un JMenuBar y sus respectivos JMenuItems
     *
     */
    private void prepareElementsMenu(){
        menu = new JMenuBar();
        setJMenuBar(menu);
        archivoM = new JMenu("Archivo");

        archivoM.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menu.add(archivoM);
        nuevo = new JMenuItem("Nuevo");
        salir = new JMenuItem("Salir");

        nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nuevo.addActionListener(this);
        salir.addActionListener(this);

        archivoM.add(nuevo);
        archivoM.add(salir);

    }

    /**
     * Genera los elementos necesarios para brindar la información
     * especificada a los usuarios
     *
     * El botón de aceptar retorna a la ventana inicial
     *
     */
    private void prepareElementsFinal(){

        JLabel mensaje = new JLabel("<html><center>El juego ha acabado, <br> " +
                "El jugador " + nombre + " ha ganado <br> ¡Felicitaciones! <br>" +
                "Todas sus fichas están coronadas " + " <br>" +
                "Para los otros participantes, suerte para la próxima </center><html>");

        aceptar = new Button("Aceptar");

        JPanel panelBotones = new JPanel();

        aceptar.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        aceptar.setSize(30,30);
        aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        aceptar.addActionListener(this);

        mensaje.setForeground(new Color(0,0,0));
        mensaje.setFont(new Font("Serif", Font.CENTER_BASELINE, 30));
        mensaje.setBorder(BorderFactory.createEmptyBorder(120,10,20,10));
        mensaje.setOpaque(false);

        panelBotones.setBorder(new CompoundBorder(new EmptyBorder(0,1000,30,1000),
                new TitledBorder("")));
        panelBotones.setLayout(new GridLayout(1,2));
        panelBotones.add(aceptar);
        panelBotones.setOpaque(false);


        add(mensaje);
        add(panelBotones);
    }
    /**
     * Modifica la acción de cerrar la ventana
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar){
            setVisible(false);
            InicioGUI game = new InicioGUI();
            game.setVisible(true);
            game.setResizable(false);
            game.setLocationRelativeTo(null);
            dispose();

        }if(e.getSource() == nuevo){
            ConfigInicialGUI configInicialGUI = new ConfigInicialGUI();
            configInicialGUI.setResizable(false);
            configInicialGUI.setLocationRelativeTo(null);
            dispose();
        }
        if(e.getSource() == salir){
            System.exit(0);
        }
    }
    /**
     * Clase que genera un nuevo fondo para el JFrame de una imagen dentro del
     * paquete presentation
     */
    class Fondo extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondoAceptar.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
