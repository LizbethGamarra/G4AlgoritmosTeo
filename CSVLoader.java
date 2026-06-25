package model;

import structures.ListLinked;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lee el archivo CSV del dataset y carga todos los videojuegos en una ListLinked.
 *
 * @author josephchilo239
 */
public class CSVLoader {

    /**
     * Lee el archivo CSV y retorna una ListLinked con todos los videojuegos.
     * @param filePath Ruta al archivo games_200_extended.csv
     * @return ListLinked<VideoGame> con los datos cargados
     */
    public static ListLinked<VideoGame> load(String filePath) {
        ListLinked<VideoGame> list = new ListLinked<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                // Saltar la cabecera del CSV
                if (firstLine) { firstLine = false; continue; }
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split(",", -1);
                if (fields.length < 13) continue;

                try {
                    int id              = Integer.parseInt(fields[0].trim());
                    String name         = fields[1].trim();
                    String genre        = fields[2].trim();
                    String platform     = fields[3].trim();
                    double rating       = Double.parseDouble(fields[4].trim());
                    int downloads       = Integer.parseInt(fields[5].trim());
                    String releaseDate  = fields[6].trim();
                    String developer    = fields[7].trim();
                    String publisher    = fields[8].trim();
                    double price        = Double.parseDouble(fields[9].trim());
                    String gameMode     = fields[10].trim();
                    // Maneja "Sí", "Si" y "true" como valores válidos para multijugador
                    boolean multiplayer = fields[11].trim().equalsIgnoreCase("Sí") ||
                                         fields[11].trim().equalsIgnoreCase("Si") ||
                                         fields[11].trim().equalsIgnoreCase("true");
                    double sizeGb       = Double.parseDouble(fields[12].trim());

                    list.insert(new VideoGame(id, name, genre, platform, rating,
                            downloads, releaseDate, developer, publisher,
                            price, gameMode, multiplayer, sizeGb));

                } catch (NumberFormatException e) {
                    // Línea con formato incorrecto, se omite
                    System.err.println("Skipping malformed line: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Dataset loaded: " + list.getSize() + " video games.");
        return list;
    }
}
