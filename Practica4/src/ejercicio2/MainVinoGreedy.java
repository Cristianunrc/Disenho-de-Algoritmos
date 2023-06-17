package ejercicio2;

public class MainVinoGreedy {

	public static void main(String[] args) {
		
		// no necesariamente tener el arregl ordenado
		int [] price = {200, 180, 150, 130, 100};
		
		VinoGreedy wine = new VinoGreedy ();
		
		int maxGan = wine.maxVentasVinos(price, 0, price.length - 1);
		
		System.out.println("Ganancia maxima obtenida: " + maxGan);

	}

}
