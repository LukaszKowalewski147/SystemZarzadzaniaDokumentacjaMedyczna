import java.util.Date;

public class Diagnoza extends Dokument {

    private String dolegliwosci;

    public Diagnoza(Date dataWystawienia, String nazwaJednostkiMedycznej,
                    String dolegliwosci) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(dataWystawienia, nazwaJednostkiMedycznej);

        this.dolegliwosci = dolegliwosci;
    }

    //  Implementacja metody abstrakcyjnej wyswietlOpis() klasy Dokument
    @Override
    public void wyswietlOpis() {

    }
}
