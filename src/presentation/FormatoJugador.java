package presentation;

import domain.Parchis;
import domain.ParchisException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase FormatoJugador que hereda de JFrame
 */
public class FormatoJugador extends JFrame implements ActionListener{
    private String color = "Rojo";
    private ArrayList<String> tiposRojo = new ArrayList<>();
    private ArrayList<String> tiposAmarillo = new ArrayList<>();
    private ArrayList<String> tiposVerde = new ArrayList<>();
    private ArrayList<String> tiposAzul = new ArrayList<>();

    private JTextField textfield1;
    private ButtonGroup grupoBotones, grupoBotones2, grupoBotones3, grupoBotones4;
    private JRadioButton normal, ventajosa, aspiradora, ingeniera, saltarina, cohete;

    private JRadioButton normal2, ventajosa2, aspiradora2, ingeniera2, saltarina2, cohete2;

    private JRadioButton normal3, ventajosa3, aspiradora3, ingeniera3, saltarina3, cohete3;

    private JRadioButton normal4, ventajosa4, aspiradora4, ingeniera4, saltarina4, cohete4;

    private JButton aceptar;

    private JLabel usuario, eleccion, ficha1, ficha2, ficha3, ficha4;

    private eleccionJugadorConfig config;

    /**
     * Constructor de la clase FormatoJugador que usa el constructor del padre con un nombre "Formato Jugador"
     * @param config la pestaña a la que retorna para que seleccione todos los jugadores
     */
    public FormatoJugador(eleccionJugadorConfig config){
        super("Formato del jugador");
        this.config = config;
        prepareElements();


    }

    /**
     * Cambia el color
     * @param color color por el que se cambiará el atributo
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * Prepara los elementos correspondientes para la ventana
     */
    private void prepareElements(){
        getContentPane().setLayout(null);
        setSize(900,500);
        setLocationRelativeTo(null);
        prepareUser();
        prepareElection();
        prepareActions();
    }

    /**
     * Modifica la acción de cerrar
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Prepara los contenedores para que el usuario diligencie los parámetros correspondientes
     */
    private void prepareUser(){
        usuario = new JLabel("Ingrese el nombre del usuario: ");
        usuario.setBounds(10,10,200,20);
        add(usuario);

        textfield1=new JTextField();
        textfield1.setBounds(220,10,150,20);
        add(textfield1);
    }

