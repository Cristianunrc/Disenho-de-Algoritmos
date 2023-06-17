package coloreoGrafos;

import java.util.Arrays;

public class ColoreadoDeGrafos{
    
    public int matrizAdyacencia[][];
    public int [] colores;
    public int nColores; // cantidad minima de colores a usar
    public int nNodos;
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private int getColorNodo(int k) {
    	
        do { 
            colores[k] = colores[k] + 1; // asigna el siguiente color
            
            if (colores[k] == nColores + 1) return 0; // si todos los colores han sido probados en el nodo, no lo pinta
            
            int j;
            
            for (j = 1; j <= nNodos; ++j){ // comprueba si algún nodo conectado a este ya tiene este color
            	
                if (matrizAdyacencia[k][j] == 1 && colores[k] == colores[j] && k != j){ 
                    break;
                }
            }  
            if (j == nNodos + 1) return colores[k];
            
        } while(true);
        
    }
    
    public void mColorear(int k) {
    	
        do { 
            colores[k] = getColorNodo(k); // pinta de un color a este nodo
            
            if (colores[k] == 0) return; // si ya se han repartido todos los colores, acaba
            
            if (k == nNodos) { // si se han coloreado todos los nodos correctamente, imprime la solución. Este algoritmo ofrece todas las soluciones posibles
                System.out.println(Arrays.toString(colores));
            }else {
            	mColorear(k + 1); // si todavía no se ha coloreado todo el grafo, entonces continuamos
            }
            
        } while(true);
    }
    
}