package it.polito.tdp.extflightdelays.model;

public class Rotta {
	
	private Airport origin;
	private Airport destination;
	private int peso;
	public Rotta(Airport origin, Airport destination, int peso) {
		this.origin = origin;
		this.destination = destination;
		this.peso = peso;
	}
	public Airport getOrigin() {
		return origin;
	}
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	

}
