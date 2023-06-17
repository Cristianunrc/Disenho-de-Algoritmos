package mainsEje5;

import ejercicio5.Anagrama;

public class Main {

	public static void main(String[] args) {
		
		// Se pueden cambiar las cadenas para ir probando los resultados.
		String cadena = "atenas"; 
		String cadenaPermu = "satena";
		
		char [] a = cadena.toCharArray();
		char [] b = cadenaPermu.toCharArray();
		
		Anagrama obj = new Anagrama(a, b);
		
		boolean result = obj.esAnagrama();
		
		System.out.println(result);
		
	}

}
