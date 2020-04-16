package gestionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Menu;
import modelo.Plato;

public class GestionMenusImp implements GestionMenus {
	
	//private ArrayList<Menu> menusSemana;
	private GestionDatos gestionDatos;

	public GestionMenusImp() {
		//this.menusSemana = new ArrayList<Menu>();
		this.gestionDatos = null;
	}

	@Override
	public ArrayList<Menu> getMenusSemana() {
		// SE DEVUELVEN EL DE HOY Y EL DEL RESTO DE LA SEMANA HASTA EL VIERNES
		
		
		
		//SI HOY ES MIERCOLES, SE DEVUELVE MIERCOLES, JUEVES Y VIERNES SOLAMENTE!!!!!!!!!
		
		
		return null;

	}

	

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public int guardarMenu(Menu menu) {
		//Cuando se guarde el menu en el fichero, se devuelve el id
		//hacer menu.setId(   el id que nos devuelva     )
		return 0;

	}
	

	@Override
	public void asociarMenuDia(int idMenu, int diaSemana) {
		gestionDatos.asociarMenuDia(idMenu, diaSemana);

	}

	@Override
	public ArrayList<Plato> getPrimeros() {
		return gestionDatos.getPrimeros();
	}

	@Override
	public ArrayList<Plato> getSegundos() {
		return gestionDatos.getSegundos();
	}

	@Override
	public ArrayList<Plato> getPostres() {
		return gestionDatos.getPostres();
	}

	
	
	
	

}
