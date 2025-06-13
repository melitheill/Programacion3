package TpEspecial;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
	
	// Lista de máquinas disponibles para imprimir piezas
    private List<Maquina> maquinas;
	
	public ArrayList<Integer> solucionGreddy(int total, ArrayList<Integer> maquinas) {
	    ArrayList<Integer> solucion = new ArrayList<Integer>();

	    while (!maquinas.isEmpty() && total > 0) {
	        int indice = maxValor(maquinas);
	        Integer maquina = maquinas.get(indice);
	        maquinas.remove(indice); // removemos por índice, no por valor

	        int cantidad = Math.round(total / maquina); // cuántas veces entra esta maquina
	        for (int j = 0; j < cantidad; j++) {
	            solucion.add(maquina);
	        }

	        total -= cantidad * maquina; // actualizamos el valor restante
	    }

	    // Si total llega a 0, devolvemos solución
	    if (total == 0) {
	        return solucion;
	    } else {
	        return null; // no se pudo llegar exactamente al monto deseado
	    }
	}

	
	public int maxValor(ArrayList<Integer> monedas) {
		int mayorValor=0;
		int maquina = 0;
		for(int i =0;i<maquinas.size();i++) {
			if(maquinas.get(i).getValor()>mayorValor) {
				mayorValor= maquinas.get(i).getValor();
				maquina=i;
			}
		}
		return maquina;
	}

}
