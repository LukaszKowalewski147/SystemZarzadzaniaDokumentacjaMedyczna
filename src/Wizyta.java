import java.util.Date;

public class Wizyta {

    private int maksymalneSpoznienie = 15;      //min
    private StatusWizyty statusWizyty = StatusWizyty.ZAPLANOWANA;
    private Date data;
    private int ocena;

    //  Asocjacja jednego lekarza przeprowadzajacego jedna wizyte
    private Lekarz lekarz;

    //  Leczenie w ktorym skomponowana jest wizyta
    private Leczenie leczenie;

    //  Chroniony konstruktor wywolywany przez metode utworzWizyte() i klasy dziedziczace
    protected Wizyta(Leczenie leczenie, Lekarz lekarz) {
        this.leczenie = leczenie;
        this.lekarz = lekarz;
    }

    //  Metoda tworzaca wizyte i dodajaca ja do leczenia
    public static Wizyta utworzWizyte(Leczenie leczenie, Lekarz lekarz) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowa wizyte
        Wizyta wizyta = new Wizyta(leczenie, lekarz);
        //  Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(wizyta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return wizyta;
    }
}
