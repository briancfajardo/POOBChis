package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableroGUI extends JFrame {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Lumpias");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };


    public TableroGUI() {
        super("POOBChisGame");
        prepareElements();
    }

    public void prepareElements() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(grid);

        setSize(900, 900);
        //init();
        //crearBoton();
        //crearPanel();
        tab();

        setVisible(true);
        //repaint();

    }

    protected JPanel makebutton(String name) {

        JPanel button = new JPanel();
        button.add(new JLabel(name));

        button.setBorder(BorderFactory.createEtchedBorder());

        button.addMouseListener(clic);
        //button.setBackground(Color.green);
        button.setVisible(true);
        grid.setConstraints(button, constraints);
        add(button);

        return button;

    }

    public void tab() {
        constraints.fill = GridBagConstraints.BOTH;
        carcel();
        CasillasHorizontales();
        CasillasVerticales();
    }

    public void CasillasHorizontales() {
        //Casillas primera parte
        int cont = 0;
        constraints.gridx = 8;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        int cont2 = 0;
        int cont3 = 1;
        //constraints.gridwidth = GridBagConstraints.RELATIVE;

        for (int i = 0; i <= 47; i++){
            JPanel casilla = makebutton("       ");
            validacionAzulVerde(casilla);

            constraints.gridx += 2;
            cont += 1;

            if (cont == 3) {
                constraints.gridx = 8;
                constraints.gridy = 14 + cont2;
            }

            if (cont == 6){
                cont2 += 1;
                constraints.gridy = cont3;
                cont3 += 1;
                cont = 0;
                constraints.gridx = 8;
            }
        }
    }

    public void validacionAzulVerde(JPanel casilla){
        if (constraints.gridx == 10 && constraints.gridy >=0 && constraints.gridy < 8){
            if (constraints.gridy == 0){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(31, 144, 255));
            }
        } else if (constraints.gridx == 10 && constraints.gridy >=14){
            if (constraints.gridy == 21){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(33, 203, 88));
            }
        } else if (constraints.gridx == 8 && constraints.gridy == 4){
            casilla.setBackground(new Color (31,144,255));
        } else if (constraints.gridx == 12 && constraints.gridy == 17) {
            casilla.setBackground(new Color(33, 203, 88));
        } else if (constraints.gridx == 12 && constraints.gridy == 4) {
            casilla.setBackground(new Color(192, 180, 179));
        } else if (constraints.gridx == 8 && constraints.gridy == 17) {
            casilla.setBackground(new Color(192, 180, 179));
        }
    }

    public void CasillasVerticales(){
        //Casillas segunda parte
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.gridy = 8;
        constraints.gridx = 0;
        int cont = 0;

        for (int i = 0; i <= 47; i++){
            JPanel casilla = makebutton("<html><br><br><html>");
            validacionRojoAmarillo(casilla);

            constraints.gridx += 1;
            cont += 1;

            if (cont == 8){
                constraints.gridx = 14;
            }

            if (cont == 16){
                constraints.gridy += 2;
                constraints.gridx = 0;
                cont = 0;
            }
        }
    }

    public void validacionRojoAmarillo(JPanel casilla) {
        if (constraints.gridy == 10 && constraints.gridx >=0 && constraints.gridx < 8){
            if (constraints.gridx == 0){
                casilla.setBackground(new Color (192, 180, 179));
            }else{
                casilla.setBackground(new Color (233, 73, 55));
            }
        } else if (constraints.gridy == 10 && constraints.gridx >=14){
            if (constraints.gridx == 21){
                casilla.setBackground(new Color (192, 180, 179));
            }else {
                casilla.setBackground(new Color(249, 198, 27));
            }
        } else if (constraints.gridx == 4 && constraints.gridy == 12){
            casilla.setBackground(new Color (233, 73, 55));
        } else if (constraints.gridx == 17 && constraints.gridy == 8) {
            casilla.setBackground(new Color(249, 198, 27));
        } else if (constraints.gridx == 4 && constraints.gridy == 8) {
            casilla.setBackground(new Color(192, 180, 179));
        } else if (constraints.gridx == 17 && constraints.gridy == 12) {
            casilla.setBackground(new Color(192, 180, 179));
        }
    }
    //public void paint(Graphics g){
    //    super.paint(g);
    //    Graphics2D circulo = (Graphics2D)g;
    //    circulo.setStroke(new BasicStroke(10.f));
    //    circulo.setPaint(new Color(23, 88, 151));
    //    circulo.fillOval(100,100,40,40);
    //}

    public void carcel(){
        //GridLayout grid = new GridLayout();
        //Primera carcel
        CarcelGUI carcel1 = new CarcelGUI(new Color(23, 88, 151), new Color(31, 143, 254));
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        grid.setConstraints(carcel1, constraints);
        add(carcel1);
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
        CarcelGUI carcel2 = new CarcelGUI(new Color(151, 120, 17), new Color(248, 197, 27));
        grid.setConstraints(carcel2, constraints);
        add(carcel2);

        //Centro
        constraints.gridx = 8;
        constraints.gridwidth = 6;
        constraints.gridheight = 6;
        constraints.gridy = 8;
        makebutton("Colores");

        //Tercera carcel
        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel3 = makebutton("Carcel");
        //carcel3.setBackground(new Color(232, 73, 55));
        CarcelGUI carcel3 = new CarcelGUI(new Color(144, 47, 36), new Color(232, 73, 55));
        grid.setConstraints(carcel3, constraints);
        add(carcel3);

        //Cuarta carcel
        constraints.gridx = 14;
        constraints.gridy = 14;
        constraints.gridwidth = 8;
        constraints.gridheight = 8;
        //JPanel carcel4 = makebutton("Carcel");
        //carcel4.setBackground(new Color(33, 202, 88));
        CarcelGUI carcel4 = new CarcelGUI(new Color(22, 119, 52), new Color(33, 202, 88));
        grid.setConstraints(carcel4, constraints);
        add(carcel4);


    }

    public static void main (String args[]){
        TableroGUI u = new TableroGUI();
    }
}
