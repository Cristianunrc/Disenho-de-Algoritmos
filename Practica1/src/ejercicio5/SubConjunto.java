package ejercicio5;

public class SubConjunto {
	
	/**
	 * Metodo que dice si un numero es igual a la suma de algun subconjunto del conjunto
	 * @param array representa el conjunto de enteros
	 * @param longitud la longitud - 1 del arreglo
	 * @param number el numero a buscar en el subconjunto
	 * @return true or false
	 */
	// Complejida : O (2^n * n) exponencial
	public boolean sumaSubConjunto (int [] array, int longitud, int number) {
		
		// Caso base o si la resta de numeros en la llamada recursiva llega a 0
		if (number == 0) {
			return true;
		}
		
		// si la longitud o el numero son negativos es porque no se encontro ningun subconjunto cuya suma sea igual al numero dado
		if (longitud < 0 || number < 0) {
			return false;
		}
		
		// se llama recursivamente al metodo con el arreglo, la longitud - 1 y el numero - numero del arreglo en la pos longitud
		boolean incluir = sumaSubConjunto (array, longitud - 1, number - array[longitud]);
		
		// se llama recursivamente al metodo con el arreglo, la longitud - 1 y el numero
		boolean excluir = sumaSubConjunto (array, longitud - 1, number);
		
		return incluir || excluir;
	}

}