package ejercicio7;

public class MainRepetidos {

	public static void main(String[] args) {
		
		//Character [] arregloChars = {'a','b','a','b','c','d','a','c'};
		
		Integer [] arregloInts = {1,1,1,1,1,2,1,1,1,6,1,9,2,9,3,6};
		
		EliminaRepetidos <Integer> arreInt = new EliminaRepetidos <Integer> (arregloInts);
		
		arreInt.mergeSort(arregloInts); // se ordena el arreglo, O (n * log(n) )
		arreInt.borraDuplicados(); // se eliminan repetidos, O (n ^ 2)
		arreInt.mostrarArreglo(); // se muestran elementos del arreglo

	}

}
