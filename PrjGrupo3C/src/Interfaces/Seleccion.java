package Interfaces;

import Implementacion.Plato;

public interface Seleccion {
    public Plato  seleccionarEntrante(String nombre);
    public Plato  seleccionarPrincipal(String nombre);
    public Plato seleccionarPostre(String nombre);
    public Boolean  seleccionarBebida(String bebida);
    public Plato getEntrante();
    public void setEntrante(Plato entrante);
    public Plato getPrincipal();
    public void setPrincipal(Plato principal);
    public Plato getPostre();
    public void setPostre(Plato postre);
    public String getBebida();
    public void setBebida(String bebida);
}
