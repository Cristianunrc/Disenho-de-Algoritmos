package ejercicio10;

public class Mochila {

	/**
	 * Retorna el valor optimo (maximo valor) de items que pueden entrar en la mochila dependiendo su capacidad.
	 * @param val un array con el valor de cada item
	 * @param peso un array con el peso de cada item
	 * @param cap la capacidad o volumen de la mochila
	 * @return el valor optimo
	 */
	// Complexity : O (n*Cap), n cantidad de items * capacidad de la mochila
	// Dynamic programming
	public int llenarMochicla (int [] val, int [] peso, int cap) {
		
		// cantidad de filas: longitud de val (o puede ser longitud de peso), es la cantidad de items
		// cantidad de columnas : cap
		int n = val.length;
		int [][] m = new int [n + 1][cap + 1]; // m tiene n + 1 filas y cap + 1 columnas 

		for(int i = 0; i <= n; i++) {
			m[i][0] = 0;  // la primer columna de la matriz tendra todos 0's
		}
		
		for(int j = 0; j <= cap; j++) {
			m[0][j] = 0;  // la primer fila de la matriz tendra todos 0's
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= cap; j++) {
				
				if (peso[i - 1] <= j) { // si (j - peso[i] >= 0 )
					m[i][j] = Math.max( m[i - 1][j - peso[i - 1]] + val[i - 1], m[i - 1][j] ); // ecuacion de recurrencia 
				}else {  // si (j - peso[i]) < 0
					m[i][j] = m[i - 1][j];  // ecuacion de recurrencia
				}
			}
		}
		
		return m [n][cap];
	}
	
}
