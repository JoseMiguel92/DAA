public class Main {

	public static void main(String[] args) {
		//							0, 1, 2, 3, 4
		int beneficios[] =        { 1, 2, 5, 6, 4 };
		int fechasDeCaducidad[] = { 3, 8, 2, 4, 1 };
		int[] solucion = new int[9];
		for (int i = 0; i < solucion.length; i++) {
			solucion[i] = -1;
		}
		boolean huertasDisponibles[] = new boolean[beneficios.length];
		for (int i = 0; i < huertasDisponibles.length; i++) {
			huertasDisponibles[i] = true;
		}
		solucion = vHortelano(beneficios, fechasDeCaducidad, solucion, huertasDisponibles);
		imprimir(beneficios,solucion);
	}

	private static void imprimir(int beneficios[],int[] solucion) {
		for (int i = 0; i < solucion.length; i++) {
			System.out.println("Dia "+i+", recogemos huerta "+(solucion[i]+1));
		}

	}

	public static int[] vHortelano(int beneficios[], int fechasDeCaducidad[], int solucion[],
			boolean huertasDisponibles[]) {
		while (hayHuertas(huertasDisponibles)) {
			int posHuerta = seleccion(beneficios, huertasDisponibles);
			huertasDisponibles[posHuerta] = false;
			if (esFactible(posHuerta, solucion)) {
				solucion[fechasDeCaducidad[posHuerta]]= posHuerta;
				huertasDisponibles[posHuerta] = false;
			}
		}
		return solucion;
	}

	public static boolean hayHuertas(boolean huertasDisponibles[]) {
		for (int i = 0; i < huertasDisponibles.length; i++) {
			if (huertasDisponibles[i])
				return true;
		}
		return false;
	}

	public static int seleccion(int beneficios[], boolean huertasDisponibles[]) {
		int beneficio = 0;
		int posicion = 0;
		for (int i = 0; i < huertasDisponibles.length; i++) {
			if (huertasDisponibles[i]) {
				if (beneficios[i] > beneficio) {
					beneficio = beneficios[i];
					posicion = i;
				}
			}
		}
		return posicion;
	}

	public static boolean esFactible(int huerta, int solucion[]) {
		if (solucion[huerta] == -1) {
			return true;
		} else
			return false;
	}

}
