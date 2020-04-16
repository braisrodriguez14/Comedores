package modelo;

import java.util.ArrayList;

public class MenuImp implements Menu {

	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;
	private String dia;
	private int id;
	
	public MenuImp(ArrayList<Plato> primeros, ArrayList<Plato> segundos, ArrayList<Plato> postres) {
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.dia = null;
	}
	
	

	public ArrayList<Plato> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<Plato> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<Plato> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<Plato> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Plato> getPostres() {
		return postres;
	}

	public void setPostres(ArrayList<Plato> postres) {
		this.postres = postres;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





	


}
