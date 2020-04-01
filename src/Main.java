import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tere tulemast menüü loojasse.");
        System.out.println("Palun sisesta oma toitumispiirangud: ");
        boolean valitud = false;
        ArrayList<String> piirangud = new ArrayList<>();

        while(!valitud) {
            System.out.println("Kui oled vegan sisesta V. Kui oled gluteenivaba sisesta G. Kui oled laktoosivaba sisesta L.");
            String valik = scanner.next();
            if(valik.equals("V") || valik.equals("G") || valik.equals("L") && !piirangud.contains(valik))
                piirangud.add(valik);
            else if(piirangud.contains(valik)){
                System.out.println("Oled selle piirangu juba sisestanud");
            }
            else {
                System.out.println("Palun sisesta sobiv varinat");
                continue;
            }
            System.out.println("Kui oled oma valikud ära valinud siis sisesta X, kui soovid veel piiranguid lisada sisesta V.");
            valik = scanner.next();
            if(valik.equals("X")){
                valitud = true;
            }else if(valik.equals("V")){
                continue;
            }else {
                System.out.println("Palun sisesta sobiv variant.");
            }
        }
        Toidud toidud = new Toidud();
        //toidud.test();


    static String juhuslikGenereerija(Toidud toidud){
        return toidud.getToidud().get((int) (Math.random() * toidud.getPikkus()) +1).toString();
    }
}
