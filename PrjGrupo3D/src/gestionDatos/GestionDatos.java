package gestionDatos;

import java.util.ArrayList;

import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import modelo.Menu;
import modelo.Plato;

public interface GestionDatos {

	// Platos.txt
	public ArrayList<Plato> getPlatos();

	public ArrayList<Plato> getPrimeros();

	public ArrayList<Plato> getSegundos();

	public ArrayList<Plato> getPostres();

	public ArrayList<Plato> getBebidas();

	public Plato getPlato(String nombre);

	// Menus.txt
	public ArrayList<Menu> getMenus();
	
	public Menu getMenu(int idMenu);

	public int guardarMenu(Menu menu);

	public void restablecerDias();

	public void asociarMenuDia(int idMenu, int diaSemana);

	// Facturas.txt
	public ArrayList<Factura> getFacturas();

	public void guardarFactura(Factura factura);

	// BaseEstadistica.txt
	public ArrayList<Estadistica> getEstadisticas();
	
	public void guardarComida(Bandeja bandeja, int idFactura);

	public void devolverBandeja(int idBandeja);

	public void valorar(int idFactura, int valoracionPrimero, int valoracionSegundo, int valoracionPostre);


}
