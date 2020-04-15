package modelo;

import java.util.ArrayList;

public class MenuImp implements Menu {

	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;
	private ArrayList<Plato> bebidas;
	private String dia;
	
	public MenuImp(ArrayList<Plato> primeros, ArrayList<Plato> segundos, ArrayList<Plato> postres, ArrayList<Plato> bebidas) {
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.bebidas = bebidas;
		this.dia = null;
	}

	@Override
	public ArrayList<Plato> getPrimeros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plato> getSegundos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plato> getPostres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDia(String dia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPrimeros(ArrayList<Plato> primeros) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSegundos(ArrayList<Plato> segundos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPostres(ArrayList<Plato> postres) {
		// TODO Auto-generated method stub

	}

}
