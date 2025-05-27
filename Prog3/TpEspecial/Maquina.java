package TpEspecial;

public class Maquina {
	private int nombre;
    private int valor;
    public Maquina(int id, int valor) {
        this.nombre = id;
        this.valor = valor;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
