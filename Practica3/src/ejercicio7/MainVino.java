package ejercicio7;

public class MainVino {

	public static void main (String [] args) {
	
	int [] preciosVinos = {4,8,9,10,11};
	
	Vino wine = new Vino ();
	
	int result = wine.gananciaMaxVentas1(preciosVinos);
	
	System.out.println("Ganancia maxima por la venta de vinos: " + result);
	
	}
	
}
