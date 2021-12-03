package pk.foto;

import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import pk.exceptions.AlbumVorhandenException;

public class FotoVerwaltung {
    TreeSet<Album> alben = new TreeSet<>();

    public void druckeAlleAlben() {
        Iterator<Album> iter = alben.iterator();
        int i = 1;
        while (iter.hasNext())
            System.out.println(String.format("\n=== Album %s ===\n%s", i++, iter.next()));
    }

    public int gibAnzahlAlben() {
        return alben.size();
    }

    public Album[] gibAlleAlben() {
        Album[] returner = new Album[alben.size()];
        Iterator<Album> iter = alben.iterator();
        for (int i = 0; i < alben.size(); i++)
            returner[i] = iter.next();

        return returner;
    }

    public void addAlbum(Album album) throws AlbumVorhandenException {
        if (findeAlbumMitName(album.getName()) != null)
            throw new AlbumVorhandenException("Der Name ist vergeben, bitte vesuchen Sie es erneut.");
        alben.add(album);
    }

    public Album findeAlbumMitName(String name) {
        Iterator<Album> iter = alben.iterator();
        Album temp;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.getName().equals(name))
                return temp;
        }
        return null;
    }
    
    public void exportiereEintraegeAlsCsv(File datei) throws IOException{
        try {
            StringBuilder input = new StringBuilder();
            for (Album album : alben) {
                input.append(album.exportiereAlsCsv());
            }
            Files.writeString(datei.toPath(), input);
        }
        catch (IOException e){
            System.err.println("Fehler beim Schreiben der Datei");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler bei Export", "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
    }
}

