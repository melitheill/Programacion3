package TpEspecial;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solucion {
	
		// Lista de máquinas disponibles para imprimir piezas
	    private List<Maquina> maquinas;
	    // Lista que guarda la mejor solución encontrada 
	    private List<Maquina> soluciones;
	    // Contador de estados generados por el algoritmo
	    private int cantidadEstadosGenerados;
	    private String metodo;
	    

	    public String getMetodo() {
	        return metodo;
	    }
	    public void setMetodo(String metodo) {
	        this.metodo = metodo;
	    }

	   
	    public int getCantidadEstadosGenerados() {
	        return cantidadEstadosGenerados;
	    }

	    public void setCantidadEstadosGenerados(int cantidadEstadosGenerados) {
	        this.cantidadEstadosGenerados = cantidadEstadosGenerados;
	    }
	   
	    // Método principal
	    public Solucion backtracking(int piezas,ArrayList<Maquina> maquinas) {
	        this.maquinas= maquinas;
	        int piezasImpresas = 0;
	        ArrayList<Maquina> solucionParcial= new ArrayList<>();
	        backtrackingRecursivo(piezas,solucionParcial,0,piezasImpresas);
	        return this;
	    }
	    
	    // Algoritmo de Backtracking recursivo
	    public void backtrackingRecursivo(int total, ArrayList<Maquina> solucionParcial, int indice, int piezasImpresas) {

	        cantidadEstadosGenerados++; // Contabiliza que se generó un nuevo estado

	        if (piezasImpresas == total) {
	            // Se guarda la solución si es la primera, o si es mejor (menos máquinas)
	            if (soluciones.size() > solucionParcial.size() || soluciones.size() == 0) {
	                soluciones = new ArrayList<>(solucionParcial);
	            }

	        } else {

	            //Poda: si aunque use todas las máquinas restantes no llego al total, corto la rama
	            if (piezasImpresas + CalcularValoresDesdeIndice(indice) < total) {
	                return; // 
	            }

	            // Iteración sobre las máquinas desde el indice
	            for (int i = indice; i < maquinas.size(); i++) {
	                Maquina maquina = maquinas.get(i);
	                Integer piezasPosibles = piezasImpresas + maquina.getValor();

	                // Poda: si me paso del total, no sigo con esta máquina
	                if (piezasPosibles <= total) {
	                    solucionParcial.add(maquina);
	                    piezasImpresas += maquina.getValor();
	                    backtrackingRecursivo(total, solucionParcial, i, piezasImpresas);
	                    solucionParcial.remove(solucionParcial.size() - 1);
	                    piezasImpresas -= maquina.getValor();
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

	    // Calcula la suma de los valores de las máquinas desde cierta posición en adelante
	    public int CalcularValoresDesdeIndice(int indice) {
	        int suma = 0;
	        for (int i = indice; i < maquinas.size(); i++) {
	            suma += maquinas.get(i).getValor();
	        }
	        return suma;
	    }
	
}
