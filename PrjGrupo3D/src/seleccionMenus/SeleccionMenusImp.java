
package seleccionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import gestionMenus.GestionMenus;
import modelo.Menu;
import modelo.Plato;

public class SeleccionMenusImp implements SeleccionMenus {

	private GestionMenus gestionMenus;
	private GestionDatos gestionDatos;

	public SeleccionMenusImp( ) {

	}

	@Override
	public void setGestionMenus( GestionMenus gestionMenus ) {
		this.gestionMenus = gestionMenus;

	}

	@Override
	public void setGestionDatos( GestionDatos gestionDatos ) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public ArrayList< Plato > getBebidas( ) {
		return gestionDatos.getBebidas( );

	}

	@Override
	public Menu getMenuDia( ) {
		return gestionMenus.getMenusSemana( ).get( 0 );

	}

}
