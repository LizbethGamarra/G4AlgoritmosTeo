package model;

/**
 * Clase modelo que representa un videojuego en el sistema GameHub.
 * Corresponde a los atributos del dataset games_200_extended.csv.
 *
 * @author josephchilo239
 */
public class VideoGame {

    private int id;
    private String name;
    private String genre;
    private String platform;
    private double rating;
    private int downloads;
    private String releaseDate;
    private String developer;
    private String publisher;
    private double price;
    private String gameMode;
    private boolean multiplayer;
    private double sizeGb;

    public VideoGame(int id, String name, String genre, String platform,
                     double rating, int downloads, String releaseDate,
                     String developer, String publisher, double price,
                     String gameMode, boolean multiplayer, double sizeGb) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.downloads = downloads;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.price = price;
        this.gameMode = gameMode;
        this.multiplayer = multiplayer;
        this.sizeGb = sizeGb;
    }

    // Getters
    public int getId()             { return id; }
    public String getName()        { return name; }
    public String getGenre()       { return genre; }
    public String getPlatform()    { return platform; }
    public double getRating()      { return rating; }
    public int getDownloads()      { return downloads; }
    public String getReleaseDate() { return releaseDate; }
    public String getDeveloper()   { return developer; }
    public String getPublisher()   { return publisher; }
    public double getPrice()       { return price; }
    public String getGameMode()    { return gameMode; }
    public boolean isMultiplayer() { return multiplayer; }
    public double getSizeGb()      { return sizeGb; }

    // Setters
    public void setName(String name)              { this.name = name; }
    public void setGenre(String genre)            { this.genre = genre; }
    public void setPlatform(String platform)      { this.platform = platform; }
    public void setRating(double rating)          { this.rating = rating; }
    public void setDownloads(int downloads)       { this.downloads = downloads; }
    public void setReleaseDate(String releaseDate){ this.releaseDate = releaseDate; }
    public void setDeveloper(String developer)    { this.developer = developer; }
    public void setPublisher(String publisher)    { this.publisher = publisher; }
    public void setPrice(double price)            { this.price = price; }
    public void setGameMode(String gameMode)      { this.gameMode = gameMode; }
    public void setMultiplayer(boolean multiplayer){ this.multiplayer = multiplayer; }
    public void setSizeGb(double sizeGb)          { this.sizeGb = sizeGb; }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %.1f★ | $%.2f", id, name, genre, rating, price);
    }
}
