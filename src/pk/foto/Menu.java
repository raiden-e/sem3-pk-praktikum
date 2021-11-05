package pk.foto;

import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Menu {

    static FotoVerwaltung fotoverwaltung;

    public static void main(String[] args) {
        fotoverwaltung = new FotoVerwaltung();

        String menu = "Foto-App\n\n";
        menu += "\t1. Album hinzufügen\n";
        menu += "\t2. Drucke alle Alben\n";
        menu += "\t3. Drucke Album mit Name\n";
        menu += "\t4. Beenden\n\n";
        menu += "Bitte Aktion wählen:";
        System.out.println(menu);

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        while (input != 4) {
            if (input == 1) {
                String name = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
                if (name == null) {
                    System.out.println("Sie müssen einen Namen angeben!");
                    continue;
                }
                String owner = JOptionPane.showInputDialog(null, "Bitte Besitzer eingeben");
                if (owner == null) {
                    System.out.println("Sie müs2einen Namen angeben!");
                    continue;
                }
                Album alb = new Album(name, owner);
                while (JOptionPane.showConfirmDialog(null, "Foto hinzufügen?", "Foto hinzufügen",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    String name1 = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
                    alb.addFoto(new Foto(name1, name1 + ".jpg", 1920, 1080, "Sony", "alpha x1", LocalDateTime.now()));
                }
                fotoverwaltung.addAlbum(alb);
            } else if (input == 2)
                fotoverwaltung.druckeAlleAlben();
            else if (input == 3)
                fotoverwaltung.findeAlbumMitName(JOptionPane.showInputDialog(null, "Bitte gesuchten Namen eingeben"));
            else
                System.out.println("Unerwartete Eingabe! Versuchen Sie es bitte erneut");

            System.out.println(menu);
            input = sc.nextInt();
        }
        sc.close();
    }

}
