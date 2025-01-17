import java.util.Date;

public class Wizyta {

    private int maksymalneSpoznienie = 15;      //w minutach
    private StatusWizyty statusWizyty = StatusWizyty.ZAPLANOWANA;
    private Date termin;
    private short ocena;

    //  Asocjacja jednego lekarza przeprowadzajacego jedna wizyte
    private Lekarz lekarz;

    //  Leczenie w ktorym skomponowana jest wizyta
    private Leczenie leczenie;

    //  Chroniony konstruktor wywolywany przez metode utworzWizyte() i klasy dziedziczace
    protected Wizyta(Leczenie leczenie, Lekarz lekarz, Date termin) {
        this.leczenie = leczenie;
        this.lekarz = lekarz;
        this.termin = termin;
    }

    //  Metoda tworzaca wizyte i dodajaca ja do leczenia
    public static Wizyta utworzWizyte(Leczenie leczenie, Lekarz lekarz, Date termin) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowa wizyte
        Wizyta wizyta = new Wizyta(leczenie, lekarz, termin);
        //  Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(wizyta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return wizyta;
    }

    public void ocenWizyte(short ocena) {
        this.ocena = ocena;
    }

    public void wystawDokument() {
        Dokument dokument = null;

        //  Uzytkownik wybiera typ dokumentu w UI

        int typDokumentu = 0;
        switch (typDokumentu) {
            case 0:
                dokument = new Skierowanie(termin, "nazwa_jednostki", "typ_badania", null);
                break;
            case 1:
                dokument = new WynikBadania(termin, "nazwa_jednostki", "typ_badania", "opis");
                break;
            case 2:
                dokument = new Diagnoza(termin, "nazwa_jednostki", "dolegliwosci");
                break;
            case 3:
                dokument = new Recepta(termin, "nazwa_jednostki", null, "dawkowanie", "lek1,lek2");
                break;
            case 4:
                dokument = new Zalecenie(termin, "nazwa_jednostki", "porada_medyczna");
                break;
        }

        if (dokument == null)
            return;

        dokument.wybierzNosnik();
    }
}
