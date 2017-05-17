
public class Main {

	public static void main(String[] args) {
		String solucion[][] = new String[10][10];
		int incrementoX[] = { 1, -1, 0, 0 };
		// MOVIMIENTOS POSIBLES EN EJE X (FILAS).
		int incrementoY[] = { 0, 0, 1, -1 };
		// MOVIMIENTOS POSIBLES EN EJE Y (COLUMNAS).
		int pasoX = 0; // COORDENADA PRIMERA. (ARRIBA - ABAJO).
		int pasoY = 0; // COORDENADA SEGUNDA. (IZQUIERDA - DERECHA).
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				solucion[i][j] = " ";
				// INICIALIZACION DEL LABERINTO A ESPACIO EN BLANCO.
			}
		}
		solucion[pasoX][pasoY] = "E"; 
		// ENTRADA AL LABERINTO.
		solucion[solucion.length - 1][0] = "S";
		// SALIDA DEL LABERINTO.
		solucion[3][4]="M";
		solucion[5][5]="M";
		solucion[8][8]="M";
		solucion[9][6]="M";
		solucion[1][3]="M";
		solucion[1][0]="M";
		solucion[1][1]="M";
		solucion[1][2]="M";
		
		// EN ESTA PARTE INTRODUCIMOS LOS MUROS.
		int numero = 1; // Numero con el que iniciamos el recorrido.
		boolean exito = BTUnaSolucion(numero, solucion, pasoX, pasoY, incrementoX, incrementoY);
		// UNA SOLUCION
		if (exito)
			imprimir(solucion);
		else
			System.out.println("No hay solución.");
		// TODAS LAS SOLUCIONES
		BTUnaSolucion(numero, solucion, pasoX, pasoY, incrementoX, incrementoY);

	}

	public static boolean BTUnaSolucion(int numero, String solucion[][], int pasoX, int pasoY, int[] incrementoX,
			int[] incrementoY) {
		boolean exito = false;
		for (int intento = 0; intento < 4 && !exito; intento++) {
			// Pongo hasta llegar a 4 porque es el numero de movimientos
			// posibles en los incrementos.

			int nuevaX = pasoX + incrementoX[intento];
			int nuevaY = pasoY + incrementoY[intento];

			if ((nuevaX >= 0 && nuevaX < solucion.length) && (nuevaY >= 0 && nuevaY < solucion.length)) {
				if (solucion[nuevaX][nuevaY].equals("S")) {
					exito = true;
				} else if (solucion[nuevaX][nuevaY].equals(" ")) {
					solucion[nuevaX][nuevaY] = Integer.toString(numero);
					exito = BTUnaSolucion(numero + 1, solucion, nuevaX, nuevaY, incrementoX, incrementoY);
					if (!exito) {
						solucion[nuevaX][nuevaY] = " ";
					}
				}
			}
		}
		return exito;
	}

	public static void imprimir(String solucion[][]) {
		for (int i = 0; i < solucion.length; i++) {
			for (int j = 0; j < solucion.length; j++) {
				System.out.print(solucion[i][j] +" ");
			}
			System.out.println();
		}
	}

}
