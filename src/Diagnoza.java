import java.util.Date;

public class Diagnoza extends Dokument {

    private String dolegliwości;

    public Diagnoza(Date dataWystawienia, String nazwaJednostkiMedycznej,
                    String dolegliwości) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.dolegliwości = dolegliwości;
    }

    @Override
    public void wyswietlOpis() {

    }
}
