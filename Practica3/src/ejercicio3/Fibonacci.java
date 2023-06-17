package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	private static Map <Integer, Integer> cache = new HashMap <Integer, Integer>();
	
	/**
	 * Fibonacci recursivo. Ineficiente ya que es exponencial y ademas
	 * recomputa computos ya calculados.
	 * @param n un entero
	 * @return el fibonacci de n
	 */
	public static int fiboNormal (int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		
		return fiboNormal (n - 1) + fiboNormal (n - 2);
	}
	
	
	/**
	 * Metodo que utiliza memoization para fibonacci y asi evitar recomputos de computos.
	 * @param n
	 * @return
	 */
	public static int fiboMemo (int n) {
		
		// si el valor no esta computado entonces se computa.
		if (!cache.containsKey(n)) { 
			cache.put(n, fiboNormal(n)); 
		}
		
		// si el valor ya esta computado entonces se retorna
		return cache.get(n);
		
	}
	
	
	
	/**
	 * Metodo que calcula el fibonacci de un numero n, mediante asginacion de valores a variables.
	 * @param n numero a ser calculado el fibonacci
	 * @return fibonacci de n
	 */
	// Complejidad: O(n)
	public int fibonacciDinamico (int n) {
		
		int fib0, fib1, aux;
		
		if (n == 0) {
			return 0;
		}else {
			fib0 = 0;
			fib1 = 1;
			for (int i = 1; i < n; i++) {
				aux = fib0 + fib1;
				fib0 = fib1;
				fib1 = aux;
			}
			return fib1;
		}
		
	}

}