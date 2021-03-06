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
import java.io.Serializable;
import java.net.URL;

/**
 * Clase encargada de mostrar los dados, hereda de JPanel
 */
public class DadosGUI extends JPanel implements Serializable {
    private int valor1 = 1;
    private int valor2 = 1;
    private OpcionFichaGUI opcionFichaGUI;
    private Parchis parchis;
    private TableroGUI tablero;
    private MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //System.out.println("mov1: " + parchis.isMov1()+ "   mov2: " + parchis.isMov1() + "   prim: " + parchis.getPrimeraTirada());
            if (parchis.isMov1() && parchis.isMov2() && parchis.getValor1() == parchis.getValor2()){
                parchis.setMov1(false);
                parchis.setMov2(false);
                parchis.tirarDado();
                valor1 = parchis.getValor1();
                valor2 = parchis.getValor2();
                ReproducirSonido();
                repaint();
            }

            else if (!parchis.isMov1() && !parchis.isMov2() && !parchis.getPrimeraTirada()) {
                parchis.tirarDado();
                valor1 = parchis.getValor1();
                valor2 = parchis.getValor2();
                ReproducirSonido();
                repaint();

            }else{
                setEnabled(false);
            }

            tablero.juego();

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

    /**
     * Constructor de la clase DadosGUI con un atributo TableroGUI que contiene parchis y le permite actualizar su valor
     * @param tablero
     */
    public DadosGUI(TableroGUI tablero){
        parchis = tablero.getParchis();
        this.tablero = tablero;
        prepareElements();

    }

    /**
     * M??todo que permite saber cual es el valor del dado 1
     * @return retorna el valor del dado 1
     */
    public int getValor1(){
        return valor1;
    }
    /**
     * M??todo que permite saber cual es el valor del dado 2
     * @return retorna el valor del dado 2
     */
    public int getValor2(){
        return valor2;
    }

    /**
     * M??todo que prepara los elementos necesarios como el tama??o el fondo y su visibilidad
     */
    private void prepareElements(){
        setPreferredSize(new Dimension((96*2)+10,96));
        //setBorder(BorderFactory.createEtchedBorder());
        setOpaque(false);
        addMouseListener(clic);
        setVisible(true);
    }

    /**
     * M??todo que busca en el paquete de sonidos, los carga y los reproduce
     */
    private void ReproducirSonido(){
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

    /**
     * M??todo que sobrescribe parchis cuando se se abre un nuevo archivo
     * @param parchis objeto Parchis que se reemplazar??
     */
    public void actualizarParchis(Parchis parchis){
        this.parchis = parchis;
        //repaint();
    }
    @Override
    public void paint(Graphics g){
        Image img1 = new ImageIcon(getClass().getResource("/imagenes/Dado"+valor1+".png")).getImage();
        Image img2 = new ImageIcon(getClass().getResource("/imagenes/Dado"+valor2+".png")).getImage();
        super.paint(g);
        g.drawImage(img1,0,0,this);
        g.drawImage(img2,96,0,this);

    }
}
