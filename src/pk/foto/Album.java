package pk.foto;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pk.exceptions.FotoMetadatenException;
import pk.foto.util.FotoUtil;

public class Album extends Fachobjekt implements Comparable<Album> {
    private static final long serialVersionUID = 1L;
    private String besitzer;
    List<Foto> fotos = new ArrayList<>();

    public Album(String name, String besitzer) {
        super(name);
        this.besitzer = besitzer;
    }

    public Foto[] getFotos() {
        Iterator<Foto> iter = fotos.iterator();
        Foto[] rueckgabe = new Foto[fotos.size()];
        int zaehler = 0;

        while (iter.hasNext())
            rueckgabe[zaehler++] = iter.next();

        return rueckgabe;
    }
    
    public String getBesitzer() {
        return besitzer;
    }

    public void addFoto(Foto foto) {
        fotos.add(foto);
    }

    public void addFoto(File file) throws FotoMetadatenException {
        try {
            var meta = FotoUtil.readMetadata(file);
            System.out.println(meta);
            Foto foto1 = new Foto(file.getName(), file.getAbsolutePath(), meta);
            this.addFoto(foto1);
        } catch (Exception e) {
            throw new FotoMetadatenException(e.getMessage());
        }
    }

    public String toString() {
        return super.getName();
    }

    public void drucke(OutputStream stream) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(stream);
        sw.write(toString());
        sw.flush();
    }

    public void drucke() {
        System.out.println(toString());
    }

    public String exportiereAlsCsv() {
        StringBuilder sb = new StringBuilder(super.exportiereAlsCsv()).append(",").append(besitzer).append("\n");
        for (Foto foto : fotos)
            sb.append(foto.exportiereAlsCsv());
        return sb.toString();
    }

    @Override
    public int compareTo(Album o) {
        if (this == o)
            return 0;
        if (o == null)
            throw new NullPointerException();
        if (super.getName() == null)
            return o.getName() == null ? 0 : -1;
        if (o.getName() == null)
            return 1;
        return super.getName().compareTo(o.getName());
    }

}
