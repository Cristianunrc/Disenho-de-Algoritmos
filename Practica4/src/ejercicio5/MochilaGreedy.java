package ejercicio5;

import java.util.Arrays;
import java.util.Comparator; // Interface

public class MochilaGreedy {
	
	/**
	 * Calcula la cantidad maxima de valores de items que se pueden meter en una mochila.
	 * Se utiliza la tecnica de greedy.
	 * @param arre el arreglo con elementos (cada elemento es un par)
	 * @param capacity la capacidad o volumen de la mochila
	 * @return el maximo valor de items a meter en la mochila
	 */
	
	// Complexity: O( n*log(n) )
	public double knapSack (ItemValue [] arre, int capacity) {
		
		// se ordena el arreglo en orden decreciente por la relacion (valor / peso)
		Arrays.sort(arre, new Comparator <ItemValue> () {
			
			// se calcula la relacion (valor/peso) por cada item
			@Override
			public int compare (ItemValue item1, ItemValue item2) {
							
				// fract1 recibe el resultado de (valor/peso) del item corriente
				double fract1 = new Double ((double) item1.value / (double) item1.weigth);
				
				// fract2 recibe el resultado de (valor/peso) del item corriente
				double fract2 = new Double ((double) item2.value / (double) item2.weigth);
				
				if (fract1 < fract2) {
					return 1; // si retona 1, se realiza un "swap"
				}else { // fract1 >= fract2
					return -1;  // si retorna -1 no ocurre nada.
				}
			}
			
			
		});
		
		double maxValueItems = 0;
		
		// for (i = 0, i < arre.length, i++)
		for (ItemValue i : arre) {
			
			int pesoCorriente = (int) i.weigth;
			int valorCorriente = (int) i.value;
			
			// si la capacidad - peso >= 0
			if (capacity - pesoCorriente >= 0) {
				
				// se mete el item en la mochila
				capacity = capacity - pesoCorriente; // se actualiza la capacidad
				maxValueItems += valorCorriente;  // se actualiza el valor
			}else {
				
				// se fracciona el item (se parte) para que entre en la mochila
				
				double fract = ((double) capacity / (double) pesoCorriente ); // fracciono el peso
				maxValueItems += (valorCorriente * fract);  // se multiplica el valor del item por el peso fraccionado
				capacity = (int) (capacity - (pesoCorriente * fract));
				break; // rompemos el loop
			}
		}
		
		return maxValueItems;
	}
	
}
