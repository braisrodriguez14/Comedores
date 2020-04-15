package gestionMenus;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Menu;

public class GestionMenusImp implements GestionMenus {
	
	//private ArrayList<Menu> menusSemana;
	private GestionDatos gestionDatos;

	public GestionMenusImp() {
		//this.menusSemana = new ArrayList<Menu>();
		this.gestionDatos = null;
	}

	@Override
	public ArrayList<Menu> getMenusSemana() {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public Menu getMenuDia(String dia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public int guardarMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;

	}
	

	@Override
	public void asociarMenuDia(int idMenu, int diaSemana) {
		gestionDatos.asociarMenuDia(idMenu, diaSemana);

	}

}
