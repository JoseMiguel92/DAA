public class Main {
	public static void main(String[] args) {
		int v[] = { 1, 1, 1, 1, 7, 7, 7, 7, 7, 7 };
		int mayor[] = new int[1];
		boolean exito = DyV(v, 0, v.length - 1, mayor);
		if (exito) {
			System.out.println("El número mayoritario es: " + mayor[0]);
		} else
			System.out.println("No hay número mayoritario.");
	}

	public static boolean DyV(int v[], int ini, int fin, int mayor[]) {
		if (ini == fin) {
			mayor[0] = v[ini];
			return true;
		} else {
			int medio = ((ini + fin) / 2);
			int mayor_izq[] = new int[1];
			int mayor_der[] = new int[1];
			boolean exito_izq = DyV(v, ini, medio, mayor_izq);
			boolean exito_der = DyV(v, medio+1, fin, mayor_der);
			if (exito_izq && exito_der) {
				if (mayoritario(v, mayor_izq[0], ini, fin)) {
					mayor[0] = mayor_izq[0];
					return true;
				} else if (mayoritario(v, mayor_der[0], ini, fin)) {
					mayor[0] = mayor_der[0];
					return true;
				}
			} else if (exito_izq && !exito_der) {
				if (mayoritario(v, mayor_izq[0], ini, fin)) {
					mayor[0] = mayor_izq[0];
					return true;
				}else {
					return false;
				}
			} else if (!exito_izq && exito_der) {
				if (mayoritario(v, mayor_der[0], ini, fin)) {
					mayor[0] = mayor_der[0];
					return true;
				}else 
					return false;
			} else
				return false;
		}
		return false;
	}

	public static boolean mayoritario(int v[], int numero, int ini, int fin) {
		int acu = 0;
		for (int i = ini; i <= fin; i++) {
			if (numero == v[i])
				acu++;
		}
		if (acu > ((fin-ini) / 2))
			return true;
		else
			return false;
	}

}
