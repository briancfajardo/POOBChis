package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormatoJugador extends JFrame {
    private int num;
    private ArrayList<String> tipoRojo = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private String[] fichasPosibles = {"Borde", "Ingeniera", "Cohete", "Aspiradora", "Saltarina", "Ventajosa"};
    public FormatoJugador(int num){
        this.num = num;
        setLayout(new GridLayout(5,7));

        prepareElements();

    }
    private void prepareElements(){
        setSize(800,300);
        setLocationRelativeTo(null);
        if(num == 4){
            JTextField textfield1= new JTextField("Rojo");
            textfield1.setBounds(120,10,150,20);
            JTextField textfield2 = new JTextField("Verde");
            textfield2.setBounds(120,10,150,20);
            JTextField textfield3 = new JTextField("Amarillo");
            textfield3.setBounds(120,10,150,20);
            JTextField textfield4 = new JTextField("Azul");
            textfield4.setBounds(120,10,150,20);


            add(textfield1);
            add(textfield2);
            add(textfield3);
            add(textfield4);

            add(opcionFichas("Rojo"));
            add(opcionFichas("Verde"));
            add(opcionFichas("Amarillo"));
            add(opcionFichas("Azul"));


            add(opcionFichas("Rojo"));
            add(opcionFichas("Verde"));
            add(opcionFichas("Amarillo"));
            add(opcionFichas("Azul"));


            add(opcionFichas("Rojo"));
            add(opcionFichas("Verde"));
            add(opcionFichas("Amarillo"));
            add(opcionFichas("Azul"));


            add(opcionFichas("Rojo"));
            add(opcionFichas("Verde"));
            add(opcionFichas("Amarillo"));
            add(opcionFichas("Azul"));

        }

        setVisible(true);

    }
    private JTextField campoTexto(String color){
        JTextField textfield = new JTextField(color);
        textfield.setBounds(120,10,150,20);
        return textfield;
    }
    private JButton opcionFichas(String color){
        JButton opciones = new JButton(color);
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aux = (String) JOptionPane.showInputDialog(
                        null,
                        "Escoge el tipo de ficha que quieres usar",
                        "Tipo Ficha",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        fichasPosibles,
                        fichasPosibles[0]);
                if (aux != null){
                    switch (color) {
                        case "Rojo" -> tipoRojo.add(aux);
                        case "Verde" -> tipoVerde.add(aux);
                        case "Amarillo" -> tipoAmarillo.add(aux);
                        default -> tipoAzul.add(aux);
                    }
                }
                //System.out.println(color +"  "+aux);
            }

        });
        return opciones;
    }

}