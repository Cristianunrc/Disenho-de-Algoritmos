package ejercicio1;

import java.util.Arrays;

public class MainInversion {

	public static void main(String[] args) {
		
		double [] arreglo1 = {1,2,3,5,4,4,6};  
		
		// en arreglo2 se copia el arreglo1 y su longitud
		double [] arreglo2 = Arrays.copyOf(arreglo1, arreglo1.length); 

		Inversion arr = new Inversion ();
		int cantInversiones = arr.mergeSort(arreglo1, arreglo2, 0, arreglo1.length - 1);
		
		System.out.println("Cantidad de inversiones: " + cantInversiones);
		
	}

}
