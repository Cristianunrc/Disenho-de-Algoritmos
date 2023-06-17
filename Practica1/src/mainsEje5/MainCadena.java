package mainsEje5;

import ejercicio5.CadenaSubcadena;

public class MainCadena {

	public static void main(String[] args) {
		
		String str1 = "atenasu"; // cadena     
		String str2 = "nasm"; // subcadena 
		
		char [] cad1 = str1.toCharArray(); // transformo el string str1 en un arreglo de caracteres y lo almaceno en el array cad1
		char [] cad2 = str2.toCharArray(); // realizo lo mismo que la linea anterior
		
		CadenaSubcadena cadSub = new CadenaSubcadena (cad1, cad2);
		
		boolean resultado = cadSub.esSubcadena();
		
		System.out.println(resultado);

	}

}
