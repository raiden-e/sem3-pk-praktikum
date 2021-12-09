package pk.foto;

import java.time.LocalDateTime;

public class Foto extends Fachobjekt {
    private String dateiName;
    private FotoMetadaten metadaten;

    public Foto(String name, String dateiName, int breite, int hoehe, String kameraMarke, String kameraModell,
            LocalDateTime erstellungszeitpunkt) {
        super(name);
        this.dateiName = dateiName;
        metadaten = new FotoMetadaten(breite, hoehe, kameraMarke, kameraModell, erstellungszeitpunkt);
    }

    public void drucke() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("Fotoname: %s\nDateiname: %s\n%s\n", super.getName(), dateiName, metadaten);
    }

    public String exportiereAlsCsv() {
        return new StringBuilder(super.exportiereAlsCsv()).append(",").append(dateiName).append("\n")
                .append(metadaten.exportiereAlsCsv()).append("\n").toString();
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + ((dateiName == null) ? 0 : dateiName.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Foto other = (Foto) obj;
        if (dateiName == null) {
            if (other.dateiName != null)
                return false;
        } else if (!dateiName.equals(other.dateiName))
            return false;

        return super.equals(obj);
    }

}
