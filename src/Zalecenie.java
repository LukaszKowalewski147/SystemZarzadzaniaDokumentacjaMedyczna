import java.util.Date;

public class Zalecenie extends Dokument {

    private String poradaMedyczna;

    public Zalecenie(Date dataWystawienia, String nazwaJednostkiMedycznej,
                     String poradaMedyczna) {
        //  Wywolanie konstruktora klasy nadrzednej Dokument
        super(dataWystawienia, nazwaJednostkiMedycznej);

        this.poradaMedyczna = poradaMedyczna;
    }

    //  Implementacja metody abstrakcyjnej pobierzOpis() klasy Dokument
    @Override
    public String pobierzOpis() {
        return "";
    }
}
