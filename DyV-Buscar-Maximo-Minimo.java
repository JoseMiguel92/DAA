public class Main {

	public static void main(String[] args) {
		int v[] = { 10000, 20, 1, 1992, 11, 90, 54, 22 };
		int resultados[] = new int[2];
		dyVMaxMin(v, 0, v.length-1, resultados);
		System.out.println("El maximo es: " + resultados[1] + " y el minimo es: " + resultados[0]);
	}

	public static void dyVMaxMin(int v[], int ini, int fin, int resultados[]) {
		// Parte de Caso Base del problema.
		if (ini == fin) {
			resultados[0] = v[ini]; // Minimo
			resultados[1] = v[ini]; // Maximo
		} else {
			// Etapa de Division del problema.
			int medio = (ini + fin) / 2;
			int resultados1[] = new int[2];
			int resultados2[] = new int[2];
			dyVMaxMin(v, ini, medio, resultados1);
			dyVMaxMin(v, medio + 1, fin, resultados2);
			// Etapa de Combinacion del problema.
			if (resultados1[0] < resultados2[0])	//Metemos el minimo
				resultados[0] = resultados1[0];
			else
				resultados[0] = resultados2[0];
			
			if (resultados1[1] > resultados2[1])	//Metemos el maximo
				resultados[1] = resultados1[1]; 
			else
				resultados[1] = resultados2[1];
		}
	}	
}
