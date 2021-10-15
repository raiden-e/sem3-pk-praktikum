package pk.foto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FotoMetadaten {
    private int breite;
    private int hoehe;
    private String kameraMarke;
    private String kameraModell;
    private LocalDateTime erstellungszeitpunkt;

    public FotoMetadaten(int pbreite, int phoehe, String pkameraMarke, String pkameraModell,
            LocalDateTime perstellungszeitpunkt) {
        this.breite = pbreite;
        this.hoehe = phoehe;
        this.kameraMarke = pkameraMarke;
        this.kameraModell = pkameraModell;
        this.erstellungszeitpunkt = perstellungszeitpunkt;
    }

    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("DD.MM.YYYY HH:mm:ss");
        String dateText = erstellungszeitpunkt.format(date);

        return String.format("Groesse: %s x %s\nKamera: %s\nErstellungsdatum: %s", hoehe, breite, kameraMarke,
                kameraModell, dateText);
    }

}