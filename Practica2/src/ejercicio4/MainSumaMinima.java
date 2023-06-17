package ejercicio4;

public class MainSumaMinima {

	public static void main(String[] args) {

		int [] array = {3, 3, 4, 0, -1};
		
		SumaSubSecuencia sumaMin = new SumaSubSecuencia (array);
		
		int resultado = sumaMin.sumaSubSecMin(array, 0, array.length - 1);
		
		System.out.println ("La subsecuencia de suma minima es: " + resultado);

	}

}
