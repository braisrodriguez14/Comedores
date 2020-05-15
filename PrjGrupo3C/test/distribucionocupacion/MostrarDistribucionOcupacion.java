
package distribucionocupacion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Implementacion.EstadisticaImp;
import Interfaces.Estadistica;

class MostrarDistribucionOcupacion {

	private Estadistica estadistica = new EstadisticaImp( );
	private ArrayList< Integer > distribucion;
	private LocalDate tiempo = LocalDate.now( );

	@Test
	void UC_0018_P_01_CP_01( ) {
		//Arrange
		
		//Act
		distribucion = estadistica.mostrarDistribucionOcupacion( null );

		//Assert
		Assertions.assertEquals( null, distribucion );
	}

	@Test
	void UC_0018_P_01_CP_02( ) {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "" );
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		distribucion = estadistica.mostrarDistribucionOcupacion( tiempo );

		//Assert
		Assertions.assertAll(
				( ) -> assertEquals( 0, distribucion.get( 0 ) ),
				( ) -> assertEquals( 0, distribucion.get( 1 ) ),
				( ) -> assertEquals( 0, distribucion.get( 2 ) ),
				( ) -> assertEquals( 0, distribucion.get( 3 ) ),
				( ) -> assertEquals( 0, distribucion.get( 4 ) ),
				( ) -> assertEquals( 0, distribucion.get( 5 ) ),
				( ) -> assertEquals( 0, distribucion.get( 6 ) ) );
	}

	@Test
	void UC_0018_P_01_CP_03( ) {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "cogida\r\n" + "CodigoBandeja: 1\r\n" + "TiempoCogida: " + tiempo.atTime( 9, 15 ) );
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		distribucion = estadistica.mostrarDistribucionOcupacion( LocalDate.now( ) );
		
		//Assert
		Assertions.assertAll(
				( ) -> assertEquals( 0, distribucion.get( 0 ) ),
				( ) -> assertEquals( 0, distribucion.get( 1 ) ),
				( ) -> assertEquals( 0, distribucion.get( 2 ) ),
				( ) -> assertEquals( 0, distribucion.get( 3 ) ),
				( ) -> assertEquals( 0, distribucion.get( 4 ) ),
				( ) -> assertEquals( 0, distribucion.get( 5 ) ),
				( ) -> assertEquals( 0, distribucion.get( 6 ) ) );
	}

	@Test
	void UC_0018_P_01_CP_04( ) {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "cogida\r\n" + "CodigoBandeja: 1\r\n" + "TiempoCogida: " + tiempo.atTime( 14, 15 ) );
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		distribucion = estadistica.mostrarDistribucionOcupacion( tiempo );

		//Assert
		Assertions.assertAll(
				( ) -> assertEquals( 0, distribucion.get( 0 ) ),
				( ) -> assertEquals( 0, distribucion.get( 1 ) ),
				( ) -> assertEquals( 0, distribucion.get( 2 ) ),
				( ) -> assertEquals( 1, distribucion.get( 3 ) ),
				( ) -> assertEquals( 0, distribucion.get( 4 ) ),
				( ) -> assertEquals( 0, distribucion.get( 5 ) ),
				( ) -> assertEquals( 0, distribucion.get( 6 ) ) );

	}

}
