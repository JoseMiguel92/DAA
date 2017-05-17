import java.util.ArrayList;

public class Main {
	static String cubos[] = new String[4];
	static final int n = 4;
	static String palabra = "hola";

	public static void main(String[] args) {
		cubos[0] = "abcdef";
		cubos[1] = "ghijkl";
		cubos[2] = "mnopqr";
		cubos[3] = "lxyvwz";
		int sol[] = new int[4];
		ArrayList<Integer> cuboLibre = new ArrayList<Integer>();
		for (int i = 0; i < sol.length; i++) {
			sol[i] = -1;
			cuboLibre.add(i);
		}
		boolean exito = buscaCadena(sol, 0, cuboLibre);
		if (exito)
			imprimir(sol);
		else
			System.out.println("No hay solucion");
	}

	private static void imprimir(int[] sol) {
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i] + " ");
		}

	}

	public static boolean buscaCadena(int[] sol, int k, ArrayList<Integer> cuboLibre) {
		boolean exito = false;
		for (int intento = 0; intento < n && !exito; intento++) {
			if (esFactible(sol, k, cuboLibre, intento)) {
				sol[k] = intento;
				if (k == n - 1)
					exito = true;
				else {
					cuboLibre.remove((Integer) intento);
					exito = buscaCadena(sol, k + 1, cuboLibre);
					if (!exito) {
						sol[k] = -1;
						cuboLibre.add(intento);
					}
				}
			}
		}
		return exito;
	}

	public static boolean esFactible(int[] sol, int k, ArrayList<Integer> cuboLibre, int intento) {
		if (!cuboLibre.contains(intento)) {
			return false;
		}
		char letra = palabra.charAt(k);
		if (cubos[intento].indexOf(letra) < 0) {
			return false;
		}
		return true;
	}

}
