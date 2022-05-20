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

public class ConfigInicialGUI extends JFrame {
    private int ancho = 900;
    private int alto = 500;
    private JMenuBar menu;
    private JMenu archivoM;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem salir;
    private JFileChooser archivos;
    private File partida;
    private Fondo fondo = new Fondo();
    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JLabel turno;
    private int jugadores = 4;
    private JPanel fichas;


    /**
     * Constructor de la clase KalahGUI
     */
    public ConfigInicialGUI(){
        this.setContentPane(fondo);
        setTitle("POOBChis");
        prepareElements();
        prepareActions();
        conf();
        setVisible(true);

    }
    private void conf() {
        constraints.fill = GridBagConstraints.BOTH;
        tituloConfig();
        numJugadores();
    }
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
        turno.setForeground(new Color(248, 197, 27));
        add(turno, constraints);
    }
    private void numJugadores(){
        constraints.gridx = 0;
        constraints.gridwidth = 3;
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
            System.out.println(jugadores);
        });


        Button cuatroJugadores = new Button("4 Jugadores");
        cuatroJugadores.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        cuatroJugadores.setSize(30,30);
        cuatroJugadores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cuatroJugadores.addActionListener(e -> {
            jugadores = 4;
            eleccionJugadorConfig jugador = new eleccionJugadorConfig();
            dispose();
        });
        //opcionFichas();
        panelJugadores.add(dosJugadores);
        panelJugadores.add(cuatroJugadores);
        add(panelJugadores, constraints);
        repaint();
    }
    /**
     * Prepara los elementos de la ventana inicial
     * Modifica el tamaño y añade el menú y los botones iniciales
     */
    private void prepareElements(){
        setSize(ancho,alto);
        prepareElementsMenu();
        prepareElementsBeginning();
        setLayout(grid);
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

        //nuevo.addActionListener(this);
        //abrir.addActionListener(this);
        //salvar.addActionListener(this);
        //salir.addActionListener(this);

        archivoM.add(nuevo);
        archivoM.add(abrir);
        archivoM.add(salvar);
        archivoM.add(salir);

    }
    public void paint(Graphics g){
        super.paint(g);
    }
    /**
     * Prepara los elementos necesarios para los botones principales
     * dentro de la pantalla de inicio, incluyendo el título y dos botones
     *
     * Le agrega a cada botón su propio oyente para que realiza el evento
     * correspondiente
     */
    private void prepareElementsBeginning(){

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

        archivos = new JFileChooser();
        archivos.showOpenDialog(this);
        try {
            partida = archivos.getSelectedFile();
            String nombre = partida.getName();
            JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está abriendo un archivo\n" + nombre,"Abrir",
                    1,null);
        }catch (Exception e){

        }

    }

    /**
     * Evento que se realiza cuando se da clic en el botón de guardar
     * Genera un JFileChooser
     */
    private void salvarArchivos(){
        archivos = new JFileChooser();
        archivos.showSaveDialog(this);
        String nombre = archivos.getSelectedFile()+"";
        if (!nombre.equals(null+"")){
            JOptionPane.showMessageDialog(this,"El elemento está en construcción, se está guardando un archivo\n" + nombre,"Guardar",
                    1,null);
        }

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
