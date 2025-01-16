public class Badanie extends Wizyta {

    private String rodzajBadania;
    private String opisWymaganegoPrzygotowania;

    //  Prywatny konstruktor dostepny tylko z metody utworzBadanie()
    private Badanie(Leczenie leczenie, Lekarz lekarz,
                    String rodzajBadania, String opisWymaganegoPrzygotowania) {
        //  Wywolanie konstruktora klasy nadrzednej Wizyta
        super(leczenie, lekarz);

        this.rodzajBadania = rodzajBadania;
        this.opisWymaganegoPrzygotowania = opisWymaganegoPrzygotowania;
    }

    //  Metoda tworzaca badanie i dodajaca je do leczenia
    public static Badanie utworzBadanie(Leczenie leczenie, Lekarz lekarz,
                                       String rodzajBadania, String opisWymaganegoPrzygotowania) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowe badanie (wizyta)
        Badanie badanie = new Badanie(leczenie, lekarz, rodzajBadania, opisWymaganegoPrzygotowania);
        //  Dodaj badanie (wizyta) do leczenia
        try {
            leczenie.dodajWizyte(badanie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return badanie;
    }
}
