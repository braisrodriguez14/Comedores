
package modelo;

public class EstadisticaImp implements Estadistica {

	private int idFactura;
	private int valoracionPrimero;
	private int valoracionSegundo;
	private int valoracionPostre;
	private String horaAsignacion;
	private String horaDevolucion;
	private Bandeja bandeja;

	public EstadisticaImp( int idFactura, int valoracionPrimero, int valoracionSegundo, int valoracionPostre,
			String horaAsignacion, String horaDevolucion, Bandeja bandeja ) {

		this.idFactura = idFactura;
		this.valoracionPrimero = valoracionPrimero;
		this.valoracionSegundo = valoracionSegundo;
		this.valoracionPostre = valoracionPostre;
		this.horaAsignacion = horaAsignacion;
		this.horaDevolucion = horaDevolucion;
		this.bandeja = bandeja;
	}

	public int getIdFactura( ) {
		return idFactura;
	}

	public int getValoracionPrimero( ) {
		return valoracionPrimero;
	}

	public int getValoracionSegundo( ) {
		return valoracionSegundo;
	}

	public int getValoracionPostre( ) {
		return valoracionPostre;
	}

	public String getHoraAsignacion( ) {
		return horaAsignacion;
	}

	public String getHoraDevolucion( ) {
		return horaDevolucion;
	}

	public Bandeja getBandeja( ) {
		return bandeja;
	}

}
