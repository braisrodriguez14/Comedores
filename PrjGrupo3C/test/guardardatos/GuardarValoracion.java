package guardardatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Implementacion.DAOEstadisticaImp;
import Implementacion.Valoracion;
import Interfaces.DAOEstadistica;


//Responsable: Alberto Pampin Perez

class GuardarValoracion {

	private DAOEstadistica daoEstat;
	
	@BeforeAll
	static void preparacionClase() throws Exception{
		
		//Se comprueba si existe el fichero
		File file = new File("Estadisticas.txt");

		if (file.createNewFile()) {
		    System.out.println("Se ha creado el archivo Estadisticas.txt");
		} 
		else {
		    System.out.println("El archivo Estadisticas.txt ya existe");
		}
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
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
		daoEstat = new DAOEstadisticaImp();
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter( "Estadisticas.txt", false ) );
			out.write( "");
			out.close( );
		}
		catch( IOException ex ) {
			ex.printStackTrace( );
		}
	} 
	
	
	@Test
	void UC_0022_P_03_CP_01() {
		
		//Arrange
		int bandeja = -1;
		Valoracion val = new Valoracion(5, "Correcto");
		val.setNombrePlato("Cerdo a la parrilla");
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA. bandeja < 0");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
		
		/* NOTA
		 Para poder hacer este segundo assert es necesario sobreescribir el método equal en la clase Implementacion/Valoracion.java
		 En caso de no hacerlo comparará la direccion de memoria del objeto y no es contenido, que es lo que nos interesa
		 */
	}
	
	
	
	@Test
	void UC_0022_P_03_CP_02() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = null;
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}

	
	@Test
	void UC_0022_P_03_CP_03() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = new Valoracion(-1, "Correcto");
		val.setNombrePlato("Cerdo a la parrilla");
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA. val.nota < 1");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}
	
	@Test
	void UC_0022_P_03_CP_04() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = new Valoracion(11, "Correcto");
		val.setNombrePlato("Cerdo a la parrilla");
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA. val.nota > 10");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}
	
	@Test
	void UC_0022_P_03_CP_05() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = new Valoracion(5, null);
		val.setNombrePlato("Cerdo a la parrilla");
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA. val.comentario = null");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}
	
	@Test
	void UC_0022_P_03_CP_06() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = new Valoracion(5, "Correcto");
		val.setNombrePlato(null);
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert 1 -> Se comprueba si se ha guardado la valoracion
		Assertions.assertTrue(daoEstat.devolverValoraciones().size() == 0, "La valoracion ha sido guardada en el fichero, NO DEBERÍA. val.nombrePlato = null");
		
		//Assert 2 -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}
	
	@Test
	void UC_0022_P_03_CP_07() {
		
		//Arrange
		int bandeja = 1;
		Valoracion val = new Valoracion(5, "Correcto");
		val.setNombrePlato("Cerdo a la parrilla");
				
		//Act
		daoEstat.guardarValoracion(bandeja, val);
		
		//Assert -> Se comprueba si se ha guardado la valoracion correctamente
		Assertions.assertEquals(val, daoEstat.devolverValoraciones().get(0), "La valoracion guardada NO coincide con la introducida");
	}

}
