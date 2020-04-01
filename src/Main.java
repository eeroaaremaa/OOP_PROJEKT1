public class Main {
    public static void main(String[] args) throws Exception {
        Toidud toidud = new Toidud();
        toidud.test();

        //System.out.println(toidud.toString());

        toidud.failistLugemine("toidud.txt");

        //System.out.println(toidud.toString());

        System.out.println(juhuslikGenereerija(toidud));
    }


    static String juhuslikGenereerija(Toidud toidud){
        return toidud.getToidud().get((int) (Math.random() * toidud.getPikkus()) +1).toString();
    }
}