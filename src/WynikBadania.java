import java.util.Date;

public class WynikBadania extends Dokument {

    private String typBadania;
    private String opis;

    //  Prywatny konstruktor dostepny tylko z metody utworzWynikBadania()
    private WynikBadania(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                         String typBadania, String opis) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(wizyta, dataWystawienia, nazwaJednostkiMedycznej);

        this.typBadania = typBadania;
        this.opis = opis;
    }

    //  Metoda tworzaca wynik badania
    public static WynikBadania utworzWynikBadania(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                                                 String typBadania, String opis) {
        //  Sprawdzenie czy wizyta istnieje
        if (wizyta == null) {
            System.out.println("Wizyta nie istnieje!");
            return null;
        }
        //  Utworz nowy dokument - wynik badania
        WynikBadania wynikBadania = new WynikBadania(wizyta, dataWystawienia, nazwaJednostkiMedycznej, typBadania, opis);
        try {
            //  Dodaj dokument do wizyty
            wizyta.dodajDokument(wynikBadania);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return wynikBadania;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "";
    }
}
