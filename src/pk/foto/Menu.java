package pk.foto;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Menu {

	static FotoVerwaltung fotoverwaltung;
	
	public static void main (String[] args) {
		
		fotoverwaltung = new FotoVerwaltung();
		
		String menu = "Foto-App\n\n"
				+ "\t1. Album hinzufügen\n"
				+"\t2. Drucke alle Alben\n"
				+"\t3. Drucke Album mit Name\n"
				+"\t4. Beenden\n\n"
				+"Bitte Aktion wählen:";
		System.out.println(menu);
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		while(input != 4) {
			
			if (input == 1) {			
				String name = JOptionPane.showInputDialog(null, "Bitte Namen einngeben");
				String owner = JOptionPane.showInputDialog(null, "Bitte Besitzer einngeben");
				fotoverwaltung.addAlbum(new Album(name, owner));
				while (JOptionPane.showConfirmDialog(null, "Foto hinzufügen?", "Foto hinzufügen", JOptionPane.YES_NO_OPTION) == 0) {
					String name1 = JOptionPane.showInputDialog(null, "Bitte Namen einngeben");
					String owner1 = JOptionPane.showInputDialog(null, "Bitte Besitzer einngeben");
					fotoverwaltung.addAlbum(new Album(name1, owner1));
				}									
			}
			else if (input == 2) 
				fotoverwaltung.druckeAlleAlben();
			else if (input == 3)
				fotoverwaltung.findeAlbumMitName(JOptionPane.showInputDialog(null, "Bitte gesuchten Namen eingeben"));
			else 
				System.out.println("Unerwartete Eingabe! Versuchen Sie es bitte erneut");
			
			System.out.print(menu);
			input = sc.nextInt();
		}
		sc.close();	
	}
	
}
