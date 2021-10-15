package pk.foto;

public class Foto {
    private String name;
    private String dateiName;

    public void drucke() {
        System.out.println("Fotoname: " + name);
        System.out.println("Dateiname: " + dateiName);
        System.out.println(FotoMetadaten.toString());
    };

    public String toString() {
        return "";
    }
}
