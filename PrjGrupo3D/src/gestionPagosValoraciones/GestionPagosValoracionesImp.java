package gestionPagosValoraciones;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import sensores.Sensor;

public class GestionPagosValoracionesImp implements GestionPagosValoraciones {
	
	private Sensor sensor;
	private GestionDatos gestionDatos;
	
	public GestionPagosValoracionesImp() {
		
	}
	
	
	@Override
	public Factura pagar(Bandeja bandeja) {
		
		
		//LLAMAMOS AL SUBSISTEMA DE SENSORES Y SE ESCANEA LA BANDEJA (NO SE PASA COMO PARAMETRO)
		//NOS DEVUELVE EL ID DE LA BANDEJA Y DEL VALE QUE """"ESCANEAMOS"""""
						//GUARDAMOS LA BANDEJA EN FICHERO
		//CON ESTO GENERAMOS UNA FACTURA
		//SE GUARDA EN EL FICHERO gestionDatos.guardarFactura(     Factura creada    )
		//SE DEVUELVE LA FACTURA
		
		return null;
	}
	

	@Override
	public void valorar(Factura factura, Bandeja bandeja,int valoracionPrimero, int valoracionSegundo, int valoracionPostre) {
		// SE GUARDA LA ESTADISTICA QUE SE GENERA EN EL FICHERO
	}

	@Override
	public void devolverBandeja(Bandeja bandeja) {
		

		//SE GUARDA LA HORA DE DEVOLUCION DE LA BANDEJA
	}

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;

	}

}
