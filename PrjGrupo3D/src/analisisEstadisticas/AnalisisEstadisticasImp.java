package analisisEstadisticas;

import java.util.ArrayList;

import gestionDatos.GestionDatos;
import modelo.Bandeja;
import modelo.Estadistica;
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
		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();
		int ocupacion = 0;
		for (Estadistica estadistica : estadisticas) {
			if (estadistica.getHoraDevolucion().equals("-1")) {
				ocupacion += 1;
			}
		}
		return ocupacion;
	}

	@Override
	public Plato platoMasSelecionado() {
		Plato plato = null;

		ArrayList<Plato> platos = gestionDatos.getPlatos();
		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		int[] cantidades = new int[platos.size()];
		int cantidadMaxima = -1;

		plato = platos.get(0);
		for (int i = 0; i < platos.size(); i++) {
			cantidades[i] = 0;
			for (Estadistica estadistica : estadisticas) {
				if (estadistica.getBandeja().getPrimero().getNombre().equals(platos.get(i).getNombre())
						|| estadistica.getBandeja().getSegundo().getNombre().equals(platos.get(i).getNombre())) {
					cantidades[i] += 1;
				}
			}
			if (cantidades[i] > cantidadMaxima) {
				cantidadMaxima = cantidades[i];
				plato = platos.get(i);
			}
		}

		return plato;
	}

	@Override
	public Plato platoMenosSelecionado() {
		Plato plato = null;

		ArrayList<Plato> platos = gestionDatos.getPlatos();
		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		int[] cantidades = new int[platos.size()];
		int cantidadMinima = Integer.MAX_VALUE;

		plato = platos.get(0);
		for (int i = 0; i < platos.size(); i++) {
			cantidades[i] = 0;
			for (Estadistica estadistica : estadisticas) {
				if (estadistica.getBandeja().getPrimero().getNombre().equals(platos.get(i).getNombre())
						|| estadistica.getBandeja().getSegundo().getNombre().equals(platos.get(i).getNombre())) {
					cantidades[i] += 1;
				}
			}
			if (cantidades[i] < cantidadMinima) {
				cantidadMinima = cantidades[i];
				plato = platos.get(i);
			}
		}

		return plato;
	}

	@Override
	public Plato platoMejorValorado() {
		Plato plato = null;

		ArrayList<Plato> platos = gestionDatos.getPlatos();
		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		double[] valoraciones = new double[platos.size()];
		int[] cantidades = new int[platos.size()];
		double valoracionMaxima = -1.0;

		plato = platos.get(0);
		for (int i = 0; i < platos.size(); i++) {
			valoraciones[i] = 0;
			cantidades[i] = 0;
			for (Estadistica estadistica : estadisticas) {
				if (platos.get(i).getTipo().equals("PRIMERO")
						&& estadistica.getBandeja().getPrimero().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionPrimero();
					cantidades[i] += 1;
				} else if (platos.get(i).getTipo().equals("SEGUNDO")
						&& estadistica.getBandeja().getSegundo().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionSegundo();
					cantidades[i] += 1;
				}
			}

			if ((cantidades[i] != 0) && (valoraciones[i] / cantidades[i] > valoracionMaxima)) {
				valoracionMaxima = valoraciones[i] / cantidades[i];
				plato = platos.get(i);
			}
		}

		return plato;
	}

	@Override
	public Plato platoPeorValorado() {
		Plato plato = null;

		ArrayList<Plato> platos = gestionDatos.getPlatos();
		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		double[] valoraciones = new double[platos.size()];
		int[] cantidades = new int[platos.size()];
		double valoracionMinima = 5.1;

		plato = platos.get(0);
		for (int i = 0; i < platos.size(); i++) {
			valoraciones[i] = 0;
			cantidades[i] = 0;
			for (Estadistica estadistica : estadisticas) {
				if (platos.get(i).getTipo().equals("PRIMERO")
						&& estadistica.getBandeja().getPrimero().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionPrimero();
					cantidades[i] += 1;
				} else if (platos.get(i).getTipo().equals("SEGUNDO")
						&& estadistica.getBandeja().getSegundo().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionSegundo();
					cantidades[i] += 1;
				}
			}

			if ((cantidades[i] != 0) && (valoraciones[i] / cantidades[i] < valoracionMinima)) {
				valoracionMinima = valoraciones[i] / cantidades[i];
				plato = platos.get(i);
			}
		}

		return plato;
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

		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		int comidas = 0;
		int minutos = 0;
		int horasAsignacion;
		int minutosAsignacion;
		int horasDevolucion;
		int minutosDevolucion;

		for (Estadistica estadistica : estadisticas) {
			if (!estadistica.getHoraDevolucion().equals("-1")) {
				horasAsignacion = Integer.valueOf(estadistica.getHoraAsignacion().split(":")[0]);
				minutosAsignacion = Integer.valueOf(estadistica.getHoraAsignacion().split(":")[1]);
				horasDevolucion = Integer.valueOf(estadistica.getHoraDevolucion().split(":")[0]);
				minutosDevolucion = Integer.valueOf(estadistica.getHoraDevolucion().split(":")[1]);
				minutos += (horasDevolucion * 60 + minutosDevolucion) - (horasAsignacion * 60 + minutosAsignacion);
				comidas += 1;
			}
		}

		int m = minutos / comidas;
		int s = (int) (60.0 * (((double) (minutos % comidas)) / comidas));

		return "Duracion Media Comida: \n\t" + m + " minutos y " + s + " segundos";
	}

	@Override
	public String rankingPlatos() {
		String ranking = "Ranking Platos:";

		ArrayList<Plato> platos = gestionDatos.getPlatos();
		Plato plato;

		for (int i = 0; i < 5; i++) {
			plato = platoMejorValoradoPrivate(platos);
			platos.remove(plato);
			ranking += "\n\t" + (i + 1) + ": " + plato.getNombre();
		}

		return ranking;
	}

	private Plato platoMejorValoradoPrivate(ArrayList<Plato> platos) {
		Plato plato = null;

		ArrayList<Estadistica> estadisticas = gestionDatos.getEstadisticas();

		double[] valoraciones = new double[platos.size()];
		int[] cantidades = new int[platos.size()];
		double valoracionMaxima = -1.0;

		plato = platos.get(0);
		for (int i = 0; i < platos.size(); i++) {
			valoraciones[i] = 0;
			cantidades[i] = 0;
			for (Estadistica estadistica : estadisticas) {
				if (platos.get(i).getTipo().equals("PRIMERO")
						&& estadistica.getBandeja().getPrimero().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionPrimero();
					cantidades[i] += 1;
				} else if (platos.get(i).getTipo().equals("SEGUNDO")
						&& estadistica.getBandeja().getSegundo().getNombre().equals(platos.get(i).getNombre())) {
					valoraciones[i] += (double) estadistica.getValoracionSegundo();
					cantidades[i] += 1;
				}
			}

			if ((cantidades[i] != 0) && (valoraciones[i] / cantidades[i] > valoracionMaxima)) {
				valoracionMaxima = valoraciones[i] / cantidades[i];
				plato = platos.get(i);
			}
		}

		return plato;
	}

}
