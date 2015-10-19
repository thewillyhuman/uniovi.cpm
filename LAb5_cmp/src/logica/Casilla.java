package logica;

public class Casilla {
	
	private int valor = 0;
	private boolean arbol = false;
	
	public Casilla(int valor) {
		this.valor = valor;
	}
	public boolean tieneArbol() {
		return arbol;
	}
	public void plantarArbol() {
		arbol = true;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
