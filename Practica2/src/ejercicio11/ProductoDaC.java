package ejercicio11;

public class ProductoDaC {
	
	private int acum;
	
	/**
	 * Retorna el producto de dos enteros, mediante la técnica decrease and conquer
	 * con decremento por una constante.
	 * El valor b >= 0
	 * @return producto de dos enteros
	 */
	public int prodDecConst (int a, int b) {
		if (b < 0) throw new IllegalArgumentException ("b must be 0 or positive.");
		
		if (a == 0 || b == 0) return 0; 
			
			acum ++; // cuenta la cantidad de sumas que se realizan, acum es igual al valor de b.
			return a + prodDecConst (a, b - 1); // el b - 1 es el decremento por una constante (by one)
	}
	
	
	/**
	 * Multiplicación por el metodo ruso. Usando la tecnica decrease and conquer por decremento por un factor constante
	 * (by 2).
	 * @param a primer numero del producto
	 * @param b segundo numero del producto
	 * @return el resultado del producto
	 */
	public int prodDecFactorConst (int a, int b) {
		int result = 0;
		setAcum(); // invoca a setAcum para setear acum en 0
		
		while (b > 0) {
			if (b % 2 != 0) { // si b es impar
				result = result + a;
			}
			a = a * 2;
			b = b / 2; // decremento por un factor constante (b/=2)
			acum ++; // las veces que se ejecuta el while
		}
		return result;
	}
	
	
	/**
	 * Setter del acumulador
	 */
	public void setAcum () {
		this.acum = 0;
	}
	
	/**
	 * Getter del acumulador
	 * @return un entero
	 */
	public int getAcum () {
		return acum;
	}
	
}