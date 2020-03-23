import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Toidud {

    private ArrayList<Toit> Toidud = new ArrayList<Toit>();

    public Toidud(ArrayList<Toit> toidud) {
        Toidud = toidud;
    }

    public Toidud() {}

    public ArrayList<Toit> getToidud() {
        return Toidud;
    }

    @Override
    public String toString() {
        return "Toidud{" +
                "Toidud=" + Toidud +
                '}';
    }

    public void test(){
        Toidud.add(new Toit("Vegan hakklihakase ja kartul", true,true,true));
    }

    //Siin toimub failist, mis sisaldab toitude infot lugemine
    //Loeteakse terve fail korraga.
    public void failistLugemine(String failiPath) throws FileNotFoundException {
        File toiduInfo = new File(failiPath);
        Scanner scanner = new Scanner(toiduInfo);

        int reaLoendur = 0;
        while(scanner.hasNextLine()){
            String rida = scanner.nextLine();
            //Siin splitib rea vastavalt
            //for loop failist sisu lugemiseks
            // i (lugeja) = reast tekitatud massiiv

            Toidud.add(new Toit("Vegan hakklihakase ja mine munni", true,true,true));

            reaLoendur++;
        }
    }


    public void lisaToit(String nimi){
        this.Toidud.add(new Toit(nimi, true, true, true));
    }
}
