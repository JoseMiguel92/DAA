public class Main {

	public static void main(String[] args) {
		int m[][] = { { 1, 1, 3, 3 },
					  { 1, 1, 3, 3 }, 
			  		  { 1, 1, 4, 5 }, 
			  		  { 1, 1, 6, 7 } };
		int num = numRegionesHomogeneas(m);
		System.out.println("Numero de regiones homogeneas en esta matriz: " + num);

	}

	public static int numRegionesHomogeneas(int[][] m) {
		return nRHDyV(m, 0, m.length - 1, 0, m[0].length - 1);
	}

	public static int nRHDyV(int m[][], int iniFila, int finFila, int iniCol, int finCol) {
		if (((iniFila == finFila) && (iniCol == finCol)) || esRegHomogenea(m, iniFila, finFila, iniCol, finCol)) {
			return 1;
		} else {
			int medioF = (iniFila + finFila) / 2;
			int medioC = (iniCol + finCol) / 2;
			return nRHDyV(m, iniFila, medioF, iniCol, medioC) + nRHDyV(m, iniFila, medioF, medioC + 1, finCol)
					+ nRHDyV(m, medioF + 1, finFila, iniCol, medioC)
					+ nRHDyV(m, medioF + 1, finFila, medioC + 1, finCol);
		}
	}

	public static boolean esRegHomogenea(int m[][], int iniFila, int finFila, int iniCol, int finCol) {
		int valor = m[iniFila][iniCol];
		boolean aux = false;
		for (int i = iniFila; i <= finFila; i++) {
			for (int j = iniCol; j <= finCol; j++) {
				if (m[i][j] == valor)
					aux = true;
				else
					return false;
			}
		}
		return aux;
	}

}
