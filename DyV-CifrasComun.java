// Buscar las cifras que tienen en comun lo numeros de un vector.
public class Main {

	public static void main(String[] args) {
		int v[] = {2230, 23, 2230, 235 ,2356};
		imprimir(DyV(v,0,v.length-1));
	}

	public static boolean[] DyV(int v[], int ini, int fin) {
		if (ini == fin)
			return sacarCifras(v[ini]);
		else {
			int mitad = (ini + fin) / 2;
			boolean resultado1[] = DyV(v, ini, mitad);
			boolean resultado2[] = DyV(v, mitad + 1, fin);
			return combinar(resultado1, resultado2);
		}
	}

	public static boolean[] sacarCifras(int numero) {
		boolean aux[] = new boolean[10];
		do {
			int cifra = numero % 10;
			numero = numero / 10;
			aux[cifra] = true;
		} while (numero != 0);
		return aux;
	}

	public static void imprimir(boolean[] numeros) {
		System.out.print("Se repite el: ");
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i]) {
				System.out.print(i+", ");
			}
		}
	}
	
	public static boolean[] combinar(boolean r1[], boolean r2[]){
		boolean aux[] = new boolean[10];
		for (int i = 0; i < aux.length; i++) {
			if(r1[i]&&r2[i]){
				aux[i]=true;
			}
		}
		return aux;
	}

}
