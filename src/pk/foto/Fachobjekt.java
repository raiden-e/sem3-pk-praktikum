package pk.foto;

import java.util.Objects;
import java.util.UUID;

public abstract class Fachobjekt {
    private final String id = UUID.randomUUID().toString();
    private String name;

    public Fachobjekt(String name) {
        this.name = name;
    }

    public abstract void drucke();

    public abstract String toString();

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
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
