import java.util.Date;

public class Diagnoza extends Dokument {

    private String dolegliwosci;

    public Diagnoza(Date dataWystawienia, String nazwaJednostkiMedycznej,
                    String dolegliwosci) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.dolegliwosci = dolegliwosci;
    }

    @Override
    public void wyswietlOpis() {

    }
}
