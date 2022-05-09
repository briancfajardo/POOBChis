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

    public ArrayList<Elemento> getElementos(){
        return elementos;
    }

    public void addElemento(Elemento nuevoElemento) {
        if (elementos.isEmpty()) {
            elementos.add(nuevoElemento);
        } else if (nuevoElemento instanceof Ficha nuevo){
            Elemento e = elementos.get(0);

            if (e instanceof Ficha) {
                BloquearOMatar(nuevo);
            } else if (e instanceof Comodin) {
                tomarComodin((Comodin) e, nuevo);
            }
        }
    }

    public void agregarUno(Elemento nuevoElemento) {
        elementos.add(nuevoElemento);
    }

    public void BloquearOMatar(Ficha ficha){
        Ficha f = (Ficha) elementos.get(0);
        if (f.getColor() == ficha.getColor()){
            setBloqueado();
            elementos.add(f);
        }else{
            elementos.remove(0);
            elementos.add(f);
        }
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
