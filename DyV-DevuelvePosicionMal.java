public class Main {
	public static void main(String[] args) {
		// int v1[] = { 7, 3, 4, 5, 10, 12, 22, 36, 41, 48, 57 };
		int v2[] = { 1, 3, 4, 5, 10, 12, 22, 13, 41, 48, 57 };
		// int v3[] = { 1, 3, 4, 5, 10, 12, 22, 36, 41, 48, 21 };
		System.out.println("La posicion incorrecta es la " + dyVPosicion(v2, 0, v2.length - 1));
	}

	public static int dyVPosicion(int v[], int ini, int fin) {
		// Parte de Casos Base del problema.
		if (ini == fin) {
			return -1; // No hay posición que este mal por que solo hay un
						// numero.
		} else if (v.length == 2) { // Suponemos que hay 2 numeros en el vector.
			if (v[ini] <= v[fin]) // Comparamos que el primer numero es menor
									// que el segundo, si es asi, esta bien,
									// devolvemos -1.
				return -1;
			else
				return fin;
			// Parte Recursiva del problema.
		} else {
			int medio = (ini + fin) / 2;
			if (v[medio] > v[medio + 1]) // Comprobamos si el que esta mal
											// colocado esta en medio de las dos
											// partes.
				return medio + 1;
			// Parte de Division del problema.
			int izq = dyVPosicion(v, ini, medio);
			if (izq < 0) { // Aqui comparamos en que parte del vector esta el
							// problema.
				return dyVPosicion(v, medio + 1, fin); // Como la parte
														// izquierda tiene un -1
														// (Esta bien)
														// devolvemos la otra
														// parte.
			} else
				return izq;
		}
	}
}