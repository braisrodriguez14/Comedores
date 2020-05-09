package Interfaces;
import java.time.LocalDate;
import Implementacion.Valoracion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Implementacion.Factura;
import java.util.HashMap;

public interface DAOEstadistica {
    public void AsignarBandeja(int bandeja, LocalDateTime inicial);
    public void devolverBandeja(int bandeja, LocalDateTime inicial);
    public void guardarValoracion(int bandeja,  Valoracion val);
    public ArrayList<Integer> devolverBandejasSinDevolver();
    public ArrayList<Valoracion> devolverValoraciones();
    public ArrayList<LocalDateTime> devolverTiempoBandejaAsignada(LocalDate fecha);
    public ArrayList<LocalDateTime> devolverTiempoBandejaDevuelta(LocalDate fecha);
    public ArrayList<Factura> devolverFacturas();
    public HashMap<Integer,LocalDateTime> obtenerTiemposDiaAsignada(String dia);
    public HashMap<Integer,LocalDateTime> obtenerTiemposDiaDevuelta(String dia);
}