package gestionDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Bandeja;
import modelo.BandejaImp;
import modelo.Estadistica;
import modelo.EstadisticaImp;
import modelo.Factura;
import modelo.FacturaImp;
import modelo.Menu;
import modelo.MenuImp;
import modelo.Plato;
import modelo.PlatoImp;

public class GestionDatosImp implements GestionDatos {

	public GestionDatosImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Plato> getPlatos() {
		ArrayList<Plato> platos = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				platos.add((Plato) new PlatoImp(linea.split("#")[0].trim(), linea.split("#")[1].trim()));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return platos;
	}

	@Override
	public ArrayList<Plato> getPrimeros() {
		ArrayList<Plato> primeros = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.split("#")[1].trim().equals("PRIMERO")) {
					primeros.add((Plato) new PlatoImp(linea.split("#")[0].trim(), "PRIMERO"));
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return primeros;
	}

	@Override
	public ArrayList<Plato> getSegundos() {
		ArrayList<Plato> segundos = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.split("#")[1].trim().equals("SEGUNDO")) {
					segundos.add((Plato) new PlatoImp(linea.split("#")[0].trim(), "SEGUNDO"));
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return segundos;
	}

	@Override
	public ArrayList<Plato> getPostres() {
		ArrayList<Plato> postres = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.split("#")[1].trim().equals("POSTRE")) {
					postres.add((Plato) new PlatoImp(linea.split("#")[0].trim(), "POSTRE"));
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return postres;
	}

	@Override
	public ArrayList<Plato> getBebidas() {
		ArrayList<Plato> bebidas = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.split("#")[1].trim().equals("BEBIDA")) {
					bebidas.add((Plato) new PlatoImp(linea.split("#")[0].trim(), "BEBIDA"));
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return bebidas;
	}

