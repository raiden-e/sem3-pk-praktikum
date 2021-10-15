package pk.foto;

import java.time.LocalDateTime;

public class Foto {
    private String name;
    private String dateiName;
    private FotoMetadaten metadaten;

    public Foto(String name, String dateiName, int breite, int hoehe, String kameraMarke, String kameraModell,
            LocalDateTime erstellungszeitpunkt) {
        this.name = name;
        this.dateiName = dateiName;
        metadaten = new FotoMetadaten(breite, hoehe, kameraMarke, kameraModell, erstellungszeitpunkt);
    }

    public void drucke() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("Fotoname: %s\nDateiname: %s\n%s", name, dateiName, metadaten);
    }
}