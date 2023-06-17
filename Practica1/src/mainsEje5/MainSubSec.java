package mainsEje5;

import ejercicio5.SubSecuencia;

public class MainSubSec {

	public static void main(String[] args) {
		
		String seq = "holacristian"; // secuencia
		String subSeq = "oaiiam"; // subsecuencia
		
		// convierto los strings en arreglo de chars y los almaceno
		char [] sq = seq.toCharArray();
		char [] suSq = subSeq.toCharArray();
		
		SubSecuencia s = new SubSecuencia (sq, suSq);
		
		boolean resultado = s.esSubsecuencia();
		
		System.out.println (subSeq + " es subsecuencia de " + seq + " : " + resultado);
	}

}
