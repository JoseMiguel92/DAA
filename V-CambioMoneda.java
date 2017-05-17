
public class Main {

	public static void main(String[] args) {
		int tiposMoneda[] = {50, 20, 10, 5, 2};
		int cambio = 188;
		int numMonedas[] = new int[tiposMoneda.length];
		if (vCambioMoneda(tiposMoneda, cambio, numMonedas)) {
			imprimir(tiposMoneda, numMonedas);
		} else
			System.out.println("No hay solucion.");
	}

	public static boolean vCambioMoneda(int tiposMoneda[], int cambio, int numMonedas[]) {
		boolean candidatos[] = new boolean[tiposMoneda.length];
		for (int i = 0; i < candidatos.length; i++) {
			candidatos[i]=true;
		}
		int posCandidato;
		while (tienesCandidatos(candidatos) && !esSolucion(suma(tiposMoneda, numMonedas), cambio)) {
			posCandidato = seleccion(candidatos);
			if (esFactible(tiposMoneda, cambio, posCandidato)) {
				numMonedas[posCandidato] = (cambio - suma(tiposMoneda, numMonedas)) / tiposMoneda[posCandidato];
			}
			candidatos[posCandidato] = false;
		}
		if (suma(tiposMoneda, numMonedas) == cambio)
			return true;
		else
			return false;
	}

	public static void imprimir(int tiposMoneda[], int numMonedas[]) {
		for (int i = 0; i < tiposMoneda.length; i++) {
			if (numMonedas[i] != 0)
				System.out.println("Tenemos la moneda de " + tiposMoneda[i] + "€ " + numMonedas[i] + " veces.");
		}
	}

	public static boolean tienesCandidatos(boolean candidatos[]) {
		boolean aux = false;
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i])
				return true;
		}
		return aux;
	}

	public static int suma(int tiposMoneda[], int numMonedas[]) {
		int suma = 0;
		for (int i = 0; i < tiposMoneda.length; i++) {
			suma += numMonedas[i] * tiposMoneda[i];
		}
		return suma;
	}

	public static boolean esSolucion(int numero, int cambio) {
		if (cambio - numero == 0)
			return true;
		else
			return false;
	}

	public static int seleccion(boolean candidatos[]) {
		int candidato = -1;
		for (int i = 0; i < candidatos.length; i++) {
			if (tienesCandidatos(candidatos) && candidatos[i])
				return i;
		}
		return candidato;
	}

	public static boolean esFactible(int tiposMoneda[], int cambio, int posCandidato) {
		if (tiposMoneda[posCandidato] <= cambio)
			return true;
		else
			return false;
	}
}
