package logica;

public class Dado {
	public static int lanzar (Corredor corredor)
	{
		int resultado =  (int) (Math.random() * corredor.getSalto()) + 1;
		return resultado;
	}
}
