
package gestionPagosValoraciones;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import sensores.Sensor;

public interface GestionPagosValoraciones {

	public Factura pagar( Bandeja bandeja, int idMenu );

	public void valorar( int idFactura, int valoracionPrimero, int valoracionSegundo, int valoracionPostre );

	public void devolverBandeja( int idBandeja );

	public void setGestionDatos( GestionDatos gestionDatos );

	public void setSensor( Sensor sensor );

}
