
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] ordenar(int v[]) {
		boolean disponibles[] = new boolean[v.length];
		int etapa = 0;
		boolean exito = ordenarBT(v, disponibles, etapa);
		if(exito){
			for (int i = 0; i < v.length; i++) {
				
			}
		}
	}

	public static boolean ordenarBT(int v[], boolean disponibles[], int etapa) {
		boolean exito = false;
		int solucion[] = new int[v.length];
		for (int intento = 0; intento < v.length && !exito; intento++) {
			if (esFactible(v, disponibles, intento, etapa)) {
				solucion[etapa] = v[intento];
				if (etapa == v.length) {
					exito = true;
					disponibles[etapa] = true;
				} else {
					exito = ordenarBT(v, disponibles, etapa + 1);
					if (!exito) {
						solucion[etapa] = -1;
						disponibles[intento] = false;
					}
				}
			}
		}
		return exito;
	}

	private static boolean esFactible(int[] v, boolean[] disponibles, int intento, int etapa) {
		// TODO Auto-generated method stub
		return false;
	}

}
