import java.util.Date;

public class Diagnoza extends Dokument {

    private String dolegliwosci;

    //  Prywatny konstruktor dostepny tylko z metody utworzDiagnoze()
    private Diagnoza(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                     String dolegliwosci) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(wizyta, dataWystawienia, nazwaJednostkiMedycznej);

        this.dolegliwosci = dolegliwosci;
    }

    //  Metoda tworzaca diagnoze
    public static Diagnoza utworzDiagnoze(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej,
                                          String dolegliwosci) {
        //  Sprawdzenie czy wizyta istnieje
        if (wizyta == null) {
            System.out.println("Wizyta nie istnieje!");
            return null;
        }
        //  Utworz nowy dokument - diagnoza
        Diagnoza diagnoza = new Diagnoza(wizyta, dataWystawienia, nazwaJednostkiMedycznej, dolegliwosci);
        try {
            //  Dodaj dokument do wizyty
            wizyta.dodajDokument(diagnoza);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return diagnoza;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "";
    }
}
