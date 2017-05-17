/*
 * Solucion: Vector con los objetos que le corresponde a cada uno, "1" si es para uno, "2" si es para el otro.
 * Paso: Objeto a repartir en ese momento del vector objetos.
 * Intento: A quien le corresponde ese objeto a repartir (1 ó 2).
 */
public class Main {

	public static void main(String[] args) {
		int objetos[] = { 100, 20, 30, 10, 80 };
		int solucion[] = new int[objetos.length];
		int paso = 0;
		boolean exito = BT(objetos, solucion, paso);
		if (exito) {
			imprimir(solucion);
		} else
			System.out.println("No hay solucion");

	}

	public static boolean BT(int objetos[], int solucion[], int paso) {
		boolean exito = false;
		for (int intento = 1; intento <= 2 && !exito; intento++) {
			solucion[paso] = intento;
			if (esFactible(objetos, intento, solucion, paso)) {
				if (paso == objetos.length-1) // Comprobamos que hemos llegado a el ultimo objeto, si es asi, hemos terminado.
					exito = true;
				else
					exito = BT(objetos, solucion, paso + 1);
			}
		}
		if (!exito) {
			solucion[paso] = 0;
		}
		return exito;
	}

	public static boolean esFactible(int objetos[], int intento, int solucion[], int paso) {
		int mitad = 0;
		int contador = 0;
		for (int i = 0; i < objetos.length; i++) {
			mitad = mitad + objetos[i];
			if (solucion[i] == 1)
				contador += objetos[i];
		}
		mitad = mitad / 2;
		if (contador <= mitad)
			return true;
		else
			return false;
	}

	public static void imprimir(int solucion[]) {
		for (int i = 0; i < solucion.length; i++) {
			System.out.println(solucion[i] + " ");
		}
	}

}
