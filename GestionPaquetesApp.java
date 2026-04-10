package practica_algoritmos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionPaquetesApp {
    public static void main(String[] args) {
        String archivo = "datos_paquetes.txt";
        int capacidad = 0, numZonas = 0, pPorZona = 0;
        Paquete<Integer>[][] matrizZonas = null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            capacidad = Integer.parseInt(br.readLine().split("=")[1].trim());
            numZonas = Integer.parseInt(br.readLine().split("=")[1].trim());
            pPorZona = Integer.parseInt(br.readLine().split("=")[1].trim());
            br.readLine();

            matrizZonas = new Paquete[numZonas][pPorZona];

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");

                Paquete<Integer> p = new Paquete<>(
                        d[0].trim(),
                        Integer.parseInt(d[1].trim()),
                        Integer.parseInt(d[2].trim()),
                        Integer.parseInt(d[3].trim()),
                        Integer.parseInt(d[4].trim())
                );

                int zIdx = Integer.parseInt(d[4].trim()) - 1;

                for (int j = 0; j < pPorZona; j++) {
                    if (matrizZonas[zIdx][j] == null) {
                        matrizZonas[zIdx][j] = p;
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("PAQUETES ANTES DEL ORDENAMIENTO");
        mostrarMatriz(matrizZonas);

        for (int i = 0; i < numZonas; i++) {
            if (i % 2 == 0)
                LogisticaManager.insertionSort(matrizZonas[i]);
            else
                LogisticaManager.quickSort(matrizZonas[i], 0, pPorZona - 1);
        }

        System.out.println("\nPAQUETES DESPUÉS DEL ORDENAMIENTO (POR ZONA)");
        mostrarMatriz(matrizZonas);

        List<Paquete<Integer>> todosLosPaquetes = new ArrayList<>();
        for (Paquete<Integer>[] fila : matrizZonas) {
            for (Paquete<Integer> p : fila) {
                if (p != null) todosLosPaquetes.add(p);
            }
        }

        List<Paquete<String>> seleccionados = LogisticaManager.seleccionarDP((List) todosLosPaquetes, capacidad);

        System.out.println("\nSELECCIÓN FINAL PARA EL CAMIÓN (CAPACIDAD: " + capacidad + ")");

        int valorTotal = 0;
        for (Paquete<String> p : seleccionados) {
            System.out.println(p);
            valorTotal += p.getValorizacion();
        }

        System.out.println("Valorización Total Optimizada: " + valorTotal);
    }

    private static void mostrarMatriz(Paquete<Integer>[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Zona " + (i + 1) + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
