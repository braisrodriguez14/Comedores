package main;

import java.util.ArrayList;

import analisisEstadisticas.*;
import gestionDatos.*;
import gestionMenus.*;
import gestionPagosValoraciones.*;
import seleccionMenus.*;
import sensores.*;
import modelo.*;

public class Main {
	
	public static void main(String[] args) {
		
							//Creamos los subsistemas
		
		GestionDatos gestionDatos = new GestionDatosImp();
		GestionMenus gestionMenus = new GestionMenusImp();
		SeleccionMenus seleccionMenus = new SeleccionMenusImp();
		GestionPagosValoraciones gestionPagosValoraciones = new GestionPagosValoracionesImp();
		AnalisisEstadisticas analisisEstadisticas = new AnalisisEstadisticasImp();
		Sensor sensor = new SensorImp();

		gestionMenus.setGestionDatos(gestionDatos);
		
		
		
		
							//A partir de aqui son los metodos de las GUI
		
		
							//GUI DEFINICION DE MENUS
		
		//En la GUI se mostraria una lista para los primeros, otra para los segundos y postres
		ArrayList<Plato> primeros = gestionDatos.getPrimeros();		
		ArrayList<Plato> segundos = gestionDatos.getSegundos();	
		ArrayList<Plato> postres = gestionDatos.getPostres();
		
		ArrayList<Plato> primerosMenu = new ArrayList<Plato>();		
		ArrayList<Plato> segundosMenu = new ArrayList<Plato>();	
		ArrayList<Plato> postresMenu = new ArrayList<Plato>();
		
		
		//Se seleccionan los platos que forman parte del menu
		primerosMenu.add(primeros.get(0));
		primerosMenu.add(primeros.get(1));
		primerosMenu.add(primeros.get(2));

		segundosMenu.add(segundos.get(0));
		segundosMenu.add(segundos.get(1));
		segundosMenu.add(segundos.get(2));

		postresMenu.add(postres.get(0));
		postresMenu.add(postres.get(1));
		postresMenu.add(postres.get(2));

		
		//Se procede a crear el menu
		Menu menu = new MenuImp(primerosMenu, segundosMenu, postresMenu);
		
		//Se guarda el menu, que devuelve el id que se le ha asignado
		int idMenu = gestionMenus.guardarMenu(menu);
		
		//Se asocia el menu al dia de la semana  (Lunes-1...Viernes-5)
		gestionMenus.asociarMenuDia(idMenu, 3);
		
		//Se recuperan los menus de cada dia de la semana
		ArrayList<Menu> menusSemana = gestionMenus.getMenusSemana();
		
		
		
		
						//GUI SELECCION DE MENUS
		
		//Se obtiene el menu del dia correspondiente al dia de hoy y todas las bebidas
		Menu menuDia = gestionMenus.getMenuDia();
		ArrayList<Plato> bebidas = gestionDatos.getBebidas();
		
		
		//Se crea la bandeja (lo que vamos a comer) a partir de el menu de el dia y las bebidas
		Plato primero = menuDia.getPrimeros().get(0);
		Plato segundo = menuDia.getSegundos().get(1);
		Plato postre = menuDia.getPostres().get(2);
		Plato bebida = bebidas.get(0);
		
		Bandeja bandeja = new BandejaImp(primero, segundo, postre, bebida);
		
		//Se guarda la bandeja 
		seleccionMenus.guardarBandeja(bandeja);
		
		//Se procede al pago
		Factura factura = gestionPagosValoraciones.pagar(bandeja);
		
		
		
						//GUI VALORACIONES DE MENUS
		int valoracionPrimero = 5;
		int valoracionSegundo = 4;
		int valoracionPostre = -1;  //No valorado
		
		gestionPagosValoraciones.valorar(factura, bandeja,valoracionPrimero, valoracionSegundo, valoracionPostre);
		

	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
}
