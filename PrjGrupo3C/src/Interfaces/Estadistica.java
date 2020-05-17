package Interfaces;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Estadistica {
    public void  calcularOcupacionActual();
    public String  mostrarStatsPlatos();
    public ArrayList<String>  mostrarRankingPlatos();
    public ArrayList< Integer >  mostrarDistribucionOcupacion(LocalDate dia);
    public ArrayList<Integer>  mostrarHoraMasFrecuente();
    public void  mostrarTiempoMedioDeComida();
}
 