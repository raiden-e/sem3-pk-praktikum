package pk.foto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pk.interfaces.CsvExportable;

public class FotoMetadaten implements CsvExportable {
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

    private String getDateText() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
        return erstellungszeitpunkt.format(date);
    }

    public String toString() {
        return String.format("Groesse: %s x %s\nKamera: %s - %s\nErstellungsdatum: %s", hoehe, breite, kameraMarke,
                kameraModell, this.getDateText());
    }

    public String exportiereAlsCsv() {
        StringBuilder sb = new StringBuilder();
        sb.append(breite).append(",");
        sb.append(hoehe).append(",");
        sb.append(kameraMarke).append(",");
        sb.append(kameraModell).append(",");
        sb.append(this.getDateText()).toString();
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + breite;
        result = prime * result + ((erstellungszeitpunkt == null) ? 0 : erstellungszeitpunkt.hashCode());
        result = prime * result + hoehe;
        result = prime * result + ((kameraMarke == null) ? 0 : kameraMarke.hashCode());
        result = prime * result + ((kameraModell == null) ? 0 : kameraModell.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FotoMetadaten other = (FotoMetadaten) obj;
        if (breite != other.breite)
            return false;
        if (erstellungszeitpunkt == null) {
            if (other.erstellungszeitpunkt != null)
                return false;
        } else if (!erstellungszeitpunkt.equals(other.erstellungszeitpunkt))
            return false;
        if (hoehe != other.hoehe)
            return false;
        if (kameraMarke == null) {
            if (other.kameraMarke != null)
                return false;
        } else if (!kameraMarke.equals(other.kameraMarke))
            return false;
        if (kameraModell == null) {
            if (other.kameraModell != null)
                return false;
        } else if (!kameraModell.equals(other.kameraModell))
            return false;
        return true;
    }

}
