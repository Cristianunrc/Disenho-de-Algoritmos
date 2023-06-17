package Ejercicio6;

import java.util.HashMap; // HashMap es una clase que implementa la interface Map
import java.util.Map;
import Ejercicio6.Tuple; // Importo la clase Tuple para utilizarla

public class Combinatoria {

			// Map <K, V> where k is the type of keys maintained by this map
	        //            where V is the type of mapped values
	private Map <Tuple <Integer, Integer>, Integer> cache = new HashMap <>();
	
	
	/**
	 * Combinatoria recursiva.
	 * @param n un entero
	 * @param m un entero
	 * @return la combinatoria
	 */
	// Complexity: O (a^n) exponencial
	public int combRecursive (int n, int m) {
		
		if (n < 0 || m < 0) {
			throw new IllegalArgumentException("m or n must be no negatives.");
		}
		
		if (m > n) {
			return 0;
		}
		
		if (m == 0 || m == n) {
			return 1;
		}
		
		return combRecursive (n - 1, m - 1) + combRecursive (n - 1, m);
	}
	
	/**
	 * Combinatoria con tecnica dynamic
	 * @param n un entero
	 * @param m un entero
	 * @return la combinatoria
	 */
	// Complexity: O (n) lineal 
	// Anda, pero probarlo
	public int combDinamica(int n, int m) {
		
		if (n < 0 || m < 0) {
			throw new IllegalArgumentException("m or n must be no negatives.");
		}
		
		if (m > n) {
			return 0;
		}
		
		int c = 1; // c store the number comb
		
		if (m > n/2) {
			m = n - m;
		}
		
		for (int i = 1; i <= m; i++) {
			c = c * (n - i + 1) / i;
		}
		
		return c;
	}
	
	/**
	 * Combinatoria usando memoization (programacion dinamica).
	 * @param tup
	 * @param val
	 * @return
	 */
	public int combMemo (Tuple<Integer, Integer> tup, Map <Tuple<Integer,Integer>, Integer> val) {
		
		int n = tup.getFirst();  // recupero el valor de n
		int m = tup.getSecond(); // recupero el valor de m

		
		if (!cache.containsKey(tup)) { // containsKey (Object key)
			cache.put(tup, combRecursive(n,m));  // put (Integer key, Integer value)
		}
		
		if (n < 0 || m < 0) throw new IllegalArgumentException ("numbers must be no negatives.");
		
		if (m > n) return 0;
		
		if (m == 0 || m == n) return 1;
		
		Tuple <Integer, Integer> fst = new Tuple <> (n - 1, m -1); // primera recurrencia
		Tuple <Integer, Integer> snd = new Tuple <> (n - 1, m); // segunda recurrencia
		
		int result = combMemo (fst, val) + combMemo (snd, val); 
		
		return cache.get(result);  // get (Object key)
		
	}
	
}