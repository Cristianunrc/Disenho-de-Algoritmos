package ejercicio5;

public class MainMochilaGreedy {

	public static void main(String[] args) {
		
		// array de elementos pares (valor, peso)
		ItemValue [] array = { new ItemValue (100, 20), 
				               new ItemValue (60, 10), 
				               new ItemValue (120, 30)}; 
		
		int capacidad = 50; // capacidad de la mochila
		
		MochilaGreedy sack = new MochilaGreedy ();
		
		double res = sack.knapSack(array, capacidad);
		
		System.out.println ("El maximo valor de items a meter en la mochila es : " + res);
	}

}
