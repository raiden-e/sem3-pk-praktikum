package pk.foto;

import java.time.LocalDateTime;

public class FotoMetadaten {
    private int breite;
    private int hoehe;
    private String kameraMarke;
    private String kameraModell;
    private LocalDateTime erstellungszeipunkt;

    public String toString() {
        return String.format("Groesse: %s x %s\nKamera: %s\nErstellungsdatum: %s", hoehe, breite, kameraMarke,
                kameraModell, erstellungszeipunkt);
    }
}
