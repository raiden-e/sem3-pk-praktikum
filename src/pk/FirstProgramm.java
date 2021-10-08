package pk;

public class FirstProgramm {
    public static void main(String[] args) throws Exception {
        maleTreppe(8, 3);
        maleTreppe(6, 2);
    }

    public static void maleTreppe(int hoehe, int stufentiefe) {
        String baustein = "";
        for (int i = 0; i < stufentiefe; i++)
            baustein += "*";
        String stufe = "";
        for (int i = 0; i < hoehe; i++) {
            stufe += baustein;
            System.out.println(stufe);
        }
    }
}
