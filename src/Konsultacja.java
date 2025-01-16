public class Konsultacja extends Wizyta {

    private String online;
    private String wymaganeDokumenty;

    private Konsultacja(Leczenie leczenie, Lekarz lekarz,
                       String online, String wymaganeDokumenty) {
        super(leczenie, lekarz);
        this.online = online;
        this.wymaganeDokumenty = wymaganeDokumenty;
    }

    public static Konsultacja utworzKonsultacje(Leczenie leczenie, Lekarz lekarz,
                                           String online, String wymaganeDokumenty) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        // Utworz nowa wizyte
        Konsultacja konsultacja = new Konsultacja(leczenie, lekarz, online, wymaganeDokumenty);
        // Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(konsultacja);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return konsultacja;
    }
}
