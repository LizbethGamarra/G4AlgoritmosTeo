package practica_algoritmos;
import java.util.ArrayList;
import java.util.List;

public class LogisticaManager {

    public static <T extends Comparable<T>> void insertionSort(Paquete<T>[] zona) {
        for (int i = 1; i < zona.length; i++) {
            Paquete<T> key = zona[i];
            int j = i - 1;

            while (j >= 0 && zona[j].getPrioridad().compareTo(key.getPrioridad()) < 0) {
                zona[j + 1] = zona[j];
                j = j - 1;
            }
            zona[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void quickSort(Paquete<T>[] zona, int low, int high) {
        if (low < high) {
            int pi = partition(zona, low, high);
            quickSort(zona, low, pi - 1);
            quickSort(zona, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(Paquete<T>[] zona, int low, int high) {
        T pivot = zona[high].getPrioridad();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (zona[j].getPrioridad().compareTo(pivot) >= 0) {
                i++;
                Paquete<T> temp = zona[i];
                zona[i] = zona[j];
                zona[j] = temp;
            }
        }

        Paquete<T> temp = zona[i + 1];
        zona[i + 1] = zona[high];
        zona[high] = temp;

        return i + 1;
    }

    public static List<Paquete<String>> seleccionarDP(List<Paquete<String>> todos, int capacidad) {
        int n = todos.size();
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                int pesoActual = todos.get(i - 1).getPeso();
                int valorActual = todos.get(i - 1).getValorizacion();

                if (pesoActual <= w) {
                    dp[i][w] = Math.max(
                        valorActual + dp[i - 1][w - pesoActual],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        List<Paquete<String>> seleccionados = new ArrayList<>();
        int res = dp[n][capacidad];
        int w = capacidad;

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                seleccionados.add(todos.get(i - 1));
                res -= todos.get(i - 1).getValorizacion();
                w -= todos.get(i - 1).getPeso();
            }
        }

        return seleccionados;
    }
}
