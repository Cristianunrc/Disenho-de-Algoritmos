package ejercicio5;

public class SubsecuenciaMasLarga {

	private int [] lis; // declare array with longest increasing subsequence (lis)
	
	public SubsecuenciaMasLarga (int n) {
		lis = new int [n]; // initialize length of lis
	}
	
	/*
	 * Calculate the longest increasing subsequence of one sequence (array of ints)
	 */
	// Complexity: O (n^2)
	public int longIncrSub (int [] array) {
		
		
		int i, j, max = 0;
		
		// initialize all elements of lis[] in 1
		for (i = 0; i < array.length; i++) {
			lis[i] = 1;
		}
		
		// se compara el elemento de array[i] con el elemento predecesor array [j],
		// lo mismo ocurre con lis, se compara el elemento lis[i] con el predecesor lis[j] + 1,
		// si ambos evaluan a true, se actualiza el arreglo lis.
		for (i = 1; i < array.length; i++) {
			for (j = 0; j < i; j++) {
				if (array[i] > array[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		// se recorre lis, y se va actualizando en max el mayor elemento del arreglo.
		for (i = 0; i < lis.length; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}
		
		return max;
	}
		
}