package seleccionMenus;

import gestionDatos.GestionDatos;
import gestionMenus.GestionMenus;
import modelo.Bandeja;

public interface SeleccionMenus {
	
	public void setGestionMenus(GestionMenus gestionMenus);   
	
	public void setGestionDatos(GestionDatos gestionDatos);
	
	public void guardarBandeja(Bandeja bandeja); 

}
