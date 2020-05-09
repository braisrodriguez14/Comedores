package Interfaces;

import Implementacion.Plato;

import java.util.ArrayList;

public interface Platos {
    public void listarEntrantes();
    public void listarPrincipales();
    public void listarPostres();
    public Plato devolverPlato(String nombre);
    public ArrayList<Plato> getPlatos();
}
