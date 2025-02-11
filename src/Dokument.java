import java.util.Date;
import java.util.HashSet;

public abstract class Dokument {

    private Date dataWystawienia;
    private String nazwaJednostkiMedycznej;

    //  Wizyta z ktora powiazany jest dokument (kompozycja dokumentow w wizycie)
    private Wizyta wizyta;

    //  Ekstensja klasy Nosnik
    private static HashSet<Nosnik> wszystkieNosniki = new HashSet<Nosnik>();
    //  Nosnik ktory powiazany jest z dokumentem (kompozycja nosnika w dokumencie)
    private Nosnik nosnik;

    //  Chroniony konstruktor wywolywany tylko przez klasy dziedziczace
    protected Dokument(Wizyta wizyta, Date dataWystawienia, String nazwaJednostkiMedycznej) {
        this.wizyta = wizyta;
        this.dataWystawienia = dataWystawienia;
        this.nazwaJednostkiMedycznej = nazwaJednostkiMedycznej;
    }

    //  Metoda do wyboru nosnika przez uzytkownika
    public void wybierzNosnik() {
        int indeksNosnika = 0;

        //  Interakcja z UI

        switch (indeksNosnika) {
            case 0:
                //  Utworzenie nosnika - dokument elektroniczny
                DokumentElektroniczny.utworzDokumentElektroniczny(this, "podpis elektroniczny");
                break;
            case 1:
                //  Utworzenie nosnika - dokument papierowy
                DokumentPapierowy.utworzDokumentPapierowy(this, 12345678L);
                break;
        }
    }

    //  Metoda nadajaca nosnik dla dokumentu
    public void nadajNosnik(Nosnik nosnik) throws Exception {
        //  Sprawdz czy ten nosnik nie zostal dodany do jakiegos dokumentu
        if (wszystkieNosniki.contains(nosnik)) {
            throw new Exception("Ten nosnik jest juz powiazany z jakims dokumentem!");
        }
        this.nosnik = nosnik;
        //  Zapamietaj na liscie wszystkich nosnikow (przeciwdziala wspoldzielniu nosnikow)
        wszystkieNosniki.add(nosnik);
    }

    //  Metoda abstrakcyjna implementowana przez wszystkie klasy dziedziczace
    public abstract String pobierzOpis();

    //  Metoda dostepu do wizyty do ktorej przypisany jest dokument
    public Wizyta pokazWizyte() {
        return wizyta;
    }

    //  Metoda dostepu do daty wystawienia
    public Date pokazDateWystawienia() {
        return dataWystawienia;
    }

    //  Metoda dostepu do nazwy jednostki medycznej
    public String pokazNazweJednostkiMedycznej() {
        return nazwaJednostkiMedycznej;
    }
}
