package pk.foto;

import java.time.LocalDateTime;

import pk.exceptions.AlbumVorhandenException;

public class Tester {
    public static void main(String[] args) throws AlbumVorhandenException {
        FotoVerwaltung fotoverwaltung1 = new FotoVerwaltung();
        Album album1 = new Album("Album1", "Dieter");
        album1.addFoto(new Foto("Foto1", "Hausaufgaben", 1234, 456, "Sony", "ModelX", LocalDateTime.now()));
        album1.addFoto(new Foto("Foto2", "Arbeit", 9866, 2738, "Sony", "ModelX", LocalDateTime.now()));

        fotoverwaltung1.addAlbum(album1);

        Album album2 = new Album("Album2", "Uschi");
        album2.addFoto(new Foto("Foto3", "Urlaub", 678, 3748, "Nikon", "ModelY", LocalDateTime.now()));
        album2.addFoto(new Foto("Foto4", "Arbeit", 9866, 2738, "Nikon", "ModelY", LocalDateTime.now()));
        fotoverwaltung1.addAlbum(album2);

        fotoverwaltung1.druckeAlleAlben();
    }
}
