import java.util.Date;

public class Recepta extends Dokument {

    private Date dataWaznosci;
    private String dawkowanie;
    private String leki;

    //  Prywatny konstruktor dostepny tylko z metody utworzRecepte()
    private Recepta(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                    Date dataWaznosci, String dawkowanie, String leki) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(wizyta, dataWystawienia, nazwaJednostkiMedycznej);

        this.dataWaznosci = dataWaznosci;
        this.dawkowanie = dawkowanie;
        this.leki = leki;
    }

    //  Metoda tworzaca recepte
    public static Recepta utworzRecepte(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                                            Date dataWaznosci, String dawkowanie, String leki) {
        //  Sprawdzenie czy wizyta istnieje
        if (wizyta == null) {
            System.out.println("Wizyta nie istnieje!");
            return null;
        }
        //  Utworz nowy dokument - recepta
        Recepta recepta = new Recepta(wizyta, dataWystawienia, nazwaJednostkiMedycznej, dataWaznosci, dawkowanie, leki);
        try {
            //  Dodaj dokument do wizyty
            wizyta.dodajDokument(recepta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return recepta;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "Data waznosci: " + dataWaznosci.toString() + "\nLeki: " + leki + "\nDawkowanie: " + dawkowanie;
    }
}
