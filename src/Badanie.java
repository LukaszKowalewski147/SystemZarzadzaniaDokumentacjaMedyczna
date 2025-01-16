public class Badanie extends Wizyta {

    private String rodzajBadania;
    private String opisWymaganegoPrzygotowania;

    private Badanie(Leczenie leczenie, Lekarz lekarz,
                    String rodzajBadania, String opisWymaganegoPrzygotowania) {
        super(leczenie, lekarz);
        this.rodzajBadania = rodzajBadania;
        this.opisWymaganegoPrzygotowania = opisWymaganegoPrzygotowania;
    }

    public static Badanie utworzBadanie(Leczenie leczenie, Lekarz lekarz,
                                       String rodzajBadania, String opisWymaganegoPrzygotowania) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        // Utworz nowa wizyte
        Badanie badanie = new Badanie(leczenie, lekarz, rodzajBadania, opisWymaganegoPrzygotowania);
        // Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(badanie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return badanie;
    }
}
