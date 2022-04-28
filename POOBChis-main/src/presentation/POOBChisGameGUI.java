package presentation;

import javax.swing.*;
import java.awt.*;

public class POOBChisGameGUI extends JFrame {
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    public POOBChisGameGUI(){
        super("POOBChisGame");
        prepareElements();
    }
    public void prepareElements(){
        setLayout(grid);
        setSize(900,900);
        //init();
        //crearBoton();
        //crearPanel();
        tab();

        setVisible(true);
        //repaint();

    }
    public void crearPanel(){
        JPanel panel = new JPanel();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        //grid.setConstraints(panel, constraints);
        add(new JButton("holu"), constraints);
        setLayout(grid);
    }

    public void crearBoton(){
        JButton button;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        button = new JButton("Button 1");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        add(button, c);

        button = new JButton("Button 2");
        c.gridx = 1;
        c.gridy = 0;
        c.ipady = 0;
        add(button, c);

        button = new JButton("Button 3");
        c.gridx = 2;
        c.gridy = 0;
        add(button, c);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setSize(50,200);
        button = new JButton("Long-Named Button 4");//make this component tall
        panel.add(button);
        button = new JButton("Long-Named Button 4");//make this component tall
        panel.add(button);
        button = new JButton("Long-Named Button 4");//make this component tall
        panel.add(button);
        c.gridx = 5;
        c.gridy = 0;
        c.ipady = 70;
        add(panel, c);

        button = new JButton("Long-Named Button 4");//make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 1;
        add(button, c);

        button = new JButton("5");
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        add(button, c);
    }
    public void init() {
        JButton button;
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        add(new JButton("Button1"), c);
        add(new JButton("Button2"), c);
        add(new JButton("Button3"), c);


        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        add(new JButton("Button4"), c);


        //makebutton("Button4", gridbag, c);
        c.gridwidth = 1;                //reset to the default
        c.gridheight = 2;
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        add(new JButton("Button1111"), c);

        c.weightx = 0.0;                //reset to the default
        //makebutton("Button5", gridbag, c); //another row
        add(new JButton("Button5"), c);


        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
        //makebutton("Button6", gridbag, c);
        add(new JButton("Button6"), c);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        //makebutton("Button7", gridbag, c);
        add(new JButton("Button7"), c);

        c.gridwidth = 1;                //reset to the default
        c.gridheight = 3;
        c.weighty = 0.0;
        //makebutton("Button8", gridbag, c);
        add(new JPanel(), c);

        c.weighty = 0.0;                //reset to the default
        //c.gridwidth = GridBagConstraints.REMAINDER; //end row
        c.gridheight = 1;//reset to the default
        add(new JButton("Button9"), c);
        add(new JButton("Button10"), c);
        add(new JButton("Button11"), c);
        //makebutton("Button8", gridbag, c);
        add(new JPanel(), c);
        //makebutton("Button9", gridbag, c);
        //makebutton("Button10", gridbag, c);


    }
    public void pruebaaaaaaMil(){
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setLayout(gridbag);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.0;
        c.gridwidth = 1;                //reset to the default
        c.gridheight = 3;
        c.weighty = 0.0;
        c.gridx=0;
        c.gridy=0;
        add(new JButton("holi"), c);
        c.gridx=1;
        c.gridy=0;
        c.weighty = 0.0;                //reset to the default
        c.gridwidth = 0;
        c.gridheight = 1;//reset to the default
        add(new JButton("Button9"), c);
        c.gridx=1;
        c.gridy=1;
        add(new JButton("Button10"), c);
        c.gridx=0;
        c.gridy=2;
        add(new JButton("Button11"), c);

        c.weightx = 0.0;
        c.weighty = 0.0;

        c.gridwidth = 3;                //reset to the default
        c.gridheight = 3;

        c.gridx=2;
        c.gridy=3;
        add(new JButton("gdf"), c);

    }

    protected void makebutton(String name) {
        Button button = new Button(name);
        gridbag.setConstraints(button, constraints);
        add(button);
    }

    public void tab(){
        setFont(new Font("SansSerif", Font.PLAIN, 14));

        //Primera carcel
        c.gridwidth = 8;
        c.gridheight = 8;
        makebutton("Carcel");

        //Casillas

        //Segunda carcel

    }

}

