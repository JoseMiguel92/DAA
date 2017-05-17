
public class Nodo {
	public int beneficios[];
	public int pesos[];
	public boolean metido[];
	public int capacidad;
	public int cota;
	public int etapa;
	public int solucion[];

	public void setCota() {
		for (int i = 0; i < etapa; i++) {
			// La cota sera el beneficio de cada objeto que hemos metido en
			// solucion.
			cota += beneficios[solucion[i]];
		}
		// Ahora calculamos el resto de cota si no hemos llegado al final.
		int beneficioActual;
		int beneficioMejor = 0;
		for (int i = 0; i < beneficios.length; i++) {
			// La cota sera el beneficio de cada objeto que hemos metido en
			// solucion.
			if (beneficios[i]>beneficioMejor)
				beneficioMejor = beneficios[i];
		}
		
		for (int i = etapa + 1 ; i < beneficios.length; i++) {
			cota += beneficioMejor;
		}
	}

	public boolean esSolucion() {
		if (etapa == solucion.length - 1)
			return true;
		return false;
	}

}
