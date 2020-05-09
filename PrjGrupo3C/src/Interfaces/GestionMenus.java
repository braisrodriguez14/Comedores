package Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

public interface GestionMenus {
    public void anhadirMenu(Menu menu);
    public void borrarMenu(LocalDate fecha);
    public void listarMenus();
    public Menu obtenerMenuDeHoy();
    public ArrayList<String> getBebidas();
}
