public class Main {
	public static void main(String[] args) {
		int v[] = { 10, 20, 1, 12, 11, 90, 54, 22 };
		int maximo = DyVMaximo(v, 0, v.length - 1);
		System.out.println("El maximo es: " + maximo);
	}

	public static int DyVMaximo(int v[], int ini, int fin) {
		if (ini == fin)
			return v[ini];
		else {
			int medio = (ini + fin) / 2;
			int maximo1 = DyVMaximo(v, ini, medio);
			int maximo2 = DyVMaximo(v, medio + 1, fin);
			if (maximo1 > maximo2)
				return maximo1;
			else
				return maximo2;
		}
	}
}
