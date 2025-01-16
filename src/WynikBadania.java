import java.util.Date;

public class WynikBadania extends Dokument {

    private String typBadania;
    private String opis;

    public WynikBadania(Date dataWystawienia, String nazwaJednostkiMedycznej,
                        String typBadania, String opis) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(dataWystawienia, nazwaJednostkiMedycznej);

        this.typBadania = typBadania;
        this.opis = opis;
    }

    //  Implementacja metody abstrakcyjnej wyswietlOpis() klasy Dokument
    @Override
    public void wyswietlOpis() {

    }
}
