public class Toit {
    private String toiduNimi;
    private boolean vegan;
    private boolean gluteeniVaba;
    private boolean laktoosiVaba;

    //Konstruktor.
    public Toit(String toiduNimi, boolean vegan, boolean gluteeniVaba, boolean laktoosiVaba) {
        this.toiduNimi = toiduNimi;
        this.vegan = vegan;
        this.gluteeniVaba = gluteeniVaba;
        this.laktoosiVaba = laktoosiVaba;
    }

    //Get ja set meetodid.

    public String getToiduNimi() {
        return toiduNimi;
    }

    public void setToiduNimi(String toiduNimi) {
        this.toiduNimi = toiduNimi;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGluteeniVaba() {
        return gluteeniVaba;
    }

    public void setGluteeniVaba(boolean gluteeniVaba) {
        this.gluteeniVaba = gluteeniVaba;
    }

    public boolean isLaktoosiVaba() {
        return laktoosiVaba;
    }

    public void setLaktoosiVaba(boolean laktoosiVaba) {
        this.laktoosiVaba = laktoosiVaba;
    }

    //toString.
    @Override
    public String toString() {
        String a = "";
        String b = "";
        String c = "";


        if (vegan) a = " vegan";

        else if (gluteeniVaba) b = " gluteenivaba";

        else if (laktoosiVaba) c = " laktoosivaba";

        return toiduNimi + "," + a + b + c;
    }


}
