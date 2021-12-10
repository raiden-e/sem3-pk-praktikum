package pk.foto;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

import pk.interfaces.CsvExportable;

public abstract class Fachobjekt implements CsvExportable {
    private final String id = UUID.randomUUID().toString();
    private String name;

    public Fachobjekt(String name) {
        this.name = name;
    }

    public abstract void drucke();
    
    public abstract void drucke (OutputStream stream) throws IOException;

    public abstract String toString();

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String exportiereAlsCsv() {
        return new StringBuilder(this.getID()).append(",").append(this.getName()).toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Fachobjekt other = (Fachobjekt) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

}
