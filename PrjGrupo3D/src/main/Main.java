
package main;

import java.util.ArrayList;

import analisisEstadisticas.AnalisisEstadisticas;
import analisisEstadisticas.AnalisisEstadisticasImp;
import gestionDatos.GestionDatos;
import gestionDatos.GestionDatosImp;
import gestionMenus.GestionMenus;
import gestionMenus.GestionMenusImp;
import gestionPagosValoraciones.GestionPagosValoraciones;
import gestionPagosValoraciones.GestionPagosValoracionesImp;
import modelo.Bandeja;
import modelo.BandejaImp;
import modelo.Factura;
import modelo.Menu;
import modelo.MenuImp;
import modelo.Plato;
import seleccionMenus.SeleccionMenus;
import seleccionMenus.SeleccionMenusImp;
import sensores.Sensor;
import sensores.SensorImp;

public class Main {

	public static void main( String[ ] args ) {

		
			// Creamos los subsistemas

		GestionDatos gestionDatos = new GestionDatosImp( );
		GestionMenus gestionMenus = new GestionMenusImp( );
		SeleccionMenus seleccionMenus = new SeleccionMenusImp( );
		GestionPagosValoraciones gestionPagosValoraciones = new GestionPagosValoracionesImp( );
		Sensor sensor = new SensorImp( );
		AnalisisEstadisticas analisisEstadisticas = new AnalisisEstadisticasImp( );

		gestionMenus.setGestionDatos( gestionDatos );
		seleccionMenus.setGestionDatos( gestionDatos );
		seleccionMenus.setGestionMenus( gestionMenus );
		gestionPagosValoraciones.setGestionDatos( gestionDatos );
		gestionPagosValoraciones.setSensor( sensor );
		analisisEstadisticas.setGestionDatos( gestionDatos );

		
		

			// GUI DEFINICION DE MENUS

		// En la GUI se mostraria una lista para los primeros, otra para los segundos y postres
		ArrayList< Plato > primeros = gestionMenus.getPrimeros( );
		ArrayList< Plato > segundos = gestionMenus.getSegundos( );
		ArrayList< Plato > postres = gestionMenus.getPostres( );

		ArrayList< Plato > primerosMenu = new ArrayList< Plato >( );
		ArrayList< Plato > segundosMenu = new ArrayList< Plato >( );
		ArrayList< Plato > postresMenu = new ArrayList< Plato >( );

		// Se seleccionan los platos que forman parte del menu
		primerosMenu.add( primeros.get( 0 ) );
		primerosMenu.add( primeros.get( 1 ) );
		primerosMenu.add( primeros.get( 2 ) );

		segundosMenu.add( segundos.get( 0 ) );
		segundosMenu.add( segundos.get( 1 ) );
		segundosMenu.add( segundos.get( 2 ) );

		postresMenu.add( postres.get( 0 ) );
		postresMenu.add( postres.get( 1 ) );
		postresMenu.add( postres.get( 2 ) );

		// Se procede a crear el menu
		Menu menu = new MenuImp( primerosMenu, segundosMenu, postresMenu );

		// Se guarda el menu, que devuelve el id que se le ha asignado
		int idMenu = gestionMenus.guardarMenu( menu );

		// Se asocia el menu al dia de la semana (Lunes-1...Viernes-5)
		gestionMenus.asociarMenuDia( idMenu, 5 );

		// Se recuperan los menus de cada dia de la semana
		ArrayList< Menu > menusSemana = gestionMenus.getMenusSemana( );

		
		
			// GUI SELECCION DE MENUS

		// Se obtiene el menu del dia correspondiente al dia de hoy y todas las bebidas
		Menu menuDia = seleccionMenus.getMenuDia( );
		ArrayList< Plato > bebidas = seleccionMenus.getBebidas( );

		// Se crea la bandeja (lo que vamos a comer) a partir de el menu de el dia y las bebidas
		Plato primero = menuDia.getPrimeros( ).get( 0 );
		Plato segundo = menuDia.getSegundos( ).get( 1 );
		Plato postre = menuDia.getPostres( ).get( 2 );
		Plato bebida = bebidas.get( 0 );

		Bandeja bandeja = new BandejaImp( primero, segundo, postre, bebida );

		// Se procede al pago
		Factura factura = gestionPagosValoraciones.pagar( bandeja, menuDia.getId( ) );

		// usuario.comer(bandeja); #EasterEGG

		// Se devuelve la bandeja y el usuario se marcha del comedor
		gestionPagosValoraciones.devolverBandeja( bandeja.getId( ) );

		
		
			// GUI VALORACIONES DE MENUS

		int valoracionPrimero = 5;
		int valoracionSegundo = 4;
		int valoracionPostre = -1; // No valorado

		gestionPagosValoraciones.valorar( factura.getId( ), valoracionPrimero, valoracionSegundo, valoracionPostre );

		
		
			// GUI VISION MENUS (ESTADISTICAS)
		
		Plato plato;

		plato = analisisEstadisticas.platoMasSelecionado( );
		System.out.println( "Plato Mas Selecionado: " + plato.getNombre( ) );

		plato = analisisEstadisticas.platoMenosSelecionado( );
		System.out.println( "Plato Menos Selecionado: " + plato.getNombre( ) );

		plato = analisisEstadisticas.platoMejorValorado( );
		System.out.println( "Plato Mejor Valorado: " + plato.getNombre( ) );

		plato = analisisEstadisticas.platoPeorValorado( );
		System.out.println( "Plato Peor Valorado: " + plato.getNombre( ) );

		/*
		analisisEstadisticas.ocupacionDiaSemana(5);
		
		 */
		
		System.out.println( analisisEstadisticas.horaMasFrecuente( ) );
		
		System.out.println( analisisEstadisticas.duracionMediaComida( ) );
		
		System.out.println( analisisEstadisticas.rankingPlatos( ) );

	}

}
