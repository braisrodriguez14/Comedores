
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
		if( gestionDatos!=null ) {
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
		else {
			return null;
		}

	}

	@Override
	public void setGestionDatos( GestionDatos gestionDatos ) {
		this.gestionDatos = gestionDatos;
	}

	@Override
	public int guardarMenu( Menu menu ) {
		if( gestionDatos!=null ) {
			return this.gestionDatos.guardarMenu( menu );			
		}
		else {
			return -1;
		}
	}

	@Override
	public void asociarMenuDia( int idMenu, int diaSemana ) {
		if( gestionDatos!=null ) {
			gestionDatos.asociarMenuDia( idMenu, diaSemana );
		}

	}

	public void restablecerDias( ) {
		if( gestionDatos!=null ) {
			gestionDatos.restablecerDias( );
		}
	}
	

	@Override
	public ArrayList< Plato > getPrimeros( ) {
		if( gestionDatos!=null ) {
			return gestionDatos.getPrimeros( );
		}
		else {
			return null;
		}
	}

	@Override
	public ArrayList< Plato > getSegundos( ) {
		if( gestionDatos!=null ) {
			return gestionDatos.getSegundos( );
		}
		else {
			return null;
		}
	}

	@Override
	public ArrayList< Plato > getPostres( ) {
		if( gestionDatos!=null ) {
			return gestionDatos.getPostres( );
		}
		else {
			return null;
		}
	}

}
