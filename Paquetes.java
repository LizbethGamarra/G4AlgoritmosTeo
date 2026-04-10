package practica_algoritmos;
import java.util.Objects;

public class Paquete<T extends Comparable<T>> {
    private String codigo;
    private int peso;
    private T prioridad;
    private int valorizacion;
    private int zona;
    public Paquete(String codigo, int peso, T prioridad, int valorizacion, int zona) {
        this.codigo = codigo;
        this.peso = peso;
        this.prioridad = prioridad;
        this.valorizacion = valorizacion;
        this.zona = zona;
    }

    public String getCodigo() { return codigo; }
    public int getPeso() { return peso; }
    public T getPrioridad() { return prioridad; }
    public int getValorizacion() { return valorizacion; }
    public int getZona() { return zona; }

    @Override
    public String toString() {
        return String.format("[%s | Prioridad:%s | Peso:%d | Valor:%d | Zona:%d]",
                codigo, prioridad, peso, valorizacion, zona);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paquete)) return false;
        Paquete<?> paquete = (Paquete<?>) o;
        return Objects.equals(codigo, paquete.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
