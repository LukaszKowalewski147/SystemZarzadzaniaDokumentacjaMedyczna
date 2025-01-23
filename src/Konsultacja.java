import java.util.Date;

public class Konsultacja extends Wizyta {

    private boolean online;
    private String tematKonsultacji;

    //  Prywatny konstruktor dostepny tylko z metody utworzKonsultacje()
    private Konsultacja(Leczenie leczenie, Lekarz lekarz,
                        Date termin, boolean online, String tematKonsultacji) {
        //  Wywolanie konstruktora klasy nadrzednej Wizyta
        super(leczenie, lekarz, termin);

        this.online = online;
        this.tematKonsultacji = tematKonsultacji;
    }

    //  Metoda tworzaca konsultacje i dodajaca ja do leczenia
    public static Konsultacja utworzKonsultacje(Leczenie leczenie, Lekarz lekarz,
                                           Date termin, boolean online, String tematKonsultacji) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowa konsultacje (wizyta)
        Konsultacja konsultacja = new Konsultacja(leczenie, lekarz, termin, online, tematKonsultacji);
        //  Dodaj konsultacje (wizyta) do leczenia
        try {
            leczenie.dodajWizyte(konsultacja);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return konsultacja;
    }
}
