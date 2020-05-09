package Implementacion;

import Interfaces.DAOMenu;
import Interfaces.GestionMenus;
import Interfaces.Menu;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestionMenusImp implements GestionMenus {

    private ArrayList<Menu> Menus;
    private ArrayList<String> Bebida;

    public GestionMenusImp() {
        DAOMenu dao = new DAOMenuImp();
        this.Menus = dao.devolverMenus();
        this.Bebida = new ArrayList<>();
        Bebida.add("Agua");
        Bebida.add("Kas Naranja");
        Bebida.add("Pepsi");
        Bebida.add("Vino");
        Bebida.add("Cerveza");
    }

    @Override
    public void anhadirMenu(Menu menu) {
        DAOMenu dao = new DAOMenuImp();
        dao.guardarMenu(menu);
        this.Menus.add(menu);
    }

    @Override
    public void borrarMenu(LocalDate fecha) {
        Menu menub = null;

        for (Menu menu : this.Menus) {
            if (fecha.isEqual(menu.getFecha())) {
                DAOMenu dao = new DAOMenuImp();
                dao.borrarMenu(menu);
                menub = menu;

            }
        }
        if (menub != null)
            this.Menus.remove(menub);

    }

    @Override
    public void listarMenus() {
        for (Menu men : this.Menus) {
            System.out.println("------------------");
            men.listarPlatosDelMenu();
        }
    }

    @Override
    public Menu obtenerMenuDeHoy() {
        LocalDate locaDate = LocalDate.now();
        for (Menu men : this.Menus) {
            int dia, mes, ano;
            if (locaDate.isEqual(men.getFecha()))
                return men;
        }
        return null;
    }

    @Override
    public ArrayList<String> getBebidas() {
        return this.Bebida; // To change body of generated methods, choose Tools | Templates.
    }

}
