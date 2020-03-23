public class Main {
    public static void main(String[] args) throws Exception {
        Toidud toidud = new Toidud();
        toidud.test();

        System.out.println(toidud.toString());

        toidud.lisaToit("testtresttest");

        System.out.println(toidud.toString());

        toidud.failistLugemine("C:/toidud.txt");

        System.out.println(toidud.toString());
    }
}
