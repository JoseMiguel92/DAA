// Ejercicio del examen de Mayo 2016.
public class Main {

	public static void main(String[] args) {
		System.out.println(desencriptar(3, 2, 3));
	}

	public static int desencriptar(int c, int s, int z) {
		return potencia(c, s) % z;
	}

	public static int potencia(int x, int n) {
		if (n == 1)
			return x;
		else if ((n % 2) == 0) {
			return potencia(x, n / 2) * potencia(x, n / 2);
		} else {
			return x * potencia(x, n - 1);
		}

	}

}