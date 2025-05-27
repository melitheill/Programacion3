package Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import TpEspecial.Maquina;
public class Reader {
    
	 private int piezasTotales;
	    private ArrayList<Maquina> maquinas;

	    public Reader() {
	        this.maquinas = new ArrayList<>();
	    }

	    public void leerDesdeArchivo(String path) {
	        File file = new File(path);
	        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
	            String line;
	            int lineCount = 0;

	            while ((line = bufferedReader.readLine()) != null) {
	                line = line.trim();
	                if (line.isEmpty()) continue;

	                if (lineCount == 0) {
	                    // Primera línea: cantidad de piezas totales
	                    this.piezasTotales = Integer.parseInt(line);
	                } else {
	                    // Resto: máquinas
	                    String[] parts = line.split(",");
	                    if (parts.length != 2) {
	                        throw new IllegalArgumentException("Formato de línea inválido: " + line);
	                    }

	                    String idStr = parts[0].trim();
	                    int id = Integer.parseInt(idStr.replaceAll("[^0-9]", "")); // Extrae solo los números
	                    int piezas = Integer.parseInt(parts[1].trim());
	                    Maquina maquina = new Maquina(id, piezas);
	                    maquinas.add(maquina);

	                }

	                lineCount++;
	            }
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo: " + e.getMessage());
	            e.printStackTrace();
	        } catch (NumberFormatException e) {
	            System.err.println("Error al convertir a número: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    public int getPiezasTotales() {
	        return piezasTotales;
	    }

	    public ArrayList<Maquina> getMaquinas() {
	        return maquinas;
	    }
}
