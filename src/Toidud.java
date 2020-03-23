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
    public void failistLugemine(String failiPath) throws Exception {
        File toiduInfo = new File(failiPath);
        try{
            Scanner scanner = new Scanner(toiduInfo);

            int reaLoendur = 0;
            while(scanner.hasNextLine()){
                String rida = scanner.nextLine();

                String[] rea_info = rida.split(", ");
                try{
                    if(rea_info[1].equals("true") || rea_info[1].equals("false")){

                        Toidud.add(new Toit(rea_info[0], leiaVäärtus(rea_info[1]),
                                leiaVäärtus(rea_info[2]), leiaVäärtus(rea_info[3])));
                    }
                } catch (Exception e) {
                    System.out.println(rea_info[0]);
                }
                //Siin splitib rea vastavalt
                //for loop failist sisu lugemiseks
                // i (lugeja) = reast tekitatud massiiv

                reaLoendur++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public boolean leiaVäärtus(String sõne){
        if(sõne.equals("true"))
            return true;
        return false;
    }


    public void lisaToit(String nimi){
        this.Toidud.add(new Toit(nimi, true, true, true));
    }
}
