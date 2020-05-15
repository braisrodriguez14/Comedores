
package pagar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Implementacion.Plato;
import Implementacion.SeleccionImp;
import Interfaces.Pago;
import Interfaces.Seleccion;

class Pagar {

	private Seleccion seleccion;
	private Pago pago;
	private int tamInicial;
	private int tamFinal;

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

	@Test
	void UC_0008_P_01_CP_01( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( "Verduras salteadas", 300, "entrante" ) );
		seleccion.setPrincipal( new Plato( "Cerdo a la parrilla", 500, "principal" ) );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal > tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_02( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = null;

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_03( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( "Verduras salteadas", 300, "entrante" ) );
		seleccion.setPrincipal( new Plato( "Cerdo a la parrilla", 500, "principal" ) );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal > tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_04( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( null );
		seleccion.setPrincipal( null );
		seleccion.setPostre( null );
		seleccion.setBebida( null );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_05( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( "Verduras salteadas", 300, "entrante" ) );
		seleccion.setPrincipal( null );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_06( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( null );
		seleccion.setPrincipal( null );
		seleccion.setPostre( null );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_07( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( "Verduras salteadas", 300, "entrante" ) );
		seleccion.setPrincipal( new Plato( "Cerdo a la parrilla", 500, "principal" ) );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( null );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_08( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( "Verduras salteadas", 300, "entrante" ) );
		seleccion.setPrincipal( new Plato( "Cerdo a la parrilla", 500, "principal" ) );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal > tamInicial );
	}

	@Test
	void UC_0008_P_01_CP_09( ) {
		//Arrange
		tamInicial = tam( );

		seleccion = new SeleccionImp( );
		seleccion.setEntrante( new Plato( null, 300, "entrante" ) );
		seleccion.setPrincipal( new Plato( "Cerdo a la parrilla", 500, "principal" ) );
		seleccion.setPostre( new Plato( "Helado de vainilla", 700, "postre" ) );
		seleccion.setBebida( "Agua" );

		//Act
		pago = new Implementacion.Pago( );
		pago.setHoraIni( LocalDateTime.now( ) );
		pago.pagar( seleccion );

		tamFinal = tam( );

		//Assert
		Assertions.assertEquals( true, tamFinal == tamInicial );
	}

}
