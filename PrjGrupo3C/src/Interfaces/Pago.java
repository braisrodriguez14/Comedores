package Interfaces;


import Implementacion.Plato;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Pago {
    public LocalDateTime calcularTiempo();
    public void valorarComida(Seleccion seleccion);
    public void pagar(Seleccion seleccion);
    public LocalDateTime getHoraInicial();
    public void setHoraIni(LocalDateTime hora_ini);
}
