import java.util.Date;

public class Skierowanie extends Dokument {

    private String typBadania;
    private Date dataWaznosci;

    public Skierowanie(Date dataWystawienia, String nazwaJednostkiMedycznej,
                       String typBadania, Date dataWaznosci) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(dataWystawienia, nazwaJednostkiMedycznej);

        this.typBadania = typBadania;
        this.dataWaznosci = dataWaznosci;
    }

    //  Implementacja metody abstrakcyjnej wyswietlOpis() klasy Dokument
    @Override
    public void wyswietlOpis() {

    }
}
