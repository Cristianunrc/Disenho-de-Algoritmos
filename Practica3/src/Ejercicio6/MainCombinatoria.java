package Ejercicio6;

import java.util.HashMap;
import java.util.Map;

public class MainCombinatoria {

	public static void main(String[] args) {
		
		int n = 20, m = 10;
		long timeBegin, timeEnd; // tiempo inicial, tiempo final
		double timeCombRecursive, timeCombDinamica; // tiempo total de la combinatoria recursiva
		
		Combinatoria comb = new Combinatoria();
		Tuple <Integer, Integer> cache = new Tuple <> (n,m);
		Map <Tuple <Integer, Integer>, Integer> val = new HashMap <>();
		
		// Tiempo de la combinatoria recursiva (original)
		timeBegin = System.nanoTime();
		int c1 = comb.combRecursive(n, m);
		timeEnd = System.nanoTime();
		
		timeCombRecursive = nanoSToS (timeEnd, timeBegin);
		
		// Tiempo de la combinatoria dinamica
		timeBegin = System.nanoTime();
		int c2 = comb.combDinamica(n, m);
		timeEnd = System.nanoTime();
		
		timeCombDinamica = nanoSToS(timeEnd, timeBegin); 
		
		
		int c3 = comb.combMemo(cache, val);
		
		
		System.out.println("Combinatoria recursiva " + c1 + ", tiempo " + timeCombRecursive);
		System.out.println ("Combinatoria dinamica " + c2 + ", tiempo " + timeCombDinamica);
		System.out.println ("Combinatoria memoization " + c3 + ", tiempo ");
	
	}
	
	
	/**
   	 * Metodo privado que transforma el tiempo de nano-segundos a segundos.
   	 * @param a es el tiempo inicial en nanoSec
   	 * @param b es el tiempo final en nanoSec
   	 * @return res, el tiempo en segundos
   	 */
    private static double nanoSToS (long a, long b) {
        double res = (double) (a-b) / 1_000_000_000.0;
        return res;
    }

}
