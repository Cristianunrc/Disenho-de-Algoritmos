package ejercicio1;

import java.util.Arrays;

public class Cambio {
	
	/**
	 * Se calcula la minima cantidad de valores de monedas para dar un determinado cambio.
	 * @param val arreglo decreciente con valores de monedas.
	 * @param c el cambio que debe darse.
	 * @return el arreglo con la minima cantidad de valores que sumados son = al cambio.
	 */
	
	// Complexity : O (n) lineal
	public int [] darCambio (int [] val, int c) {
		// declaro un arreglo para guardar los valores de monedas.
		int [] f = new int [100];
		int j = 0; // inicializacion de variable del arreglo f
		
		if (val.length == 0) throw new IllegalArgumentException ("no hay cambio para dar.");
		
		if ( c == 0 ) { // no hay que entregar cambio
			f[0] = 0;
			
		}else {
		
			int cAct;
			int i = 0; // inicializacion de variable del arreglo val
			
			while (c > 0) {
				cAct = c - val[i]; // C - Di, se reduce el problema a dar cambio.
			
				if (cAct >= 0) {
					c = cAct; // paso
					f [j] = val [i];
					j++;  // j sera la longitud del arreglo a retornar 
				}else{
					i++;
				}
			}
		}
		
		// Nose cual es la complejidad del copyOf
		int [] arre = Arrays.copyOf(f, j); // en arre copio los elementos de f y le doy la longitud j
		
		return arre;
	}
}
