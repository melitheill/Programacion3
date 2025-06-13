package TpEspecial;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private int cantidadEstadosGenerados;
    private  int piezasImpresas;
    private String metodo;
    private List<Maquina> soluciones;

    public Solucion(String metodo) {
        this.cantidadEstadosGenerados = 0;
        this.piezasImpresas = 0;
        this.metodo = metodo;
        this.soluciones = new ArrayList<>();
    }

    public int getPiezasImpresas() {
        return piezasImpresas;
    }

    public void sumarPiezasImpresas(int piezasImpresas) {
        this.piezasImpresas += piezasImpresas;
    }
    public void restarPiezasImpresas(int piezasImpresas) {
        this.piezasImpresas -= piezasImpresas;
    }

    public int getCantidadEstadosGenerados() {
        return cantidadEstadosGenerados;
    }

    public String getMetodo() {
        return metodo;
    }

    public List<Maquina> getSoluciones() {
        return new ArrayList<>(soluciones);
    }

    public void setCantidadEstadosGenerados() {
        this.cantidadEstadosGenerados++;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void addSoluciones(Maquina nuevaSolucion) {
        soluciones.add(nuevaSolucion);
    }
    public void addSoluciones(ArrayList<Maquina> nuevaSolucion) {
        soluciones.clear();
        soluciones.addAll(nuevaSolucion);
    }
    public void limpiarSoluciones() {
        soluciones.clear();
    }
    public int getSolucionesSize() {
        return soluciones.size();
    }
    public String getSolucionesString() {
        String solucionesString = "";
        for (Maquina m : soluciones) {
            solucionesString += m+"//";
        }
        return solucionesString;
    }
    @Override
    public String toString() {
        if(soluciones.isEmpty()){
            return "No se encontro una solucion para el algoritmo " + getMetodo();
        }
        return "Metodo: "+ getMetodo()+" ,la cantidad de estados generados "+ getCantidadEstadosGenerados()+" ,el estado de la solucion es "+ getSolucionesString();
    }
}
