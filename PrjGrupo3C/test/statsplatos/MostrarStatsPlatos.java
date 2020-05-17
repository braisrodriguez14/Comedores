package statsplatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Implementacion.EstadisticaImp;
import Interfaces.Estadistica;

//Responsable: Miguel Ventoso Fernandez

class MostrarStatsPlatos {

	//Variables globales
	private Estadistica estadistica;
	
	@BeforeAll
	static void preparacion() throws Exception{
		
		//Se comprueba si existe el fichero
		File file = new File("Facturas.txt");

		if (file.createNewFile()) {
		    System.out.println("Se ha creado el archivo Facturas.txt");
		} 
		else {
		    System.out.println("El archivo Facturas.txt ya existe");
		}
	} 
	
	@BeforeEach
	void crearEstadistica(){
		
		//Se crea un nuevo objeto Estadistica antes de ejecutar un nuevo caso de prueba
		estadistica = new EstadisticaImp();
	}
	
	/*Antes de comenzar con las pruebas, cabe resaltar que para poder llevarlas a cabo es necesario llenar el fichero 
	 * Estadisticas.txt con ciertos datos, ya que el m�todo a probar debe leer esos datos para poder llegar 
	 * a las conclusiones*/
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_01() {
		
		//Arrange
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
				out.write( "IdxFactura\r\n" + "Vale: 1\r\n" + "CodigoBandeja: 1\r\n" + "Platos: croquetas,bacalao,natilla\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Platos.txt", false ) );
				out.write( "IdxPlato\r\n" + "Nombre: croquetas\r\n" + "Calorias: 1\r\n" + "Ingredientes: croquetas\r\n" + "Tipo: entrante\r\n" +
						"IdxPlato\r\n" + "Nombre: bacalao\r\n" + "Calorias: 1\r\n" + "Ingredientes: bacalao\r\n" + "Tipo: principal\r\n" +
						"IdxPlato\r\n" + "Nombre: natilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: natilla\r\n" + "Tipo: postre\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			String solucion = "El entrante mas elegido es: croquetas. El entrante menos elegido es: croquetas. El principal mas elegido es: bacalao"
					+ ". El principal menos elegido es: bacalao. El postre mas elegido es: natilla. El postre menos elegido es: natilla";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_02() {
		
		//Arrange
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
				out.write( "IdxFactura\r\n" + "Vale: 1\r\n" + "CodigoBandeja: 1\r\n" + "Platos: croquetas,bacalao,natilla\r\n" + 
				"IdxFactura\r\n" + "Vale: 2\r\n" + "CodigoBandeja: 2\r\n" + "Platos: croquetas,bacalao,natilla\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Platos.txt", false ) );
				out.write( "IdxPlato\r\n" + "Nombre: croquetas\r\n" + "Calorias: 1\r\n" + "Ingredientes: croquetas\r\n" + "Tipo: entrante\r\n" +
						"IdxPlato\r\n" + "Nombre: bacalao\r\n" + "Calorias: 1\r\n" + "Ingredientes: bacalao\r\n" + "Tipo: principal\r\n" +
						"IdxPlato\r\n" + "Nombre: natilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: natilla\r\n" + "Tipo: postre\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			String solucion = "El entrante mas elegido es: croquetas. El entrante menos elegido es: croquetas. El principal mas elegido es: bacalao"
					+ ". El principal menos elegido es: bacalao. El postre mas elegido es: natilla. El postre menos elegido es: natilla";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_03() {
		
		//Arrange
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
				out.write( "IdxFactura\r\n" + "Vale: 1\r\n" + "CodigoBandeja: 1\r\n" + "Platos: croquetas,bacalao,natilla\r\n" + 
				"IdxFactura\r\n" + "Vale: 2\r\n" + "CodigoBandeja: 2\r\n" + "Platos: croquetas,costilla,natilla\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Platos.txt", false ) );
				out.write( "IdxPlato\r\n" + "Nombre: croquetas\r\n" + "Calorias: 1\r\n" + "Ingredientes: croquetas\r\n" + "Tipo: entrante\r\n" +
						"IdxPlato\r\n" + "Nombre: bacalao\r\n" + "Calorias: 1\r\n" + "Ingredientes: bacalao\r\n" + "Tipo: principal\r\n" +
						"IdxPlato\r\n" + "Nombre: natilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: natilla\r\n" + "Tipo: postre\r\n" +
						"IdxPlato\r\n" + "Nombre: costilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: costilla\r\n" + "Tipo: principal\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			String solucion = "El entrante mas elegido es: croquetas. El entrante menos elegido es: croquetas. El principal mas elegido es: bacalao"
					+ ". El principal menos elegido es: bacalao. El postre mas elegido es: natilla. El postre menos elegido es: natilla";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_04() {
		
		//Arrange
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
				out.write( "IdxFactura\r\n" + "Vale: 1\r\n" + "CodigoBandeja: 1\r\n" + "Platos: croquetas,bacalao,natilla\r\n" + 
				"IdxFactura\r\n" + "Vale: 2\r\n" + "CodigoBandeja: 2\r\n" + "Platos: sopa,costilla,manzana\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Platos.txt", false ) );
				out.write( "IdxPlato\r\n" + "Nombre: croquetas\r\n" + "Calorias: 1\r\n" + "Ingredientes: croquetas\r\n" + "Tipo: entrante\r\n" +
						"IdxPlato\r\n" + "Nombre: bacalao\r\n" + "Calorias: 1\r\n" + "Ingredientes: bacalao\r\n" + "Tipo: principal\r\n" +
						"IdxPlato\r\n" + "Nombre: natilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: natilla\r\n" + "Tipo: postre\r\n" +
						"IdxPlato\r\n" + "Nombre: sopa\r\n" + "Calorias: 1\r\n" + "Ingredientes: sopa\r\n" + "Tipo: primero\r\n" +
						"IdxPlato\r\n" + "Nombre: manzana\r\n" + "Calorias: 1\r\n" + "Ingredientes: manzana\r\n" + "Tipo: postre\r\n" +
						"IdxPlato\r\n" + "Nombre: costilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: costilla\r\n" + "Tipo: principal\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			String solucion = "El entrante mas elegido es: croquetas. El entrante menos elegido es: croquetas. El principal mas elegido es: bacalao"
					+ ". El principal menos elegido es: bacalao. El postre mas elegido es: natilla. El postre menos elegido es: natilla";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_05() {
		
		//Arrange
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
				out.write( "IdxFactura\r\n" + "Vale: 1\r\n" + "CodigoBandeja: 1\r\n" + "Platos: croquetas,bacalao,natilla\r\n" + 
				"IdxFactura\r\n" + "Vale: 2\r\n" + "CodigoBandeja: 2\r\n" + "Platos: croquetas,bacalao,natilla\r\n" + 
				"IdxFactura\r\n" + "Vale: 3\r\n" + "CodigoBandeja: 3\r\n" + "Platos: sopa,costilla,manzana\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			try {
				BufferedWriter out = new BufferedWriter( new FileWriter( "Platos.txt", false ) );
				out.write( "IdxPlato\r\n" + "Nombre: croquetas\r\n" + "Calorias: 1\r\n" + "Ingredientes: croquetas\r\n" + "Tipo: entrante\r\n" +
						"IdxPlato\r\n" + "Nombre: bacalao\r\n" + "Calorias: 1\r\n" + "Ingredientes: bacalao\r\n" + "Tipo: principal\r\n" +
						"IdxPlato\r\n" + "Nombre: natilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: natilla\r\n" + "Tipo: postre\r\n" +
						"IdxPlato\r\n" + "Nombre: sopa\r\n" + "Calorias: 1\r\n" + "Ingredientes: sopa\r\n" + "Tipo: primero\r\n" +
						"IdxPlato\r\n" + "Nombre: manzana\r\n" + "Calorias: 1\r\n" + "Ingredientes: manzana\r\n" + "Tipo: postre\r\n" +
						"IdxPlato\r\n" + "Nombre: costilla\r\n" + "Calorias: 1\r\n" + "Ingredientes: costilla\r\n" + "Tipo: principal\r\n");
				out.close( );
			}
			catch( IOException ex ) {
				ex.printStackTrace( );
			}
			
			String solucion = "El entrante mas elegido es: croquetas. El entrante menos elegido es: sopa. El principal mas elegido es: bacalao"
					+ ". El principal menos elegido es: costilla. El postre mas elegido es: natilla. El postre menos elegido es: manzana";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
	
	@DisplayName("Mostrar Stats Platos")
	@Test
	void UC_0016_P_01_CP_06() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
			out.write("");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
			
			String solucion = "";
		
			//Act
			String resultado = estadistica.mostrarStatsPlatos();
			
			//Assert
			Assertions.assertEquals(solucion, resultado, "El resultado NO es el esperado");
			
			
	}
		
		

}
