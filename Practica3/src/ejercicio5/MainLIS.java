package ejercicio5;

public class MainLIS {

	public static void main(String[] args) {
		
		// sequence of integer
		int [] arre = {1,1,1,1,1,1,1,1,1,1,1,1,1,1};

		SubsecuenciaMasLarga sml = new SubsecuenciaMasLarga(arre.length);
		
		int maxValue = sml.longIncrSub(arre);
		
		System.out.println("The subsequence increasing more longer of is: " + maxValue);
		
	}

}
