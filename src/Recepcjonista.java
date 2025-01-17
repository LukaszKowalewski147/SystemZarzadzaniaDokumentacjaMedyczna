import java.util.Date;

public class Recepcjonista extends Pracownik {

    private String numerStanowiska;

    public Recepcjonista(String imie, String nazwisko, String numerTelefonu,
                         String email, String godzinyPracy, String numerStanowiska) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerStanowiska = numerStanowiska;
    }

    public Pacjent rejestrujKontoPacjenta(String imie, String nazwisko, String numerTelefonu, String adres,
                                          Date dataUrodzenia, long PESEL, String plec, String rodzajUbezpieczenia) {
        return new Pacjent(imie, nazwisko, numerTelefonu,
                adres, dataUrodzenia, PESEL, plec,rodzajUbezpieczenia);
    }

    public void wyrejestrujKontoPacjenta(Pacjent pacjent) {
        pacjent.wyrejestrujKonto();
    }
}
