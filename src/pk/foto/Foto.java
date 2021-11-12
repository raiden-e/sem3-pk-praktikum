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
        /*
         * if (super.getName() == null) { if (other.getName() != null) return false; }
         * else if (!super.getName().equals(other.getName())) return false; if
         * (super.getID() == null) { if (other.getID() != null) return false; } else if
         * (!super.getID().equals(other.getID())) return false;
         */
        return super.equals(obj);
    }

}
