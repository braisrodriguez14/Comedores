package seleccionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import gestionMenus.GestionMenus;
import modelo.*;

public interface SeleccionMenus {
	
	public void setGestionMenus(GestionMenus gestionMenus);   
	
	public void setGestionDatos(GestionDatos gestionDatos);

	public ArrayList<Plato> getBebidas(); 
	
	public Menu getMenuDia(); 

}
