import java.util.Date;

public class Recepta extends Dokument {

    private Date dataWaznosci;
    private String dawkowanie;
    private String leki;

    public Recepta(Date dataWystawienia, String nazwaJednostkiMedycznej,
                   Date dataWaznosci, String dawkowanie, String leki) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(dataWystawienia, nazwaJednostkiMedycznej);

        this.dataWaznosci = dataWaznosci;
        this.dawkowanie = dawkowanie;
        this.leki = leki;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "";
    }
}
