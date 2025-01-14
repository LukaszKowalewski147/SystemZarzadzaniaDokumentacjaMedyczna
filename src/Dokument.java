import java.util.Date;

public abstract class Dokument {

    private Date dataWystawienia;
    private String nazwaJednostkiMedycznej;

    protected Dokument(Date dataWystawienia, String nazwaJednostkiMedycznej) {
        this.dataWystawienia = dataWystawienia;
        this.nazwaJednostkiMedycznej = nazwaJednostkiMedycznej;
    }

    public abstract void wyświetlOpis();
}
