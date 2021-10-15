package pk.foto;

public class Foto {
    private String name;
    private String dateiName;
    private FotoMetadaten metadaten;

    public void drucke() {
        System.out.println("Fotoname: " + name);
        System.out.println("Dateiname: " + dateiName);
        System.out.println(metadaten);
    };

    public String toString() {
        return "";
    }
}
