package Implementacion;

import java.util.ArrayList;

public class Plato {
    private String nombre;
    private int calorias;
    private String ingredientes;
    private String tipo;

    public Plato(){
       
    }

    public Plato(String nombre, int calorias, String tipo){
        this.nombre = nombre;
        this.calorias = calorias;
        
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

   

   

   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
