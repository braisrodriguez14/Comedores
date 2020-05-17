package guardardatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Implementacion.DAOMenuImp;
import Implementacion.MenuImp;
import Implementacion.Plato;
import Interfaces.DAOMenu;
import Interfaces.Menu;

//Responsable: Brais Rodriguez Suarez

class GuardarMenu {

	private DAOMenu daoMenu;
	
	@BeforeAll
	static void preparacionClase() throws IOException {
		//Se comprueba si existe el fichero
		File archivo = new File("Menus.txt");

		if (archivo.createNewFile()) {
		    System.out.println("Se ha creado el archivo Menus.txt");
		} 
		else {
		    System.out.println("El archivo Menus.txt ya existe");
		}
	}
	
	@BeforeEach
	void preparacionCasoPrueba(){
		//Se crea un nuevo objeto DAOMenu antes de ejecutar un nuevo caso de prueba
		daoMenu = new DAOMenuImp();
		
		//Se elimina el contenido del fichero Estadisticas.txt
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("Menus.txt", false));
			out.write("");
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Test
	@DisplayName("Guardar menu P_01 CP_01")
	void UC_0022_P_01_CP_01() {
		//Arrange
		Menu menu = null;
						
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert
		assertEquals(0, archivo.length(), "Se ha guardado un menu no valido.");
		
		/*
		 * Se comprueba que el menu no se haya guardado en el archivo ya que no es un menu valido
		 */
	}
	
	@Test
	@DisplayName("Guardar menu P_01 CP_02")
	void UC_0022_P_01_CP_02() {
		//Arrange
		Menu menu = new MenuImp();
		
		for(int i = 0; i < 3; i ++) {
			menu.anhadirEntrante(new Plato());
			menu.anhadirPrincipal(new Plato());
			menu.anhadirPostre(new Plato());
		}
		
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert
		assertEquals(0, archivo.length(), "Se ha guardado un menu no valido.");
		
		/*
		 * Se comprueba que el menu no se haya guardado en el archivo ya que no es un menu valido
		 */
	}
	
	@Test
	@DisplayName("Guardar menu P_01 CP_03")
	void UC_0022_P_01_CP_03() {
		//Arrange
		Menu menu = new MenuImp();
		menu.setFecha(LocalDate.now());
		
		for(int i = 0; i < 3; i ++) {
			menu.anhadirPrincipal(new Plato());
			menu.anhadirPostre(new Plato());
		}
		
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert
		assertEquals(0, archivo.length(), "Se ha guardado un menu no valido.");
		
		/*
		 * Se comprueba que el menu no se haya guardado en el archivo ya que no es un menu valido
		 */
	}
	
	@Test
	@DisplayName("Guardar menu P_01 CP_04")
	void UC_0022_P_01_CP_04() {
		//Arrange
		Menu menu = new MenuImp();
		menu.setFecha(LocalDate.now());
		
		for(int i = 0; i < 3; i ++) {
			menu.anhadirEntrante(new Plato());
			menu.anhadirPostre(new Plato());
		}
		
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert
		assertEquals(0, archivo.length(), "Se ha guardado un menu no valido.");
		
		/*
		 * Se comprueba que el menu no se haya guardado en el archivo ya que no es un menu valido
		 */
	}
	
	@Test
	@DisplayName("Guardar menu P_01 CP_05")
	void UC_0022_P_01_CP_05() {
		//Arrange
		Menu menu = new MenuImp();
		menu.setFecha(LocalDate.now());
		
		for(int i = 0; i < 3; i ++) {
			menu.anhadirEntrante(new Plato());
			menu.anhadirPrincipal(new Plato());
		}
		
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert
		assertEquals(0, archivo.length(), "Se ha guardado un menu no valido.");
		
		/*
		 * Se comprueba que el menu no se haya guardado en el archivo ya que no es un menu valido
		 */
	}
	
	@Test
	@DisplayName("Guardar menu P_01 CP_06")
	void UC_0022_P_01_CP_06() {
		//Arrange
		Menu menu = new MenuImp();
		menu.setFecha(LocalDate.now());
		
		for(int i = 0; i < 3; i ++) {
			menu.anhadirEntrante(new Plato("Ensalada", 50, "Entrante"));
			menu.anhadirPrincipal(new Plato("Macarrones", 150, "Principal"));
			menu.anhadirPostre(new Plato("Natillas", 100, "Postre"));
		}
		
		//Act
		daoMenu.guardarMenu(menu);
		Menu menuGuardado = daoMenu.devolverMenus().get(0);
		
		//Assert
		assertAll(
				() -> assertNotNull(menuGuardado.getFecha(), "La fecha del menu guardado es incorrecta"),
				() -> assertEquals(3, menuGuardado.getEntrantes().size(), "El numero de entrantes es incorrecto"),
				() -> assertEquals(3, menuGuardado.getPrincipales().size(), "El numero de platos principales es incorrecto"),
				() -> assertEquals(3, menuGuardado.getPostres().size(), "El numero de postres es incorrecto")
		);
		
		/*
		 * Se comprueba que el menu se ha guardado correctamente en el archivo
		 */
	}

}
