import java.util.Date;

public class Zalecenie extends Dokument {

    private String poradaMedyczna;

    public Zalecenie(Date dataWystawienia, String nazwaJednostkiMedycznej,
                     String poradaMedyczna) {
        super(dataWystawienia, nazwaJednostkiMedycznej);
        this.poradaMedyczna = poradaMedyczna;
    }

    @Override
    public void wyświetlOpis() {

    }
}
