package gestionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Menu;

public interface GestionMenus {
	
	public ArrayList<Menu> getMenusSemana();
	
	public Menu getMenuDia();
	
	public void setGestionDatos(GestionDatos gestionDatos);

	public int guardarMenu(Menu menu); 
	
	public void asociarMenuDia(int idMenu, int diaSemana); 


}
