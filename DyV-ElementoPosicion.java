//Dado un vector ordenado, buscar la posicion en el vector que guarda la propia posicion.
public class Main {

	public static void main(String[] args) {
		int v[] = { -1, 0, 2, 8, 9, 10, 11 };
		System.out.println("La posicion es " + DyV(v, 0, v.length-1));
	}

	public static int DyV(int v[], int ini, int fin) {
		if (ini == fin) {
			if (v[ini] == ini)
				return ini;
			else
				return -1;
		} else {
			int medio = (ini + fin) / 2;
			int izq = DyV(v, ini, medio);
			int der = DyV(v, medio + 1, fin);
			return Math.max(izq, der);
		}
	}

}
