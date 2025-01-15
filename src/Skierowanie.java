import java.util.Date;

public class Skierowanie extends Dokument {

    private String typBadania;
    private Date dataWaznosci;

    public Skierowanie(Date dataWystawienia, String nazwaJednostkiMedycznej,
                       String typBadania, Date dataWaznosci) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.typBadania = typBadania;
        this.dataWaznosci = dataWaznosci;
    }

    @Override
    public void wyswietlOpis() {

    }
}
