import java.util.Date;

public class WynikBadania extends Dokument {

    private String typBadania;
    private String opis;

    public WynikBadania(Date dataWystawienia, String nazwaJednostkiMedycznej,
                        String typBadania, String opis) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.typBadania = typBadania;
        this.opis = opis;
    }

    @Override
    public void wyswietlOpis() {

    }
}
