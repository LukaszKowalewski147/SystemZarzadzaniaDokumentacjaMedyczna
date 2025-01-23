import java.util.Date;

public class Skierowanie extends Dokument {

    private String typBadania;
    private Date dataWaznosci;

    //  Prywatny konstruktor dostepny tylko z metody utworzSkierowanie()
    private Skierowanie(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                        String typBadania, Date dataWaznosci) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(wizyta, dataWystawienia, nazwaJednostkiMedycznej);

        this.typBadania = typBadania;
        this.dataWaznosci = dataWaznosci;
    }

    //  Metoda tworzaca skierowanie
    public static Skierowanie utworzSkierowanie(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                                                String typBadania, Date dataWaznosci) {
        //  Sprawdzenie czy wizyta istnieje
        if (wizyta == null) {
            System.out.println("Wizyta nie istnieje!");
            return null;
        }
        //  Utworz nowy dokument - skierowanie
        Skierowanie skierowanie = new Skierowanie(wizyta, dataWystawienia, nazwaJednostkiMedycznej, typBadania, dataWaznosci);
        try {
            //  Dodaj dokument do wizyty
            wizyta.dodajDokument(skierowanie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return skierowanie;
    }

    //  Metoda zwracajaca informacje o skierowaniu
    public String pobierzInformacjeOSkierowaniu() {
        return typBadania + "\nWazne do: " + dataWaznosci.toString();
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "";
    }
}
