package presentation;

import domain.Parchis;
import domain.ParchisException;
import domain.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class TableroGUI extends JFrame implements ActionListener,Serializable{

    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private TableroGUI.Fondo fondo = new TableroGUI.Fondo();
    private Parchis parchis;
    private DadosGUI dado;
    private int dado1;
    private int dado2;

    private JMenuBar menu;
    private JMenu archivoM;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem salvar;
    private JMenuItem salir;
    private JFileChooser archivos;
    private File partida;

    private CarcelGUI carcelAzul;
    private CarcelGUI carcelAmarilla;
    private CarcelGUI carcelRoja;
    private CarcelGUI carcelVerde;

    private boolean terminar = false;
    private ArrayList<CasillasGUI> casillaAzul= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaAmarilla= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaRoja= new ArrayList<>();
    private ArrayList<CasillasGUI> casillaVerde= new ArrayList<>();
    private  JLabel turno, encarcelada, enjuego, coronada;
    private GanadoresGUI win1;
    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoRojo = new ArrayList<>();
    private int cantJugadores;
    private String turnoActual;

    private String usuarioRojo, usuarioAmarillo, usuarioVerde, usuarioAzul;



    public TableroGUI(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde,
                      ArrayList<String> tipoRojo, int cantJugadores, String usuarioAmarillo, String usuarioAzul,
                      String usuarioVerde, String usuarioRojo) {
        super("POOBChisGame");
        this.cantJugadores = cantJugadores;
        this.setContentPane(fondo);
        //inicializarTipos();
        parchis = new Parchis(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo, cantJugadores);

        this.usuarioAmarillo = usuarioAmarillo;
        this.usuarioAzul = usuarioAzul;
        this.usuarioRojo = usuarioRojo;
        this.usuarioVerde = usuarioVerde;

        prepareElements();
    }

    public Parchis getParchis(){return parchis;}


    public void juego(){
        //while (!terminar){
        int contHabilitados = 0;
        mensajeTurno();
        mensajeEncarceladas();
        mensajeCoronadas();
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
        prepareElementsMenu();
        tab();

        setVisible(true);
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
    private void tab() {
        constraints.fill = GridBagConstraints.BOTH;
        carcel();
        casillasAzules();
        casillasAmarillas();
        casillasRojas();
        casillasVerdes();
        dados();
        tituloTurno();
        tituloEncarceladas();
        tituloCoronadas();

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
            turno.setText("Turno de " + usuarioRojo);
            turno.setForeground(new Color(227, 128, 128));
            turnoActual = "Rojo";
        } else if (parchis.getTurno(parchis.VERDE)) {
            turno.setText("Turno de " + usuarioVerde);
            turno.setForeground(new Color(87, 234, 135));
            turnoActual = "Verde";
        }else if (parchis.getTurno(parchis.AZUL)) {
            turno.setText("Turno de " + usuarioAzul);
            turno.setForeground(new Color(56, 152, 248));
            turnoActual = "Azul";
        }else if (parchis.getTurno(parchis.AMARILLO)) {
            turno.setText("Turno de " + usuarioAmarillo);
            turno.setForeground(new Color(241, 206, 89));
            turnoActual = "Amarillo";
        }
    }

    private void tituloEncarceladas(){
        constraints.gridx = 22;
        constraints.gridwidth = 10;
        constraints.gridheight = 1;
        constraints.gridy = 8;
        constraints.fill = GridBagConstraints.BOTH;
        encarcelada = new JLabel();
        Font letra = new Font("Serif", Font.CENTER_BASELINE, 30);
        encarcelada.setFont(letra);
        mensajeEncarceladas();
        add(encarcelada, constraints);
    }
    private void mensajeEncarceladas(){
        if(parchis.getTurno(parchis.ROJO)){
            encarcelada.setText("Fichas en la carcel: " + parchis.getCarcel("Rojo"));
            encarcelada.setForeground(new Color(227, 128, 128));
            turnoActual = "Rojo";
        } else if (parchis.getTurno(parchis.VERDE)) {
            encarcelada.setText("Fichas en la carcel: " + parchis.getCarcel("Verde"));
            encarcelada.setForeground(new Color(87, 234, 135));
            turnoActual = "Verde";
        }else if (parchis.getTurno(parchis.AZUL)) {
            encarcelada.setText("Fichas en la carcel: " + parchis.getCarcel("Azul"));
            encarcelada.setForeground(new Color(56, 152, 248));
            turnoActual = "Azul";
        }else if (parchis.getTurno(parchis.AMARILLO)) {
            encarcelada.setText("Fichas en la carcel: " + parchis.getCarcel("Amarillo"));
            encarcelada.setForeground(new Color(241, 206, 89));
            turnoActual = "Amarillo";
        }
    }

    private void tituloCoronadas(){
        constraints.gridx = 22;
        constraints.gridwidth = 10;
        constraints.gridheight = 1;
        constraints.gridy = 10;
        constraints.fill = GridBagConstraints.BOTH;
        coronada = new JLabel();
        Font letra = new Font("Serif", Font.CENTER_BASELINE, 30);
        coronada.setFont(letra);
        mensajeCoronadas();
        add(coronada, constraints);
    }
    private void mensajeCoronadas(){
        if(parchis.getTurno(parchis.ROJO)){
            coronada.setText("Fichas coronadas: " + parchis.getGanadores("Rojo"));
            coronada.setForeground(new Color(227, 128, 128));
            turnoActual = "Rojo";
        } else if (parchis.getTurno(parchis.VERDE)) {
            coronada.setText("Fichas coronadas: " + parchis.getGanadores("Verde"));
            coronada.setForeground(new Color(87, 234, 135));
            turnoActual = "Verde";
        }else if (parchis.getTurno(parchis.AZUL)) {
            coronada.setText("Fichas coronadas: " + parchis.getGanadores("Azul"));
            coronada.setForeground(new Color(56, 152, 248));
            turnoActual = "Azul";
        }else if (parchis.getTurno(parchis.AMARILLO)) {
            coronada.setText("Fichas coronadas: " + parchis.getGanadores("Amarillo"));
            coronada.setForeground(new Color(241, 206, 89));
            turnoActual = "Amarillo";
        }
    }

    private void dados(){
        constraints.gridx = 22;
        constraints.gridwidth = 8;
        constraints.gridheight = 4;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.BOTH;
        dado = new DadosGUI(this);
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


    /**
     * Evento que se realiza cuando se da clic en el botón de abrir
     * Genera un JFileChooser
     */
    public void abrirArchivos(){
        try {
            archivos = new JFileChooser();
            archivos.showOpenDialog(this);
            partida = archivos.getSelectedFile();
            String nombre = partida+"";
            parchis = parchis.abrir(nombre);
            actualizarParchis();
            juego();

        }catch (ParchisException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Archivo no encontrado");
        }


    }

    private void actualizarParchis(){
        //while (!terminar){
        carcelAzul.actualizarParchis(parchis);
        carcelAmarilla.actualizarParchis(parchis);
        carcelRoja.actualizarParchis(parchis);
        carcelVerde.actualizarParchis(parchis);
        win1.actualizarParchis(parchis);
        dado.actualizarParchis(parchis);
        for(int i = 0; i<24;i++){
            casillaAzul.get(i).actualizarParchis(parchis);
            casillaAmarilla.get(i).actualizarParchis(parchis);
            casillaRoja.get(i).actualizarParchis(parchis);
            casillaVerde.get(i).actualizarParchis(parchis);

        }
    }

    public void salvarArchivos(){
        try{
            archivos = new JFileChooser();
            archivos.showSaveDialog(this);
            String nombre = archivos.getSelectedFile()+"";
            parchis.guardar(nombre);
        }catch (ParchisException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Archivo no encontrado");
        }


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
            //TableroGUI tab = new TableroGUI(parchis.getTipoAmarillo(), parchis.getTipoAzul(), parchis.getTipoVerde(), parchis.getTipoRojo(), parchis.getCantJugadores());

        }
        if (e.getSource() == salvar) {
            salvarArchivos();
        }
        if (e.getSource() == salir) {
            System.exit(0);
        }
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
