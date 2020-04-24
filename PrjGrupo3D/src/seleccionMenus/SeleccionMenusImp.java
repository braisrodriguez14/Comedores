
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
		if( gestionDatos != null ) {
			return gestionDatos.getBebidas( );
		}
		else {
			return null;
		}
	}

	@Override
	public Menu getMenuDia( ) {
		if( gestionMenus != null ) {
			return gestionMenus.getMenusSemana( ).get( 0 );
		}
		else {
			return null;
		}

	}

}
