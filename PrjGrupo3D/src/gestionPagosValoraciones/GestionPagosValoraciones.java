package gestionPagosValoraciones;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import sensores.Sensor;

public interface GestionPagosValoraciones {
	
	public Factura pagar(Bandeja bandeja);
	
	public void valorar(Factura factura, Bandeja bandeja,int valoracionPrimero, int valoracionSegundo, int valoracionPostre);
	
	public void devolverBandeja();
	
	public void setGestionDatos(GestionDatos gestionDatos);
	
	public void setSensor(Sensor sensor);


}
