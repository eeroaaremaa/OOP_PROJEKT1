import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Toit {
    private String toiduNimi;
    private boolean vegan;
    private boolean gluteeniVaba;
    private boolean laktoosiVaba;

    public Toit(String toiduNimi, boolean vegan, boolean gluteeniVaba, boolean laktoosiVaba) {
        this.toiduNimi = toiduNimi;
        this.vegan = vegan;
        this.gluteeniVaba = gluteeniVaba;
        this.laktoosiVaba = laktoosiVaba;
    }

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

    @Override
    public String toString() {
        return "Toit{" +
                "toiduNimi='" + toiduNimi + '\'' +
                ", vegan=" + vegan +
                ", gluteeniVaba=" + gluteeniVaba +
                ", laktoosiVaba=" + laktoosiVaba +
                '}';
    }



}


/*

[toit1, toit2, toit3, .....]
 */
