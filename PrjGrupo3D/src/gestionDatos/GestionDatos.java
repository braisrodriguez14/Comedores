package gestionDatos;

import java.util.ArrayList;

import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import modelo.Menu;
import modelo.Plato;

public interface GestionDatos {
	
	public ArrayList<Plato> getPlatos();
	
	public ArrayList<Plato> getPrimeros();
	
	public ArrayList<Plato> getSegundos();

	public ArrayList<Plato> getPostres();
	
	public ArrayList<Plato> getBebidas();
	
	public Plato getPlato(String nombre);
	
	public ArrayList<Menu> getMenus();
	
	public Menu getMenu(int idMenu);
	
	public void guardarMenu(Menu menu);
	
	public void actualizarMenu(Menu menu);
	
	public void asociarMenuDia(int idMenu, int diaSemana); 
	
	public void guardarFactura(Factura factura);
	
	public ArrayList<Factura> getFacturas();
	
	public ArrayList<Estadistica> getEstadisticas();

	public void guardarEstadistica(Estadistica estadistica);
	
	public void guardarBandeja(Bandeja bandeja);


}
