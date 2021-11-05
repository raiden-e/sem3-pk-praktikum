package pk.foto;

import java.util.Iterator;
import java.util.LinkedList;

public class FotoVerwaltung {

    LinkedList<Album> alben = new LinkedList<Album>();

    public void druckeAlleAlben() {
        System.out.println("not implemented");
    }

    public int gibAnzahlAlben() {
        return -1;
    }

    public Album[] gibAlleAlben() {
        Iterator<Album> iter = alben.iterator();
        Album[] returner = new Album[alben.size()];



        return returner;
    }

    public void addAlbum(Album album) {
        alben.add(album);
    }

    public Album findeAlbumMitName(String name) {
        return null;
    }
}
