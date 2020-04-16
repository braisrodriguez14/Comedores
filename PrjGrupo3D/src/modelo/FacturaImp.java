package modelo;

public class FacturaImp implements Factura {
	
	private int id;
	private Estadistica estadistica;
	private String dia;
	private int idVale;
	private int idFactura;
	private int idMenu;
	
	
	public FacturaImp(Estadistica estadistica, String dia, int idVale, int idFactura, int idMenu) {
		this.id = -777;
		this.estadistica = estadistica;
		this.dia = dia;
		this.idVale = idVale;
		this.idFactura = idFactura;
		this.idMenu = idMenu;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Estadistica getEstadistica() {
		return estadistica;
	}


	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public int getIdVale() {
		return idVale;
	}


	public void setIdVale(int idVale) {
		this.idVale = idVale;
	}


	public int getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}


	public int getIdMenu() {
		return idMenu;
	}


	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
	
	
	
	
	
	

}
