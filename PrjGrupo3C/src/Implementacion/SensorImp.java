package Implementacion;

import java.time.LocalDateTime;

public class SensorImp implements Interfaces.Sensor {



    @Override
    public int devolverCodigoBandeja() {
        return (int)(Math.random()*1000);
    }

    @Override
    public int devolverCodigoVale() {
        return (int)(Math.random()*1000);
    }

    @Override
    public LocalDateTime devolverHoraActual() {
        return LocalDateTime.now();
    }
}
