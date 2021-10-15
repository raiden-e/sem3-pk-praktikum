package pk.foto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FotoMetadaten {
    private int breite;
    private int hoehe;
    private String kameraMarke;
    private String kameraModell;
    private LocalDateTime erstellungszeitpunkt;

    public String toString() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("TT.MM.JJJJ HH:mm:ss");
        String dateText = erstellungszeitpunkt.format(date);

        return String.format("Groesse: %s x %s\nKamera: %s\nErstellungsdatum: %s", hoehe, breite, kameraMarke,
                kameraModell, dateText);
    }
}
