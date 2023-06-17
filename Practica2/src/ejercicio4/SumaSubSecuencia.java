package ejercicio4;

public class SumaSubSecuencia {

	private int [] array;
	private int s1; // atributos donde se almacenan los valores que retornan las funciones internas de sumaSubSecMin 
	private int s2;
	private int s3;
	
	public SumaSubSecuencia(int [] arre) {
		this.array = arre;
		s1 = 0;
		s2 = 0;
		s3 = 0;
	}
	
	public int sumaSubSecMin (int [] arreglo, int low, int high) {
		
		if (high <= low) { // si el arreglo tiene un elemento o es vacio
			return 0;
		}
		
		int mid = (low + high) / 2;
		
		s1 = sumaSubSecMin (arreglo, low, mid);
		s2 = sumaSubSecMin (arreglo, mid + 1, high);
		s3 = sumaMedio (arreglo, low, mid, high);
		
		return minTres (s1, s2, s3);
		
	}
	
	
	private int sumaMedio (int [] arreglo, int low, int mid, int high) {
		
		int r1 = 0, r2 = 0;
		
		r1 = sumaHaciaDerecha (arreglo, mid + 1, high); // suma los valores del arreglo [mid + 1 .. high]
		r2 = sumaHaciaDerecha (arreglo, low, mid); // suma los valores del arreglo [low .. mid]
		
		return r1 + r2;
		
	}
	
	
	private int sumaHaciaDerecha (int [] arreglo, int low, int high) {
		
		int sumMin = 0;
		int sumaAcum = 0;
		
		for (int i = low; i <= high; i++) {
			sumaAcum += arreglo [i];
			sumMin = Math.min (sumMin, sumaAcum);
		}
		
		return sumMin;
		
	}
	
	private int minTres (int x, int y, int z) {
		
		if (x <= y && y <= z) {
			return x;
		}else {
			if (y <= x && y <= z) {
				return y;
			}else {
				return z;
			}
		}
		
	}
	 	
}