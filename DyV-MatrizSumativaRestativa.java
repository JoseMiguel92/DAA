// Comprobar si una matriz dada es sumativa,restativa o neutra.
// Sera Sumativa si lo que haya en esa posicion es igual a la suma de los indices de la posicion.
// Sera Restativa si lo que haya en esa posicion es igual a la resta de los indices de la posicion.
// Será Neutra si no es ni restativa ni sumativa en esa posicion.
// Este código sólo es válido para matrices cuadradas.
public class Main {

	public static void main(String[] args) {
		int m[][] = { { 2, 2 }, { 2, 2 } };
		char tipo = analizar(m);
		if (tipo == 'n')
			System.out.println("Neutra.");
		else
			System.out.println(tipo);
	}

	public static char analizar(int[][] m) {
		int iniF = 0;
		int iniC = 0;
		int finF = m.length - 1;
		int finC = m[0].length - 1;
		return analizarAux(m, iniF, finF, iniC, finC);
	}

	public static char analizarAux(int[][] m, int iniF, int finF, int iniC, int finC) {
		// Parte Caso Base.
		if ((iniF == finF) && (iniC == finC)) {
			// Miramos que sea de una sola posicion la matriz, para comprobar el
			// caso base.
			if (m[iniF][iniC] == iniF + iniC) {
				return 's';
			} else if (m[iniF][iniC] == iniF - iniC) {
				return 'r';
			} else {
				return 'n';
			}
		} else { // Parte Recursiva.
			// Dividimos.
			int medioF = (iniF + finF) / 2;
			int medioC = (iniC + finC) / 2;
			char m1 = analizarAux(m, iniF, medioF, iniC, medioC);
			char m2 = analizarAux(m, iniF, medioF, medioC + 1, finC);
			char m3 = analizarAux(m, medioF + 1, finF, iniC, medioC);
			char m4 = analizarAux(m, medioF + 1, finF, medioC + 1, finC);
			// Combinacion.
			if ((m1 == m2) && (m1 == m3) && (m1 == m4))
				return m1; // Devolvemos el char correspondiente.
			//
			else
				return 'n'; // Devolvemos un char de comprobacion para luego
							// imprimir.
		}
	}
}