package modelo;

public class FacturaImp implements Factura {

	private int id;
	private String dia;
	private int idVale;
	private int idMenu;

	public FacturaImp(int idVale, int idMenu) {
		this.id = -1;
		this.dia = java.time.LocalDate.now().toString();
		this.idVale = idVale;
		this.idMenu = idMenu;
	}
	
	

	public FacturaImp(int id, String dia, int idVale, int idMenu) {
		this.id = id;
		this.dia = dia;
		this.idVale = idVale;
		this.idMenu = idMenu;
	}



	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getDia() {
		return dia;
	}

	public int getIdVale() {
		return idVale;
	}

	public int getIdMenu() {
		return idMenu;
	}

}
