import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// DATOS DEL PROBLEMA.
		int beneficios[] = { 3, 5, 1, 7, 9, 23, 1 };
		int pesos[] = { 9, 3, 1, 8, 4, 9, 10 };
		boolean metido[] = new boolean[pesos.length];
		int capacidad = 10;
		int cota_inicial = 0;
		int solucion[];

		// CALCULO DE LA COTA INICIAL.
		int capacidadAux = capacidad;
		for (int i = 0; i < pesos.length; i++) {
			if ((!metido[i]) && (pesos[i] < capacidadAux)) {
				metido[i] = true;
				capacidadAux = capacidadAux - pesos[i];
				cota_inicial = cota_inicial + beneficios[i];
			}
		}

		// CREACION ESTRUCTURA DE DATOS( MONTICULO - LISTA ORDENADA).
		LinkedList<Nodo> lista_ordenada = new LinkedList<Nodo>();
		Nodo inicial = new Nodo();
		// INICIALIZACION DEL NODO INICIAL(DEL QUE PARTIRAN TODOS LOS DEMAS).
		inicial.beneficios = beneficios;
		inicial.pesos = pesos;
		inicial.capacidad = capacidad;
		// for (int i = 0; i < metido.length; i++) {
		// inicial.metido[i]=false;
		// }
		inicial.setCota();
		inicial.etapa = -1;
		lista_ordenada.add(inicial);

		// ESQUEMA RAMIFICA Y PODA.
		while (!lista_ordenada.isEmpty()) {
			// Extraemos el mas prometedor.
			Nodo padre = lista_ordenada.remove(0);
			// Sacamos sus hijos.
			List<Nodo> hijos = getComplecciones(padre);
			for (Nodo hijo : hijos) {
				if (hijo.esSolucion()) {
					if (hijo.cota > cota_inicial) {
						CopiarSolucion(solucion, hijo);
						cota_inicial = hijo.cota;
					}
				} else {
					if (hijo.cota > cota_inicial) {
						lista_ordenada.add(hijo);
					} else {
						System.out.println("Hijo(Nodo), rechazado (podado), su cota no es mejor que la actual");
					}
				}
			}
			Collections.sort(lista_ordenada);
		}

	}

	public static List<Nodo> getComplecciones(Nodo padre) {
		ArrayList<Nodo> hijosAux = new ArrayList<Nodo>();
		for (int intento = 0; intento < padre.pesos.length; intento++) {
			Nodo hijo = new Nodo();
			CopiarNodo(padre,hijo);
			hijo.etapa++;
			hijo.solucion[hijo.etapa] = intento;
			hijo.metido[hijo.etapa] = true;
			hijo.setCota();
			if(esFactible(hijo)){
				hijosAux.add(hijo);
			}
		}
		return hijosAux;
	}
	
	public static boolean esFactible(Nodo hijo) {
		int capacidadAux=0;
		for (int i = 0; i < hijo.metido.length; i++) {
			if(hijo.metido[i]){
				capacidadAux += hijo.pesos[i];
			}
		}
		if(capacidadAux > hijo.capacidad)
			return false;
		else
			return true;
	}

	public static void CopiarNodo(Nodo padre, Nodo hijo) {
		hijo.beneficios = padre.beneficios;
		hijo.capacidad = padre.capacidad;
		hijo.etapa = padre.etapa;
		hijo.metido = padre.metido;
		hijo.solucion = padre.solucion;
		
	}

	public static void CopiarSolucion(int solucion[],Nodo hijo){
		for (int i = 0; i < hijo.solucion.length; i++) {
			if(hijo.metido[i]){
				solucion[i] = hijo.solucion[i];
			}	
		}
	}
	

}
