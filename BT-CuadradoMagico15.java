/*
 *	Solucion: Matriz con los numeros correctamente colocados.
 *	Paso: Posicion donde colocar el numero del intento.
 *	Intento: Numero a colocar.
 */
public class Main {

	public static void main(String[] args) {
		int solucion[][] = new int[3][3];
		int pasoX = 0;
		int pasoY = 0;
		boolean exito = BT(solucion, pasoX, pasoY);
		if(exito)
			imprimir(solucion);
		else
			System.out.println("No hay solución.");
	}

	public static boolean BT(int solucion[][], int pasoX, int pasoY) {
		boolean exito = false;

		for (int intento = 1; intento <= 9 && !exito; intento++) {
			solucion[pasoX][pasoY] = intento;
			if (esFactible(intento, pasoX, pasoY, solucion)) {
				if (pasoX == solucion.length - 1 && pasoY == solucion.length - 1)
					return true;
				else { // Aqui llamaremos a una nueva etapa del
						// problema(pasoX+1,pasoY+1), tendremos que calcular esa
						// nueva coordenada, por si estamos en la ultima columna
						// de una fila o no.
					int nuevaX = pasoX;
					int nuevaY = pasoY;
					if (pasoY < solucion.length - 1) {
						nuevaY++;
					} else {
						nuevaX = nuevaX + 1;
						nuevaY = 0;
					}
					exito = BT(solucion, nuevaX, nuevaY);
				}
			}
		}
		if (!exito)
			solucion[pasoX][pasoY] = 0;
		return exito;
	}

	public static boolean esFactible(int intento, int pasoX, int pasoY, int solucion[][]) {
		int sumaFila = 0;
		for (int i = 0; i < solucion.length; i++) {
			sumaFila = sumaFila + solucion[pasoX][i];
		}
		int sumaColumna = 0;
		for (int i = 0; i < solucion.length; i++) {
			sumaColumna = sumaColumna + solucion[i][pasoY];
		}
		int contador = 0; // Aqui buscamos que no haya repeticiones de numeros.
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				if (solucion[i][j] == intento)
					contador++;
			}
		}
		return ((sumaColumna<15 && pasoX<solucion.length-1) || (sumaColumna == 15 && pasoX==solucion.length-1))
				// La columna tiene una suma menor que 15 pero no hemos llegado al final ó 
				//tiene una suma igual a 15 y hemos llegado al final de esa columna.
				&&
				((sumaFila<15 && pasoY<solucion.length-1) || (sumaFila == 15 && pasoY==solucion.length-1))
				// la fila tiene una suma menor que 15 pero no hemos llegado al final ó 
				// tiene una suma igual a 15 y hemos llegado al final de esa fila.
				&&
				contador == 1; // Para que no se puedan repetir los numeros.

	}

	public static void imprimir(int solucion[][]) {
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				System.out.print(solucion[i][j] + " ");
			}
			System.out.println();

		}
	}

}
