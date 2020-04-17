
package gestionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Menu;
import modelo.Plato;

public class GestionMenusImp implements GestionMenus {

	private GestionDatos gestionDatos;

	public GestionMenusImp( ) {
		this.gestionDatos = null;
	}

	@Override
	public ArrayList< Menu > getMenusSemana( ) {
		ArrayList< Menu > menusSemana = new ArrayList< Menu >( );
		ArrayList< Menu > menus = gestionDatos.getMenus( );
		int diaSemana = java.time.LocalDate.now( ).getDayOfWeek( ).getValue( );
		if( diaSemana > 5 ) {
			diaSemana = 1;
		}
		for( ; diaSemana < 6; diaSemana++ ) {
			for( Menu menu : menus ) {
				if( menu.getDia( ) == diaSemana ) {
					menusSemana.add( menu );
				}
			}
		}
		return menusSemana;

	}

	@Override
	public void setGestionDatos( GestionDatos gestionDatos ) {
		this.gestionDatos = gestionDatos;
	}

	@Override
	public int guardarMenu( Menu menu ) {
		return this.gestionDatos.guardarMenu( menu );
	}

	@Override
	public void asociarMenuDia( int idMenu, int diaSemana ) {
		gestionDatos.asociarMenuDia( idMenu, diaSemana );

	}

	@Override
	public ArrayList< Plato > getPrimeros( ) {
		return gestionDatos.getPrimeros( );
	}

	@Override
	public ArrayList< Plato > getSegundos( ) {
		return gestionDatos.getSegundos( );
	}

	@Override
	public ArrayList< Plato > getPostres( ) {
		return gestionDatos.getPostres( );
	}

}