    /**
     * Lee las opciones que seleccionó el usuario
     */
    private void prepareElection(){

        eleccion = new JLabel("Seleccione los 4 tipos de fichas");
        eleccion.setBounds(10, 60, 300, 30);
        add(eleccion);

        ficha1 = new JLabel("Para la primera ficha: ");
        ficha1.setBounds(10, 100, 200, 30);
        add(ficha1);

        normal =new JRadioButton("Normal",true);
        ventajosa =new JRadioButton("Ventajosa",false);
        aspiradora =new JRadioButton("Aspiradora",false);
        ingeniera =new JRadioButton("Ingeniera",false);
        saltarina =new JRadioButton("Saltarina",false);
        cohete =new JRadioButton("Cohete",false);

        normal.setBounds(20,140,120,20);
        ventajosa.setBounds(20,170,120,20);
        aspiradora.setBounds(20,200,120,20);
        ingeniera.setBounds(20,230,120,20);
        saltarina.setBounds(20,260,120,20);
        cohete.setBounds(20,290,120,20);

        grupoBotones = new ButtonGroup();
        grupoBotones.add(normal);
        grupoBotones.add(ventajosa);
        grupoBotones.add(aspiradora);
        grupoBotones.add(ingeniera);
        grupoBotones.add(saltarina);
        grupoBotones.add(cohete);

        add(normal);
        add(ventajosa);
        add(aspiradora);
        add(ingeniera);
        add(saltarina);
        add(cohete);


        ficha2 = new JLabel("Para la segunda ficha: ");
        ficha2.setBounds(230, 100, 200, 30);
        add(ficha2);

        normal2 =new JRadioButton("Normal",true);
        ventajosa2 =new JRadioButton("Ventajosa",false);
        aspiradora2 =new JRadioButton("Aspiradora",false);
        ingeniera2 =new JRadioButton("Ingeniera",false);
        saltarina2 =new JRadioButton("Saltarina",false);
        cohete2 =new JRadioButton("Cohete",false);

        normal2.setBounds(230,140,120,20);
        ventajosa2.setBounds(230,170,120,20);
        aspiradora2.setBounds(230,200,120,20);
        ingeniera2.setBounds(230,230,120,20);
        saltarina2.setBounds(230,260,120,20);
        cohete2.setBounds(230,290,120,20);

        grupoBotones2 = new ButtonGroup();
        grupoBotones2.add(normal2);
        grupoBotones2.add(ventajosa2);
        grupoBotones2.add(aspiradora2);
        grupoBotones2.add(ingeniera2);
        grupoBotones2.add(saltarina2);
        grupoBotones2.add(cohete2);

        add(normal2);
        add(ventajosa2);
        add(aspiradora2);
        add(ingeniera2);
        add(saltarina2);
        add(cohete2);


        ficha3 = new JLabel("Para la tercera ficha: ");
        ficha3.setBounds(440, 100, 200, 30);
        add(ficha3);

        normal3 =new JRadioButton("Normal",true);
        ventajosa3 =new JRadioButton("Ventajosa",false);
        aspiradora3 =new JRadioButton("Aspiradora",false);
        ingeniera3 =new JRadioButton("Ingeniera",false);
        saltarina3 =new JRadioButton("Saltarina",false);
        cohete3 =new JRadioButton("Cohete",false);

        normal3.setBounds(440,140,120,20);
        ventajosa3.setBounds(440,170,120,20);
        aspiradora3.setBounds(440,200,120,20);
        ingeniera3.setBounds(440,230,120,20);
        saltarina3.setBounds(440,260,120,20);
        cohete3.setBounds(440,290,120,20);

        grupoBotones3 = new ButtonGroup();
        grupoBotones3.add(normal3);
        grupoBotones3.add(ventajosa3);
        grupoBotones3.add(aspiradora3);
        grupoBotones3.add(ingeniera3);
        grupoBotones3.add(saltarina3);
        grupoBotones3.add(cohete3);

        add(normal3);
        add(ventajosa3);
        add(aspiradora3);
        add(ingeniera3);
        add(saltarina3);
        add(cohete3);


        ficha4 = new JLabel("Para la cuarta ficha: ");
        ficha4.setBounds(650, 100, 200, 30);
        add(ficha4);

        normal4 =new JRadioButton("Normal",true);
        ventajosa4 =new JRadioButton("Ventajosa",false);
        aspiradora4 =new JRadioButton("Aspiradora",false);
        ingeniera4 =new JRadioButton("Ingeniera",false);
        saltarina4 =new JRadioButton("Saltarina",false);
        cohete4 =new JRadioButton("Cohete",false);

        normal4.setBounds(650,140,120,20);
        ventajosa4.setBounds(650,170,120,20);
        aspiradora4.setBounds(650,200,120,20);
        ingeniera4.setBounds(650,230,120,20);
        saltarina4.setBounds(650,260,120,20);
        cohete4.setBounds(650,290,120,20);

        grupoBotones4 = new ButtonGroup();
        grupoBotones4.add(normal4);
        grupoBotones4.add(ventajosa4);
        grupoBotones4.add(aspiradora4);
        grupoBotones4.add(ingeniera4);
        grupoBotones4.add(saltarina4);
        grupoBotones4.add(cohete4);

        add(normal4);
        add(ventajosa4);
        add(aspiradora4);
        add(ingeniera4);
        add(saltarina4);
        add(cohete4);


        crearBotonAceptar();


    }

