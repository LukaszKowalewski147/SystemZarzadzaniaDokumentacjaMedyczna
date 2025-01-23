import java.util.Date;

public class Zalecenie extends Dokument {

    private String poradaMedyczna;

    //  Prywatny konstruktor dostepny tylko z metody utworzZalecenie()
    private Zalecenie(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                      String poradaMedyczna) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(wizyta, dataWystawienia, nazwaJednostkiMedycznej);

        this.poradaMedyczna = poradaMedyczna;
    }

    //  Metoda tworzaca zalecenie
    public static Zalecenie utworzZalecenie(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                                              String poradaMedyczna) {
        //  Sprawdzenie czy wizyta istnieje
        if (wizyta == null) {
            System.out.println("Wizyta nie istnieje!");
            return null;
        }
        //  Utworz nowy dokument - zalecenie
        Zalecenie zalecenie = new Zalecenie(wizyta, dataWystawienia, nazwaJednostkiMedycznej, poradaMedyczna);
        try {
            //  Dodaj dokument do wizyty
            wizyta.dodajDokument(zalecenie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return zalecenie;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "Porada medyczna: " + poradaMedyczna;
    }
}
