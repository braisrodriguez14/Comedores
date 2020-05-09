package Implementacion;

import Interfaces.DAOMenu;
import Interfaces.DAOPlato;
import Interfaces.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;

public class DAOMenuImp implements DAOMenu{

    @Override
    public ArrayList<Menu> devolverMenus() {
        ArrayList<Menu> resultado = new ArrayList<Menu>();
        DAOPlato platobd = new DAOPlatoImp();
        try{
        
        File file=new File("Menus.txt");    //creates a new file instance  
        FileReader fr = null;
        
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        Menu temp = null;
        while((line=br.readLine())!=null)
        
        {  
            String[] cabecera = line.split(": ");
            if(cabecera[0].equals("IdxMenu")){
                temp = new MenuImp();
            }
            if(cabecera[0].equals("Fecha")){
                LocalDate fecha = LocalDate.parse(cabecera[1]);
                temp.setFecha(fecha);
            }
            if(cabecera[0].equals("NombresEntrantes")){
                String[] entrantes = cabecera[1].split(",");
                ArrayList<Plato> entrantesArr = new ArrayList<Plato>();
                //////////////////////////////////
                for(int i = 0; i < entrantes.length; i++){
                    Plato entrante = platobd.recuperarPlato(entrantes[i]);
                    entrantesArr.add(entrante);
                }
                temp.setEntrantes(entrantesArr);
                    
            }
            if(cabecera[0].equals("NombresPrincipales")){
                String[] entrantes = cabecera[1].split(",");
                ArrayList<Plato> entrantesArr = new ArrayList<Plato>();
                //////////////////////////////////
                for(int i = 0; i < entrantes.length; i++){
                    Plato entrante = platobd.recuperarPlato(entrantes[i]);
                    entrantesArr.add(entrante);
                }
                temp.setPrincipales(entrantesArr);
            }
            if(cabecera[0].equals("NombresPostres")){
                String[] entrantes = cabecera[1].split(",");
                ArrayList<Plato> entrantesArr = new ArrayList<Plato>();
                //////////////////////////////////
                for(int i = 0; i < entrantes.length; i++){
                    Plato entrante = platobd.recuperarPlato(entrantes[i]);
                    entrantesArr.add(entrante);
                }
                temp.setPostres(entrantesArr);
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
    public void guardarMenu(Menu menu) {
        int id = 1;
        //Se obtiene el último id
        try{
        
        File file=new File("Menus.txt");    //creates a new file instance  
        FileReader fr = null;
        
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        
        while((line=br.readLine())!=null)
        
        {  
            String[] cabecera = line.split(" ");
            if(cabecera[0].equals("IdxMenu:")){
                id = Integer.parseInt(cabecera[1]) + 1;
                
            }
            
        } 
        fr.close();    //closes the stream and release the resources  
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException e){
        
        }
        
        try { 
  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
            new FileWriter("Menus.txt", true)); 
            String linea = "IdxMenu: " + id + "\n";
            out.write(linea);
            linea = "Fecha: "+ menu.getFecha().toString() + "\n";
            out.write(linea);
            
            ////Platos entrantes
            linea = "NombresEntrantes: ";
            for(int i = 0; i<menu.getEntrantes().size(); i++){
                linea = linea+menu.getEntrantes().get(i).getNombre();
                if(i<menu.getEntrantes().size()-1){
                    linea = linea+",";
                }else{
                    linea = linea+"\n";
                }
            }
            out.write(linea);
            ////Platos entrantes
            linea = "NombresPrincipales: ";
            for(int i = 0; i<menu.getPrincipales().size(); i++){
                linea = linea+menu.getPrincipales().get(i).getNombre();
                if(i<menu.getPrincipales().size()-1){
                    linea = linea+",";
                }else{
                    linea = linea+"\n";
                }
            }
            out.write(linea);
            ////Platos entrantes
            linea = "NombresPostres: ";
            for(int i = 0; i<menu.getPostres().size(); i++){
                linea = linea+menu.getPostres().get(i).getNombre();
                if(i<menu.getPostres().size()-1){
                    linea = linea+",";
                }else{
                    linea = linea+"\n";
                }
            }
            out.write(linea);
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    }

    @Override
    public void borrarMenu(Menu menu) {
        ArrayList<Menu> menusActuales = this.devolverMenus();
        for(int i = 0; i < menusActuales.size(); i++){
            if(menu.getFecha().equals(menusActuales.get(i).getFecha())){
                menusActuales.remove(i);
                break;
            }
        }
        //Se limpia el archivo
        PrintWriter writer = null;
            try {
                writer = new PrintWriter("Menus.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOMenuImp.class.getName()).log(Level.SEVERE, null, ex);
            }
            writer.print("");
            writer.close();
            
        //Se guardan los menús
        for(int i = 0; i < menusActuales.size(); i++){
            
            this.guardarMenu(menusActuales.get(i));
            

        }
    }
    
}
