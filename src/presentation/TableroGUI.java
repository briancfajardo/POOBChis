package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableroGUI extends JFrame {

    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private TableroGUI.Fondo fondo = new TableroGUI.Fondo();
    private Parchis parchis;
    private int dado1;
    private int dado2;
    private CarcelGUI carcelAzul;
    private CarcelGUI carcelAmarilla;
    private CarcelGUI carcelRoja;
    private CarcelGUI carcelVerde;

    private boolean terminar = false;
    private ArrayList<CasillasGUI> casillaAzul= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaAmarilla= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaRoja= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaVerde= new ArrayList<>();
    private  JLabel turno;
    private GanadoresGUI win1;
    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoRojo = new ArrayList<>();
    private int cantJugadores;
    private String turnoActual;



    public TableroGUI(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde, ArrayList<String> tipoRojo, int cantJugadores) {
        super("POOBChisGame");
        this.cantJugadores = cantJugadores;
        this.setContentPane(fondo);
        inicializarTipos();
        parchis = new Parchis(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo, cantJugadores);
        prepareElements();
    }

    public Parchis getParchis(){return parchis;}

    private void inicializarTipos(){
        tipoAmarillo.add("Borde");
        tipoAmarillo.add("Borde");
        tipoAmarillo.add("Borde");
        tipoAmarillo.add("Borde");

        tipoAzul.add("Borde");
        tipoAzul.add("Borde");
        tipoAzul.add("Borde");
        tipoAzul.add("Borde");

        tipoVerde.add("Borde");
        tipoVerde.add("Borde");
        tipoVerde.add("Borde");
        tipoVerde.add("Borde");

        tipoRojo.add("Borde");
        tipoRojo.add("Borde");
        tipoRojo.add("Borde");
        tipoRojo.add("Borde");



    }
    public void juego(){
        //while (!terminar){
        int contHabilitados = 0;
        mensajeTurno();
        carcelAzul.actualizar();
        carcelAmarilla.actualizar();
        carcelRoja.actualizar();
        carcelVerde.actualizar();
        win1.actualizar();
        for(int i = 0; i<24;i++){
            casillaAzul.get(i).actualizar(turnoActual);
            casillaAmarilla.get(i).actualizar(turnoActual);
            casillaRoja.get(i).actualizar(turnoActual);
            casillaVerde.get(i).actualizar(turnoActual);

        }
        for (int i = 0; i<24; i++){
            if(casillaAzul.get(i).isHabilitado()){contHabilitados += 1;}
            if(casillaVerde.get(i).isHabilitado()){contHabilitados += 1;}
            if(casillaRoja.get(i).isHabilitado()){contHabilitados += 1;}
            if(casillaAmarilla.get(i).isHabilitado()){contHabilitados += 1;}
        }
        //System.out.println("ContHabilitados: "+ contHabilitados);
        if(contHabilitados == 0 && parchis.getCarcel(turnoActual) != 4
                && parchis.getValor1() != parchis.getValor2()
                && !parchis.isMataFicha() && !parchis.isSacaFicha()){
            parchis.cambiarTurno();
        }
    }

    public String getTurnoActual() {
        return turnoActual;
    }

    private void prepareElements() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(grid);

        setSize(900, 900);
        tab();

        setVisible(true);
    }
    private void tab() {
        constraints.fill = GridBagConstraints.BOTH;
        carcel();
        casillasAzules();
        casillasAmarillas();
        casillasRojas();
        casillasVerdes();
        dados();
        tituloTurno();
    }
    private void tituloTurno(){
        constraints.gridx = 22;
        constraints.gridwidth = 8;
        constraints.gridheight = 3;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        turno = new JLabel();
        Font letra = new Font("Serif", Font.CENTER_BASELINE, 30);
        turno.setFont(letra);
        mensajeTurno();
        add(turno, constraints);
    }
    private void mensajeTurno(){
        if(parchis.getTurno(parchis.ROJO)){
            turno.setText("Turno del rojo");
            turno.setForeground(new Color(227, 128, 128));
            turnoActual = "Rojo";
        } else if (parchis.getTurno(parchis.VERDE)) {
            turno.setText("Turno del verde");
            turno.setForeground(new Color(87, 234, 135));
            turnoActual = "Verde";
        }else if (parchis.getTurno(parchis.AZUL)) {
            turno.setText("Turno del azul");
            turno.setForeground(new Color(56, 152, 248));
            turnoActual = "Azul";
        }else if (parchis.getTurno(parchis.AMARILLO)) {
            turno.setText("Turno del amarillo");
            turno.setForeground(new Color(241, 206, 89));
            turnoActual = "Amarillo";
        }
    }
    private void dados(){
        constraints.gridx = 22;
        constraints.gridwidth = 8;
        constraints.gridheight = 4;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.BOTH;
        DadosGUI dado = new DadosGUI(this);
        dado1 = dado.getValor1();
        dado2 = dado.getValor2();
        add(dado,constraints);
    }
    private void casillasAzules(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 8;
            constraints.gridy = i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"       ", this, "Azul");
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
            CasillasGUI casilla = new CasillasGUI(15-i,"<html><br><br><html>", this, "Azul");
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
            CasillasGUI casilla = new CasillasGUI(i+16,"       ", this,"Azul");
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
    private void casillasAmarillas(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 21-i;
            constraints.gridy = 8;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"<html><br><br><html>", this, "Amarillo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color(249, 198, 27));
            }casillaAmarilla.add(casilla);
        }

        //tramo 2
        for (int i = 0; i < 8; i++){
            constraints.gridx = 12;
            constraints.gridy = i;
            constraints.gridwidth = 2;
            constraints.gridheight = 1;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(15-i,"       ", this, "Amarillo");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 4){
                casilla.setBackground(new Color (192, 180, 179));
            }casillaAmarilla.add(casilla);
        }

        //tramo 3
        for (int i = 0; i < 8; i++){
            constraints.gridx = 14+i;
            constraints.gridy = 10;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(23-i,"<html><br><br><html>", this, "Amarillo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 7){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(249, 198, 27));
            }casillaAmarilla.add(casilla);
        }
    }
    private void casillasRojas(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = i;
            constraints.gridy = 12;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(i,"<html><br><br><html>", this, "Rojo");
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
            CasillasGUI casilla = new CasillasGUI(i+8,"       ", this, "Rojo");
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
            CasillasGUI casilla = new CasillasGUI(16+i,"<html><br><br><html>", this, "Rojo");
            casilla.setTipo(casilla.ALTA);
            add(casilla,constraints);
            if(i == 0){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(232, 73, 55));
            }casillaRoja.add(casilla);
        }
    }
    private void casillasVerdes(){
        //tramo 1
        for (int i = 0; i < 8; i++){
            constraints.gridx = 14+i;
            constraints.gridy = 12;
            constraints.gridwidth = 1;
            constraints.gridheight = 2;
            constraints.fill = GridBagConstraints.BOTH;
            CasillasGUI casilla = new CasillasGUI(8+i,"<html><br><br><html>", this, "Verde");
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
            CasillasGUI casilla = new CasillasGUI(i,"       ", this, "Verde");
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
            CasillasGUI casilla = new CasillasGUI(23-i,"       ", this, "Verde");
            casilla.setTipo(casilla.ANCHA);
            add(casilla,constraints);
            if(i == 7){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color (33, 202, 88));
            }casillaVerde.add(casilla);
        }
    }

    private void carcel(){
        constraints.fill = GridBagConstraints.BOTH;
        //GridLayout grid = new GridLayout();
        //Primera carcel
        carcelAzul = new CarcelGUI(new Color(23, 88, 151), new Color(31, 143, 254),"Azul", parchis);
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //grid.setConstraints(carcel1, constraints);
        add(carcelAzul,constraints);
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
        carcelAmarilla = new CarcelGUI(new Color(151, 120, 17), new Color(248, 197, 27),"Amarillo",parchis);
        //grid.setConstraints(carcel2, constraints);
        add(carcelAmarilla,constraints);

        //Centro
        constraints.gridx = 8;
        constraints.gridwidth = 6;
        constraints.gridheight = 6;
        constraints.gridy = 8;
        win1 = new GanadoresGUI(parchis);
        //grid.setConstraints(win1, constraints);
        add(win1,constraints);

        //Tercera carcel
        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel3 = makebutton("Carcel");
        //carcel3.setBackground(new Color(232, 73, 55));
        carcelRoja = new CarcelGUI(new Color(144, 47, 36), new Color(232, 73, 55),"Rojo",parchis);
        //grid.setConstraints(carcel3, constraints);
        add(carcelRoja,constraints);

        //Cuarta carcel
        constraints.gridx = 14;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel4 = makebutton("Carcel");
        //carcel4.setBackground(new Color(33, 202, 88));
        carcelVerde = new CarcelGUI(new Color(22, 119, 52), new Color(33, 202, 88),"Verde",parchis);
        //grid.setConstraints(carcel4, constraints);
        add(carcelVerde,constraints);
    }


    public static void main (String[] args){
        //TableroGUI u = new TableroGUI();
        //u.juego();
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
