import java.util.Date;

public class Pacjent extends UzytkownikSystemu {

    private String plec;
    private Date dataUrodzenia;
    private int PESEL;
    private String adres;
    private String rodzajUbezpieczenia;

    public Pacjent(String imie, String nazwisko, String numerTelefonu,
                   String adres, Date dataUrodzenia, int PESEL,
                   String plec, String rodzajUbezpieczenia) {
        super(imie, nazwisko, numerTelefonu);
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.PESEL = PESEL;
        this.plec = plec;
        this.rodzajUbezpieczenia = rodzajUbezpieczenia;
    }

    public void przegladajKalendarzWizyt() {

    }

    public void umowWizyte() {

    }

    public void wyszukajLeczenie() {

    }
}
