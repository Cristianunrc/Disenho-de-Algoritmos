package ejercicio5;

public class MainLCS {

	public static void main(String[] args) {
		
		String secuencia1 = "matamoscas"; // long = 7
		String secuencia2 = "amapola"; // long = 10
		
		LongComSub s = new LongComSub ();
		
		String result = s.encontrarLCS(secuencia1, secuencia2);
		
		System.out.println(result);

	}

}
