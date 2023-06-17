package ejercicio10;

public class MainMochila {

	public static void main(String[] args) {
		
		int [] valores = {12, 10, 20, 15}; // valores de los items
		int [] pesos = {2, 1, 3, 2}; // peso de cda item
		
		int capacidad = 5;  // capacidad o volumen de la mochila
		
		Mochila sack = new Mochila ();
		
		int result = sack.llenarMochicla(valores, pesos, capacidad);

		System.out.println(result);
	}

}
