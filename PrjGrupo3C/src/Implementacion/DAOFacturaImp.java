
package Implementacion;

import Interfaces.DAOFactura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOFacturaImp implements DAOFactura{

    @Override
    public void GuardarFactura(Factura factura) {
        int id = 1;
        //Se obtiene el último id
        try{
        
        File file=new File("Facturas.txt");    //creates a new file instance  
        FileReader fr = null;
        
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        
        while((line=br.readLine())!=null)
        
        {  
            String[] cabecera = line.split(" ");
            if(cabecera[0].equals("IdxFactura:")){
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
            new FileWriter("Facturas.txt", true)); 
            String linea = "IdxFactura: " + id + "\n";
            out.write(linea);
            linea = "Vale: "+ factura.getVale() + "\n";
            out.write(linea);
            linea = "CodigoBandeja: "+ factura.getCodigoBandeja() + "\n";
            out.write(linea);
            //platos
            String entrante = factura.getSeleccion().getEntrante().getNombre();
            String principal = factura.getSeleccion().getPrincipal().getNombre();
            String postre = factura.getSeleccion().getPostre().getNombre();
            linea = "Platos: " +entrante+","+principal+","+postre + "\n";
            out.write(linea);
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    }
    
}