package presentation;

import domain.Dado;
import domain.Parchis;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DadosGUI extends JPanel {
    private int valor1 = 1;
    private int valor2 = 1;
    private OpcionFichaGUI opcionFichaGUI;
    private Parchis parchis;
    private MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (parchis.isMov1() && parchis.isMov2() && parchis.getValor1() == parchis.getValor2()){
                parchis.setMov1(false);
                parchis.setMov2(false);
                parchis.tirarDado();
                valor1 = parchis.getValor1();
                valor2 = parchis.getValor2();
                ReproducirSonido();
                repaint();
            }

            else if (!parchis.isMov1() && !parchis.isMov2()) {
                parchis.tirarDado();
                valor1 = parchis.getValor1();
                valor2 = parchis.getValor2();
                ReproducirSonido();
                repaint();

            }else{
                setEnabled(false);
            }

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
    public DadosGUI(Parchis parchis){
        this.parchis = parchis;
        prepareElements();
    }
    public int getValor1(){
        return valor1;
    }
    public int getValor2(){
        return valor2;
    }
    public void prepareElements(){
        setPreferredSize(new Dimension((96*2)+10,96));
        //setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        addMouseListener(clic);
        setVisible(true);
    }

    public void ReproducirSonido(){
        try {
            //URL url = getClass().getResource("/audios/dados.wav");
            //File audio = new File("wav2.wav");
            String nombreSonido = "src/audios/dados.wav";

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido. " + ex);
        }
    }
    public void paint(Graphics g){
        Image img1 = new ImageIcon(getClass().getResource("/imagenes/Dado"+valor1+".png")).getImage();
        Image img2 = new ImageIcon(getClass().getResource("/imagenes/Dado"+valor2+".png")).getImage();
        super.paint(g);
        g.drawImage(img1,0,0,this);
        g.drawImage(img2,96,0,this);

    }
}
