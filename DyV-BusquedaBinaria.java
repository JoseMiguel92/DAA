
public class Main {
	public static void main(String args[]) {
		int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int e = 3;
		int posicion = DyV(v, 0, v.length - 1, e);
		System.out.println("La posicion del numero " + e + " es la " + posicion);
	}

	public static int DyV(int v[], int ini, int fin, int elemento) {
		if (ini == fin) {
			if (v[ini] == elemento)
				return ini;
			else 
				return -1;
		} else {
			int medio = (ini + fin) / 2;
			if (v[medio] == elemento)
				return medio;
			else if (v[medio] > elemento)
				return DyV(v, ini, medio, elemento);
			else
				return DyV(v, medio + 1, fin, elemento);
		}
	}

}
