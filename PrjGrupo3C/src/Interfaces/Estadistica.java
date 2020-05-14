package Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Estadistica {
    public void  calcularOcupacionActual();
    public void  mostrarStatsPlatos();
    public void  mostrarRankingPlatos();
    public void  mostrarDistribucionOcupacion(LocalDate dia);
    public ArrayList<Integer>  mostrarHoraMasFrecuente();
    public void  mostrarTiempoMedioDeComida();
}
