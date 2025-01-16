import java.util.Date;

public class Wizyta {

    private int maksymalneSpoznienie = 15;      //min
    private StatusWizyty statusWizyty = StatusWizyty.ZAPLANOWANA;
    private Date data;
    private int ocena;

    //  Asocjacja lekarza przeprowadzajacego wizyte
    private Lekarz lekarz;

    public Wizyta(Lekarz lekarz) {
        // TODO: this.data = data teraz
        this.lekarz = lekarz;
    }
}
