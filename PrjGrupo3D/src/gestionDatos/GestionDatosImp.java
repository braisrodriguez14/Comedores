package gestionDatos;

import java.util.ArrayList;

import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import modelo.Menu;
import modelo.Plato;

public class GestionDatosImp implements GestionDatos {
	
	public GestionDatosImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Plato> getPlatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plato> getPrimeros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plato> getSegundos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plato> getPostres() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Plato> getBebidas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Plato getPlato(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getMenu(int idMenu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarMenu(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarMenu(Menu menu) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void asociarMenuDia(int idMenu, int diaSemana) {
		
		
		
		
		//Comprobar que se pueda asociar a ese dia -> Que no este ocupado por otro menu
		//										   -> Que si es jueves no puedas asociar un lunes											
		
		
		
		

	}

	@Override
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Factura> getFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Estadistica> getEstadisticas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarEstadistica(Estadistica estadistica) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarBandeja(Bandeja bandeja) {
		// TODO Auto-generated method stub
		
	}

}
