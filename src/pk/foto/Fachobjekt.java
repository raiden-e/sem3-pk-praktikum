package pk.foto;

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
}
