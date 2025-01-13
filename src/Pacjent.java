import java.util.Date;

public class Pacjent extends UżytkownikSystemu {

    private String płeć;
    private Date dataUrodzenia;
    private int PESEL;
    private String adres;
    private String rodzajUbezpieczenia;

    public Pacjent(String imię, String nazwisko, String numerTelefonu,
                   String adres, Date dataUrodzenia, int PESEL,
                   String płeć, String rodzajUbezpieczenia) {
        super(imię, nazwisko, numerTelefonu);
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.PESEL = PESEL;
        this.płeć = płeć;
        this.rodzajUbezpieczenia = rodzajUbezpieczenia;
    }

    public void przeglądajKalendarzWizyt() {

    }

    public void umówWizytę() {

    }

    public void wyszukajLeczenie() {

    }
}
