import java.util.Date;

public class Skierowanie extends Dokument {

    private String typBadania;
    private Date dataWażności;

    public Skierowanie(Date dataWystawienia, String nazwaJednostkiMedycznej,
                       String typBadania, Date dataWażności) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.typBadania = typBadania;
        this.dataWażności = dataWażności;
    }

    @Override
    public void wyswietlOpis() {

    }
}
