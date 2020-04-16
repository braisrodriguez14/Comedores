package modelo;

public interface Estadistica {
	
	public int getId();
	
	public int getIdFactura();
	
	public int getValoracionPrimero();
	
	public int getValoracionSegundo();
	
	public int getValoracionPostre();
	
	public String getHoraAsignacion();
	
	public String getHoraDevolucion();
	
	public Bandeja getBandeja();
	
	public void setId(int idEstadistica);
	
	public void setIdFactura(int idFactura);	
	
	public void setValoracionPrimero(int valoracionPrimero);
	
	public void setValoracionSegundo(int valoracionSegundo);
	
	public void setValoracionPostre(int valoracionPostre);
	
	public void setHoraAsignacion(String horaAsignacion);
	
	public void setHoraDevolucion(String horaDevolucion);
	
	public void setBandeja(Bandeja bandeja);


}
