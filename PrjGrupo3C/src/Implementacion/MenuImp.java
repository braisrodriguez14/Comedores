package Implementacion;

import java.time.LocalDate;
import java.util.ArrayList;

public class MenuImp implements Interfaces.Menu {
    private ArrayList<Plato> entrantes;
    private ArrayList<Plato> principales;
    private ArrayList<Plato> postres;
    private LocalDate fecha;

    public MenuImp() {
        entrantes = new ArrayList<>();
        principales = new ArrayList<>();
        postres = new ArrayList<>();
    }

    @Override
    public ArrayList<Plato> getEntrantes() {
        return entrantes;
    }

    @Override
    public void setEntrantes(ArrayList<Plato> entrantes) {
        this.entrantes = entrantes;
    }

    @Override
    public ArrayList<Plato> getPrincipales() {
        return principales;
    }

    @Override
    public void setPrincipales(ArrayList<Plato> principales) {
        this.principales = principales;
    }

    @Override
    public ArrayList<Plato> getPostres() {
        return postres;
    }

    public void setPostres(ArrayList<Plato> postres) {
        this.postres = postres;
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }
    

    @Override
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public void anhadirPrincipal(Plato plato) {
        principales.add(plato);
    }

    @Override
    public void anhadirEntrante(Plato plato) {
        entrantes.add(plato);

    }

    @Override
    public void anhadirPostre(Plato plato) {
        postres.add(plato);

    }

    @Override
    public void listarPlatosDelMenu() {
        //Ejemplo de listado de platos
        System.out.println("Platos Principales");
        if(!entrantes.isEmpty()){
            for(int i = 0; i < entrantes.size(); i++){
                System.out.println("\t"+entrantes.get(i).getNombre());
            }
        }
        if(!principales.isEmpty()){       
            System.out.println("Segundos");
            for(int i = 0; i < principales.size(); i++){
                System.out.println("\t"+principales.get(i).getNombre());
            }
        }
        if(!postres.isEmpty()){        
            System.out.println("Postres");
            for(int i = 0; i < postres.size(); i++){
                System.out.println("\t"+postres.get(i).getNombre());
            }
        }
    }
}
    

