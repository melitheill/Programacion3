import TpEspecial.Backtraking;
import TpEspecial.Greedy;
import TpEspecial.Maquina;
import Utils.Reader;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.leerDesdeArchivo("Prog3/datos.txt");
        int piezas= reader.getPiezasTotales();
        ArrayList<Maquina> maquinas =reader.getMaquinas();
        System.out.println(piezas);
        for (Maquina m : maquinas) {
            System.out.println("Maquina " + m.getNombre()+" -----> "+ m.getValor());
        }
        System.out.println(" ");
        Backtraking backtraking = new Backtraking();
        System.out.println(backtraking.backtracking(piezas,maquinas));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Greedy greedy = new Greedy();
        System.out.println(greedy.solucionGreddy(piezas,maquinas));
    }
}
