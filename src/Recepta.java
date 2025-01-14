import java.util.Date;

public class Recepta extends Dokument {

    private Date dataWażności;
    private String dawkowanie;
    private String leki;

    public Recepta(Date dataWystawienia, String nazwaJednostkiMedycznej,
                   Date dataWażności, String dawkowanie, String leki) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.dataWażności = dataWażności;
        this.dawkowanie = dawkowanie;
        this.leki = leki;
    }

    @Override
    public void wyświetlOpis() {

    }
}
