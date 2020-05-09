package Interfaces;

import java.util.ArrayList;

public interface DAOMenu {
    
    public ArrayList<Menu> devolverMenus();
    public void guardarMenu(Menu menu);
    public void borrarMenu(Menu menu);
}
