/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutar;

import Implementacion.*;
import Interfaces.DAOEstadistica;
import Interfaces.DAOPlato;
import Interfaces.Estadistica;
import Interfaces.GestionMenus;
import Interfaces.Menu;
import Interfaces.Pago;
import Interfaces.Seleccion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // TODO code application logic here

        DAOPlato dao = new DAOPlatoImp();
        Menu menu = new MenuImp();
        menu.setFecha(LocalDate.now());
        GestionMenus gestionMenus = new GestionMenusImp();

        // Se crea un menú con los platos disponibles

        for (Plato platosDisponible : dao.devolverPlatos()) {
            if (platosDisponible.getTipo().equals("entrante") && menu.getEntrantes().size() < 3) {
                menu.anhadirEntrante(platosDisponible);
            }
            if (platosDisponible.getTipo().equals("principal") && menu.getPrincipales().size() < 3) {
                menu.anhadirPrincipal(platosDisponible);
            }
            if (platosDisponible.getTipo().equals("postre") && menu.getPostres().size() < 3) {
                menu.anhadirPostre(platosDisponible);
            }
        }
        gestionMenus.anhadirMenu(menu);
        Menu MenudeHoy = gestionMenus.obtenerMenuDeHoy();
        System.out.println("Platos Disponibles: ");

        Scanner n = new Scanner(System.in);
        Seleccion seleccionador = new SeleccionImp();

        System.out.println("---- Entrantes: ");

        for (int i = 0; i < MenudeHoy.getEntrantes().size(); i++) {
            System.out.println("          " + menu.getEntrantes().get(i).getNombre());
        }
        System.out.println("Elige el entrante");
        String lineaTexto = n.nextLine();
        Plato entrante = seleccionador.seleccionarEntrante(lineaTexto);

        while (entrante == null) {
            System.out.println("Elige el entrante correcto: ");
            lineaTexto = n.nextLine();
            entrante = seleccionador.seleccionarEntrante(lineaTexto);
        }

        System.out.println("---- Principales: ");

        for (int i = 0; i < MenudeHoy.getPrincipales().size(); i++) {
            System.out.println("          " + menu.getPrincipales().get(i).getNombre());
        }
        System.out.println("Elige el plato principal");
        lineaTexto = n.nextLine();
        Plato platoPrincipal = seleccionador.seleccionarPrincipal(lineaTexto);

        while (platoPrincipal == null) {
            System.out.println("Elige el plato principal correcto: ");
            lineaTexto = n.nextLine();
            platoPrincipal = seleccionador.seleccionarPrincipal(lineaTexto);
        }

        System.out.println("---- Postres: ");

        for (int i = 0; i < MenudeHoy.getPostres().size(); i++) {
            System.out.println("          " + menu.getPostres().get(i).getNombre());
        }
        System.out.println("Elige el postre");

        lineaTexto = n.nextLine();
        Plato postre = seleccionador.seleccionarPostre(lineaTexto);

        while (postre == null) {
            System.out.println("Elige el postre correcto: ");
            lineaTexto = n.nextLine();
            postre = seleccionador.seleccionarPostre(lineaTexto);
        }

        Pago pago = new Implementacion.Pago();
        pago.setHoraIni(LocalDateTime.now());
        pago.pagar(seleccionador);

        System.out.println(pago.calcularTiempo());

        pago.valorarComida(seleccionador);

        DAOEstadistica estas = new DAOEstadisticaImp();
        estas.AsignarBandeja(4, LocalDateTime.now());
        ArrayList<Integer> bandejas = estas.devolverBandejasSinDevolver();
        ArrayList<Factura> fact = estas.devolverFacturas();
        System.out.println(fact.size());
        for (Factura a : fact) {
            System.out.println("Nombre del plato" + a.getSeleccion());
            System.out.println("Puntuacion" + a.getVale());
        }

        Estadistica e = new EstadisticaImp();
        e.calcularOcupacionActual();

        e.mostrarDistribucionOcupacion(LocalDate.now());
        e.mostrarHoraMasFrecuente();
        e.mostrarRankingPlatos();
        e.mostrarStatsPlatos();

    }

}
