package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FichasGUI extends JFrame{
    protected JPanel contentPane;
    protected int x;
    protected int y;
    protected int cant;
    protected String color;
    protected String color2;
    public int ANCHA = 1;
    public int ALTA = 0;
    public int CARCEL = 2;
    public int FINAL = 3;
    private int tipo;
    public FichasGUI(String color, int cant){
        this.cant =cant;
        this.color = color;
    }

    public void setXY(int numX, int numY){
        x = numX;
        y = numY;
    }
    public void setColor2(String color){
        this.color2 = color;
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void paint(Graphics g){
        super.paint(g);
        Image img = new ImageIcon(getClass().getResource("/imagenes/CircleP10"+"AzulVentajosa"+".png")).getImage();

        if (cant == 1 && tipo != CARCEL && tipo != FINAL){
            g.drawImage(img,(x/2)-5,(y/2)-5,this);
        }else if(cant == 2 && tipo == ANCHA){
            g.drawImage(img,(x/2)-12,(y/2)-5,this);
            g.drawImage(img,(x/2)+2,(y/2)-5,this);
        }else if(cant == 2 && tipo == ALTA){
            g.drawImage(img,(x/2)-5,(y/2)-12,this);
            g.drawImage(img,(x/2)-5,(y/2)+2,this);
        }

        else if(tipo == CARCEL){
            if (cant == 1){
                g.drawImage(img,45,85,this);
            } else if (cant == 2) {
                g.drawImage(img,45,85,this);
                g.drawImage(img,105,85,this);
            }else if (cant == 3) {
                g.drawImage(img,45,85,this);
                g.drawImage(img,105,85,this);
                g.drawImage(img,45,145,this);
            }else if (cant == 4) {
                g.drawImage(img,45,85,this);
                g.drawImage(img,105,85,this);
                g.drawImage(img,45,145,this);
                g.drawImage(img,105,145,this);
            }
        }

        else if(tipo == FINAL){
            if(color.equals("Azul")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img,(x/2)-15,(y/2)-45,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img,(x/2)-15,(y/2)-45,this);
                    g.drawImage(img,(x/2)+5,(y/2)-45,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img,(x/2)-15,(y/2)-45,this);
                    g.drawImage(img,(x/2)+5,(y/2)-45,this);
                    g.drawImage(img,(x/2)-5,(y/2)-60,this);
                }
            }else if(color.equals("Amarillo")){
                if (cant == 1){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img,(x/2)+26,(y/2)-15,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img,(x/2)+26,(y/2)-15,this);
                    g.drawImage(img,(x/2)+26,(y/2)+5,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img,(x/2)+26,(y/2)-15,this);
                    g.drawImage(img,(x/2)+26,(y/2)+5,this);
                    g.drawImage(img,(x/2)+37,(y/2)-5,this);
                }
            }else if(color.equals("Verde")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img,(x/2)-15,(y/2)+30,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img,(x/2)-15,(y/2)+30,this);
                    g.drawImage(img,(x/2)+5,(y/2)+30,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img,(x/2)-15,(y/2)+30,this);
                    g.drawImage(img,(x/2)+5,(y/2)+30,this);
                    g.drawImage(img,(x/2)-5,(y/2)+45,this);
                }
            }else if(color.equals("Rojo")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img,(x/2)-36,(y/2)-15,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img,(x/2)-36,(y/2)-15,this);
                    g.drawImage(img,(x/2)-36,(y/2)+5,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img,(x/2)-36,(y/2)-15,this);
                    g.drawImage(img,(x/2)-36,(y/2)+5,this);
                    g.drawImage(img,(x/2)-47,(y/2)-5,this);
                }
            }
        }


    }
}
