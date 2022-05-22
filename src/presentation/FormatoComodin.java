package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormatoComodin extends JFrame implements ActionListener {
    private ArrayList<String> comodines = new ArrayList<>();

    private JRadioButton avanzar, retroceder, irCarcel, salirCarcel, jugarDoble, quitarFicha, romperBloqueo, inmortal, mutar;

    private JButton aceptar;

    private JLabel  comodin;


    public FormatoComodin(){
        super("Eleccion de comodines");
        prepareElements();


    }

    private void prepareElements(){
        getContentPane().setLayout(null);
        setSize(900,500);
        setLocationRelativeTo(null);
        prepareComodines();
        setVisible(true);
    }


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


    private void crearBotonAceptar(){
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(220 ,400,120,30);
        aceptar.addActionListener(this);
        add(aceptar);

        //getContentPane().add(aceptar, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar){
            //System.out.println("rojo: " + nombreRojo + ", amarillo:" + nombreAmarillo + ", azul:" +
            //     nombreAzul + ", verde:" + nombreVerde);

            //TableroGUI nuevaPartida = new TableroGUI(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo, 2);
            //nuevaPartida.setVisible(true);
            //nuevaPartida.setResizable(false);
            //nuevaPartida.setLocationRelativeTo(null);
            dispose();
        }
    }

    public static void main(String[] args) {
        FormatoComodin comodines = new FormatoComodin();
        comodines.setResizable(false);
        comodines.setLocationRelativeTo(null);
    }

}
