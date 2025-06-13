package TpEspecial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Greedy {
	
	// Lista de máquinas disponibles para imprimir piezas
    private List<Maquina> maquinas;
	private Solucion solucion;
	
	public Solucion solucionGreddy(int total, ArrayList<Maquina> maquinas) {
		solucion=new Solucion("Greedy");

		// Ordenar las máquinas por valor descendente (mayor valor primero)
		Collections.sort(maquinas);
		Iterator iter = maquinas.iterator();
		while (iter.hasNext()) {
			if (total <= 0) break;

			Maquina maquina = (Maquina) iter.next();

			int valor = maquina.getValor();
			int cantidad = total / valor;  // tomamos el máximo posible sin pasarnos

			for (int i = 0; i < cantidad; i++) {
				solucion.setCantidadEstadosGenerados();
				solucion.addSoluciones(maquina);
			}

			total -= cantidad * valor;
		}

		if (total == 0) {
			return solucion;
		} else {
			return null; // no se pudo llegar exactamente al total
		}
	}
}
