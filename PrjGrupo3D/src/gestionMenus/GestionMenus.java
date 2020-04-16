package gestionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Menu;
import modelo.Plato;

public interface GestionMenus {
	
	public ArrayList<Menu> getMenusSemana();
	
	public void setGestionDatos(GestionDatos gestionDatos);

	public int guardarMenu(Menu menu); 
	
	public void asociarMenuDia(int idMenu, int diaSemana); 
	
	public ArrayList<Plato> getPrimeros();
	
	public ArrayList<Plato> getSegundos();

	public ArrayList<Plato> getPostres();
	


}
