package domain;

import java.util.ArrayList;

public class Casilla extends  Elemento{
    private ArrayList<Elemento> elementos;
    private boolean bloqueado = false;

    private boolean seguro = false;
    public Casilla(){
        elementos = new ArrayList<Elemento>();
    }

    public void setBloqueado(){
        bloqueado = true;
    }

    public void setSeguro(){
        seguro = true;
    }

    public void quitarBloqueo(){
        bloqueado = false;
    }

    public ArrayList<Elemento> getElementos(){
        return elementos;
    }


    public void agregarUno(Elemento nuevoElemento) {
        elementos.add(nuevoElemento);
    }

    public void tomarComodin(Comodin comodin, Ficha ficha){
        comodin.mostrarPoder();
    }

    public void quitarElemento(Elemento elemento){
        elementos.remove(elemento);
    }

    public boolean isBloqueado(){
        return bloqueado;
    }

    public boolean isSeguro(){
        return seguro;
    }

    @Override
    public String toString(){
        String mensaje = "";
        mensaje += "clase: " + getClass() + "\n";
        mensaje += "elementos: " + getElementos().toString() + "\n";
        mensaje += "esSeguro: " + seguro + "\n";
        mensaje += "estaBloqueado: " + bloqueado + "\n";
        return mensaje;
    }

}
