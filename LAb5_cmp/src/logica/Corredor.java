package src.logica;

//La clase Corredor no ser� intanciable directamente, as� que la declaramos abstracta.
public abstract class Corredor {
	private int puntuacion;
	private int posicion;
	private boolean durmiendo;
	//Determina el alcance de cada salto en el tablero. Este valor se sobrescribe en las subclases.
	protected int salto;
	private String foto;
	private Calle calleAsignada;
	public final static int POSICION_SALIDA = -1;
	
	public Corredor(Calle calleAsignada, String foto) {
		this.calleAsignada = calleAsignada;
		this.foto = foto;
		durmiendo = false;
		puntuacion = 0;
		salto = 0;
		posicion = POSICION_SALIDA;
	}
	
	public int getSalto() {
		return salto;
	}

	public boolean isDurmiendo() {
		return durmiendo;
	}

	public void dormir() {
		durmiendo = true;
	}
	
	public void despertar() {
		durmiendo = false;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion (int posicion) {
		this.posicion = posicion;
	}
	
	public Calle getCalleAsignada() {
		return calleAsignada;
	}

	public String getFoto() {
		return foto;
	}
	
	public void incrementaPuntuacion (int puntos){
		puntuacion += puntos;
	}
}
