package Interfaces;

import java.time.LocalDateTime;

public interface Sensor {
    public int devolverCodigoBandeja();
    public int devolverCodigoVale();
    public LocalDateTime devolverHoraActual();
}