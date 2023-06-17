package ejercicio2;

public class VinoGreedy {

	/**
	 * Se calcula la mayor ganancia por las ventas de vinos, donde el precio de estos
	 * va aumentando a medida que el tiempo pasa (Y * pi). Se utiliza la tecnica greedy.
	 * @param precios arreglo con precios de vinos ordenados decrecientemente
	 * @param low valor cero
	 * @param high longitud de array - 1
	 * @return maxima ganancia
	 */
	// Complexity : O (a ^ n) exponential
	// Usar el mismo algoritmo de vinos con programacion dinamica y elegir los valores de menor a mayor 
	public int maxVentasVinos (int [] precios, int low, int high) {
		
		// empty array
		if (high < low) return 0;
			
		int year = precios.length - (high - low); // year = 1 (year one)
			
		int ganMax = year * precios [low] + maxVentasVinos(precios, low + 1, high); // increment low by one, T(n-1)
			
		return ganMax;
	}
	
}
