/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import Interfaces.DAOEstadistica;
import Interfaces.DAOPlato;
import Interfaces.Seleccion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

/**
 *
 * @author Stanislav
 */
public class DAOEstadisticaImp implements DAOEstadistica {

    @Override
    public void AsignarBandeja(int bandeja, LocalDateTime inicial) {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", true));
            String linea = "cogida" + "\n";
            out.write(linea);
            linea = "CodigoBandeja: " + bandeja + "\n";
            out.write(linea);
            linea = "TiempoCogida: " + inicial.toString() + "\n";
            out.write(linea);
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }

    @Override
    public void devolverBandeja(int bandeja, LocalDateTime inicial) {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", true));
            String linea = "entregada" + "\n";
            out.write(linea);
            linea = "CodigoBandeja: " + bandeja + "\n";
            out.write(linea);
            linea = "TiempoCogida: " + inicial.toString() + "\n";
            out.write(linea);
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }

    @Override
    public void guardarValoracion(int bandeja, Valoracion val) {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter("Estadisticas.txt", true));
            String linea = "valoracion" + "\n";
            out.write(linea);
            linea = "Nombre: " + val.getNombrePlato() + "\n";
            out.write(linea);
            linea = "Nota: " + val.getNota() + "\n";
            out.write(linea);
            linea = "Comentario: " + val.getComentario() + "\n";
            out.write(linea);
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }

    @Override
    public ArrayList<Integer> devolverBandejasSinDevolver() {
        ArrayList<Integer> resultado = new ArrayList<Integer>();

        try {

            File file = new File("Estadisticas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;

            while ((line = br.readLine()) != null)

            {

                if (line.equals("cogida")) {
                    line = br.readLine();
                    String separado[] = line.split(" ");
                    resultado.add(Integer.parseInt(separado[1]));
                }

                if (line.equals("entregada")) {
                    line = br.readLine();
                    String separado[] = line.split(" ");
                    for (int i = 0; i < resultado.size(); i++) {
                        if (Integer.parseInt(separado[1]) == resultado.get(i)) {
                            resultado.remove(i);
                            break;
                        }
                    }
                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultado;
    }

    @Override
    public ArrayList<Valoracion> devolverValoraciones() {
        ArrayList<Valoracion> resultado = new ArrayList<Valoracion>();
        
        try{
        
        File file=new File("Estadisticas.txt");    //creates a new file instance  
        FileReader fr = null;
        fr = new FileReader(file); //reads the file
        
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream    
        String line;
        Valoracion temp = null;
        while((line=br.readLine())!=null)
        
        {  
            
            String[] cabecera = line.split(": ");
            if(cabecera[0].equals("valoracion")){
                temp  = new Valoracion();
                
            }
            if(cabecera[0].equals("Nombre")){
                temp.setNombrePlato(cabecera[1]);
                
            }
            if(cabecera[0].equals("Nota")){
                temp.setNota(Integer.parseInt(cabecera[1]));
                
            }
            if(cabecera[0].equals("Comentario")){
                temp.setComentario(cabecera[1]);
                resultado.add(temp);
                
            }
            fr.close(); // closes the stream and release the resources
        }
    }
         catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultado;

    }

    @Override
    public ArrayList<LocalDateTime> devolverTiempoBandejaAsignada(LocalDate fecha) {
        ArrayList<LocalDateTime> resultado = new ArrayList<LocalDateTime>();

        try {

            File file = new File("Estadisticas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;
            LocalDateTime temp = null;
            while ((line = br.readLine()) != null)

            {

                String[] cabecera = line.split(": ");
                if (cabecera[0].equals("cogida")) {
                    line = br.readLine();
                    line = br.readLine();
                    String[] seprar = line.split(" ");
                    temp = LocalDateTime.parse(seprar[1]);
                    if (fecha.isEqual(temp.toLocalDate())) {
                        resultado.add(temp);
                    }

                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultado;

    }

    @Override
    public ArrayList<LocalDateTime> devolverTiempoBandejaDevuelta(LocalDate fecha) {
        ArrayList<LocalDateTime> resultado = new ArrayList<LocalDateTime>();

        try {

            File file = new File("Estadisticas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;
            LocalDateTime temp = null;
            while ((line = br.readLine()) != null)

            {

                String[] cabecera = line.split(": ");
                if (cabecera[0].equals("entregada")) {
                    line = br.readLine();
                    line = br.readLine();
                    String[] seprar = line.split(" ");
                    temp = LocalDateTime.parse(seprar[1]);
                    if (fecha.isEqual(temp.toLocalDate())) {
                        resultado.add(temp);
                    }

                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultado;
    }

    @Override
    public ArrayList<Factura> devolverFacturas() {
        ArrayList<Factura> resultado = new ArrayList<Factura>();
        DAOPlato pbd = new DAOPlatoImp();
        try {

            File file = new File("Facturas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;
            Factura temp = null;
            while ((line = br.readLine()) != null)

            {

                String[] cabecera = line.split(": ");
                if (cabecera[0].equals("IdxFactura")) {
                    temp = new Factura();

                }
                if (cabecera[0].equals("Vale")) {
                    temp.setVale(Integer.parseInt(cabecera[1]));

                }
                if (cabecera[0].equals("CodigoBandeja")) {
                    temp.setCodigoBandeja(Integer.parseInt(cabecera[1]));

                }
                if (cabecera[0].equals("Platos")) {
                    String[] platos = cabecera[1].split(",");
                    Seleccion s = new SeleccionImp();

                    Plato entrante = pbd.recuperarPlato(platos[0]);
                    Plato principal = pbd.recuperarPlato(platos[1]);
                    Plato postre = pbd.recuperarPlato(platos[2]);

                    s.setEntrante(entrante);
                    s.setPrincipal(principal);
                    s.setPostre(postre);

                    temp.setSeleccion(s);
                    resultado.add(temp);

                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultado;
    }

    @Override
    public HashMap<Integer, LocalDateTime> obtenerTiemposDiaAsignada(String dia) {
        HashMap<Integer, LocalDateTime> resultadoReal = new HashMap<Integer, LocalDateTime>();
        ArrayList<LocalDateTime> resultado = new ArrayList<LocalDateTime>();

        try {

            File file = new File("Estadisticas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;
            Integer tempInt;
            LocalDateTime temp = null;
            while ((line = br.readLine()) != null)

            {

                String[] cabecera = line.split(": ");
                if (cabecera[0].equals("cogida")) {
                    line = br.readLine();
                    String[] seprar = line.split(" ");
                    tempInt = Integer.parseInt(seprar[1]);
                    line = br.readLine();
                    seprar = line.split(" ");
                    temp = LocalDateTime.parse(seprar[1]);
                    if (temp.getDayOfWeek().name().equals(dia)) {
                        resultado.add(temp);
                        resultadoReal.put(tempInt, temp);
                    }

                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultadoReal;
    }

    @Override
    public HashMap<Integer, LocalDateTime> obtenerTiemposDiaDevuelta(String dia) {
        HashMap<Integer, LocalDateTime> resultadoReal = new HashMap<Integer, LocalDateTime>();
        ArrayList<LocalDateTime> resultado = new ArrayList<LocalDateTime>();

        try {

            File file = new File("Estadisticas.txt"); // creates a new file instance
            FileReader fr = null;
            fr = new FileReader(file); // reads the file

            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            String line;
            Integer tempInt;
            LocalDateTime temp = null;
            while ((line = br.readLine()) != null)

            {

                String[] cabecera = line.split(": ");
                if (cabecera[0].equals("entregada")) {
                    line = br.readLine();
                    String[] seprar = line.split(" ");
                    tempInt = Integer.parseInt(seprar[1]);
                    line = br.readLine();
                    seprar = line.split(" ");
                    temp = LocalDateTime.parse(seprar[1]);
                    if (temp.getDayOfWeek().name().equals(dia)) {
                        resultado.add(temp);
                        resultadoReal.put(tempInt, temp);
                    }

                }

            }
            fr.close(); // closes the stream and release the resources

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOPlatoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

        }

        return resultadoReal;
    }

}