package modelo;

public class BandejaImp implements Bandeja {

	private int id;
	private Plato primero;
	private Plato segundo;
	private Plato postre;
	private Plato bebida;

	public BandejaImp(Plato primero, Plato segundo, Plato postre, Plato bebida) {
		this.id = -1;
		this.primero = primero;
		this.segundo = segundo;
		this.postre = postre;
		this.bebida = bebida;
	}

	public BandejaImp(int id, Plato primero, Plato segundo, Plato postre, Plato bebida) {
		this.id = id;
		this.primero = primero;
		this.segundo = segundo;
		this.postre = postre;
		this.bebida = bebida;
	}

	public int getId() {
		return id;
	}

	public void setId(int idBandeja) {
		this.id = idBandeja;
	}

	public Plato getPrimero() {
		return primero;
	}

	public void setPrimero(Plato primero) {
		this.primero = primero;
	}

	public Plato getSegundo() {
		return segundo;
	}

	public void setSegundo(Plato segundo) {
		this.segundo = segundo;
	}

	public Plato getPostre() {
		return postre;
	}

	public void setPostre(Plato postre) {
		this.postre = postre;
	}

	public Plato getBebida() {
		return bebida;
	}

	public void setBebida(Plato bebida) {
		this.bebida = bebida;
	}

}
