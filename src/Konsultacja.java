public class Konsultacja extends Wizyta {

    private String online;
    private String wymaganeDokumenty;

    //  Prywatny konstruktor dostepny tylko z metody utworzKonsultacje()
    private Konsultacja(Leczenie leczenie, Lekarz lekarz,
                       String online, String wymaganeDokumenty) {
        //  Wywolanie konstruktora klasy nadrzednej Wizyta
        super(leczenie, lekarz);

        this.online = online;
        this.wymaganeDokumenty = wymaganeDokumenty;
    }

    //  Metoda tworzaca konsultacje i dodajaca ja do leczenia
    public static Konsultacja utworzKonsultacje(Leczenie leczenie, Lekarz lekarz,
                                           String online, String wymaganeDokumenty) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowa konsultacje (wizyta)
        Konsultacja konsultacja = new Konsultacja(leczenie, lekarz, online, wymaganeDokumenty);
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
