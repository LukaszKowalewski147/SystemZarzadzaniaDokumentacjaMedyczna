import java.util.Date;
import java.util.HashSet;

public abstract class Dokument {

    private Date dataWystawienia;
    private String nazwaJednostkiMedycznej;

    private static HashSet<Nosnik> wszystkieNosniki = new HashSet<Nosnik>();
    private Nosnik nosnik;

    public Dokument(Date dataWystawienia, String nazwaJednostkiMedycznej, Nosnik nosnik) {
        this.dataWystawienia = dataWystawienia;
        this.nazwaJednostkiMedycznej = nazwaJednostkiMedycznej;

        try {
            wybierzNosnik(nosnik);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void wybierzNosnik(Nosnik nosnik) throws Exception {
        // Sprawdz czy ten nosnik nie zostal dodany do jakiegos dokumentu
        if(wszystkieNosniki.contains(nosnik)) {
            throw new Exception("Ten nosnik jest juz powiazany z innym dokumentem!"); }
        this.nosnik = nosnik;
        // Zapamietaj na liscie wszystkich nosnikow (przeciwdziala wspoldzielniu nosnikow)
        wszystkieNosniki.add(nosnik);
    }

    public abstract void wyswietlOpis();
}
