package pk.foto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Album extends Fachobjekt {
    private String besitzer;
    List<Foto> fotos = new ArrayList<>();

    public Album(String name, String besitzer) {
        super(name);
        this.besitzer = besitzer;
    }

    public Foto[] getFotos() {
        Iterator<Foto> iter = fotos.iterator();
        Foto[] rueckgabe = new Foto[fotos.size()];
        int zaehler = 0;

        while (iter.hasNext())
            rueckgabe[zaehler++] = iter.next();

        return rueckgabe;
    }

    public void addFoto(Foto foto) {
        fotos.add(foto);
    }

    public String toString() {
        String x = String.format("Name: %s\nBesitzer: %s", super.getName(), besitzer);
        int counter = 1;
        for (Foto foto : fotos)
            x += String.format("\n=== Foto %s ===\n%-4s", counter++, foto);

        return x;
    }

    public void drucke() {
        System.out.println(toString());
    }

}
