package ejercicio11;

public class MainProd {

	public static void main(String[] args) {
		
		int x = 4;
		int y = 3;
		
		ProductoDaC prod = new ProductoDaC ();
		
		int rDecConst = prod.prodDecConst(x, y);
		int cantOp1 = prod.getAcum();
		int rDecFactConst = prod.prodDecFactorConst(x, y);
		int cantOp2 = prod.getAcum();
		
		System.out.println("Producto decremento por una constante: " + rDecConst);
		System.out.println ("Producto decremento por un factor constante: " + rDecFactConst);
		System.out.println ("Operaciones realizadas en decremento por una constante: " + cantOp1);
		System.out.println ("Operaciones realizadas en decremento por un factor constante: " + cantOp2);
		

	}

}
