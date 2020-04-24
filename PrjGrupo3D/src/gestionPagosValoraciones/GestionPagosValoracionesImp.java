
package gestionPagosValoraciones;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
import modelo.Factura;
import modelo.FacturaImp;
import sensores.Sensor;

public class GestionPagosValoracionesImp implements GestionPagosValoraciones {

	private Sensor sensor;
	private GestionDatos gestionDatos;

	public GestionPagosValoracionesImp( ) {
	}

	@Override
	public Factura pagar( Bandeja bandeja, int idMenu ) {
		if( gestionDatos != null && sensor != null ) {

			// Escaneamos la bandeja desde el subsitema sensores
			int idBandeja = sensor.leerIdBandeja( );
			// Establecemos el id de la bandeja leido
			bandeja.setId( idBandeja );

			// Escaneamos el vale desde el subsitema sensores
			int idVale = sensor.leerIdVale( );

			// Creamos la factura
			Factura factura = new FacturaImp( idVale, idMenu );

			// Guardamos la factura (Se le establece un id al ser guardada en archivo)
			gestionDatos.guardarFactura( factura );
			// Guardamos los datos de la comida en la Base Estadistica (datos bandeja, hora
			// de asignacion y la factura asociada)
			gestionDatos.guardarComida( bandeja, factura.getId( ) );

			return factura;
		}
		else {
			return null;
		}
	}

	@Override
	public void valorar( int idFactura, int valoracionPrimero, int valoracionSegundo, int valoracionPostre ) {
		if( gestionDatos != null ) {
			gestionDatos.valorar( idFactura, valoracionPrimero, valoracionSegundo, valoracionPostre );
		}
	}

	@Override
	public void devolverBandeja( int idBandeja ) {
		if( gestionDatos != null ) {
			gestionDatos.devolverBandeja( idBandeja );
		}
	}

	@Override
	public void setGestionDatos( GestionDatos gestionDatos ) {
		this.gestionDatos = gestionDatos;
	}

	@Override
	public void setSensor( Sensor sensor ) {
		this.sensor = sensor;
	}

}
