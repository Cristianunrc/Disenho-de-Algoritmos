package ejercicio8prima;

public class Edge implements Comparable <Edge> {
	int src; // origen
	int dest; // destino
	int weigth; // peso
	
	@Override
	public int compareTo(Edge compareEdge) {
		return this.weigth - compareEdge.weigth;
	}
	
}
