package pk.foto;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;

import javafx.stage.Stage;
import pk.exceptions.AlbumVorhandenException;
import pk.exceptions.FotoMetadatenException;
import pk.foto.ui.AlbumErfassungView;

public class Tester {
    public static void main(String[] args) throws AlbumVorhandenException, IOException, ImageProcessingException,
            MetadataException, NullPointerException, FotoMetadatenException {
        FotoVerwaltung fotoverwaltung1 = new FotoVerwaltung();

         File file = new File("images/DSC02033.jpg");
         System.out.println(file);
         Album album1 = new Album("Album1", "Dieter");
         album1.addFoto(file);
         file = new File("images/35835723323_b3ed4bf5d1_o.jpg");
         album1.addFoto(file);
         
//         fv1.addAlbum(album1);
//         fv1.addAlbum(album1);
//         album1.addFoto(new Foto("Foto2", "Arbeit", 9866, 2738, "Sony", "ModelX", LocalDateTime.now()));
        
        
         Album album2 = new Album("Album2", "Uschi");
         album2.addFoto(new Foto("Foto3", "Urlaub", 678, 3748, "Nikon", "ModelY",
         LocalDateTime.now()));
         album2.addFoto(new Foto("Foto4", "Arbeit", 9866, 2738, "Nikon", "ModelY",
         LocalDateTime.now()));
         fotoverwaltung1.addAlbum(album2);
        
         fotoverwaltung1.druckeAlleAlben();
        
         File datei1 = new File("datei1");
         fotoverwaltung1.exportiereEintraegeAlsCsv(datei1);

        Stage stage = new Stage();
        var albumerfassungview1 = new AlbumErfassungView(stage);
        albumerfassungview1.showView();
    }
}
