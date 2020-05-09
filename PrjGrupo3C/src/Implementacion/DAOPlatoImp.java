
package Implementacion;

import Interfaces.DAOPlato;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOPlatoImp implements DAOPlato{

    @Override
    public ArrayList<Plato> devolverPlatos() {
        ArrayList<Plato> resultado = new ArrayList<Plato>();
        
        try{
        
        File file=new File("Platos.txt");    //creates a new file instance  
        FileReader fr = null;
        
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        Plato temp = null;
        while((line=br.readLine())!=null)
        
        {  
            String[] cabecera = line.split(": ");
            if(cabecera[0].equals("IdxPlato")){
                temp = new Plato();
            }
            if(cabecera[0].equals("Nombre")){
                temp.setNombre(cabecera[1]);
            }
            if(cabecera[0].equals("Calorias")){
                temp.setCalorias(Integer.parseInt(cabecera[1]));
            }
            if(cabecera[0].equals("Ingredientes")){
                temp.setIngredientes(cabecera[1]);
            }
            if(cabecera[0].equals("Tipo")){
                temp.setTipo(cabecera[1]);
                resultado.add(temp);
            }
            
        } 
        fr.close();    //closes the stream and release the resources  
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException e){
        
        }
        
        return resultado;
    }

    @Override
    public Plato recuperarPlato(String nombre) {
        Plato resultado = null;
        
        try{
        
        File file=new File("Platos.txt");    //creates a new file instance  
        FileReader fr = null;
        
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        Plato temp = null;
        boolean encontrado = false;
        while((line=br.readLine())!=null)
        
        {  
            String[] cabecera = line.split(": ");
            if(cabecera[0].equals("IdxPlato")){
                temp = new Plato();
            }
            if(cabecera[0].equals("Nombre")){
                if(cabecera[1].equals(nombre)){
                    encontrado = true;
                }
                temp.setNombre(cabecera[1]);
            }
            if(cabecera[0].equals("Calorias")){
                temp.setCalorias(Integer.parseInt(cabecera[1]));
            }
            if(cabecera[0].equals("Ingredientes")){
                temp.setIngredientes(cabecera[1]);
            }
            if(cabecera[0].equals("Tipo")){
                temp.setTipo(cabecera[1]);
                if(encontrado == true){
                    resultado = temp;
                    break;
                }
            }
            
        } 
        fr.close();    //closes the stream and release the resources  
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException e){
        
        }
        
        return resultado;
    }
    
}