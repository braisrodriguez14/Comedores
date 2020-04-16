package analisisEstadisticas;

import gestionDatos.GestionDatos;
import modelo.Plato;

public class AnalisisEstadisticasImp implements AnalisisEstadisticas {

	private GestionDatos gestionDatos;

	public AnalisisEstadisticasImp() {

	}

	@Override
	public void setGestionDatos(GestionDatos gestionDatos) {
		this.gestionDatos = gestionDatos;

	}

	@Override
	public int ocupacionActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Plato platoMasSelecionado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plato platoMenosSelecionado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plato platoMejorValorado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plato platoPeorValorado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ocupacionDiaSemana(int dia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String horaMasFrecuente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String duracionMediaComida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rankingPlatos() {
		// TODO Auto-generated method stub
		return null;
	}

}
