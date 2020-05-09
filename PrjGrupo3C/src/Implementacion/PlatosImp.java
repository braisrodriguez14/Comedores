package Implementacion;

import Interfaces.DAOPlato;

import java.util.ArrayList;

public class PlatosImp implements Interfaces.Platos {


    @Override
    public void listarEntrantes() {
        DAOPlato dao = new DAOPlatoImp();
        ArrayList<Plato> platos = dao.devolverPlatos();
        System.out.println("Entrantes:");

        for(int i = 0; i < platos.size(); i++){
            if(platos.get(i).getTipo().equals("Entrante")){
                System.out.println(" - " + platos.get(i).getNombre());
            }
        }
    }

    @Override
    public void listarPrincipales() {
        DAOPlato dao = new DAOPlatoImp();
        ArrayList<Plato> platos = dao.devolverPlatos();
        System.out.println("Principales:");

        for(int i = 0; i < platos.size(); i++){
            if(platos.get(i).getTipo().equals("Principal")){
                System.out.println(" - " + platos.get(i).getNombre());
            }
        }
    }

    @Override
    public void listarPostres() {
        DAOPlato dao = new DAOPlatoImp();
        ArrayList<Plato> platos = dao.devolverPlatos();
        System.out.println("Postres:");

        for(int i = 0; i < platos.size(); i++){
            if(platos.get(i).getTipo().equals("Postre")){
                System.out.println(" - " + platos.get(i).getNombre());
            }
        }

    }

    @Override
    public Plato devolverPlato(String nombre) {
        DAOPlato dao = new DAOPlatoImp();
        ArrayList<Plato> platos = dao.devolverPlatos();
        for(int i = 0; i < platos.size(); i++){
            if(platos.get(i).getTipo().equals(nombre)){
                return platos.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Plato> getPlatos() {
        DAOPlato dao = new DAOPlatoImp();
        return dao.devolverPlatos();
    }
}
