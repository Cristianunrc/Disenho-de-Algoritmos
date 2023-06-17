package ejercicio5;

public class LongComSub {
	
	/**
	 * Metodo que toma dos strings (secuencias) y retorna la subsecuencia común más larga a ambas secuencias.
	 * @param x primer secuencia
	 * @param y segunda secuencia 
	 * @return un string LCS
	 */
	public String encontrarLCS (String x, String y) {
		
		int seqOne = x.length(); // sec1 recibe la longitud de x
		int seqTwo = y.length(); // sec2 recibe la longitud de y
		
		String s = "";
		
		// Caso base
		if (seqOne == 0) return s;  // sec1 = [] -> []
		
		if (seqOne == 1) { // secuencia x tiene un solo elemento
			
			// se busca el caracter comun en ambas secuencias
			for (int i = 0; i < seqTwo; i++) {
				if (y.charAt(i) == x.charAt(0)) { // charAt(index) trata el caracter corriente de la cadena y retorna
					return x;                    // su valor numerico ASCII
				}
			}
			return s; // sino retorna vacio
		}
		
		// Caso general
		
		int c = solveLCS (x, y); // O (n^2)
		
		String x1 = x.substring(0, seqOne/2); // primera mitad de la subcadena x
		String x2 = x.substring(seqOne/2, seqOne); // segunda mitad de la subcadena x
		
		// Encontrar la correcta particion de la secuencia y
		
		int j;
		for (j = 0; j < seqTwo; j++) {
			int c1 = solveLCS (x1, y.substring(0, j)); // LCS de la primera mitad
			int c2 = solveLCS (x2, y.substring(j, seqTwo)); // LCS de la segunda mitad
			
			if (c1 + c2 == c) {
				break; // si se ejecuta la condicion termina el ciclo
			}
		}
		
		// Hasta aqui j = una correcta particion de la secuencia y
		
		String y1 = y.substring(0, j);
		String y2 = y.substring(j, seqTwo);
		
		String sol1 = encontrarLCS (x1, y1); // T(n/2) 
		String sol2 = encontrarLCS (x2, y2); // T(n/2)
		
		return (sol1 + sol2); // concatena ambas cadenas
		
	}
	
	/**
	 * Metodo que retorna la LCS en forma de un entero. 
	 * @param p la primer secuencia de caracteres
	 * @param q la segunda secuencia de caracteres
	 * @return la longitud de LCS
	 */
	// O(n^2)
	private int solveLCS (String p, String q) {
		
		// incializar casos bases
		
		int [][] k = new int [40][40]; // matriz k 
		
		for (int j = 0; j < q.length() + 1; j++) {
			k [1][j] = 0;
		}
		
		for (int i = 1; i < p.length() + 1; i++) {
			
			// se copian las filas k[1][..] a las filas k[0][..]
			for (int j = 0; j < q.length() + 1; j++) {
				k[0][j] = k[1][j];
			}
			
			k[1][0] = 0;
			
			for (int j = 1; j < q.length() + 1; j++) {
				
				if (p.charAt(i - 1) == q.charAt(j - 1)) {
					k[1][j] = k[0][j - 1] + 1;
				}else {
					k[1][j] = Math.max(k[0][j], k[1][j - 1]);
				}
			}
		}
		
		// el valor de la sequencia de maxima longitud esta en k[1][q.lenght]
		return k[1][q.length()];
	}
	
}