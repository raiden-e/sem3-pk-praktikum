package pk.foto;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;

import pk.exceptions.AlbumVorhandenException;
import pk.exceptions.FotoMetadatenException;

public class Tester {
    public static void main(String[] args) throws AlbumVorhandenException, IOException, ImageProcessingException, MetadataException, NullPointerException, FotoMetadatenException {
        FotoVerwaltung fotoverwaltung1 = new FotoVerwaltung();
        
        File file1 = new File("images/DSC02033.jpg");
        System.out.println(file1);
        Album album1 = new Album("Album1", "Dieter");
        album1.addFoto(file1);
        album1.addFoto(new Foto("Foto1", "Hausaufgaben", 1234, 456, "Sony", "ModelX", LocalDateTime.now()));
        album1.addFoto(new Foto("Foto2", "Arbeit", 9866, 2738, "Sony", "ModelX", LocalDateTime.now()));

        fotoverwaltung1.addAlbum(album1);

        Album album2 = new Album("Album2", "Uschi");
        album2.addFoto(new Foto("Foto3", "Urlaub", 678, 3748, "Nikon", "ModelY", LocalDateTime.now()));
        album2.addFoto(new Foto("Foto4", "Arbeit", 9866, 2738, "Nikon", "ModelY", LocalDateTime.now()));
        fotoverwaltung1.addAlbum(album2);

        fotoverwaltung1.druckeAlleAlben();

        File datei1 = new File("datei1");
        fotoverwaltung1.exportiereEintraegeAlsCsv(datei1);
    }
}
