package ejercicio7;

import java.lang.reflect.Array;

public class EliminaRepetidos <T> {
	
	public static final int Max = 30;
	private T [] array;
	int cantidad;
	
	/**
	 * Constructor donde seteo el arreglo y la cantidad
	 * @param arre
	 */
	public EliminaRepetidos (T [] arre) {
		this.array = arre;
		cantidad = 0;
	}
	
	
	/**
	 * Metodo mergeSort donde ordena los elementos de un arreglo.
	 * @param array es el arreglo a ordenar.
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] array) {	   
		  // Se invoca al metodo privado sort. 
	      sort( array, 0, array.length-1);
	   }
	
	/**
	 * Metodo de ordenamiento mergeSort.
	 * @param arreglo el arreglo de elementos
	 * @param left la primer posicion del arreglo 0
	 * @param right la ultima posicion del arreglo arreglo.length - 1
	 */
	// Complejidad: O ( n * log(n) )
	private static <T extends Comparable<? super T>> void sort (T [] arreglo, int left, int right){
	      
		   if(left < right){
			   
			   //Encuentra el punto medio del vector.
			   int middle = (left + right) / 2;
			   
			   //Divide la primera y segunda mitad (llamada recursiva).
			   sort(arreglo, left, middle);
			   sort(arreglo, middle+1, right);
			   //Une las mitades.
			   merge(arreglo, left, middle, right, arreglo[0].getClass() );
	      }

	   }
	
	
	/**
	 * Metodo merge invocado dentro del metodo mergeSort.
	 * @param array
	 * @param left
	 * @param middle
	 * @param right
	 * @param type
	 */
	// Complejidad: O (n) lineal
	private  static <T extends Comparable<? super T>> void merge (T[] array, int left, int middle, int right, Class type ) {
	      
		  //Tamaño de los sub arreglos
	      int n1 = middle - left + 1;
	      int n2 = right - middle;

	      //Arrays auxiliares

	      T[] leftArray = (T[]) Array.newInstance( type, n1 );
	      T[] rightArray = (T[]) Array.newInstance( type, n2 );

	      //Copiar datos a arrays auxiliares

	      for (int i=0; i < n1; i++) {
	        leftArray[i] = array[left+i];
	      }

	      for (int j=0; j < n2; j++) {
	        rightArray[j] = array[middle + j + 1];
	      }

	      /* Unir los arrays temporales */    
	      //Indices del primer y segundo subvector.
	      int i = 0, j = 0;

	      //Indice inicial del sub array parametro.
	      int k = left;

	      //Ordenamiento.
	      while (i < n1 && j < n2) {
	        if ( leftArray[i].compareTo( rightArray[j] ) <= 0 ) {
	          array[k] = leftArray[i];
	          i++;
	        } else {
	            array[k] = rightArray[j];
	            j++;
	        }
	        k++;

	      }
	      /* Si quedan elementos por ordenar */
	      //Copiar los elementos restantes de leftArray[].

	      while (i < n1) {
	        array[k] = leftArray[i];
	        i++;
	        k++;
	      }

	      //Copiar los elementos restantes de rightArray[].
	      while (j < n2) {
	        array[k] = rightArray[j];
	        j++;
	        k++;
	      }
	    }
	
	
	/**
	 * Elimina los elementos repetidos en un arreglo.
	*/
	// Complejidad: O(n ^ 2)
	public void borraDuplicados () {
		
		if (array.length <= 1) throw new IllegalArgumentException ("Nada que eliminar");
		
		int i = 0, j = 0;
		while (i < array.length) {
			array[j] = array[i]; // el arreglo se va asignando valores a si mismo
			j++; 
			i++;
			while (i < array.length && array[i] == array[i - 1]) {
					i++;
			}
		}
		cantidad = j; // en cantidad se almacena la longitud del arreglo, donde lleva la cuenta el j
	}
	
	/**
	 * Muestra los elementos del arreglo.
	 */
	public void mostrarArreglo () {
		for (int j = 0; j < cantidad; j++) {
			System.out.println(array[j]);
		}
	}
	
}	