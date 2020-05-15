package rankingplatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Implementacion.EstadisticaImp;
import Interfaces.Estadistica;


//Responsable: Alberto Pampin Perez


class MostrarRankingPlatos {
	
	//Variables globales
	private Estadistica estat;
	
	@BeforeAll
	static void preparacion() throws Exception{
		
		//Se comprueba si existe el fichero
		File file = new File("Estadisticas.txt");

		if (file.createNewFile()) {
		    System.out.println("Se ha creado el archivo Estadisticas.txt");
		} 
		else {
		    System.out.println("El archivo Estadisticas.txt ya existe");
		}
	} 
	
	@BeforeEach
	void crearEstadistica(){
		
		//Se crea un nuevo objeto Estadistica antes de ejecutar un nuevo caso de prueba
		estat = new EstadisticaImp();
	}

	

	@Test
	void UC_0017_P_01_CP_01() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertEquals("Verduras salteadas", resultado.get(0), "El resultado NO es 'Verduras salteadas'");
		
	}
	
	
	@Test
	void UC_0017_P_01_CP_02() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertEquals("Verduras salteadas", resultado.get(0), "El resultado NO es 'Verduras salteadas'");
		
	}
	
	@Test
	void UC_0017_P_01_CP_03() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertEquals("Verduras salteadas", resultado.get(0), "El resultado NO es 'Verduras salteadas'");
		
	}
	
	@Test
	void UC_0017_P_01_CP_04() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "valoracion\r\n" + "Nombre: Cerdo a la parrilla\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 6\r\n" + "Comentario: na\r\n");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertEquals("Verduras salteadas-Cerdo a la parrilla", resultado.get(0)+"-"+resultado.get(1), "El resultado NO es 'Verduras salteadas-Cerdo a la parrilla'");
		
	}
	
	@Test
	void UC_0017_P_01_CP_05() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "valoracion\r\n" + "Nombre: Cerdo a la parrilla\r\n" + "Nota: 4\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Verduras salteadas\r\n" + "Nota: 6\r\n" + "Comentario: na\r\n");
			out.write( "valoracion\r\n" + "Nombre: Cerdo a la parrilla\r\n" + "Nota: 5\r\n" + "Comentario: na\r\n");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertEquals("Verduras salteadas-Cerdo a la parrilla", resultado.get(0)+"-"+resultado.get(1), "El resultado NO es 'Verduras salteadas-Cerdo a la parrilla'");
		
	}
	
	@Test
	void UC_0017_P_01_CP_06() {
		
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
		
		//Act
		ArrayList<String> resultado = estat.mostrarRankingPlatos();
		
		//Assert
		Assertions.assertTrue(resultado.isEmpty(), "El resultado NO es está vacío");
		
	}

}
