package ejercicio5;

public class SubSecuencia {
	
	private char [] sec;
	private char [] subSec;
	
	/**
	 * Constructor donde se setean los arreglos.
	 * @param s1 arreglo de chars, la secuencia
	 * @param s2 arreglos de chars, la subsecuencia
	 */
	public SubSecuencia (char [] s1, char [] s2) {
		this.sec = s1;
		this.subSec = s2;
	}
	
	public boolean esSubsecuencia () {
		
		if (sec.length < subSec.length) throw new IllegalArgumentException ("La longitud de la subsecuencia no puede ser mayor que la secuencia.");
		
		int k = 0;
		
		for (int i = 0; i <= (sec.length - subSec.length); i++) {
			
			int j = k; // la variable j es inicializada en k.
			
			while (j < subSec.length && subSec[j] == sec[i + j] ) {
						k++;
						j = k; // en j guardo la ultima posicion recorrida del arreglo subSec
			}
			
			if (j == subSec.length) {
				return true;
			}
		}
		
		return false;	
	}
	
}