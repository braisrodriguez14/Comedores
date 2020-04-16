package modelo;

public interface Factura {
	
	public int getId();
	
	public Estadistica getEstadistica();
	
	public String getDia();
	
	public int getIdVale();
	
	public void setId(int idFactura);
	
	public void setIdMenu(int idMenu);
	
	public void setEstadistica(Estadistica estadistica);
	
	public void setDia(String dia);
	
	public void setIdVale(int idVale);


}
