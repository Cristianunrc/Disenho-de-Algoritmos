package mainsEje5;

import ejercicio5.SubConjunto;

public class MainSubConjunto {

	public static void main(String[] args) {
		
		int [] arreglo = {4,7,1,6}; // incializo el arreglo con numeros
		int num = 0; // el numero que sea igual a la suma de subconjunto/s

		SubConjunto numIgualSub = new SubConjunto ();
		
		boolean ans = numIgualSub.sumaSubConjunto(arreglo, arreglo.length - 1, num);
		
		System.out.println("Existe alguna suma de subconjunto en el conjunto que sea igual a " + num + " : " + ans);
	}

}
