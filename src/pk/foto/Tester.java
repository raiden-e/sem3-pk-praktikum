package pk.foto;

public class Tester {
    public static void main(String[] args) {
        FotoVerwaltung fotoverwaltung1 = new FotoVerwaltung();
        fotoverwaltung1.addAlbum(new Album(new Foto("Foto1", "Foto1.png"), new Foto("Foto2", "Foto2.png")));
        fotoverwaltung1.addAlbum(new Album(new Foto("Foto1", "Foto3.jpg"), new Foto("Foto2", "Foto4.jpg")));

        fotoverwaltung1.druckeAlleAlben();
    }
}
