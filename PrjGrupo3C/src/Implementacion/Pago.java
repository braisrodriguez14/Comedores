/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import Implementacion.SensorImp;
import Interfaces.DAOEstadistica;
import Interfaces.DAOFactura;
import Interfaces.Seleccion;
import Interfaces.Sensor;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author xabierperezfeal
 */
public class Pago implements Interfaces.Pago {

    private LocalDateTime fecha_ini;
    private int bandeja;

    @Override
    public LocalDateTime calcularTiempo() {
        LocalDateTime fin = LocalDateTime.now();
        DAOEstadistica ee = new DAOEstadisticaImp();
        ee.devolverBandeja(bandeja, fin);
        int meses = fecha_ini.getMonthValue();
        LocalDateTime resultado = fin.minusYears(fecha_ini.getYear()).minusMonths(meses)
                .minusDays(fecha_ini.getDayOfMonth()).plusHours(fecha_ini.getHour())
                .minusMinutes(this.fecha_ini.getMinute()).minusSeconds(this.fecha_ini.getSecond())
                .minusNanos(this.fecha_ini.getNano());
        return resultado;
    }

    @Override
    public void valorarComida(Seleccion seleccion) {
        DAOEstadistica ee = new DAOEstadisticaImp();
        Scanner s = new Scanner(System.in);
        Scanner p = new Scanner(System.in);
        // La nota va por plato o por menu ??
        int nota = -1;
        System.out.println("Valoracion del entrante: " + seleccion.getEntrante().getNombre());
        System.out.println("Introduzca la nota del plato: ");
        nota = p.nextInt();
        System.out.println("Introduzca algun comentario si asi lo desea");
        String comment = s.nextLine();
        Valoracion val = new Valoracion(nota, comment);
        val.setNombrePlato(seleccion.getEntrante().getNombre());
        ee.guardarValoracion(this.bandeja, val);
        System.out.println("Valoracion del principal: " + seleccion.getPrincipal().getNombre());
        System.out.println("Introduzca la nota del plato: ");
        nota = p.nextInt();
        System.out.println("Introduzca algun comentario si asi lo desea");
        comment = s.nextLine();
        val = new Valoracion(nota, comment);
        val.setNombrePlato(seleccion.getPrincipal().getNombre());
        ee.guardarValoracion(this.bandeja, val);
        System.out.println("Valoracion del postre: " + seleccion.getPostre().getNombre());
        System.out.println("Introduzca la nota del plato: ");
        nota = p.nextInt();
        System.out.println("Introduzca algun comentario si asi lo desea");
        comment = s.nextLine();
        val = new Valoracion(nota, comment);
        val.setNombrePlato(seleccion.getPostre().getNombre());
        ee.guardarValoracion(this.bandeja, val);

    }

    @Override
    public void pagar(Seleccion seleccion) {
        Sensor s = new SensorImp();
        int vale = s.devolverCodigoVale();
        int bandeja = s.devolverCodigoBandeja();
        this.bandeja = bandeja;
        DAOEstadistica dee = new DAOEstadisticaImp();
        dee.AsignarBandeja(bandeja, fecha_ini);
        Factura f = new Factura(seleccion, vale, bandeja);
        DAOFactura fact = new DAOFacturaImp();
        fact.GuardarFactura(f);
    }

    @Override
    public LocalDateTime getHoraInicial() {
        return this.fecha_ini; // To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHoraIni(LocalDateTime hora_ini) {
        this.fecha_ini = hora_ini; // To change body of generated methods, choose Tools | Templates.
    }

    public void setBandeja(int bandeja) {
        this.bandeja = bandeja; // To change body of generated methods, choose Tools | Templates.
    }
}
