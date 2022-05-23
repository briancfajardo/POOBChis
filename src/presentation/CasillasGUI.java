package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class CasillasGUI extends JPanel implements Serializable {
    private OpcionFichaGUI opcionFichaGUI;
    private boolean habilitado = true;
    private Point punto;
    private MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            actualizar(parchis.obtenerTurno());
            //System.out.println(habilitado + " " + parchis.isTurnoPropio()+"  "+(!parchis.isMov1() || !parchis.isMov2())
            //        +"  "+ parchis.obtenerTurno());
            if (habilitado && parchis.isTurnoPropio()){

                if (parchis.isMataFicha()) {
                    parchis.moverGanancia(color,num, 20);
//
                }else if (parchis.isSacaFicha()){
                    parchis.moverGanancia(color,num, 10);
                }
                else if(!parchis.isMov1() || !parchis.isMov2()){
                    punto=MouseInfo.getPointerInfo().getLocation();
                    int x=punto.x;
                    int y=punto.y;
                    opcionFichaGUI = new OpcionFichaGUI(tablero, x, y);
                    //System.out.println(parchis.getCantidadCasilla(color, num));
                    if(parchis.getCantidadCasilla(color, num) != 0){

                        opcionFichaGUI.moverFicha(color, num);
                    }
                }



            }
            tablero.juego();
            //contieneFichaColor(turno);
            //System.out.println(turno);
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
    int alto;
    int ancho;
    public int ANCHA = 1;
    public int ALTA = 0;
    private int tipo;
    private FichasGUI ficha;
    private int num;
    private Parchis parchis;
    private String color;
    private boolean bloqueado;
    private boolean seguro;
    private TableroGUI tablero;
    private String tipo1;
    private String tipo2;

    //private String turno;

    /**
     * Constructor de la clase CasillasGUI
     * @param num número de elementos con los que se crea
     * @param msg Mensaje que contendrá (Se usó para cuadrar tamaños)
     * @param tablero Tablero GUI
     * @param color color de la casa a la que pertenece
     */
    public CasillasGUI(int num, String msg, TableroGUI tablero, String color){
        parchis = tablero.getParchis();
        this.tablero = tablero;
        this.color = color;
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(clic);
        setVisible(true);
        add(new JLabel(msg));
        alto = getSize().height;
        ancho = getSize().width;
        ficha = new FichasGUI(color,0, "Borde", "Borde", "Borde", "Borde");
        this.num = num;
        this.bloqueado = parchis.isBloqueado(color,num);
        this.seguro = parchis.isSeguro(color,num);
        //turno = convertirStringTurno();
    }

    /**
     * Método que retorna si la casilla se encuentra habilitada
     * @return booleano que representa si la casilla se encuentra habilitada
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * Método que actualiza todos los parámetros de la casilla
     * @param turno turno para saber si se habilita o no la casilla
     */
    public void actualizar(String turno){
        int aux = parchis.getCantidadCasilla(color, num);
        ficha.setCant(aux);

        habilitado = contieneFichaColor(turno);
        //System.out.println("Está habilitado: "+ habilitado);
        if(parchis.isSeguro(color,num) && num != 4){
            setBackground(new Color(192, 180, 179));
        } else if (parchis.isBloqueado(color,num) && num != 4) {
            setBackground(new Color(216, 144, 225));
        }else if(num != 4 && num >= 0 && num <16){
            setBackground(new Color(237, 237, 237));
        }
        try{
            if (aux == 1){
                //System.out.println(aux);
                ficha.setColor(parchis.getColorFicha(color,num,0));
                String clase = String.valueOf(parchis.getTablero().getElementosCasilla(color,num).get(0).getClass()).replace("class domain.", "");
                if (clase.equals("Ficha")){
                    clase = "Borde";
                }
                ficha.setClase1(clase);

            }else if(aux == 2){
                ficha.setColor(parchis.getColorFicha(color,num,0));
                ficha.setColor2(parchis.getColorFicha(color,num,1));

                String clase = String.valueOf(parchis.getTablero().getElementosCasilla(color,num).get(0).getClass()).replace("class domain.", "");
                if (clase.equals("Ficha")){
                    clase = "Borde";
                }
                ficha.setClase1(clase);

                String clase2 = String.valueOf(parchis.getTablero().getElementosCasilla(color,num).get(1).getClass()).replace("class domain.", "");
                if (clase2.equals("Ficha")){
                    clase2 = "Borde";
                }
                ficha.setClase2(clase2);
            }
        }catch (Exception e){
            System.out.println(num + " " + parchis.getCantidadCasilla(color, num));
        }

        //if(parchis.isBloqueado(color,num)){
        //    setBackground(new Color (192, 180, 179));
        //}
        repaint();
    }

    /**
     * Método para especificar un tipo de casilla, entre ancha y alta, esto debido a que pese a que se crean todas las casillas
     * al tiempo la forma cambia dependiendo de su posición
     * @param tipo tipo de casilla
     */
    public void setTipo(int tipo){
        this.tipo = tipo;
        if(tipo == ANCHA){
            ficha.setRolFicha(ficha.ANCHA);
        }else {
            ficha.setRolFicha(ficha.ALTA);
        }

    }

    /**
     * Método que sobrescribe parchis cuando se se abre un nuevo archivo
     * @param parchis objeto Parchis que se reemplazará
     */
    public void actualizarParchis(Parchis parchis){
        this.parchis = parchis;
        //repaint();
    }

    /**
     * Métod que dice si la casilla contiene una ficha de un color específico
     * @param colorTurno color del turno actual, esto para saber que casillas estarán habilitas
     * @return booleano
     */
    private boolean contieneFichaColor (String colorTurno){
        //System.out.println("mataFicha: " + parchis.isMataFicha() + "   sacaFicha: " + parchis.isSacaFicha());
        //System.out.println("Bloqueo:"+!parchis.getTablero().verificarBloqueo(color, num, 20, colorTurno) + "   color: " + color + "   numero: " + num);
        if (ficha.getCant() == 1){
            //System.out.println("--------------------");
            if (parchis.isMataFicha() && !parchis.getTablero().verificarBloqueo(color, num, 20, colorTurno)) {
                return ficha.getColor().equals(colorTurno);
            }else if (parchis.isMataFicha()){
                return false;
            }

            if (parchis.isSacaFicha() && !parchis.getTablero().verificarBloqueo(color, num, 10, colorTurno)) {
                return ficha.getColor().equals(colorTurno);
            }else if (parchis.isSacaFicha()){
                return false;
            }

            if (!parchis.getTablero().verificarBloqueo(color, num, parchis.getValor1(), colorTurno)
                    && (!parchis.isMov1() || parchis.isSacaFicha() || parchis.isMataFicha())){
                return ficha.getColor().equals(colorTurno);
            }
            if (!parchis.getTablero().verificarBloqueo(color, num, parchis.getValor2(), colorTurno)
                    && (!parchis.isMov2() || parchis.isSacaFicha() || parchis.isMataFicha())){
                return ficha.getColor().equals(colorTurno);
            }
        }else if (ficha.getCant() == 2){

            if (parchis.isMataFicha() && !parchis.getTablero().verificarBloqueo(color, num, 20, colorTurno)) {
                return ficha.getColor().equals(colorTurno) || ficha.getColor2().equals(colorTurno);
            }else if (parchis.isMataFicha()){
                return false;
            }

            if (parchis.isSacaFicha() && !parchis.getTablero().verificarBloqueo(color, num, 10, colorTurno)) {
                return ficha.getColor().equals(colorTurno) || ficha.getColor2().equals(colorTurno);
            }else if (parchis.isSacaFicha()){
                return false;
            }

            if (!parchis.getTablero().verificarBloqueo(color, num, parchis.getValor1(), colorTurno)
                    && (!parchis.isMov1() || parchis.isSacaFicha() || parchis.isMataFicha())){
                return ficha.getColor().equals(colorTurno) || ficha.getColor2().equals(colorTurno);
            }
            if (!parchis.getTablero().verificarBloqueo(color, num, parchis.getValor2(), colorTurno)
                    && (!parchis.isMov2() || parchis.isSacaFicha() || parchis.isMataFicha())){
                return ficha.getColor().equals(colorTurno) || ficha.getColor2().equals(colorTurno);
            }
            //if (!parchis.getTablero().verificarBloqueo(color, num, parchis.getValor2(), colorTurno) && ficha.getColor().equals(colorTurno) && ficha.getColor2().equals(colorTurno)
            //&& parchis.isMov1() && parchis.isMov2()){
            //    return true;
            //}
        }
        return false;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        alto = getSize().height;
        ancho = getSize().width;
        ficha.setXY(ancho,alto);
        ficha.paint(g);
    }
}
