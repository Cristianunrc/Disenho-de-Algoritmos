package ejercicio3;

public class MainFibo {

	public static void main(String[] args) {
		
		int num = 42; // num es de tipo long para tener una mayor representacion numerica del fibonacci
		
		Fibonacci f = new Fibonacci ();
		
		//int m = f.fiboNormal(num);
		int r = f.fiboMemo(num);
		
		System.out.println ("Fibonacci de " + num + " con memo es " + r);
		//System.out.println ("Fibonacci de " + num + " con normal es " + m);

	}

}
