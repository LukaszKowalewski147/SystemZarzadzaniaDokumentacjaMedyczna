import java.util.Date;

public class Recepta extends Dokument {

    private Date dataWaznosci;
    private String dawkowanie;
    private String leki;

    public Recepta(Date dataWystawienia, String nazwaJednostkiMedycznej,
                   Date dataWaznosci, String dawkowanie, String leki) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.dataWaznosci = dataWaznosci;
        this.dawkowanie = dawkowanie;
        this.leki = leki;
    }

    @Override
    public void wyswietlOpis() {

    }
}
