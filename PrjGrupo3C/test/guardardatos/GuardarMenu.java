package guardardatos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Implementacion.DAOMenuImp;
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
	@DisplayName("UC_0022_P_01_CP_01")
	void UC_0022_P_01_CP_01() {
		//Arrange
		Menu menu = null;
						
		//Act
		daoMenu.guardarMenu(menu);
		
		File archivo = new File("Menus.txt");
				
		//Assert 1 -> Se comprueba que el menu no se haya guardado en el archivo
		assertEquals(0, archivo.length());
	}

}
