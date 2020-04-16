package seleccionMenus;

import gestionDatos.GestionDatos;
import gestionMenus.GestionMenus;
import modelo.Bandeja;

public class SeleccionMenusImp implements SeleccionMenus {

	private GestionMenus gestionMenu;
	private GestionDatos gestionDatos;
	
	public SeleccionMenusImp() {
		
	}
	
	@Override
	public void setGestionMenus(GestionMenus gestionMenus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarBandeja(Bandeja bandeja) {
		gestionDatos.guardarBandeja(bandeja);
	}

}
