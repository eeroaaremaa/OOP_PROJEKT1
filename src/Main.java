import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //piirangudBoolean hoiab kasutaja poolt sisestatud piiranguid toitumise osas
    //järjekorras vegan, gluteenivaba ja laktoosivaba
    public static String[] piirangudBoolean = {"false", "false", "false"};

    public static void main(String[] args) throws Exception {
        //Palume kasutajal sisestada enda toitumisega seotud piirangud
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tere tulemast menüü loojasse.");
        System.out.println("Palun sisesta oma toitumispiirangud: ");
        boolean valitud = false;
        ArrayList<String> piirangud = new ArrayList<>();

        //Järgnev while tsükkel küsib kasutajalt tema toitumispiiranguid, kuni
        //ta kõik korrektselt sisestanud on
        while (!valitud) {
            System.out.println("Kui oled vegan sisesta V. Kui oled gluteenivaba sisesta G. Kui oled laktoosivaba sisesta L. Kui sul piiranguid ei ole siis vajuta X");
            String valik = scanner.next();
            if (valik.equals("V") || valik.equals("G") || valik.equals("L") && !piirangud.contains(valik))
                piirangud.add(valik);
            else if (valik.equals("X")) {
                valitud = true;
                break;
            } else if (piirangud.contains(valik)) {
                System.out.println("Oled selle piirangu juba sisestanud");
            } else {
                System.out.println("Palun sisesta sobiv varinat");
                continue;
            }

            //Kui kasutaja on piirangud ära sisestanud siis liigume järgmise osa juurde
            System.out.println("Kui oled oma valikud ära valinud siis sisesta X, kui soovid veel piiranguid lisada sisesta N.");
            valik = scanner.next();
            if (valik.equals("X")) {
                valitud = true;
            } else if (valik.equals("N")) {
                continue;
            } else {
                System.out.println("Palun sisesta sobiv variant.");
            }
        }

        //viime piirangudBooleani andmed sisse sõnedena
        for (int i = 0; i < 3; i++) {
            try {
                if (piirangud.get(i).equals("G")) {
                    piirangudBoolean[1] = "true";
                } else if (piirangud.get(i).equals("V")) {
                    piirangudBoolean[0] = "true";
                } else if (piirangud.get(i).equals("L")) {
                    piirangudBoolean[2] = "true";
                }
            } catch (Exception e) {
            }
        }

        //Loeme failist toidud
        Toidud toidud = new Toidud();
        toidud.failistLugemine("toidud.txt");

        //Järgen while loop küsib kasutajalt mida ta järgmisena teha soovib
        //Kasutaja saab küsida programmilt järgmist suvalist toitu, et kasutaja
        //ei peaks ise valima mis toitu ta järgmisena süüa soovib.
        while (true) {
            System.out.println("Järgmise toidu nägemiseks sisesta J, toidu lisamiseks sisesta +, programmist lahkumiseks sisesta X");
            String valik = scanner.next();
            if (valik.equals("J")) {
                System.out.println(juhuslikGenereerija(toidud));
            } else if (valik.equals("+")) {
                System.out.println("Toidu lisamiseks sisesta toit järgmise vormistusega:");
                String[] sisestamiseleA = new String[4];

                //Kastaja peab sisestama toidu nime ja toitumispiirangute info
                System.out.println("Toidu nimi: ");
                String sisestamisele = scanner.next();
                sisestamiseleA[0] = sisestamisele;

                System.out.println("Kas toit on vegan (sisesta true või false): ");
                sisestamisele = scanner.next();
                if (sisestamisele.equals("true") || sisestamisele.equals("false")) {
                    sisestamiseleA[1] = sisestamisele;
                } else {
                    System.out.println("Sisestasid valesti, palun alusta uuest.");
                    continue;
                }

                System.out.println("Kas toit on gluteenivaba (sisesta true või false): ");
                sisestamisele = scanner.next();
                if (sisestamisele.equals("true") || sisestamisele.equals("false")) {
                    sisestamiseleA[2] = sisestamisele;
                } else {
                    System.out.println("Sisestasid valesti, palun alusta uuest.");
                    continue;
                }

                System.out.println("Kas toit on laktoosivaba (sisesta true või false): ");
                sisestamisele = scanner.next();
                if (sisestamisele.equals("true") || sisestamisele.equals("false")) {
                    sisestamiseleA[3] = sisestamisele;
                } else {
                    System.out.println("Sisestasid valesti, palun alusta uuest.");
                    continue;
                }

                //Kui kasutaja on toidu andmed sisestanud siis lisame selle ka faili

                String faili = sisestamiseleA[0] + ", " + sisestamiseleA[1] + ", " + sisestamiseleA[2] + ", " + sisestamiseleA[3];

                File file = new File("toidud.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write("\n" + faili);
                fileWriter.close();

                //Kui lisatud toit sobib tema toitumispiirangutega lisa see toitude nimekirja
                if (Toidud.sobivus(sisestamiseleA)) {
                    toidud.lisaToit(sisestamiseleA[0], Toidud.leiaVäärtus(sisestamiseleA[1]),
                            Toidud.leiaVäärtus(sisestamiseleA[2]), Toidud.leiaVäärtus(sisestamiseleA[3]));
                    continue;
                }
            //Kui kasutaja valib X siis pannakse kogu programm kinni.
            } else if (valik.equals("X")) {
                System.exit(0);
            }
        }

    }

    //Järgnev meetod valib juhusliku toidu listist ning tagastab selle sõnena
    static String juhuslikGenereerija(Toidud toidud) {
        return toidud.getToidud().get((int) (Math.random() * toidud.getPikkus()) + 1).toString();
    }
}