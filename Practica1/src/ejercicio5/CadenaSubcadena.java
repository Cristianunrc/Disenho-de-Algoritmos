package ejercicio5;

public class CadenaSubcadena {

	public static final int Max = 40;
	private char [] cad1;
	private char [] cad2;
	
	/**
	 * Constructor donde se setean ambos arreglos.
	 * @param cadena1 un arreglo de chars
	 * @param cadena2 un arreglo de chars
	 */
	public CadenaSubcadena (char [] cadena1, char [] cadena2) {
		this.cad1 = cadena1;
		this.cad2 = cadena2;
	}
	
	/**
	 * Metodo que dice si una cadena es subcadena de otra.
	 * @return true or false
	 */
	public boolean esSubcadena () {
	
		if (cad1.length < cad2.length) throw new IllegalArgumentException ("La longitud de la subcadena no puede ser mayor que la cadena.");
		
		for (int i = 0; i <= (cad1.length - cad2.length); i++) {
			
			int j = 0;
			while (j < cad2.length && cad2[j] == cad1[i + j] ) {
						j++;
			}
			
			if (j == cad2.length) {
				return true;
			}
		}
		
		return false;	
	}
	
}