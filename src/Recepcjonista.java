import java.util.Date;

public class Recepcjonista extends Pracownik {

    private String numerStanowiska;

    //  Publiczny konstruktor
    public Recepcjonista(String imie, String nazwisko, String numerTelefonu,
                         String email, String godzinyPracy, String numerStanowiska) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerStanowiska = numerStanowiska;
    }

    //  Metoda tworzaca (rejestrujaca) konto pacjenta
    public Pacjent rejestrujKontoPacjenta(String imie, String nazwisko, String numerTelefonu, String adres,
                                          Date dataUrodzenia, long PESEL, String plec, String rodzajUbezpieczenia) {
        return new Pacjent(imie, nazwisko, numerTelefonu,
                adres, dataUrodzenia, PESEL, plec,rodzajUbezpieczenia);
    }

    //  Metoda wyrejestrowujaca konto pacjenta
    public void wyrejestrujKontoPacjenta(Pacjent pacjent) {
        pacjent.wyrejestrujKonto();
    }

    //  Metoda dostepu do numeru stanowiska
    public String pokazNumerStanowiska() {
        return numerStanowiska;
    }
}
