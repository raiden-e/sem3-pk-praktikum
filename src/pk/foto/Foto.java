package pk.foto;

public class Foto {
    private String name;
    private String dateiName;
    private FotoMetadaten metadaten;
    
    public Foto(String pName, String pDateiName) {
    	
    }

    public void drucke() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("Fotoname: %s\nDateiname: %s\n%s", name, dateiName, metadaten);
    }
}
