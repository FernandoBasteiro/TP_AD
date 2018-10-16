package negocio;

import java.util.ArrayList;
import java.util.Random;

import tests.CartaDAOv;

public class Mazo {

	private ArrayList<Carta>cartas;

	public Mazo() {
		super();
		this.cartas = CartaDAOv.getInstance().getCartas();
	}
	
	public Carta darCarta(){
		Random aleatorio = new Random();
		
		Carta c = cartas.get(aleatorio.nextInt((cartas.size())));
		
		cartas.remove(c);
		return c;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	
	
	
}
