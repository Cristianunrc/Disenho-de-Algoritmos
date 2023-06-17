package ejercicio8prima;

import java.util.*;

public class Graph {

	int vertices; // vertices o nodos
	int edges; // arcos o aristas
	Edge[] arcos; // arreglos de arcos
	
	/**
	 * Constructor Graph
	 * @param v cant de vertices
	 * @param e cant de arcos
	 */
	public Graph(int v, int e) {
		this.vertices = v;
		this.edges = e;
		arcos = new Edge[edges]; // se inicializa el array arcos con el tamaño de edges (cantidad de artistas)
		for (int i = 0; i < edges; ++i) {
			arcos[i] = new Edge(); // cada elemento del array arcos va a referenciar a la clase Edge
		}
	}
	
	/**
	 * Retorna la clase de equivalencia
	 * @param sub un arreglo de SubSet (sub conjuntos)
	 * @param i un entero
	 * @return una clase de equivalencia
	 */
	public int find (SubSet[] sub, int i) {
		if (sub[i].parent != i) {
			sub[i].parent = find(sub, sub[i].parent);
		}
		return sub[i].parent;
	}
	
	/**
	 * Une las clases de equivalencias de los elementos x e y
	 * @param sub un arreglo de SubSet
	 * @param x un entero
	 * @param y un entero
	 */
	public void union (SubSet[] sub, int x, int y) {
		int xroot = find(sub, x); // en xroot se almacena la clase de equivalencia del x
		int yroot = find(sub, y); // en yroot se almacena la clase de equivalencia del y
		
		if (sub[xroot].rank < sub[yroot].rank) { // si el rango de la raiz x es < que el rango de la raiz y
			sub[xroot].parent = yroot;          // el padre de la raiz x sera la raiz y
		}else {
			if(sub[xroot].rank > sub[yroot].rank) { // si el rango de la raiz x es > que el rango de la raiz y
				sub[yroot].parent = xroot;          // el padre de la raiz y sera la raiz x 
			}else { // si ambos rangos son iguales
				sub[yroot].parent = xroot;
				sub[xroot].rank ++;
			}
		}
	}
	
	/**
	 * Algoritmo de kruskal (arbol abarcador minimo), calcula los caminos mas cortos entres cada par de nodos.
	 * Construye un arbol dirigido, conexo y aciclico.
	 */
	public void kruskal() {
		Edge[] result = new Edge [vertices];
		
		for(int i = 0; i < vertices; ++i) {
			result[i] = new Edge(); //cada elemento del arreglo result referenciara a la clase edge
		}
		
		// ordena el arreglo arcos en orden ascendente
		Arrays.sort(arcos);
		SubSet[] sub = new SubSet[vertices]; // inicializo el arreglo sub con un tamaño de vertices
		for(int i = 0; i < vertices; ++i) {
			sub[i] = new SubSet(); // cada elemento del arreglo sub referenciara a la clase SubSet
		}
		
		for(int v = 0; v < vertices; ++v) {
			sub[v].parent = v; // 0, 1, 2, ..., vertices - 1
			sub[v].rank = 0; // 0, 0, 0, ..., hasta vertices - 1
		}
		
		int e = 0;
		int i = 0;
		while(e < vertices - 1) {
			Edge next_edge = new Edge();
			next_edge = arcos[i++]; // next_edge = arcos[i] ; i++; (asigna y luego incrementa)
			int x = find (sub, next_edge.src); // en x almaceno la clase de equivalencia del nodo origen
			int y = find (sub, next_edge.src); // en y almaceno la clase de equivalencia del nodo destino
			
			if (x != y) { // si ambos arcos estan en clases de equivalencias distintas
				result[e++] = next_edge; // el elemento del arreglo en la posicion e recibe el arco con menor costo
				union(sub, x, y); // se realiza la union de las clases de equivalencia
			}
		}
	}
	
	
private class SubSet{
	int parent;
	int rank;
}
	
}
