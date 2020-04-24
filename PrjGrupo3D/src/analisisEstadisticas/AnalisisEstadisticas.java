
package analisisEstadisticas;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Plato;

public interface AnalisisEstadisticas {

	public void setGestionDatos( GestionDatos gestionDatos );

	public int ocupacionActual( );

	// Devuelve el primer plato mas seleccionado
	public Plato platoMasSelecionado( );

	// Devuelve el primer plato menos seleccionado
	public Plato platoMenosSelecionado( );

	// Devuelve el primer plato mejor valorado
	public Plato platoMejorValorado( );

	// Devuelve el primer plato peor valorado
	public Plato platoPeorValorado( );

	// Devuelve el tanto por uno de la ocupacion del comedor de un dia de la semana (1-5)
	public float ocupacionDiaSemana( int dia );

	// Devuelve la hora del dia mas frecuente a la que empiezan las comidas (0-23)
	public int horaMasFrecuente( );

	// Devuelve la duracin media de las comidas en minutos
	public float duracionMediaComida( );

	// Devuelve un ArrayList de tamanho 5 con los platos mejor valorados (0 -> mejor valorado) 
	public ArrayList<Plato> rankingPlatos( );

}
