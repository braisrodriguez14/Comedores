package modelo;

import java.util.ArrayList;

public class MenuImp implements Menu {

	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;
	private int dia;
	private int id;

	public MenuImp(ArrayList<Plato> primeros, ArrayList<Plato> segundos, ArrayList<Plato> postres) {
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.dia = -1;
		this.id = -1;
	}

	public MenuImp(ArrayList<Plato> primeros, ArrayList<Plato> segundos, ArrayList<Plato> postres, int dia, int id) {
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.dia = dia;
		this.id = id;
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

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
