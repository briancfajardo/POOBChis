package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableroGUI extends JFrame {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    private TableroGUI.Fondo fondo = new TableroGUI.Fondo();
    private Parchis parchis;
    private int dado1;
    private int dado2;
    private CarcelGUI carcel1;
    private CarcelGUI carcel2;
    private CarcelGUI carcel3;
    private CarcelGUI carcel4;
    private boolean terminar = false;
    private ArrayList<CasillasGUI> casillaAzul= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaAmarilla= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaRoja= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaVerde= new ArrayList<>();
    public TableroGUI() {
        super("POOBChisGame");
        this.setContentPane(fondo);
        parchis = new Parchis();
        prepareElements();
    }
    public void juego(){
        while (!terminar){
            carcel1.actualizar();
            carcel2.actualizar();
            carcel3.actualizar();
            carcel4.actualizar();
            for(int i = 0; i<24;i++){
                casillaAzul.get(i).actualizar();
                casillaAmarilla.get(i).actualizar();
                casillaRoja.get(i).actualizar();
                casillaVerde.get(i).actualizar();
            }
        }
    }
    public void prepareElements() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(grid);

        setSize(900, 900);
        tab();

        setVisible(true);
    }
    public void tab() {
        constraints.fill = GridBagConstraints.BOTH;
        carcel();
        casillasAzules();
        casillasAmarillas();
        casillasRojas();
        casillasVerdes();
        dados();
    }
    public void dados(){
        constraints.gridx = 22;
        constraints.gridwidth = 8;
        constraints.gridheight = 4;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        DadosGUI dado = new DadosGUI(parchis);
        dado1 = dado.getValor1();
        dado2 = dado.getValor2();
        add(dado,constraints);
    }
    public void casillasAzules(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 8;
            constraints.gridy = i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"       ", parchis, "Azul");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color(31, 144, 255));
            }
            casillaAzul.add(casilla);
        }
        //tramo 2
        for (int i = 0; i < 8; i++){
            constraints.gridx = i;
            constraints.gridy = 8;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(15-i,"<html><br><br><html>", parchis, "Azul");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color (192, 180, 179));
            }
            casillaAzul.add(casilla);
        }
        //tramo 3
        for (int i = 0; i < 8; i++){
            constraints.gridx = 10;
            constraints.gridy = i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i+16,"       ", parchis,"Azul");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 0){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(31, 144, 255));
            }
            casillaAzul.add(casilla);
        }
    }
    public void casillasAmarillas(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 12;
            constraints.gridy = i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(15-i,"       ", parchis, "Amarillo");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color (192, 180, 179));
            }casillaAmarilla.add(casilla);
        }
        //tramo 2
        for (int i = 0; i < 8; i++){
            constraints.gridx = 14+i;
            constraints.gridy = 8;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(7-i,"<html><br><br><html>", parchis, "Amarillo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 3){
                casilla.setBackground(new Color(249, 198, 27));
            }casillaAmarilla.add(casilla);
        }
        //tramo 3
        for (int i = 0; i < 8; i++){
            constraints.gridx = 14+i;
            constraints.gridy = 10;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(23-i,"<html><br><br><html>", parchis, "Amarillo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 7){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(249, 198, 27));
            }casillaAmarilla.add(casilla);
        }
    }
    public void casillasRojas(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = i;
            constraints.gridy = 12;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"<html><br><br><html>", parchis, "Rojo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color (232, 73, 55));
            }casillaRoja.add(casilla);
        }
        //tramo 2
        for (int i = 0; i < 8; i++){
            constraints.gridx = 8;
            constraints.gridy = 14+i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i+8,"       ", parchis, "Rojo");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 3){
                casilla.setBackground(new Color (192, 180, 179));
            }casillaRoja.add(casilla);
        }

        //tramo 3
        for (int i = 0; i < 8; i++){
            constraints.gridx = i;
            constraints.gridy = 10;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(16+i,"<html><br><br><html>", parchis, "Rojo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 0){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(232, 73, 55));
            }casillaRoja.add(casilla);
        }
    }
    public void casillasVerdes(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 14+i;
            constraints.gridy = 12;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(8+i,"<html><br><br><html>", parchis, "Verde");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 3){
                casilla.setBackground(new Color (192, 180, 179));
            }casillaVerde.add(casilla);
        }
        //tramo 2
        for (int i = 0; i < 8; i++){
            constraints.gridx = 12;
            constraints.gridy = 21-i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"       ", parchis, "Verde");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color (33, 202, 88));
            }casillaVerde.add(casilla);
        }
        //tramo 3
        for (int i = 0; i < 8; i++){
            constraints.gridx = 10;
            constraints.gridy = 14+i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(23-i,"       ", parchis, "Verde");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 7){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color (33, 202, 88));
            }casillaVerde.add(casilla);
        }
    }

    public void carcel(){
        constraints.fill = GridBagConstraints.BOTH;
        //GridLayout grid = new GridLayout();
        //Primera carcel
        carcel1 = new CarcelGUI(new Color(23, 88, 151), new Color(31, 143, 254),"Azul", parchis);
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //grid.setConstraints(carcel1, constraints);
        add(carcel1,constraints);
        //JPanel carcel1 = makebutton("Carcel");
        //carcel1.setBackground(new Color(31, 143, 254));
        //grid.addLayoutComponent("Carcel",new CarcelGUI(new Color(23, 88, 151)));
        //carcel1.setLayout(grid);
        //carcel1.



        //Segunda carcel
        constraints.gridx = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel2 = makebutton("Carcel");
        //carcel2.setBackground(new Color(248, 197, 27));
        carcel2 = new CarcelGUI(new Color(151, 120, 17), new Color(248, 197, 27),"Amarillo",parchis);
        //grid.setConstraints(carcel2, constraints);
        add(carcel2,constraints);

        //Centro
        constraints.gridx = 8;
        constraints.gridwidth = 6;
        constraints.gridheight = 6;
        constraints.gridy = 8;
        GanadoresGUI win1 = new GanadoresGUI("Azul",0);
        //grid.setConstraints(win1, constraints);
        add(win1,constraints);

        //Tercera carcel
        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel3 = makebutton("Carcel");
        //carcel3.setBackground(new Color(232, 73, 55));
        carcel3 = new CarcelGUI(new Color(144, 47, 36), new Color(232, 73, 55),"Rojo",parchis);
        //grid.setConstraints(carcel3, constraints);
        add(carcel3,constraints);

        //Cuarta carcel
        constraints.gridx = 14;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel4 = makebutton("Carcel");
        //carcel4.setBackground(new Color(33, 202, 88));
        carcel4 = new CarcelGUI(new Color(22, 119, 52), new Color(33, 202, 88),"Verde",parchis);
        //grid.setConstraints(carcel4, constraints);
        add(carcel4,constraints);
    }

    public static void main (String[] args){
        TableroGUI u = new TableroGUI();
        u.juego();
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
