package horamasfrecuente;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Implementacion.DAOEstadisticaImp;
import Implementacion.DAOMenuImp;
import Implementacion.EstadisticaImp;
import Implementacion.MenuImp;
import Implementacion.Plato;
import Interfaces.Estadistica;

//Responsable: Brais Rodriguez Suarez

class MostrarHoraMasFrecuente {

	private Estadistica estadistica;
	
	@BeforeAll
	static void preparacionClase() throws IOException {
		//Se comprueba si existe el fichero
		File archivo = new File("Estadisticas.txt");

		if (archivo.createNewFile()) {
		    System.out.println("Se ha creado el archivo Estadisticas.txt");
		} 
		else {
		    System.out.println("El archivo Estadisticas.txt ya existe");
		}
	}
	
	@BeforeEach
	void preparacionCasoPrueba(){
		//Se crea un nuevo objeto DAOEstadisticas antes de ejecutar un nuevo caso de prueba
		estadistica = new EstadisticaImp();
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", false));
			out.write("");
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	@DisplayName("Mostrar hora mas frecuente P_01 CP_01")
	void UC_0019_P_01_CP_01() {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", false));
			out.write("");
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		ArrayList<Integer> resultadoEsperado = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
						
		//Act
		ArrayList<Integer> resultado = estadistica.mostrarHoraMasFrecuente();
				
		//Assert
		assertAll(
				() -> assertEquals(resultadoEsperado.size(), resultado.size(), "El numero de dias calculado es incorrecto."),
				() -> assertEquals(resultadoEsperado, resultado, "Las horas mas frecuentes no son correctas.")
		);
		
	}
	
	@Test
	@DisplayName("Mostrar hora mas frecuente P_01 CP_02")
	void UC_0019_P_01_CP_02() {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", false));
			out.write("cogida\n");
			out.write("CodigoBandeja: 605\n");
			out.write("TiempoCogida: 2020-05-04T00:00:00.000\n");
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		ArrayList<Integer> resultadoEsperado = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
						
		//Act
		ArrayList<Integer> resultado = estadistica.mostrarHoraMasFrecuente();
				
		//Assert
		assertAll(
				() -> assertEquals(resultadoEsperado.size(), resultado.size(), "El numero de dias calculado es incorrecto."),
				() -> assertEquals(resultadoEsperado, resultado, "Las horas mas frecuentes no son correctas.")
		);
		
	}
	
	@Test
	@DisplayName("Mostrar hora mas frecuente P_01 CP_03")
	void UC_0019_P_01_CP_03() {
		//Arrange
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", false));
			out.write("cogida\n");
			out.write("CodigoBandeja: 605\n");
			out.write("TiempoCogida: 2020-05-04T14:10:04.451\n");
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		ArrayList<Integer> resultadoEsperado = new ArrayList<>(Arrays.asList(14, 0, 0, 0, 0, 0, 0));
						
		//Act
		ArrayList<Integer> resultado = estadistica.mostrarHoraMasFrecuente();
				
		//Assert
		assertAll(
				() -> assertEquals(resultadoEsperado.size(), resultado.size(), "El numero de dias calculado es incorrecto."),
				() -> assertEquals(resultadoEsperado, resultado, "Las horas mas frecuentes no son correctas.")
		);
		
	}

}
