package presentation;

import domain.Parchis;
import domain.ParchisException;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class InicioGUI extends JFrame implements ActionListener{
    private int ancho = 900;
    private int alto = 500;
    private JMenuBar menu;
    private JMenu archivoM;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem salir;
    private Fondo fondo = new Fondo();

    private TableroGUI nuevaPartida;

    static private final InicioGUI juego = new InicioGUI();


    /**
     * Constructor de la clase KalahGUI
     */
    private InicioGUI(){
        this.setContentPane(fondo);
        setTitle("POOBChis");
        prepareElements();
        prepareActions();
        setVisible(true);
        inicializarTipos();
    }

    private static InicioGUI getJuego(){
        return juego;
    }
    private void inicializarTipos(){

        ArrayList<String> Tamarillo = new ArrayList<>();
        ArrayList<String> Tazul = new ArrayList<>();
        ArrayList<String> Trojo = new ArrayList<>();
        ArrayList<String> Tverde = new ArrayList<>();

        Tamarillo.add("Borde");
        Tamarillo.add("Borde");
        Tamarillo.add("Borde");
        Tamarillo.add("Borde");

        Tazul.add("Borde");
        Tazul.add("Borde");
        Tazul.add("Borde");
        Tazul.add("Borde");

        Tverde.add("Borde");
        Tverde.add("Borde");
        Tverde.add("Borde");
        Tverde.add("Borde");

        Trojo.add("Borde");
        Trojo.add("Borde");
        Trojo.add("Borde");
        Trojo.add("Borde");

        nuevaPartida = new TableroGUI(Tamarillo, Tazul, Trojo, Tverde, 2,
                "amarillo", "azul", "verde", "rojo");
        nuevaPartida.setVisible(false);

    }


    /**
     * Prepara los elementos de la ventana inicial
     * Modifica el tamaño y añade el menú y los botones iniciales
     */
    private void prepareElements(){
        setSize(ancho,alto);
        prepareElementsMenu();
        prepareElementsBeginning();
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

        //config = new JMenuItem("Configuración");
        //config.addActionListener(this);
        //config.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //menu.add(config);

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        salvar = new JMenuItem("Salvar");
        salir = new JMenuItem("Salir");

        nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        abrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        salvar.addActionListener(this);
        salir.addActionListener(this);

        archivoM.add(nuevo);
        archivoM.add(abrir);
        archivoM.add(salvar);
        archivoM.add(salir);

    }

    /**
     * Prepara los elementos necesarios para los botones principales
     * dentro de la pantalla de inicio, incluyendo el título y dos botones
     *
     * Le agrega a cada botón su propio oyente para que realiza el evento
     * correspondiente
     */
    private void prepareElementsBeginning(){
        JLabel titulo = new JLabel("POOBChis");
        Button juego = new Button("Nuevo Juego");
        Button salir = new Button("Salir");
        JPanel panelBotones = new JPanel();

        JPanel panelSalir = new JPanel();

        juego.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 20));
        juego.setBackground(new Color(120, 222, 167));
        juego.setSize(40,40);
        juego.setCursor(new Cursor(Cursor.HAND_CURSOR));
        juego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigInicialGUI configInicialGUI = new ConfigInicialGUI();
                configInicialGUI.setResizable(false);
                configInicialGUI.setLocationRelativeTo(null);
                dispose();
            }
        });


        panelBotones.setBorder(new CompoundBorder(new EmptyBorder(100,1000,30,1000),
                new TitledBorder("")));
        panelBotones.setLayout(new GridLayout(1,2));
        panelBotones.add(juego);
        panelBotones.setOpaque(false);

        setLayout(new FlowLayout());

        panelSalir.setBorder(new CompoundBorder(new EmptyBorder(30,1000,30,1000),
                new TitledBorder("")));
        panelSalir.setLayout(new GridLayout(1,1));


        salir.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 20));
        salir.setSize(40,40);
        salir.setBackground(new Color(120, 222, 167));
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelSalir.add(salir);
        panelSalir.setOpaque(false);


        titulo.setForeground(new Color(0, 248, 103));
        titulo.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 100));

        add(titulo);
        add(panelBotones);
        add(panelSalir);


    }

    /**
     * Modifica la acción de cerrar
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    /**
     * Evento que se realiza cuando se da clic en el botón de abrir
     * Genera un JFileChooser
     */
    private void abrirArchivos(){
        nuevaPartida.abrirArchivos();
        nuevaPartida.setLocationRelativeTo(null);
        nuevaPartida.setVisible(true);
    }

    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void salvarArchivos(){
        nuevaPartida.salvarArchivos();
        nuevaPartida.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nuevo) {
            ConfigInicialGUI configInicialGUI = new ConfigInicialGUI();
            configInicialGUI.setResizable(false);
            configInicialGUI.setLocationRelativeTo(null);
            dispose();
        }
        if (e.getSource() == abrir) {
            abrirArchivos();
            dispose();
        }
        if (e.getSource() == salvar) {
            salvarArchivos();
            dispose();
        }
        if (e.getSource() == salir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        InicioGUI inicio = getJuego();
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
