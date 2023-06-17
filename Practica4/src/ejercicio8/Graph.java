package ejercicio8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;
/**
 * Esta clase representa un grafo dirigido usando
 * una representacion de lista de adyacencia
 */
public class Graph {

	private int vertex; // number of vertex
	
	// List <E> donde E es el tipo de elementos en la lista
	// En un grafo con costos, necesitamos almacenar el par de
	// vertices y pesos por cada adyacente
	List <List<Par>> adj;
	
	public Graph (int v) {
		this.vertex = v;
		adj = new ArrayList<>();
		for (int i = 0; i < vertex; i++) {
			adj.add(new ArrayList<>()); // se adhieren los nodos al arrayList
		}
	}
	
	/**
	 * Añade al grafo los vertices adyacentes con peso 
	 * @param u un vertice
	 * @param v otro vertice
	 * @param w el peso o distancia entre el vertice u y v
	 */
	public void addAdyacente (int u, int v, int w) {
		adj.get(u).add(new Par(u, w)); // retorna el vertice u y lo adhiere al grafo como un par (vertice, peso)
		adj.get(v).add(new Par (v, w));
	}
	
	
	public void prims() {
		
		// Se crea una cola de prioridad donde se almacenan los vertices que
		// comienzan con el arbol abarcador minimo
		PriorityQueue<Par> q = new PriorityQueue<>(
									vertex, new Comparator<Par>() {
										public int compare(Par a, Par b) {
											return a.first - b.second;
										}
									});
		
		int src = 0;
		
		// Se crea un arreglo key donde se inicializa todos los elementos de key en infinito
		int infinity = Integer.MAX_VALUE; // (2^31) - 1 -> cota superior de in Integer
		int [] key = new int[vertex];
		Arrays.fill(key, infinity); // se asigna el valor de infinity a cada elemento del arreglo
		
		// se crea un arreglo para llevar un registro de los vertices incluidos en el arbol abarcador minimo
		boolean [] inAAM = new boolean[vertex];
		int [] parent = new int[vertex];
		
		q.offer(new Par(0, src)); // inserta src en la cola de prioridad, el costo del nodo inicial a si mismo es cero
		key[src] = 0;
		
		while(!q.isEmpty()) {
			
			// Se retorna la cabeza de la cola (el primer elemento) considerando second, es decir, el peso.
			int u = q.peek().second;
			q.poll();
			
			if(inAAM[u]) {
				continue;
			}
			
			inAAM[u] = true; // se incluye al vertice en el aam
			
			// i es usado para retornar todos los vertices adyacentes a un vertice
			for (Par i : adj.get(u)) {
				
				int v = i.first; // en v se almacena el vertice adyacente a u
				int w = i.second; // en w se almacena el peso de u a v -> peso(u,v)
				
				// si v no esta en aam y el peso(u,v) es menor que el elemento corriente de key
				if (!inAAM[v] && key[v] > w) {
					// se actualiza el key del vertice v
					key[v] = w;
					q.offer(new Par(key[v], v));
					parent[v] = u;
				}
			}
		}
	
		// imprime los adyacentes del arbol abarcador minimo usando el arreglo parent
		
		for(int i = 1; i < vertex; i++) {
			System.out.println(parent[i] + " - " + i);
		}
	
	}
	
}