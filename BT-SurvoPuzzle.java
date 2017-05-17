
public class Main {

	public static void main(String[] args) {
		int m[][] = new int[3][4];
		m[0][0] = 5;
		m[1][1] = 5;
		m[2][3] = 5;
		int[] sumaF = { 10, 20, 30 };
		int[] sumaC = { 40, 30, 21, 80 };
		boolean exito = BT(m, 0, 0, sumaF, sumaC);
		if (exito) {
			System.out.println("exito");
		} else
			System.out.println("no exito");
	}

	public static boolean BT(int m[][], int pasoX, int pasoY, int sumaF[], int sumaC[]) {
		boolean exito = false;
		if (m[pasoX][pasoY] == -1) {
			for (int intento = 0; intento < (m.length * m[0].length); intento++) {
				if (esFactible(m, pasoX, pasoY, intento, sumaF, sumaC)) {
					m[pasoX][pasoY] = intento;
					if ((pasoX == m.length - 1) && (pasoY == m[0].length - 1))
						exito = true;
					else {
						int nuevaX = pasoX;
						int nuevaY = pasoY;
						if (nuevaY == m[0].length - 1) {
							nuevaY = 0;
							nuevaX++;
						} else {
							nuevaY++;
						}
						exito = BT(m, nuevaX, nuevaY, sumaF, sumaC);
						if (!exito) {
							m[pasoX][pasoY] = -1;
						}
					}
					if (!exito) {
						m[pasoX][pasoY] = -1;
					}
				}
			}
			return exito;
		} else {
			if (esFactible(m, pasoX, pasoY, m[pasoX][pasoY], sumaF, sumaC)) {
				if ((pasoX == m.length - 1) && (pasoY == m[0].length - 1)) {
					exito = true;
				} else {
					int nuevaX = pasoX;
					int nuevaY = pasoY;
					if (nuevaY == m[0].length - 1) {
						nuevaY = 0;
						nuevaX++;
					} else {
						nuevaY++;
					}
					exito = BT(m, nuevaX, nuevaY, sumaF, sumaC);
				}
			}
		}
	}

	public static boolean esFactible(int[][] m, int pasoX, int pasoY, int intento, int[] sumaF, int[] sumaC) {
		int suma_actualF = 0;
		int suma_actualC = 0;
		for (int i = 0; i < pasoY; i++) {
			suma_actualF += m[pasoX][i];
		}
		for (int i = 0; i < pasoX; i++) {
			suma_actualC += m[i][pasoY];
		}
		if (pasoX == m.length - 1) {
			if ((suma_actualC + intento) != sumaC[pasoY])
				return false;
		} else {
			if ((suma_actualC + intento) >= sumaC[pasoY])
				return false;
		}
		if (pasoY == m[0].length - 1) {
			if ((suma_actualF + intento) != sumaF[pasoX])
				return false;
		} else {
			if ((suma_actualF + intento) >= sumaF[pasoX])
				return false;
		}
		return true;
	}
}
