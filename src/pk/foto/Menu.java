package pk.foto;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pk.exceptions.AlbumVorhandenException;
import pk.exceptions.UngueltigeMenueAuswahlException;

public class Menu {
    static FotoVerwaltung fotoverwaltung;

    public static void main(String[] args) throws Exception {
        fotoverwaltung = new FotoVerwaltung();
        Scanner sc = new Scanner(System.in);
        int input = -1;
        String menu = "Foto-App\n\n";
        menu += "\t1. Album hinzufügen\n";
        menu += "\t2. Drucke alle Alben\n";
        menu += "\t3. Drucke Album mit Name\n";
        menu += "\t4. CSV-Export\n";
        menu += "\t5. Beenden\n\n";
        menu += "Bitte Aktion wählen:";

        try {
            while (input != 5) {
                System.out.println(menu);
                try {
                    input = sc.nextInt();
                    if (input == 1)
                        menuAddAlbum();
                    else if (input == 2)
                        fotoverwaltung.druckeAlleAlben();
                    else if (input == 3)
                        menuPrintAlbumByName();
                    else if (input == 4)
                        exportiereCsv();
                    else if (input != 5)
                        throw new UngueltigeMenueAuswahlException("Die Zahl muss von 1 bis 5 sein.");
                } catch (java.util.InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Bitte geben Sie einen gültigen numerischen Wert an.");
                } catch (UngueltigeMenueAuswahlException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static void menuPrintAlbumByName() {
        String inp = JOptionPane.showInputDialog(null, "Bitte gesuchten Namen eingeben");
        System.out.println(fotoverwaltung.findeAlbumMitName(inp));
    }

    private static void menuAddAlbum() {
        String name = getInput("Namen");
        String owner = getInput("Besitzer");
        Album alb = new Album(name, owner);
        while (JOptionPane.showConfirmDialog(null, "Foto hinzufügen?", "Foto hinzufügen",
                JOptionPane.YES_NO_OPTION) == 0) {
            String name1 = getInput("Namen");
            alb.addFoto(new Foto(name1, name1 + ".jpg", 1920, 1080, "Sony", "alpha x1", LocalDateTime.now()));
        }
        try {
            fotoverwaltung.addAlbum(alb);
        } catch (AlbumVorhandenException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String getInput(String param) {
        String obj = JOptionPane.showInputDialog(null, String.format("Bitte %s eingeben", param));
        while (obj == null || obj.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, String.format("Sie müssen einen %s angeben!", param), "Alert",
                    JOptionPane.WARNING_MESSAGE);
            obj = JOptionPane.showInputDialog(null, String.format("Bitte %s eingeben", param));
        }
        return obj;
    }

    private static void exportiereCsv() {
        boolean checks = false;
        File f = new File("");
        while (checks == false) {
            String inp = JOptionPane.showInputDialog(null, "Bitte Dateiname eingeben");
            checks = true;
            if (inp == null || inp.trim().isEmpty()) {
                checks = false;
                JOptionPane.showMessageDialog(null, "Der Name darf nicht leer sein!", "Alert",
                        JOptionPane.WARNING_MESSAGE);
                continue;
            }
            f = new File(inp);
            if (f.exists())
                checks = 0 == JOptionPane.showConfirmDialog(null,
                        "Datei existiert bereits. Soll die Datei überschrieben werden?",
                        "Datei existiert bereits",
                        JOptionPane.YES_NO_OPTION);
        }
        try {
            fotoverwaltung.exportiereEintraegeAlsCsv(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
