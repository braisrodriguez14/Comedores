package Interfaces;

import java.util.ArrayList;
import Implementacion.Plato;

public interface DAOPlato {

    public ArrayList<Plato> devolverPlatos();

    public Plato recuperarPlato(String nombre);

}   