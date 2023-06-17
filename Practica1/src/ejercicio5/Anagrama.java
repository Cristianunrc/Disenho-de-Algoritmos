package ejercicio5;

public class Anagrama {
	
	public static final int Max = 50;
	private char [] arrayA;
	private char [] arrayB;
	
	/**
	 * Constructor donde se setean los arreglos
	 * @param arrA un arreglo de caracteres
	 * @param arrB un arreglo de caracteres
	 */
	public Anagrama (char [] arrA, char [] arrB) {
		
		this.arrayA = arrA;
		this.arrayB = arrB;
	}
	
	
	/**
	 * Metodo que dice si un arreglo de caracteres es un anagrama de otro arreglo de caracteres.
	 * @return boleano
	 */
	public boolean esAnagrama () {
		
		if (arrayA.length != arrayB.length) {
			return false;
			
		}else {
		
			boolean var = true;
			int i = 0;
			while(i < arrayA.length && var) {
			
				int j = 0;
				boolean find = false;
			
				while(j < arrayB.length && !find) {
					if (arrayA[i] == arrayB[j]) {
						find = true;
					}else {
						j++;
					}
				}
			
				if(find) {
					arrayB[j] = 0; // el cero es como un null
				}else {
					var = false;
				}
			
				i++;
			}
		
			return var;
		}
	}

}