package ejercicio1;

public class Inversion {
	
	/**
	 * Cuenta la cantidad de inversiones (o swaps) que se hacen en el arreglo, usando mergeSort (divide and conquer)
	 * @param array1  arreglo de float
	 * @param array2  arreglo de float
	 * @param low  posición 0
	 * @param high  posición lenght - 1
	 * @return cantidad de inversiones que se hace en el array
	 */
	// Complejidad: O(n * log(n) )
	public static int mergeSort (double [] array1, double [] array2, int low, int high) {
		
		if (high <= low) return 0; // caso base, si el arreglo esta vacio o si tiene un solo elemento
		
		int mid = (low + high) / 2; // en mid se almacena la longitud media del arreglo
		int invCount = 0;
		
		// se divide la mitad izq del array recursivamente y se actualiza invCount 
		invCount = invCount + mergeSort (array1, array2, low, mid);
		
		// se divide la mitad derecha del array recursivamente y se actualiza invCount
		invCount = invCount + mergeSort (array1, array2, mid + 1, high);
		
		// se unen las dos mitades del arreglo y se vuelve actualizar invCount
		invCount = invCount + merge (array1, array2, low, mid, high); 
		
		return invCount;
		
	}
	
	
	/**
	 * Metodo que toma las dos mitades ordenadas del arreglo y las une.
	 * @param array1 el arreglo ordenado [0..mid]
	 * @param array2 el arreglo ordenado [mid+1..high]
	 * @param low primera posicion 0
	 * @param mid posicion media
	 * @param high posicion length - 1
	 * @return un entero
	 */
	// Complejidad: O (n)
	private static int merge (double [] array1, double [] array2, int low, int mid, int high) {
	
		int i = low, k = low, j = mid + 1;
		int invCount = 0;
		
		// mientras haya elementos en las mitades izq y der de los arrays
		while (i <= mid && j <= high) {
			if (array1[i] <= array1[j]) {
				array2[k] = array1[i];
				k++;                   // estas tres lineas se pueden resumir en array2[k++] = array1[i++], asigna y luego incrementa
				i++;					
			}else {
				array2[k] = array1[j];  
				k++;                   // es lo mismo que hacer arra2[k++] = array1[j++]
				j++;
				invCount = invCount + (mid - i + 1); // se actualiza el contador
			}
		}
		
		// copia los elementos restantes
		while (i <= mid) {
			array2[k] = array1[i];
			k++;
			i++;
		}
		
		// se copian los elementos de array2 a array1
		for (i = low; i <= high; i++) {
			array1[i] = array2[i];
		}
		
		return invCount;
	}

}