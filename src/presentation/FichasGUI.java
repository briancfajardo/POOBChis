package presentation;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class FichasGUI extends JFrame implements Serializable {
    private JPanel contentPane;
    private int x;
    private int y;
    private int cant;
    private String color;
    private String color2;
    public int ANCHA = 1;
    public int ALTA = 0;
    public int CARCEL = 2;
    public int FINAL = 3;
    private int rolFicha;

    private ElementoGUI elemento1;
    private ElementoGUI elemento2;
    private ElementoGUI elemento3;
    private ElementoGUI elemento4;

    public FichasGUI(String color, int cant, String tipo1, String tipo2, String tipo3, String tipo4){
        this.cant =cant;
        this.color = color;
        this.color2 = color;
        elemento1 = new ElementoGUI(tipo1);
        elemento2 = new ElementoGUI(tipo2);
        elemento3 = new ElementoGUI(tipo3);
        elemento4 = new ElementoGUI(tipo4);

    }

    public void setClase1(String clase){
        elemento1.cambiarTipo(clase);
    }

    public void setClase2(String clase){
        elemento2.cambiarTipo(clase);
    }
    public void setClase3(String clase){
        elemento3.cambiarTipo(clase);
    }
    public void setClase4(String clase){
        elemento4.cambiarTipo(clase);
    }

    public void setXY(int numX, int numY){
        x = numX;
        y = numY;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setColor2(String color){
        this.color2 = color;
    }
    public void setRolFicha(int rolFicha){
        this.rolFicha = rolFicha;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getColor(){return color;}

    public String getColor2(){return color2;}
    public int getCant(){return cant;}


    public void paint(Graphics g){
        super.paint(g);
        Image img = elemento1.creadorImagen(color);
        Image img2 = elemento2.creadorImagen(color2);
        Image img3 = elemento3.creadorImagen(color);
        Image img4 = elemento4.creadorImagen(color);


        if (cant == 1 && rolFicha != CARCEL && rolFicha != FINAL){
            g.drawImage(img,(x/2)-5,(y/2)-5,this);
        }else if(cant == 2 && rolFicha == ANCHA){
            g.drawImage(img,(x/2)-12,(y/2)-5,this);
            g.drawImage(img2,(x/2)+2,(y/2)-5,this);
        }else if(cant == 2 && rolFicha == ALTA){
            g.drawImage(img,(x/2)-5,(y/2)-12,this);
            g.drawImage(img2,(x/2)-5,(y/2)+2,this);
        }

        else if(rolFicha == CARCEL){
            if (cant == 1){
                g.drawImage(img,45,85,this);
            } else if (cant == 2) {
                g.drawImage(img,45,85,this);
                g.drawImage(img2,105,85,this);
            }else if (cant == 3) {
                g.drawImage(img,45,85,this);
                g.drawImage(img2,105,85,this);
                g.drawImage(img3,45,145,this);
            }else if (cant == 4) {
                g.drawImage(img,45,85,this);
                g.drawImage(img2,105,85,this);
                g.drawImage(img3,45,145,this);
                g.drawImage(img4,105,145,this);
            }
        }

        else if(rolFicha == FINAL){
            if(color.equals("Azul")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img2,(x/2)-15,(y/2)-45,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img2,(x/2)-15,(y/2)-45,this);
                    g.drawImage(img3,(x/2)+5,(y/2)-45,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-5,(y/2)-30,this);
                    g.drawImage(img2,(x/2)-15,(y/2)-45,this);
                    g.drawImage(img3,(x/2)+5,(y/2)-45,this);
                    g.drawImage(img4,(x/2)-5,(y/2)-60,this);
                }
            }else if(color.equals("Amarillo")){
                if (cant == 1){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img2,(x/2)+26,(y/2)-15,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img2,(x/2)+26,(y/2)-15,this);
                    g.drawImage(img3,(x/2)+26,(y/2)+5,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)+15,(y/2)-5,this);
                    g.drawImage(img2,(x/2)+26,(y/2)-15,this);
                    g.drawImage(img3,(x/2)+26,(y/2)+5,this);
                    g.drawImage(img4,(x/2)+37,(y/2)-5,this);
                }
            }else if(color.equals("Verde")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img2,(x/2)-15,(y/2)+30,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img2,(x/2)-15,(y/2)+30,this);
                    g.drawImage(img3,(x/2)+5,(y/2)+30,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-5,(y/2)+15,this);
                    g.drawImage(img2,(x/2)-15,(y/2)+30,this);
                    g.drawImage(img3,(x/2)+5,(y/2)+30,this);
                    g.drawImage(img4,(x/2)-5,(y/2)+45,this);
                }
            }else if(color.equals("Rojo")){
                if (cant == 1){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                }else if(cant == 2){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img2,(x/2)-36,(y/2)-15,this);
                }else if(cant == 3){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img2,(x/2)-36,(y/2)-15,this);
                    g.drawImage(img3,(x/2)-36,(y/2)+5,this);
                }
                else if(cant == 4){
                    g.drawImage(img,(x/2)-25,(y/2)-5,this);
                    g.drawImage(img2,(x/2)-36,(y/2)-15,this);
                    g.drawImage(img3,(x/2)-36,(y/2)+5,this);
                    g.drawImage(img4,(x/2)-47,(y/2)-5,this);
                }
            }
        }



    }
}
