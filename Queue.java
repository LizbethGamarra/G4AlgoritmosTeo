package structures;

/**
 * Cola (Queue) genérica implementada desde cero con nodos enlazados.
 * NO utiliza ninguna clase de java.util.
 *
 * Funcionalidad: Cola de descargas pendientes (RF05)
 * Complejidad: enqueue O(1) | dequeue O(1) | peek O(1)
 *
 * @author josephchilo239
 * @param <T> Tipo de dato genérico
 */
public class Queue<T> {

    // Nodo interno de la cola
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    /** Agrega un elemento al final de la cola. O(1) */
    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    /** Retira y retorna el elemento del frente. O(1) */
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    /** Retorna el elemento del frente sin retirarlo. O(1) */
    public T peek() {
        if (isEmpty()) throw new RuntimeException("La cola está vacía");
        return front.data;
    }

    /** Retorna todos los elementos como arreglo sin modificar la cola. O(n) */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = front;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}
