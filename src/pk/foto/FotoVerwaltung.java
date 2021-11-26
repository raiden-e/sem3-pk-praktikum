package pk.foto;

import java.util.Iterator;
import java.util.TreeSet;

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

    public void addAlbum(Album album) {
        alben.add(album);
    }

    public Album findeAlbumMitName(String name) {
        Iterator<Album> iter = alben.iterator();
        Album temp;
        while (iter.hasNext()) {
            temp = iter.next();
            if (temp.getName() == name)
                return temp;
        }
        return null;
    }
}
