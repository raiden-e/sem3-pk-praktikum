package pk.foto;

import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
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

    public void exportiereEintraegeAlsCsv(File datei) throws IOException {
        var d = datei.getName();
        if (!d.substring(d.length() - 4, d.length()).equals(".csv"))
            datei = new File(datei.getParentFile(), d + ".csv");
        try (FileWriter fw = new FileWriter(datei); PrintWriter pw = new PrintWriter(fw)) {
            StringBuilder input = new StringBuilder();
            for (Album album : alben)
                input.append(album.exportiereAlsCsv());
            pw.println(input);
        }
    }

    public void exportiereEintraegeAlsCsvNio(File datei) throws IOException {
        var d = datei.getName();
        if (!d.substring(d.length() - 4, d.length()).equals(".csv"))
            datei = new File(datei.getParentFile(), d + ".csv");
        try {
            StringBuilder input = new StringBuilder();
            for (Album album : alben)
                input.append(album.exportiereAlsCsv());

            Files.writeString(datei.toPath(), input);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler bei Export", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            throw e;
        }
    }

    public void importEintrargevonCSV(File datei) throws IOException {
        var d = datei.getName();
        if (!d.substring(d.length() - 4, d.length()).equals(".csv"))
            datei = new File(datei.getParentFile(), d + ".csv");

    }

    public void laden() {
        File file = new File("test.ser");
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.alben = (TreeSet<Album>)ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void speichern() throws IOException {
        File file = new File("Fotos.dat");
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(alben); // TreeSet ist serializable :)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
