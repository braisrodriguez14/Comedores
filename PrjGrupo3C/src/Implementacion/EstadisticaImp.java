package Implementacion;

import Interfaces.DAOEstadistica;
import Interfaces.Estadistica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class EstadisticaImp implements Estadistica {

    @Override
    public void calcularOcupacionActual() {
        DAOEstadistica daoe = new DAOEstadisticaImp();
        System.out.println("La ocupación actual es de: " + daoe.devolverBandejasSinDevolver().size());
    }

    @Override
    public void mostrarStatsPlatos() {
        // TODO Auto-generated method stub
        DAOEstadistica daoe = new DAOEstadisticaImp();
        ArrayList<Factura> facturas = daoe.devolverFacturas();
        HashMap<String, Integer> entrantes = new HashMap<>(), principales = new HashMap<>(), postres = new HashMap<>();
        for (Factura f : facturas) {

            if (entrantes.containsKey(f.getSeleccion().getEntrante().getNombre())) {
                entrantes.replace(f.getSeleccion().getEntrante().getNombre(), entrantes.get(f.getSeleccion().getEntrante().getNombre()) + 1);
            } else {
                entrantes.put(f.getSeleccion().getEntrante().getNombre(), 1);
            }
            if (principales.containsKey(f.getSeleccion().getPrincipal().getNombre())) {
                principales.replace(f.getSeleccion().getPrincipal().getNombre(),
                        principales.get(f.getSeleccion().getPrincipal().getNombre()) + 1);
            } else {
                principales.put(f.getSeleccion().getPrincipal().getNombre(), 1);
            }
            if (postres.containsKey(f.getSeleccion().getPostre().getNombre())) {
                postres.replace(f.getSeleccion().getPostre().getNombre(), postres.get(f.getSeleccion().getPostre().getNombre()) + 1);
            } else {
                postres.put(f.getSeleccion().getPostre().getNombre(), 1);
            }
        }

        Optional<Entry<String, Integer>> maxEntrante = entrantes.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        Optional<Entry<String, Integer>> minEntrante = entrantes.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        Optional<Entry<String, Integer>> maxPrincipal = principales.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        Optional<Entry<String, Integer>> minPrincipal = principales.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        Optional<Entry<String, Integer>> maxPostres = postres.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        Optional<Entry<String, Integer>> minPostres = postres.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        System.out.println("El entrante más elegido es: " + maxEntrante.get().getKey());
        System.out.println("El entrante menos elegido es: " + minEntrante.get().getKey());
        System.out.println("El principal más elegido es: " + maxPrincipal.get().getKey());
        System.out.println("El principal menos elegido es: " + minPrincipal.get().getKey());
        System.out.println("El postre más elegido es: " + maxPostres.get().getKey());
        System.out.println("El postre menos elegido es: " + minPostres.get().getKey());
    }

    @Override
    public void mostrarRankingPlatos() {
        // TODO Auto-generated method stub
        DAOEstadistica daoe = new DAOEstadisticaImp();
        ArrayList<Valoracion> valoraciones = daoe.devolverValoraciones();
        HashMap<String, Double> platos = new HashMap<>();
        HashMap<String, Integer> cuentaPlatos = new HashMap<>();
        for (Valoracion f : valoraciones) {
            if (platos.containsKey(f.getNombrePlato())) {
                platos.replace(f.getNombrePlato(), platos.get(f.getNombrePlato()) + f.getNota());
                cuentaPlatos.replace(f.getNombrePlato(), cuentaPlatos.get(f.getNombrePlato()) + 1);
            } else {
                platos.put(f.getNombrePlato(), (double) f.getNota());
                cuentaPlatos.put(f.getNombrePlato(), 1);
            }
        }
        for (Entry<String, Double> e : platos.entrySet()) {
            platos.replace(e.getKey(), e.getValue() / cuentaPlatos.get(e.getKey()));
        }
        HashMap<String, Double> aux = new HashMap<>(platos);
        ArrayList<String> ranking = new ArrayList<>();
        Optional<Entry<String, Double>> max;
        while (!aux.isEmpty()) {
            max = aux.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
            ranking.add(max.get().getKey());
            aux.remove(max.get().getKey());
        }
        System.out.println("El ranking de platos es el siguiente:");
        for (String s : ranking) {
            System.out.println(s + ": " + platos.get(s));
        }
    }

    @Override
    public ArrayList<Integer> mostrarDistribucionOcupacion(LocalDate dia) {
    	//1
    	if( dia == null ) {
    		//2
			return null;
		}
    	else {
    		//3
            DAOEstadistica daoe = new DAOEstadisticaImp();
            ArrayList<LocalDateTime> bandejas = daoe.devolverTiempoBandejaAsignada(dia);
            ArrayList<Integer> numeros = new ArrayList<>();
            //4
            for (int i = 11; i < 18; i++) {
                numeros.add(0);
                //5
                for (LocalDateTime l : bandejas) {
                	//6
                    if (l.getHour() == i) {
                    	//7
                        numeros.set(i - 11, numeros.get(i - 11) + 1);
                    }
                }//8
                //9
                System.out.println(i - 11 + ": " + numeros.get(i - 11));
            }//10

        	return numeros;
    	}
    	//11
    }

    @Override
    public ArrayList<Integer> mostrarHoraMasFrecuente() {
        DAOEstadistica daoe = new DAOEstadisticaImp();
        String[] semana = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
        ArrayList<ArrayList<LocalDateTime>> dias = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            dias.add(new ArrayList<>());
            dias.set(i, new ArrayList<>(((Map) daoe.obtenerTiemposDiaAsignada(semana[i])).values()));
        }
        
        ArrayList<ArrayList<Integer>> numeros = new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            numeros.add(new ArrayList<>());
            for (int i = 11; i < 18; i++) {
                numeros.get(j).add(0);
                for (LocalDateTime l : dias.get(j)) {
                    if (l.getHour() == i) {
                        numeros.get(j).set(i - 11, numeros.get(j).get(i - 11) + 1);
                    }
                }
            }
        }
        
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            resultado.add(numeros.get(i).stream().max(Integer::compare).get());
        }
        
        return resultado;
    }

    @Override
    public void mostrarTiempoMedioDeComida() {
        // TODO Auto-generated method stub
        DAOEstadistica daoe = new DAOEstadisticaImp();
        String[] semana = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
        HashMap<Integer, LocalDateTime> recoge = new HashMap<>(), devuelve = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            recoge.putAll((Map<Integer, LocalDateTime>) daoe.obtenerTiemposDiaAsignada(semana[i]));
            devuelve.putAll((Map<Integer, LocalDateTime>) daoe.obtenerTiemposDiaDevuelta(semana[i]));
        }
        double media = 0.0;
        for (Entry<Integer, LocalDateTime> e : devuelve.entrySet()) {
            media += calcularDiferencia(e.getValue(), recoge.get(e.getKey()));
        }
        media /= recoge.size();

        System.out.println("El tiempo medio de comida es de: " + media + " minutos");

    }

    private double calcularDiferencia(LocalDateTime principio, LocalDateTime fin) {
        double res = 0.0;
        res += 60 - principio.getMinute();
        res += (fin.getHour() - principio.getHour()) * 60;
        res += fin.getMinute();
        return res;
    }

}