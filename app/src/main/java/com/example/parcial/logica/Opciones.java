package com.example.parcial.logica;

public class Opciones {
    public String opcion="";
    public boolean correcto;

    public Opciones() {
    }

    public Opciones(String opcion,boolean correcto) {
        this.opcion=opcion;
        this.correcto=false;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
