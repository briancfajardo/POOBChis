package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase FormatoComodin que se encarga de ofrecer al usuario la opción de escoger que tipo de comodines que quiere en el juego
 */
public class FormatoComodin extends JFrame implements ActionListener {
    private ArrayList<String> comodines = new ArrayList<>();

    private ArrayList<String> tipoAmarillo, tipoAzul, tipoVerde, tipoRojo;
    private String usuarioAmarillo, usuarioAzul, usuarioVerde, usuarioRojo;
    private int cantJugadores;

    private JRadioButton avanzar, retroceder, irCarcel, salirCarcel, jugarDoble, quitarFicha, romperBloqueo, inmortal, mutar;

    private JButton aceptar;

    private JLabel  comodin;

    /**
     * Constructor de la clase FormatoComodin
     * @param tipoAmarillo tipo de fichas Amarillas
     * @param tipoAzul tipo de fichas Azules
     * @param tipoVerde tipo de fichas Verdes
     * @param tipoRojo tipo de fichas Rojas
     * @param cantJugadores cantidad de jugadores
     * @param usuarioAmarillo Nombre del usuario Amarillo
     * @param usuarioAzul Nombre del usuario Azul
     * @param usuarioVerde Nombre del usuario Verde
     * @param usuarioRojo Nombre del usuario Rojo
     */
    public FormatoComodin(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde,
                          ArrayList<String> tipoRojo, int cantJugadores, String usuarioAmarillo, String usuarioAzul,
                          String usuarioVerde, String usuarioRojo){
        super("Eleccion de comodines");
        this.tipoAmarillo = tipoAmarillo;
        this.tipoAzul = tipoAzul;
        this.tipoVerde = tipoVerde;
        this.tipoRojo = tipoRojo;
        this.cantJugadores = cantJugadores;
        this.usuarioAmarillo = usuarioAmarillo;
        this.usuarioAzul = usuarioAzul;
        this.usuarioVerde = usuarioVerde;
        this.usuarioRojo = usuarioRojo;


        prepareElements();


    }

    /**
     * Prepara los elementos necesarios para la ventana como el tamaño, Layout, visibilidad entre otros
     */
    private void prepareElements(){
        getContentPane().setLayout(null);
        setSize(900,500);
        setLocationRelativeTo(null);
        prepareComodines();
        setVisible(true);
    }

    /**
     * Recolecta la información correspondiente a los tipos de comodines
     */
    private void prepareComodines(){
        comodin = new JLabel("Seleccione los comodines que desea ver dentro del juego");
        comodin.setBounds(10, 20, 500, 30);
        add(comodin);

        avanzar =new JRadioButton("Avanzar",true);
        retroceder =new JRadioButton("Retroceder",false);
        irCarcel =new JRadioButton("Irse a la cárcel",false);
        salirCarcel =new JRadioButton("Salir de la cárcel",false);
        jugarDoble =new JRadioButton("Jugar doble",false);
        quitarFicha =new JRadioButton("Quitar ficha",false);
        romperBloqueo =new JRadioButton("Romper bloqueo",false);
        inmortal =new JRadioButton("Inmortal",false);
        mutar =new JRadioButton("Mutar",false);


        avanzar.setBounds(20,100,120,20);
        retroceder.setBounds(20,130,120,20);
        irCarcel.setBounds(20,160,120,20);
        salirCarcel.setBounds(20,190,120,20);
        jugarDoble.setBounds(20,220,120,20);
        quitarFicha.setBounds(20,250,120,20);
        romperBloqueo.setBounds(20,280,120,20);
        inmortal.setBounds(20,310,120,20);
        mutar.setBounds(20,340,120,20);

        add(avanzar);
        add(retroceder);
        add(irCarcel);
        add(salirCarcel);
        add(jugarDoble);
        add(quitarFicha);
        add(romperBloqueo);
        add(inmortal);
        add(mutar);

        crearBotonAceptar();
    }

    /**
     * Creo el botón Aceptar y lo agrega al layout
     */
    private void crearBotonAceptar(){
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(220 ,400,120,30);
        aceptar.addActionListener(this);
        add(aceptar);
    }

    /**
     * Muestra los tipos de comodines disponibles que existen
     */
    private void darTipos() {
        if (avanzar.isSelected()) {
            comodines.add("Adelantar");
        }
        if (retroceder.isSelected()) {
            comodines.add("Atrasar");
        }
        if (irCarcel.isSelected()) {
            comodines.add("EntraCarcel");
        }
        if (inmortal.isSelected()) {
            comodines.add("Inmortal");
        }
        if (mutar.isSelected()) {
            comodines.add("Mutar");
        }
        if (quitarFicha.isSelected()) {
            comodines.add("Quitar");
        }
        if (romperBloqueo.isSelected()) {
            comodines.add("QuitarBloqueo");
        }
        if (jugarDoble.isSelected()) {
            comodines.add("RepiteTurno");
        }
        if (salirCarcel.isSelected()) {
            comodines.add("SaleCarcel");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar){
            //System.out.println("rojo: " + nombreRojo + ", amarillo:" + nombreAmarillo + ", azul:" +
            //     nombreAzul + ", verde:" + nombreVerde);
            darTipos();
            TableroGUI nuevaPartida = new TableroGUI(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo, cantJugadores,
                    usuarioAmarillo, usuarioAzul, usuarioVerde, usuarioRojo, comodines);
            nuevaPartida.setVisible(true);
            nuevaPartida.setResizable(false);
            nuevaPartida.setLocationRelativeTo(null);
            dispose();
        }
    }
}
