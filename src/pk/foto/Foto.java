package pk.foto;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;

public class Foto extends Fachobjekt {
    private static final long serialVersionUID = 1L;
    private String dateiName;
    private FotoMetadaten metadaten;

    public Foto(String name, String dateiName, int breite, int hoehe, String kameraMarke, String kameraModell,
            LocalDateTime erstellungszeitpunkt) {
        super(name);
        this.dateiName = dateiName;
        metadaten = new FotoMetadaten(breite, hoehe, kameraMarke, kameraModell, erstellungszeitpunkt);
    }

    public Foto(String name, String dateiName, FotoMetadaten meta) {
        super(name);
        this.dateiName = dateiName;
        metadaten = meta;
    }
    
    public FotoMetadaten getMetadaten() {
        return metadaten;
    }
    
    public String getFilePath() {
        return dateiName;
    }
    public void drucke(OutputStream stream) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(stream);
        sw.write(toString());
        sw.flush();
    }

    public void drucke() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n", super.getName(), dateiName, metadaten);
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
