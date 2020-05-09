package Implementacion;

import Interfaces.Seleccion;

public class Factura {
    private Seleccion seleccion;
    private int vale;
    private int codigoBandeja;

    public Factura(){

    }

    public Factura(Seleccion seleccion, int vale, int codigoBandeja) {
        this.seleccion = seleccion;
        this.vale = vale;
        this.codigoBandeja = codigoBandeja;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public int getVale() {
        return vale;
    }

    public void setVale(int vale) {
        this.vale = vale;
    }

    public int getCodigoBandeja() {
        return codigoBandeja;
    }

    public void setCodigoBandeja(int codigoBandeja) {
        this.codigoBandeja = codigoBandeja;
    }
}