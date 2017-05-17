
public class Main {

	public static void main(String[] args) {
		int dimension = 5;
		int solucion[][] = new int[dimension][dimension];
		int incrementoX[] = { -2, 2, -1, 1, -1, 1, -2, 2 };
		int incrementoY[] = { 1, 1, 2, 2, -2, -2, -1, -1 };
		int pasoX = 4; // COORDENADA X DE INICIO.
		int pasoY = 4; // COORDENADA Y DE INICIO.
		solucion[pasoX][pasoY] = 1; // INICIALIZACION A "1".
		int numero = 2; // NUMERO SIGUIENTE A PONER.
		boolean exito = BT(numero, solucion, pasoX, pasoY, incrementoX, incrementoY);
		if (exito)
			imprimir(solucion);
		else
			System.out.println("No hay solucion.");
	}

	private static boolean BT(int numero, int[][] solucion, int pasoX, int pasoY, int[] incrementoX,
			int[] incrementoY) {
		boolean exito = false;
		for (int intento = 0; intento < 8 && !exito; intento++) {
			int nuevaX = pasoX + incrementoX[intento];
			int nuevaY = pasoY + incrementoY[intento];

			if ((nuevaX >= 0 && nuevaX < solucion.length) && (nuevaY >= 0 && nuevaY < solucion.length)) {
				if (solucion[nuevaX][nuevaY] == 0) {
					solucion[nuevaX][nuevaY] = numero;
					if (numero == solucion.length * solucion.length) {
						exito = true;
					} else {
						exito = BT(numero + 1, solucion, nuevaX, nuevaY, incrementoX, incrementoY);
						if (!exito)
							solucion[nuevaX][nuevaY] = 0;
					}
				}

			}
		}

		return exito;
	}

	private static void imprimir(int[][] solucion) {
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				System.out.print(solucion[i][j] + " ");
			}
			System.out.println();
		}

	}

}
