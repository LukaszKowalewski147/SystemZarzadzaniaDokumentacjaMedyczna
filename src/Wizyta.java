import java.util.Date;

public class Wizyta {

    private int maksymalneSpoznienie = 15;      //min
    private StatusWizyty statusWizyty = StatusWizyty.ZAPLANOWANA;
    private Date data;
    private int ocena;

    //  Asocjacja lekarza przeprowadzajacego wizyte
    private Lekarz lekarz;

    //  Leczenie z ktorym powiazana jest wizyta
    private Leczenie leczenie;

    protected Wizyta(Leczenie leczenie, Lekarz lekarz) {
        this.leczenie = leczenie;
        this.lekarz = lekarz;
    }

    public static Wizyta utworzWizyte(Leczenie leczenie, Lekarz lekarz) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        // Utworz nowa wizyte
        Wizyta wizyta = new Wizyta(leczenie, lekarz);
        // Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(wizyta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return wizyta;
    }
}