    /**
     * Crea el botón aceptar para guardar la selección
     */
    private void crearBotonAceptar(){
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(380 ,400,120,30);
        aceptar.addActionListener(this);
        add(aceptar);

    }

    /**
     * Varifica que el nombre escrito sea valido
     * @param nombre nombre escrito por el usuario
     * @throws ParchisException SIN_NOMBRE_EXCEPTION, CARACTERES_EXCEPTION
     */
    private void verificarNombre(String nombre) throws ParchisException{
        if (nombre.equals("")) throw new ParchisException(ParchisException.SIN_NOMBRE_EXCEPTION);
        if (nombre.contains("#") || nombre.contains("*") || nombre.contains("%") || nombre.contains("$")
                || nombre.contains("&")) throw new ParchisException(ParchisException.CARACTERES_EXCEPTION);

    }

    /**
     * Reinicia los tipos de fichas para el siguiente usuario
     */
    private void reiniciarTipos(){
        tiposRojo = new ArrayList<>();
        tiposAmarillo = new ArrayList<>();
        tiposVerde = new ArrayList<>();
        tiposAzul = new ArrayList<>();
    }

    /**+
     * método que tiene en cuenta todos los posibles casos que escogió el usuario
     * @return retorna el arrelo de los tipos listo
     */
    private ArrayList<String> darTipos(){
        int cont = 0;
        switch (color){
            case "Amarillo"->{
                if (normal.isSelected()){
                    tiposAmarillo.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ventajosa.isSelected()){
                    tiposAmarillo.add("Ventajosa");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (aspiradora.isSelected()){
                    tiposAmarillo.add("Aspiradora");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ingeniera.isSelected()){
                    tiposAmarillo.add("Ingeniera");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (saltarina.isSelected()){
                    tiposAmarillo.add("Saltarina");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (cohete.isSelected()){
                    tiposAmarillo.add("Cohete");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (normal2.isSelected()){
                    tiposAmarillo.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ventajosa2.isSelected()){
                    tiposAmarillo.add("Ventajosa");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (aspiradora2.isSelected()){
                    tiposAmarillo.add("Aspiradora");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ingeniera2.isSelected()){
                    tiposAmarillo.add("Ingeniera");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (saltarina2.isSelected()){
                    tiposAmarillo.add("Saltarina");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (cohete2.isSelected()){
                    tiposAmarillo.add("Cohete");
                    cont += 1;
                    normal.setSelected(false);
                }

                if (normal3.isSelected()){
                    tiposAmarillo.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ventajosa3.isSelected()){
                    tiposAmarillo.add("Ventajosa");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (aspiradora3.isSelected()){
                    tiposAmarillo.add("Aspiradora");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ingeniera3.isSelected()){
                    tiposAmarillo.add("Ingeniera");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (saltarina3.isSelected()){
                    tiposAmarillo.add("Saltarina");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (cohete3.isSelected()){
                    tiposAmarillo.add("Cohete");
                    cont += 1;
                    normal.setSelected(false);
                }

                if (normal4.isSelected()){
                    tiposAmarillo.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ventajosa4.isSelected()){
                    tiposAmarillo.add("Ventajosa");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (aspiradora4.isSelected()){
                    tiposAmarillo.add("Aspiradora");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (ingeniera4.isSelected()){
                    tiposAmarillo.add("Ingeniera");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (saltarina4.isSelected()){
                    tiposAmarillo.add("Saltarina");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (cohete4.isSelected()){
                    tiposAmarillo.add("Cohete");
                    cont += 1;
                    normal.setSelected(false);
                }
                if (cont == 4){
                    return tiposAmarillo;
                }
            }
            case "Rojo"->{
                if (normal.isSelected()){
                    tiposRojo.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                else if (ventajosa.isSelected()){
                    tiposRojo.add("Ventajosa");
                    cont += 1;
                    ventajosa.setSelected(false);
                }
                else if (aspiradora.isSelected()){
                    tiposRojo.add("Aspiradora");
                    cont += 1;
                    aspiradora.setSelected(false);
                }
                else if (ingeniera.isSelected()){
                    tiposRojo.add("Ingeniera");
                    cont += 1;
                    ingeniera.setSelected(false);
                }
                else if (saltarina.isSelected()){
                    tiposRojo.add("Saltarina");
                    cont += 1;
                    saltarina.setSelected(false);
                }
                else if (cohete.isSelected()){
                    tiposRojo.add("Cohete");
                    cont += 1;
                    cohete.setSelected(false);
                }
                if (normal2.isSelected()){
                    tiposRojo.add("Borde");
                    cont += 1;
                    normal2.setSelected(false);
                }
                else if (ventajosa2.isSelected()){
                    tiposRojo.add("Ventajosa");
                    cont += 1;
                    ventajosa2.setSelected(false);
                }
                else if (aspiradora2.isSelected()){
                    tiposRojo.add("Aspiradora");
                    cont += 1;
                    aspiradora2.setSelected(false);
                }
                else if (ingeniera2.isSelected()){
                    tiposRojo.add("Ingeniera");
                    cont += 1;
                    ingeniera2.setSelected(false);
                }
                else if (saltarina2.isSelected()){
                    tiposRojo.add("Saltarina");
                    cont += 1;
                    saltarina2.setSelected(false);
                }
                else if (cohete2.isSelected()){
                    tiposRojo.add("Cohete");
                    cont += 1;
                    cohete2.setSelected(false);
                }

                if (normal3.isSelected()){
                    tiposRojo.add("Borde");
                    cont += 1;
                    normal3.setSelected(false);
                }
                else if (ventajosa3.isSelected()){
                    tiposRojo.add("Ventajosa");
                    cont += 1;
                    ventajosa3.setSelected(false);
                }
                else if (aspiradora3.isSelected()){
                    tiposRojo.add("Aspiradora");
                    cont += 1;
                    aspiradora3.setSelected(false);
                }
                else if (ingeniera3.isSelected()){
                    tiposRojo.add("Ingeniera");
                    cont += 1;
                    ingeniera3.setSelected(false);
                }
                else if (saltarina3.isSelected()){
                    tiposRojo.add("Saltarina");
                    cont += 1;
                    saltarina3.setSelected(false);
                }
                else if (cohete3.isSelected()){
                    tiposRojo.add("Cohete");
                    cont += 1;
                    cohete3.setSelected(false);
                }

                if (normal4.isSelected()){
                    tiposRojo.add("Borde");
                    cont += 1;
                    normal4.setSelected(false);
                }
                else if (ventajosa4.isSelected()){
                    tiposRojo.add("Ventajosa");
                    cont += 1;
                    ventajosa4.setSelected(false);
                }
                else if (aspiradora4.isSelected()){
                    tiposRojo.add("Aspiradora");
                    cont += 1;
                    aspiradora4.setSelected(false);
                }
                else if (ingeniera4.isSelected()){
                    tiposRojo.add("Ingeniera");
                    cont += 1;
                    ingeniera4.setSelected(false);
                }
                else if (saltarina4.isSelected()){
                    tiposRojo.add("Saltarina");
                    cont += 1;
                    saltarina4.setSelected(false);
                }
                else if (cohete4.isSelected()){
                    tiposRojo.add("Cohete");
                    cont += 1;
                    cohete4.setSelected(false);
                }

                if (cont == 4){
                    return tiposRojo;
                }

            }
            case "Azul"->{
                if (normal.isSelected()){
                    tiposAzul.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                else if (ventajosa.isSelected()){
                    tiposAzul.add("Ventajosa");
                    cont += 1;
                    ventajosa.setSelected(false);
                }
                else if (aspiradora.isSelected()){
                    tiposAzul.add("Aspiradora");
                    cont += 1;
                    aspiradora.setSelected(false);
                }
                else if (ingeniera.isSelected()){
                    tiposAzul.add("Ingeniera");
                    cont += 1;
                    ingeniera.setSelected(false);
                }
                else if (saltarina.isSelected()){
                    tiposAzul.add("Saltarina");
                    cont += 1;
                    saltarina.setSelected(false);
                }
                else if (cohete.isSelected()){
                    tiposAzul.add("Cohete");
                    cont += 1;
                    cohete.setSelected(false);
                }
                if (normal2.isSelected()){
                    tiposAzul.add("Borde");
                    cont += 1;
                    normal2.setSelected(false);
                }
                else if (ventajosa2.isSelected()){
                    tiposAzul.add("Ventajosa");
                    cont += 1;
                    ventajosa2.setSelected(false);
                }
                else if (aspiradora2.isSelected()){
                    tiposAzul.add("Aspiradora");
                    cont += 1;
                    aspiradora2.setSelected(false);
                }
                else if (ingeniera2.isSelected()){
                    tiposAzul.add("Ingeniera");
                    cont += 1;
                    ingeniera2.setSelected(false);
                }
                else if (saltarina2.isSelected()){
                    tiposAzul.add("Saltarina");
                    cont += 1;
                    saltarina2.setSelected(false);
                }
                else if (cohete2.isSelected()){
                    tiposAzul.add("Cohete");
                    cont += 1;
                    cohete2.setSelected(false);
                }

                if (normal3.isSelected()){
                    tiposAzul.add("Borde");
                    cont += 1;
                    normal3.setSelected(false);
                }
                else if (ventajosa3.isSelected()){
                    tiposAzul.add("Ventajosa");
                    cont += 1;
                    ventajosa3.setSelected(false);
                }
                else if (aspiradora3.isSelected()){
                    tiposAzul.add("Aspiradora");
                    cont += 1;
                    aspiradora3.setSelected(false);
                }
                else if (ingeniera3.isSelected()){
                    tiposAzul.add("Ingeniera");
                    cont += 1;
                    ingeniera3.setSelected(false);
                }
                else if (saltarina3.isSelected()){
                    tiposAzul.add("Saltarina");
                    cont += 1;
                    saltarina3.setSelected(false);
                }
                else if (cohete3.isSelected()){
                    tiposAzul.add("Cohete");
                    cont += 1;
                    cohete3.setSelected(false);
                }

                if (normal4.isSelected()){
                    tiposAzul.add("Borde");
                    cont += 1;
                    normal4.setSelected(false);
                }
                else if (ventajosa4.isSelected()){
                    tiposAzul.add("Ventajosa");
                    cont += 1;
                    ventajosa4.setSelected(false);
                }
                else if (aspiradora4.isSelected()){
                    tiposAzul.add("Aspiradora");
                    cont += 1;
                    aspiradora4.setSelected(false);
                }
                else if (ingeniera4.isSelected()){
                    tiposAzul.add("Ingeniera");
                    cont += 1;
                    ingeniera4.setSelected(false);
                }
                else if (saltarina4.isSelected()){
                    tiposAzul.add("Saltarina");
                    cont += 1;
                    saltarina4.setSelected(false);
                }
                else if (cohete4.isSelected()){
                    tiposAzul.add("Cohete");
                    cont += 1;
                    cohete4.setSelected(false);
                }
                if (cont == 4){
                    return tiposAzul;
                }
            }
            case "Verde"->{
                if (normal.isSelected()){
                    tiposVerde.add("Borde");
                    cont += 1;
                    normal.setSelected(false);
                }
                else if (ventajosa.isSelected()){
                    tiposVerde.add("Ventajosa");
                    cont += 1;
                    ventajosa.setSelected(false);
                }
                else if (aspiradora.isSelected()){
                    tiposVerde.add("Aspiradora");
                    cont += 1;
                    aspiradora.setSelected(false);
                }
                else if (ingeniera.isSelected()){
                    tiposVerde.add("Ingeniera");
                    cont += 1;
                    ingeniera.setSelected(false);
                }
                else if (saltarina.isSelected()){
                    tiposVerde.add("Saltarina");
                    cont += 1;
                    saltarina.setSelected(false);
                }
                else if (cohete.isSelected()){
                    tiposVerde.add("Cohete");
                    cont += 1;
                    cohete.setSelected(false);
                }
                if (normal2.isSelected()){
                    tiposVerde.add("Borde");
                    cont += 1;
                    normal2.setSelected(false);
                }
                else if (ventajosa2.isSelected()){
                    tiposVerde.add("Ventajosa");
                    cont += 1;
                    ventajosa2.setSelected(false);
                }
                else if (aspiradora2.isSelected()){
                    tiposVerde.add("Aspiradora");
                    cont += 1;
                    aspiradora2.setSelected(false);
                }
                else if (ingeniera2.isSelected()){
                    tiposVerde.add("Ingeniera");
                    cont += 1;
                    ingeniera2.setSelected(false);
                }
                else if (saltarina2.isSelected()){
                    tiposVerde.add("Saltarina");
                    cont += 1;
                    saltarina2.setSelected(false);
                }
                else if (cohete2.isSelected()){
                    tiposVerde.add("Cohete");
                    cont += 1;
                    cohete2.setSelected(false);
                }

                if (normal3.isSelected()){
                    tiposVerde.add("Borde");
                    cont += 1;
                    normal3.setSelected(false);
                }
                else if (ventajosa3.isSelected()){
                    tiposVerde.add("Ventajosa");
                    cont += 1;
                    ventajosa3.setSelected(false);
                }
                else if (aspiradora3.isSelected()){
                    tiposVerde.add("Aspiradora");
                    cont += 1;
                    aspiradora3.setSelected(false);
                }
                else if (ingeniera3.isSelected()){
                    tiposVerde.add("Ingeniera");
                    cont += 1;
                    ingeniera3.setSelected(false);
                }
                else if (saltarina3.isSelected()){
                    tiposVerde.add("Saltarina");
                    cont += 1;
                    saltarina3.setSelected(false);
                }
                else if (cohete3.isSelected()){
                    tiposVerde.add("Cohete");
                    cont += 1;
                    cohete3.setSelected(false);
                }

                if (normal4.isSelected()){
                    tiposVerde.add("Borde");
                    cont += 1;
                    normal4.setSelected(false);
                }
                else if (ventajosa4.isSelected()){
                    tiposVerde.add("Ventajosa");
                    cont += 1;
                    ventajosa4.setSelected(false);
                }
                else if (aspiradora4.isSelected()){
                    tiposVerde.add("Aspiradora");
                    cont += 1;
                    aspiradora4.setSelected(false);
                }
                else if (ingeniera4.isSelected()){
                    tiposVerde.add("Ingeniera");
                    cont += 1;
                    ingeniera4.setSelected(false);
                }
                else if (saltarina4.isSelected()){
                    tiposVerde.add("Saltarina");
                    cont += 1;
                    saltarina4.setSelected(false);
                }
                else if (cohete4.isSelected()){
                    tiposVerde.add("Cohete");
                    cont += 1;
                    cohete4.setSelected(false);
                }
                if (cont == 4){
                    return tiposVerde;
                }
            }
        }return null;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar){

            try{
                String nombre = textfield1.getText();
                verificarNombre(nombre);

                config.setNombre(color, nombre);
                config.setTipo(color,darTipos());
                config.setVisible(true);
                config.setResizable(false);
                config.setLocationRelativeTo(null);
                dispose();


            }catch (ParchisException exception){
                System.out.println(exception.getMessage());
                reiniciarTipos();
            }


        }
    }
}