	@Override
	public Plato getPlato(String nombre) {
		Plato plato = null;

		try {
			FileReader fr = new FileReader("Platos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.split("#")[0].trim().equals(nombre)) {
					plato = new PlatoImp(linea.split("#")[0].trim(), linea.split("#")[1].trim());
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return plato;
	}

	@Override
	public ArrayList<Menu> getMenus() {
		ArrayList<Menu> menus = new ArrayList<>();
		ArrayList<Plato> primeros = new ArrayList<>();
		ArrayList<Plato> segundos = new ArrayList<>();
		ArrayList<Plato> postres = new ArrayList<>();
		int dia = -1;
		int id = -1;

		try {
			FileReader fr = new FileReader("Menus.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String[] campos;
			while ((linea = br.readLine()) != null) {
				campos = linea.split("#");
				primeros.clear();
				segundos.clear();
				postres.clear();
				primeros.add((Plato) new PlatoImp(campos[2].trim(), "PRIMERO"));
				primeros.add((Plato) new PlatoImp(campos[3].trim(), "PRIMERO"));
				primeros.add((Plato) new PlatoImp(campos[4].trim(), "PRIMERO"));
				segundos.add((Plato) new PlatoImp(campos[5].trim(), "SEGUNDO"));
				segundos.add((Plato) new PlatoImp(campos[6].trim(), "SEGUNDO"));
				segundos.add((Plato) new PlatoImp(campos[7].trim(), "SEGUNDO"));
				postres.add((Plato) new PlatoImp(campos[8].trim(), "POSTRE"));
				postres.add((Plato) new PlatoImp(campos[9].trim(), "POSTRE"));
				postres.add((Plato) new PlatoImp(campos[10].trim(), "POSTRE"));
				dia = Integer.parseInt(campos[1].trim());
				id = Integer.parseInt(campos[0].trim());
				menus.add((Menu) new MenuImp(primeros, segundos, postres, dia, id));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return menus;
	}

	@Override
	public Menu getMenu(int idMenu) {
		ArrayList<Menu> menus = this.getMenus();
		for (Menu menu : menus) {
			if (menu.getId() == idMenu) {
				return menu;
			}
		}
		return null;
	}

	@Override
	public int guardarMenu(Menu menu) {
		ArrayList<Menu> menus = this.getMenus();
		int idMenu = -1;
		for (Menu menuTemp : menus) {
			if (menuTemp.getId() > idMenu) {
				idMenu = menuTemp.getId();
			}
		}
		idMenu += 1;

		String linea;
		linea = String.valueOf(idMenu);
		linea += " # " + menu.getDia();
		linea += " # " + menu.getPrimeros().get(0).getNombre();
		linea += " # " + menu.getPrimeros().get(1).getNombre();
		linea += " # " + menu.getPrimeros().get(2).getNombre();
		linea += " # " + menu.getSegundos().get(0).getNombre();
		linea += " # " + menu.getSegundos().get(1).getNombre();
		linea += " # " + menu.getSegundos().get(2).getNombre();
		linea += " # " + menu.getPostres().get(0).getNombre();
		linea += " # " + menu.getPostres().get(1).getNombre();
		linea += " # " + menu.getPostres().get(2).getNombre();

		FileWriter fw;
		try {
			fw = new FileWriter(new File("Menus.txt"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(linea);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}

		return idMenu;
	}

	@Override
	public void restablecerDias() {
		String menus = "";
		String auxiliar = null;
		try {
			FileReader fr = new FileReader("Menus.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			boolean leer = ((linea = br.readLine()) != null);
			while (leer) {
				String[] campos = linea.split("#");
				auxiliar = campos[0].trim();
				auxiliar += " # " + "-1";
				auxiliar += " # " + campos[2].trim();
				auxiliar += " # " + campos[3].trim();
				auxiliar += " # " + campos[4].trim();
				auxiliar += " # " + campos[5].trim();
				auxiliar += " # " + campos[6].trim();
				auxiliar += " # " + campos[7].trim();
				auxiliar += " # " + campos[8].trim();
				auxiliar += " # " + campos[9].trim();
				auxiliar += " # " + campos[10].trim();
				if (leer = ((linea = br.readLine()) != null)) {
					menus += auxiliar + "\n";
				} else {
					menus += auxiliar;
				}
			}
			br.close();
			fr.close();

			FileWriter fw = new FileWriter(new File("Menus.txt"), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(menus, 0, menus.length());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void asociarMenuDia(int idMenu, int diaSemana) {
		String menus = "";
		String auxiliar = null;
		try {
			FileReader fr = new FileReader("Menus.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			boolean leer = ((linea = br.readLine()) != null);
			while (leer) {
				if (linea.split("#")[0].trim().equals(String.valueOf(idMenu))) {
					String[] campos = linea.split("#");
					auxiliar = campos[0].trim();
					auxiliar += " # " + diaSemana;
					auxiliar += " # " + campos[2].trim();
					auxiliar += " # " + campos[3].trim();
					auxiliar += " # " + campos[4].trim();
					auxiliar += " # " + campos[5].trim();
					auxiliar += " # " + campos[6].trim();
					auxiliar += " # " + campos[7].trim();
					auxiliar += " # " + campos[8].trim();
					auxiliar += " # " + campos[9].trim();
					auxiliar += " # " + campos[10].trim();
				} else {
					auxiliar = linea;
				}
				if (leer = ((linea = br.readLine()) != null)) {
					menus += auxiliar + "\n";
				} else {
					menus += auxiliar;
				}
			}
			br.close();
			fr.close();

			FileWriter fw = new FileWriter(new File("Menus.txt"), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(menus, 0, menus.length());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura> facturas = new ArrayList<>();
		int idFactura;
		int idMenu;
		String dia;
		int idVale;

		try {
			FileReader fr = new FileReader("Facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String[] campos;
			while ((linea = br.readLine()) != null) {
				campos = linea.split("#");
				idFactura = Integer.parseInt(campos[0].trim());
				idMenu = Integer.parseInt(campos[1].trim());
				dia = campos[2].trim();
				idVale = Integer.parseInt(campos[3].trim());
				facturas.add((Factura) new FacturaImp(idFactura, dia, idVale, idMenu));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return facturas;
	}

	@Override
	public void guardarFactura(Factura factura) {
		ArrayList<Factura> facturas = this.getFacturas();
		int idFactura = -1;
		for (Factura facturaTemp : facturas) {
			if (facturaTemp.getId() > idFactura) {
				idFactura = facturaTemp.getId();
			}
		}
		idFactura += 1;
		factura.setId(idFactura);

		String linea;
		linea = String.valueOf(factura.getId());
		linea += " # " + factura.getIdMenu();
		linea += " # " + factura.getDia();
		linea += " # " + factura.getIdVale();

		FileWriter fw;
		try {
			fw = new FileWriter(new File("Facturas.txt"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(linea);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	@Override
	public ArrayList<Estadistica> getEstadisticas() {
		ArrayList<Estadistica> estadisticas = new ArrayList<>();
		int idFactura;
		int valoracionPrimero;
		int valoracionSegundo;
		int valoracionPostre;
		String horaAsignacion;
		String horaDevolucion;
		Bandeja bandeja;

		try {
			FileReader fr = new FileReader("BaseEstadistica.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			String[] campos;
			while ((linea = br.readLine()) != null) {
				campos = linea.split("#");
				idFactura = Integer.parseInt(campos[0].trim());
				valoracionPrimero = Integer.parseInt(campos[1].trim());
				valoracionSegundo = Integer.parseInt(campos[2].trim());
				valoracionPostre = Integer.parseInt(campos[3].trim());
				horaAsignacion = campos[4].trim();
				horaDevolucion = campos[5].trim();
				bandeja = new BandejaImp(Integer.parseInt(campos[6].trim()),
						(Plato) new PlatoImp(campos[7].trim(), "PRIMERO"),
						(Plato) new PlatoImp(campos[8].trim(), "PRIMERO"),
						(Plato) new PlatoImp(campos[9].trim(), "PRIMERO"),
						(Plato) new PlatoImp(campos[10].trim(), "PRIMERO"));

				estadisticas.add((Estadistica) new EstadisticaImp(idFactura, valoracionPrimero, valoracionSegundo,
						valoracionPostre, horaAsignacion, horaDevolucion, bandeja));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println(e);
		}

		return estadisticas;
	}

	@Override
	public void guardarComida(Bandeja bandeja, int idFactura) {
		String linea;

		linea = String.valueOf(idFactura);
		linea += " # -1";
		linea += " # -1";
		linea += " # -1";
		linea += " # " + java.time.LocalTime.now().getHour() + ":" + java.time.LocalTime.now().getMinute();
		linea += " # -1";
		linea += " # " + String.valueOf(bandeja.getId());
		linea += " # " + bandeja.getPrimero().getNombre();
		linea += " # " + bandeja.getSegundo().getNombre();
		linea += " # " + bandeja.getPostre().getNombre();
		linea += " # " + bandeja.getBebida().getNombre();

		FileWriter fw;
		try {
			fw = new FileWriter(new File("BaseEstadistica.txt"), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(linea);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	@Override
	public void devolverBandeja(int idBandeja) {
		String baseEstadistica = "";
		String auxiliar = null;
		try {
			FileReader fr = new FileReader("BaseEstadistica.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			boolean leer = ((linea = br.readLine()) != null);
			while (leer) {
				if (linea.split("#")[6].trim().equals(String.valueOf(idBandeja))
						&& linea.split("#")[5].trim().equals("-1")) {
					String[] campos = linea.split("#");
					auxiliar = campos[0].trim();
					auxiliar += " # " + campos[1].trim();
					auxiliar += " # " + campos[2].trim();
					auxiliar += " # " + campos[3].trim();
					auxiliar += " # " + campos[4].trim();
					auxiliar += " # " + java.time.LocalTime.now().getHour() + ":" + java.time.LocalTime.now().getMinute();
					auxiliar += " # " + campos[6].trim();
					auxiliar += " # " + campos[7].trim();
					auxiliar += " # " + campos[8].trim();
					auxiliar += " # " + campos[9].trim();
					auxiliar += " # " + campos[10].trim();
				} else {
					auxiliar = linea;
				}
				if (leer = ((linea = br.readLine()) != null)) {
					baseEstadistica += auxiliar + "\n";
				} else {
					baseEstadistica += auxiliar;
				}
			}
			br.close();
			fr.close();

			FileWriter fw = new FileWriter(new File("BaseEstadistica.txt"), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(baseEstadistica, 0, baseEstadistica.length());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void valorar(int idFactura, int valoracionPrimero, int valoracionSegundo, int valoracionPostre) {
		String baseEstadistica = "";
		String auxiliar = null;
		try {
			FileReader fr = new FileReader("BaseEstadistica.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			boolean leer = ((linea = br.readLine()) != null);
			while (leer) {
				if (linea.split("#")[0].trim().equals(String.valueOf(idFactura))) {
					String[] campos = linea.split("#");
					auxiliar = campos[0].trim();
					auxiliar += " # " + valoracionPrimero;
					auxiliar += " # " + valoracionSegundo;
					auxiliar += " # " + valoracionPostre;
					auxiliar += " # " + campos[4].trim();
					auxiliar += " # " + campos[5].trim();
					auxiliar += " # " + campos[6].trim();
					auxiliar += " # " + campos[7].trim();
					auxiliar += " # " + campos[8].trim();
					auxiliar += " # " + campos[9].trim();
					auxiliar += " # " + campos[10].trim();
				} else {
					auxiliar = linea;
				}
				if (leer = ((linea = br.readLine()) != null)) {
					baseEstadistica += auxiliar + "\n";
				} else {
					baseEstadistica += auxiliar;
				}
			}
			br.close();
			fr.close();

			FileWriter fw = new FileWriter(new File("BaseEstadistica.txt"), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(baseEstadistica, 0, baseEstadistica.length());
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
