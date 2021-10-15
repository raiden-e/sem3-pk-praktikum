package pk.foto;

public class Album {
    private String name;
    private String besitzer;

    Foto[] fotos = new Foto[2];

    public void drucke() {
        System.out.println(String.format("Name: %s\nBesitzer: %s", name, besitzer));
        int counter = 1;
        for (Foto foto : fotos)
            System.out.println(String.format("=== Foto %s ===\n%-4s", counter++, foto));
    }

    public Foto[] getFotos() {

    }

    public void addFoto(Foto foto) {

    }

    public String toString() {

    }
}
