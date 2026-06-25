package structures;

/**
 * Lista enlazada simple genérica implementada desde cero.
 * NO utiliza ninguna clase de java.util.
 *
 * Funcionalidad: Catálogo principal de videojuegos (RF01)
 * Complejidad: insertar O(n) al final | buscar O(n) | eliminar O(n)
 *
 * @author josephchilo239
 * @param <T> Tipo de dato genérico
 */
public class ListLinked<T> {

    // Nodo interno de la lista
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public ListLinked() {
        head = null;
        size = 0;
    }

    /** Inserta un elemento al final de la lista. O(n) */
    public void insert(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /** Inserta un elemento al inicio de la lista. O(1) */
    public void insertAtHead(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Elimina el primer nodo que coincida con el dato dado. O(n) */
    public boolean delete(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** Retorna el elemento en la posición indicada. O(n) */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /** Retorna todos los elementos como un arreglo de Object. O(n) */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    /** Vacía la lista completa. */
    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}
