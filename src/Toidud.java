import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Toidud {
    //Loome ArrayListi, kus hakkame hoidma erinevaid toite.
    private ArrayList<Toit> Toidud = new ArrayList<Toit>();

    //Konstruktor.
    public Toidud(ArrayList<Toit> toidud) {
        Toidud = toidud;
    }

    //Konstruktor
    public Toidud() {
    }

    //Get meetod.
    public ArrayList<Toit> getToidud() {
        return Toidud;
    }

    //toString
    @Override
    public String toString() {
        return "Toidud{" +
                "Toidud=" + Toidud +
                '}';
    }

    //Siin toimub failist, mis sisaldab toitude infot, lugemine.
    //Loeteakse terve fail korraga.
    public void failistLugemine(String failiPath) throws Exception {
        File toiduInfo = new File(failiPath);
        try {
            Scanner scanner = new Scanner(toiduInfo);
            //Muutuja, mis loeb, mis rida meil parasjagu failist sisse loeti.
            int reaLoendur = 0;
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();

                String[] rea_info = rida.split(", ");
                try {
                    if (rea_info[1].equals("true") || rea_info[1].equals("false")) {

                        if (sobivus(rea_info)) {
                            Toidud.add(new Toit(rea_info[0], leiaVäärtus(rea_info[1]),
                                    leiaVäärtus(rea_info[2]), leiaVäärtus(rea_info[3])));
                        }
                    }
                } catch (Exception ignored) {
                }
                reaLoendur++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    //Meetod, mis muudab sõnena sisse antud "true" või "false" tõeväärtusteks.
    //Tagastab - true, kui sõne on "true", tagastab false, kui sõne on "false".
    public static boolean leiaVäärtus(String sõne) {
        if (sõne.equals("true"))
            return true;
        return false;
    }

    //Meetod, toitude ArrayListi pikkuse saamiseks Listi indeksitega tegelemiseks, sellepärast ka lõpus -1.
    public int getPikkus() {
        return Toidud.size() - 1;
    }

    //Lisab vastava toidu Listi.
    public void lisaToit(String nimi, boolean vegan, boolean gVaba, boolean lVaba) {
        this.Toidud.add(new Toit(nimi, vegan, gVaba, lVaba));
    }
    //Meetod, mis määrab, kas toit sobib kasutaja sisestatud tingimustega.
    //Tagastab tõeväärtuse
    public static boolean sobivus(String[] rea_info) {
        if ((Main.piirangudBoolean[0].equals("true") && rea_info[1].equals("false")) ||
                Main.piirangudBoolean[1].equals("true") && rea_info[2].equals("false") ||
                Main.piirangudBoolean[2].equals("true") && rea_info[3].equals("false")) {
            return false;
        } else {
            return true;
        }
    }

}
