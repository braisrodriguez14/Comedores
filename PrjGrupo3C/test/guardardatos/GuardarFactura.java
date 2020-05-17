package guardardatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Implementacion.DAOFacturaImp;
import Implementacion.Factura;
import Implementacion.Plato;
import Implementacion.SeleccionImp;
import Interfaces.DAOFactura;
import Interfaces.Seleccion;

//Responsable: Miguel Ventoso Fernandez

class GuardarFactura {

	private DAOFactura daoFactura;
	
	@BeforeAll
	static void preparacionClase() throws Exception{
		
		//Se comprueba si existe el fichero
		File file = new File("Facturas.txt");

		if (file.createNewFile()) {
		    System.out.println("Se ha creado el archivo Estadisticas.txt");
		} 
		else {
		    System.out.println("El archivo Estadisticas.txt ya existe");
		}
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
			out.write( "");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
	} 

	@BeforeEach
	void preparacionCasoPrueba(){
		
		//Se crea un nuevo objeto DAOEstadistica antes de ejecutar un nuevo caso de prueba
		daoFactura = new DAOFacturaImp();
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Facturas.txt", false ) );
			out.write("");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
	} 
	
	private int tam( ) {
		int tam = 0;

		try {

			File file = new File( "Facturas.txt" );
			FileReader fr = new FileReader( file );
			BufferedReader br = new BufferedReader( fr );

			while( br.readLine( ) != null ) {
				tam += 1;
			}
			fr.close( ); // closes the stream and release the resources
		}
		catch( Exception ex ) {
			ex.printStackTrace( );
		}

		return tam;
	}
	
	@DisplayName("Guardar datos")
	@Test
	void UC_0022_P_02_CP_01() {
		
		//Arrange
		int tamInicial = tam();
		Plato entrante = new Plato("croquetas", 200, "entrante");
		Plato primero = new Plato("bacalao", 200, "principal");
		Plato postre = new Plato("natillas", 100, "postre");
		Seleccion seleccion = new SeleccionImp();
		seleccion.setEntrante(entrante);
		seleccion.setPrincipal(primero);
		seleccion.setPostre(postre);
		seleccion.setBebida("agua");
		
		Factura factura = new Factura(seleccion, -1, 2);
				
		//Act
		daoFactura.GuardarFactura(factura);
		int tamFinal = tam();
		
		//Assert
		
		Assertions.assertEquals( 0, tamFinal - tamInicial, "Fallo al guardar factura con id vale negativo");
		
		/*El resultado esperado es que, al ser el identificador del vale negativo, no se escriba en el fichero.
		por lo que no debe haber variacion del tamanho del fichero*/
		
	}
	
	@DisplayName("Guardar datos")
	@Test
	void UC_0022_P_02_CP_02() {
		
		//Arrange
		int tamInicial = tam();
		Plato entrante = new Plato("croquetas", 200, "entrante");
		Plato primero = new Plato("bacalao", 200, "principal");
		Plato postre = new Plato("natillas", 100, "postre");
		Seleccion seleccion = new SeleccionImp();
		seleccion.setEntrante(entrante);
		seleccion.setPrincipal(primero);
		seleccion.setPostre(postre);
		seleccion.setBebida("agua");
		
		Factura factura = new Factura(seleccion, 1, -2);
				
		//Act
		daoFactura.GuardarFactura(factura);
		int tamFinal = tam();
		
		//Assert
		
		Assertions.assertEquals( 0, tamFinal - tamInicial, "Fallo al guardar factura con id bandeja negativo");
		
		/*El resultado esperado es que, al ser el codigo de la bandeja negativo, no se escriba en el fichero,
		por lo que no debe haber variacion del tamanho del fichero*/
		
	}
	
	@DisplayName("Guardar datos")
	@Test
	void UC_0022_P_02_CP_03() {
		
		//Arrange
		int tamInicial = tam();
		Seleccion seleccion = new SeleccionImp();
		seleccion.setEntrante(null);
		seleccion.setPrincipal(null);
		seleccion.setPostre(null);
		seleccion.setBebida(null);
		
		Factura factura = new Factura(seleccion, 1, 2);
				
		//Act
		daoFactura.GuardarFactura(factura);
		int tamFinal = tam();
		
		//Assert
		
		Assertions.assertEquals( 0, tamFinal - tamInicial, "Fallo al guardar factura con seleccion null negativo");
		
		/*El resultado esperado es que, al ser la seleccion null, no se escriba en el fichero,
		por lo que no debe haber variacion del tamanho del fichero*/
		
	}
	
	@DisplayName("Guardar datos")
	@Test
	void UC_0022_P_02_CP_04() {
		
		//Arrange
		int tamInicial = tam();
		Plato entrante = new Plato("croquetas", 200, "entrante");
		Plato primero = new Plato("bacalao", 200, "principal");
		Plato postre = new Plato("natillas", 100, "postre");
		Seleccion seleccion = new SeleccionImp();
		seleccion.setEntrante(entrante);
		seleccion.setPrincipal(primero);
		seleccion.setPostre(postre);
		seleccion.setBebida("agua");
		
		Factura factura = new Factura(seleccion, 1, 2);
				
		//Act
		daoFactura.GuardarFactura(factura);
		int tamFinal = tam();
		
		//Assert
		
		Assertions.assertEquals( 4, tamFinal - tamInicial, "Fallo al guardar factura con seleccion null negativo");
		
		/*El resultado esperado es que, al ser todos los datos introducidos datos validos, se escriba en el fichero
		 * Facturas.txt el contenido de la factura (es decir, 4 lineas)*/
		
	}
	

}