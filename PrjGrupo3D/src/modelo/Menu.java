package modelo;

import java.util.ArrayList;

public interface Menu {
	
	public ArrayList<Plato> getPrimeros();
	
	public ArrayList<Plato> getSegundos();
	
	public ArrayList<Plato> getPostres();
	
	public String getDia();
	
	public void setDia(String dia);
	
	public void setPrimeros(ArrayList<Plato> primeros);
	
	public void setSegundos(ArrayList<Plato> segundos);
	
	public void setPostres(ArrayList<Plato> postres);


}
