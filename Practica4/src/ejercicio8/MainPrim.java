package ejercicio8;

public class MainPrim {

	public static void main(String[] args) {
		
		int cantNodos = 9;
		
		Graph g = new Graph (cantNodos);
		
		g.addAdyacente(0, 1, 4); // (nodo u, nodo v, peso(u,v))
		g.addAdyacente(0, 7, 8);
		g.addAdyacente(1, 2, 8);
		g.addAdyacente(1, 7, 11);
		g.addAdyacente(2, 3, 7);
		g.addAdyacente(2, 8, 2);
		g.addAdyacente(2, 5, 4);
		g.addAdyacente(3, 4, 9);
		g.addAdyacente(3, 5, 14);
		g.addAdyacente(4, 5, 10);
		g.addAdyacente(5, 6, 2);
		g.addAdyacente(6, 7, 1);
		g.addAdyacente(6, 8, 6);
		g.addAdyacente(7, 8, 7);
		
		g.prims();
	}

}
