package TpEspecial;

public class Maquina implements Comparable<Maquina> {
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
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Maquina) {
            Maquina maquina = (Maquina)obj;
            return this.nombre == maquina.nombre && this.valor == maquina.valor;
        }
        return false;
    }
    public int compareTo(Maquina maquina) {
        return   maquina.valor - this.valor;
    }
    @Override
    public String toString() {
        return "M" + nombre + " piezas= " + valor ;
    }

}
