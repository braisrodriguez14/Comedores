package modelo;

public class EstadisticaImp implements Estadistica {

	
	private int id;
	private int idFactura;
	private int valoracionPrimero;
	private int valoracionSegundo;
	private int valoracionPostre;
	private String horaAsignacion;
	private String horaDevolucion;
	private Bandeja bandeja;
	
	public EstadisticaImp(int idEstadistica, int idFactura, int valoracionPrimero, int valoracionSegundo,
			int valoracionPostre, String horaAsignacion, String horaDevolucion, Bandeja bandeja) {

		this.id = idEstadistica;
		this.idFactura = idFactura;
		this.valoracionPrimero = valoracionPrimero;
		this.valoracionSegundo = valoracionSegundo;
		this.valoracionPostre = valoracionPostre;
		this.horaAsignacion = horaAsignacion;
		this.horaDevolucion = horaDevolucion;
		this.bandeja = bandeja;
	}

	public int getId() {
		return id;
	}

	public void setId(int idEstadistica) {
		this.id = idEstadistica;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getValoracionPrimero() {
		return valoracionPrimero;
	}

	public void setValoracionPrimero(int valoracionPrimero) {
		this.valoracionPrimero = valoracionPrimero;
	}

	public int getValoracionSegundo() {
		return valoracionSegundo;
	}

	public void setValoracionSegundo(int valoracionSegundo) {
		this.valoracionSegundo = valoracionSegundo;
	}

	public int getValoracionPostre() {
		return valoracionPostre;
	}

	public void setValoracionPostre(int valoracionPostre) {
		this.valoracionPostre = valoracionPostre;
	}

	public String getHoraAsignacion() {
		return horaAsignacion;
	}

	public void setHoraAsignacion(String horaAsignacion) {
		this.horaAsignacion = horaAsignacion;
	}

	public String getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(String horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}

	public Bandeja getBandeja() {
		return bandeja;
	}

	public void setBandeja(Bandeja bandeja) {
		this.bandeja = bandeja;
	}
	
	
	
	

}
