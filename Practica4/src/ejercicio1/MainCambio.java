package ejercicio1;

public class MainCambio {

	public static void main(String[] args) {
		
		int [] valores = {7, 5, 1}; // arreglo con valores de monedas.
		int cambio = 25; // el cambio que debo entregar.

		Cambio c1 = new Cambio ();
		int [] minValores = c1.darCambio(valores, cambio);
		
		for (int i = 0; i < minValores.length; i++) {
			System.out.println (minValores[i]);
		}
		
		// Caso donde no se retorna una solucion optima es:
		// cambio = 25
		// valores = {7, 5, 1}
		// solucion retornada : {7,7,7,1,1,1,1}
		// solucion optima : {5,5,5,5,5} 
	}

}
