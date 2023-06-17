package ejercicio7;

import java.util.HashMap;
import java.util.Map;
import Ejercicio6.Tuple;

public class Vino {
	
	// Map <key, value> donde key representa el rango (i, j) de precios de la lista de vinos
	// y value representa la ganacia maxima obtenida por las ventas.
	
	/**
	 * Metodo que calcula la ganancia maxima obtenida por la venta de vinos.
	 * @param precios el arreglo con los precios de los vinos
	 * @return ganancia maxima
	 */
	public int gananciaMaxVentas1 (int [] precios) {
		
		Map <Tuple <Integer, Integer>, Integer> memo = new HashMap <> ();
		
		return gananciaMaxVentas2 (precios, 0, precios.length - 1, memo);
	}
	
	
	public int gananciaMaxVentas2 (int [] price, int low, int high, Map <Tuple <Integer, Integer>, Integer> memo) {
		
		if (high <= low) return 0; // ver esta linea
		
		Tuple <Integer, Integer> range = new Tuple <> (low, high); // first = low , second = high
		
		if (memo.containsKey(range)) { // si contiene a range entonces lo retorno
			return memo.get(range);
		}
		
		int year = price.length - (high - low); // year = 1 (año uno)
		
		// año * precio del primer vino
		int ventaPrimero = year * price[low] + gananciaMaxVentas2 (price, low + 1, high, memo); // se va incrementando low
		
		// año * precio del ultimo vino
		int ventaUltimo = year * price[high] + gananciaMaxVentas2 (price, low, high - 1, memo); // se va decrementando high
		
		int ventaTotal = Math.max(ventaPrimero, ventaUltimo);
		
		memo.put(range, ventaTotal); // sino gananciaMaxVentas1
		
		return ventaTotal;
		
	}
	
}