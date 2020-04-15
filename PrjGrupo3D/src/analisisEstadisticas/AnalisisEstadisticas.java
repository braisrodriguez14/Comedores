package analisisEstadisticas;

import gestionDatos.GestionDatos;
import modelo.Plato;

public interface AnalisisEstadisticas {
	
	public void setGestionDatos(GestionDatos gestionDatos);
	
	public int ocupacionActual();
	
	public Plato platoMasSelecionado();
	
	public Plato platoMenosSelecionado();
	
	public Plato platoMejorValorado();
	
	public Plato platoPeorValorado();
	
	public String ocupacionDiaSemana(String dia);
	
	public String horaMasFrecuente();
	
	public String duracionMediaComida();
	
	public String rankingPlatos();


}
