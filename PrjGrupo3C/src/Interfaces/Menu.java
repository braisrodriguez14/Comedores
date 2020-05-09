
package Interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Implementacion.Plato;


public interface Menu {

    public void anhadirPrincipal(Plato plato);

    public void anhadirEntrante(Plato plato);

    public void anhadirPostre(Plato plato);

    public void listarPlatosDelMenu();

    public LocalDate getFecha();

    public void setFecha(LocalDate fecha);

    public ArrayList<Plato> getEntrantes();

    public void setEntrantes(ArrayList<Plato> entrantes);

    public ArrayList<Plato> getPrincipales();

    public void setPrincipales(ArrayList<Plato> principales);

    public ArrayList<Plato> getPostres();

    public void setPostres(ArrayList<Plato> postres);

    
}