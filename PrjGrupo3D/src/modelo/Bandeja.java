package modelo;

public interface Bandeja {

	public int getIdBandeja();
	
	public Plato getPrimero();
	
	public Plato getSegundo();
	
	public Plato getPostre();
	
	public Plato getBebida();
	
	public void setIdBandeja(int idBandeja);
	
	public void setPrimero(Plato primero);
	
	public void setSegundo(Plato segundo);
	
	public void setPostre(Plato postre);
	
	public void setBebida(Plato bebida);

}
