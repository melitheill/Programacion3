package TpEspecial;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Backtraking {
	
		// Lista de máquinas disponibles para imprimir piezas
	    private List<Maquina> maquinas;
		private Solucion solucion;

	    // Método principal
	    public Solucion backtracking(int piezas,ArrayList<Maquina> maquinas) {
	        this.maquinas= maquinas;
			solucion= new Solucion("Backtraking");

	        ArrayList<Maquina> solucionParcial= new ArrayList<>();
	        backtrackingRecursivo(piezas,solucionParcial,0);
	        return solucion;
	    }
	    
	    // Algoritmo de Backtracking recursivo
	    public void backtrackingRecursivo(int total, ArrayList<Maquina> solucionParcial, int indice) {

	        solucion.setCantidadEstadosGenerados(); // Contabiliza que se generó un nuevo estado

	        if (solucion.getPiezasImpresas() == total) {
	            // Se guarda la solución si es la primera, o si es mejor (menos máquinas)
	            if (solucion.getSolucionesSize() > solucionParcial.size() || solucion.getSolucionesSize() == 0) {
	                solucion.addSoluciones(solucionParcial);
	            }

	        } else {

	            // Iteración sobre las máquinas desde el indice
	            for (int i = indice; i < maquinas.size(); i++) {
	                Maquina maquina = maquinas.get(i);
	                Integer piezasPosibles = solucion.getPiezasImpresas() + maquina.getValor();

	                // Poda: si me paso del total, no sigo con esta máquina
	                if (piezasPosibles <= total) {
	                    solucionParcial.add(maquina);
						solucion.sumarPiezasImpresas(maquina.getValor());
	                    backtrackingRecursivo(total, solucionParcial, i);
	                    solucionParcial.remove(solucionParcial.size() - 1);
						solucion.restarPiezasImpresas(maquina.getValor());
	                }
	            }
	        }
	    }

	    // Calcula la suma de valores de la solución parcial actual
	    public int CalcularSumaParcial(ArrayList<Maquina> solucion) {
	        int suma = 0;
	        for (int i = 0; i < solucion.size(); i++) {
	            suma += solucion.get(i).getValor();
	        }
	        return suma;
	    }

	  
	
}
