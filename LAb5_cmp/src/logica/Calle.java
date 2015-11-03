package src.logica;


public class Calle {

	public static final int DIM = 11;
	public static final int POSICION_META = 10;
	private static final int VALOR_CASILLA = 50;
	private Casilla[] casillas = new Casilla[DIM];

	public Calle (boolean arboles) {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla(VALOR_CASILLA);
		}
		if (arboles) {
			colocarArbol();
			colocarArbol();
		}
	}

	private int colocarArbol() {
		int columna;
		// Metemos -1 para que nunca caiga un árbol en la casilla de meta.
		int semilla = DIM - 1;
		do {
			columna = (int) (Math.random() * semilla);
		} while (casillas[columna].tieneArbol());
		casillas[columna].plantarArbol();
		System.out.println("Tenemos un arbol en " + columna);
		return columna;
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
