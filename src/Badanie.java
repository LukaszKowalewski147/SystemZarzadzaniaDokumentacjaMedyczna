import java.util.Date;

public class Badanie extends Wizyta {

    private Skierowanie skierowanie;
    private String opisWymaganegoPrzygotowania;
    private boolean zrealizowane = false;

    //  Prywatny konstruktor dostepny tylko z metody utworzBadanie()
    private Badanie(Leczenie leczenie, Lekarz lekarz,
                    Date termin, Skierowanie skierowanie) {
        //  Wywolanie konstruktora klasy nadrzednej Wizyta
        super(leczenie, lekarz, termin);

        this.skierowanie = skierowanie;
    }

    //  Metoda tworzaca badanie i dodajaca je do leczenia
    public static Badanie utworzBadanie(Leczenie leczenie, Lekarz lekarz,
                                       Date termin, Skierowanie skierowanie) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowe badanie (wizyta)
        Badanie badanie = new Badanie(leczenie, lekarz, termin, skierowanie);
        //  Dodaj badanie (wizyta) do leczenia
        try {
            leczenie.dodajWizyte(badanie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return badanie;
    }

    public void dodajOpisWymaganegoPrzygotowania(String opisWymaganegoPrzygotowania) {
        this.opisWymaganegoPrzygotowania = opisWymaganegoPrzygotowania;
    }

    public void zmienStatusNaZrealizowane() {
        zrealizowane = true;
    }
}
