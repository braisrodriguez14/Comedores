package Implementacion;

import Interfaces.GestionMenus;
import Interfaces.Menu;

public class SeleccionImp implements Interfaces.Seleccion {
    private Plato entrante;
    private Plato principal;
    private Plato postre;
    private String bebida;



    @Override
    public Plato seleccionarEntrante(String nombre) {
        GestionMenus menu = new GestionMenusImp();
        Menu m = menu.obtenerMenuDeHoy();
        for(int i = 0; i < m.getEntrantes().size(); i++){
            if(m.getEntrantes().get(i).getNombre().equals(nombre)){
                entrante = m.getEntrantes().get(i);
                return m.getEntrantes().get(i);
            }
        }
        return null;
    }

    @Override
    public Plato seleccionarPrincipal(String nombre) {
        GestionMenus menu = new GestionMenusImp();
        Menu m = menu.obtenerMenuDeHoy();
        for(int i = 0; i < m.getPrincipales().size(); i++){
            if(m.getPrincipales().get(i).getNombre().equals(nombre)){
                principal = m.getPrincipales().get(i);
                return m.getPrincipales().get(i);
            }
        }
        return null;
    }

    @Override
    public Plato seleccionarPostre(String nombre) {
        GestionMenus menu = new GestionMenusImp();
        Menu m = menu.obtenerMenuDeHoy();
        for(int i = 0; i < m.getPostres().size(); i++){
            if(m.getPostres().get(i).getNombre().equals(nombre)){
                postre = m.getPostres().get(i);
                return m.getPostres().get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean seleccionarBebida(String bebida) {
        GestionMenus menu = new GestionMenusImp();
        if(menu.getBebidas().contains(bebida)){
            this.bebida = bebida;
            return true;
        }
        return false;
    }

    public Plato getEntrante() {
        return entrante;
    }

    public void setEntrante(Plato entrante) {
        this.entrante = entrante;
    }

    public Plato getPrincipal() {
        return principal;
    }

    public void setPrincipal(Plato principal) {
        this.principal = principal;
    }

    public Plato getPostre() {
        return postre;
    }

    public void setPostre(Plato postre) {
        this.postre = postre;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }
}
