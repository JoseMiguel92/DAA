public class Main {

	public static void main(String[] args) {
		int numReinas = 6;
		int solucion[] = new int[numReinas];
		for (int i = 0; i < solucion.length; i++) {
			solucion[i] = -1;
		}
		int paso = 0;
		int dimension = solucion.length;
		BT(solucion, paso, dimension); // PARA IMPRIMIR TODAS LAS SOLUCIONES.
		// --PARA IMPRIMIR UNA SOLUCION.
		// boolean exito = BT(solucion, paso, dimension);
		// if (exito) {
		// imprimir(solucion);
		// } else
		// System.out.println("No hay solucion");
	}

	public static boolean BT(int[] solucion, int paso, int dimension) {
		boolean exito = false;
		for (int intento = 0; intento < dimension && !exito; intento++) {
			solucion[paso] = intento; // MARCACION DE CASILLA.
										// En la posicion "paso", que es la fila
										// del tablero, metemos el intento, que
										// es la columna del tablero.
			if (esFactible(solucion, paso, intento, dimension)) {
				if (paso == dimension - 1)
					// PARA IMPRIMIR UNA SOLUCION.
					// return true;
					imprimir(solucion);// PARA IMPRIMIR TODAS LAS SOLUCIONES.

				else
					exito = BT(solucion, paso + 1, dimension);
			}

		}
		if (!exito) // DESMARCO LA CASILLA QUE SELECCIONE.
			solucion[paso] = -1;
		return exito;
	}

	// public static boolean esFactible(int solucion[], int paso, int intento,
	// int dimension) {
	// for (int i = 0; i <= paso-1; i++) {
	// if((solucion[i]==intento)
	// ||
	// (Math.abs(i-paso)==Math.abs(solucion[i]-solucion[paso])))
	// return false;
	// }
	// return true;
	// }
	//
	// Este codigo que sigue, y el anterior, son dos maneras de hacer lo mismo.
	//

	public static boolean esFactible(int solucion[], int paso, int intento, int dimension) {
		for (int i = 0; i <= paso - 1; i++) {
			if (solucion[i] == intento) {
				return false;
			}
		}
		for (int i = 0; i <= paso - 1; i++) {
			if (Math.abs(i - paso) == Math.abs(solucion[i] - solucion[paso])) {
				return false;
			}
		}
		return true;
	}

	public static void imprimir(int[] solucion) {
		for (int i = 0; i < solucion.length; i++) {
			System.out.print(solucion[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

}
