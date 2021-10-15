package pk.foto;

public class Album {
    private String name;
    private String besitzer;
    Foto[] fotos = new Foto[2];

    public Album(String name, String besitzer) {
        this.name = name;
        this.besitzer = besitzer;
    }

    public void drucke() {
        System.out.println(toString());
    }

    public Foto[] getFotos() {
        return fotos;
    }

    public void addFoto(Foto foto) {
        int i;

        for (i = 0; i < fotos.length; i++) {
            if (fotos[i] == null) {
                fotos[i] = foto;
                return;
            }
        }

        Foto[] fotosNeu = new Foto[fotos.length + 1];

        for (int j = 0; j < fotos.length; j++)
            fotosNeu[j] = fotos[j];

        fotosNeu[fotos.length] = foto;
        fotos = fotosNeu;
    }

    public String toString() {
        String x = String.format("Name: %s\nBesitzer: %s", name, besitzer);
        int counter = 1;
        for (Foto foto : fotos)
            x += String.format("\n=== Foto %s ===\n%-4s", counter++, foto);

        return x;
    }

    public String getName() {
        return this.name;
    }
}
