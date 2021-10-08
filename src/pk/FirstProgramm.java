package pk;

public class FirstProgramm {
    public static void main(String[] args) throws Exception {
        // This is a comment
        maleTreppe(8, 3);
        maleTreppe(6, 2);
    }

    public static void maleTreppe(int hoehe, int stufentiefe) {
        String baustein = "";
        for (int i = 0; i < stufentiefe; i++)
            baustein += "*";

        String spacing = "";
        for (int i = 0; i < hoehe * stufentiefe; i++)
            spacing += " ";
        String stufe = "";
        for (int i = 0; i < hoehe; i++) {
            stufe += baustein;
            System.out.println(spacing.substring(0, ((hoehe - i) * stufentiefe)) + stufe);
        }
    }
}
