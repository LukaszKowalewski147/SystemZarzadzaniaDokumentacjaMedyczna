import java.util.Date;
import java.util.HashSet;

public abstract class Dokument {

    private Date dataWystawienia;
    private String nazwaJednostkiMedycznej;

    //  Ekstensja klasy Nosnik
    private static HashSet<Nosnik> wszystkieNosniki = new HashSet<Nosnik>();
    //  Kompozycja jednego nosnika dokumentu
    private Nosnik nosnik;

    public Dokument(Date dataWystawienia, String nazwaJednostkiMedycznej) {
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

    public abstract void wyswietlOpis();
}
