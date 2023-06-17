package coloreoGrafos;

public class Main {

	public static void main(String[] args) {
		
		ColoreadoDeGrafos coloreoGraph = new ColoreadoDeGrafos();
		 
		coloreoGraph.nColores = 3; // seleccionamos 3 colores, por ejemplo. La matriz de adyacencia indica 1 si los nodos están conectados, y 0 si no
		coloreoGraph.matrizAdyacencia = new int[][]{{0, 0, 0, 0, 0}, {0, 1, 1, 0, 1}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 1, 1, 1, 1}}; 
		coloreoGraph.nNodos = coloreoGraph.matrizAdyacencia.length - 1; // cantidad de nodos de nuestro grafo
		coloreoGraph.colores = new int[coloreoGraph.nNodos + 1]; // este es el array que nos dará la solución con los colores de los nodos
		coloreoGraph.mColorear(1);

	}

}