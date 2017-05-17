public class Main {
	public static void main(String[] args) {
//		int v1[] = { 2, 5, 8, 12, 15, 21, 22, 24, 24, 27 };
//		int v2[] = { 2, 1, 28, 40, 36, 11, 72, 4, 44, 56 };
		int v3[] = { 5, 7, 9, 10, 45, 89, 99, 109, 290, 456, 5678 };
		System.out.println("¿Esta ordenado? "+dyVOrdenado(v3, 0, v3.length - 1));
	}

	public static boolean dyVOrdenado(int v[], int ini, int fin) {
		if (v.length == 2) {
			if (v[0] > v[1])
				return false;
			else
				return true;
		} else if (ini == fin) {
			return true;
		} else {
			int medio = (ini + fin) / 2;
			boolean izq = dyVOrdenado(v, ini, medio);
			boolean der = dyVOrdenado(v, medio + 1, fin);
			if ((izq && der) && (v[medio] <= v[medio + 1]))
				return true;
			else
				return false;
		}
	}
}