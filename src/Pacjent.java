import java.util.ArrayList;
import java.util.Date;

public class Pacjent extends UzytkownikSystemu {

    private String plec;
    private Date dataUrodzenia;
    private int PESEL;
    private String adres;
    private String rodzajUbezpieczenia;

    //  Asocjacja wielu leczen pacjenta
    private ArrayList<Leczenie> leczenia;

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

    //  Metoda dodajaca leczenie do kontenera "leczenia" wywolywana w konstruktorze leczenia
    public void dodajLeczenie(Leczenie leczenie) {
        // Sprawdz czy to leczenie nie zostalo dodane do tego pacjenta
        if (!leczenia.contains(leczenie)) {
            leczenia.add(leczenie);
        }
    }

    public void przegladajKalendarzWizyt() {

    }

    public void umowWizyte() {

    }

    public void wyszukajLeczenie() {

    }
}
