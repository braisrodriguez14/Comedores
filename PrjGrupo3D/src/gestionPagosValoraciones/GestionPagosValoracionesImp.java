package gestionPagosValoraciones;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import sensores.Sensor;

public class GestionPagosValoracionesImp implements GestionPagosValoraciones {

	
	public GestionPagosValoracionesImp() {
		
	}
	
	
	@Override
	public Factura pagar(Bandeja bandeja) {
		
		
		//LLAMAMOS AL SUBSISTEMA DE SENSORES Y SE ESCANEA LA BANDEJA (NO SE PASA COMO PARAMETRO)
		//NOS DEVUELVE EL ID DE LA BANDEJA Y DEL VALE QUE """"ESCANEAMOS"""""
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
	public void devolverBandeja() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSensor(Sensor sensor) {
		// TODO Auto-generated method stub

	}

}
