package Interfaces;

import java.time.LocalDate;

public interface Estadistica {
    public void  calcularOcupacionActual();
    public void  mostrarStatsPlatos();
    public void  mostrarRankingPlatos();
    public void  mostrarDistribucionOcupacion(LocalDate dia);
    public void  mostrarHoraMasFrecuente();
    public void  mostrarTiempoMedioDeComida();
}
