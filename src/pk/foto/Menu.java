package pk.foto;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
        menu += "\t4. Beenden\n\n";
        menu += "Bitte Aktion wählen:";

        try {
            while (input != 4) {
                System.out.println(menu);
                try {
                    input = sc.nextInt();
                } catch (Exception e) {
                    e.printStackTrace();
                    input = -1;
                    sc.nextLine();
                }
                try {
                    if (input == 1) {
                        String name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
                        if (name == null) {
                            System.out.println("Sie müssen einen Namen angeben!");
                            continue;
                        }
                        String owner = JOptionPane.showInputDialog(null, "Bitte Besitzer eingeben");
                        if (owner == null) {
                            System.out.println("Sie müssen einen Namen angeben!");
                            continue;
                        }
                        Album alb = new Album(name, owner);
                        while (JOptionPane.showConfirmDialog(null, "Foto hinzufügen?", "Foto hinzufügen",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            String name1 = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
                            alb.addFoto(new Foto(name1, name1 + ".jpg", 1920, 1080, "Sony", "alpha x1",
                                    LocalDateTime.now()));
                        }
                        fotoverwaltung.addAlbum(alb);
                    } else if (input == 2)
                        fotoverwaltung.druckeAlleAlben();
                    else if (input == 3)
                        fotoverwaltung
                                .findeAlbumMitName(JOptionPane.showInputDialog(null, "Bitte gesuchten Namen eingeben"));
                    else
                        throw new UngueltigeMenueAuswahlException(
                                "Bitte geben Sie einen gültigen numerischen Wert an.");
                } catch (UngueltigeMenueAuswahlException e) {
                    System.out.println(e.getMessage());
                    input = -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

}
