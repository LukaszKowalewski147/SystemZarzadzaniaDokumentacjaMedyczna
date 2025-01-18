import java.util.ArrayList;
import java.util.Date;

public class Pacjent extends UzytkownikSystemu {

    private String plec;
    private Date dataUrodzenia;
    private long PESEL;
    private String adres;
    private String rodzajUbezpieczenia;
    private boolean wyrejestrowany = false;

    //  Asocjacja wielu leczen pacjenta
    private ArrayList<Leczenie> leczenia;

    public Pacjent(String imie, String nazwisko, String numerTelefonu,
                   String adres, Date dataUrodzenia, long PESEL,
                   String plec, String rodzajUbezpieczenia) {
        //  Wywolanie konstruktora klasy nadrzednej UzytkownikSystemu
        super(imie, nazwisko, numerTelefonu);

        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.PESEL = PESEL;
        this.plec = plec;
        this.rodzajUbezpieczenia = rodzajUbezpieczenia;
        leczenia = new ArrayList<Leczenie>();
    }

    //  Metoda dodajaca leczenie do kontenera "leczenia" wywolywana w konstruktorze leczenia
    public void dodajLeczenie(Leczenie leczenie) {
        //  Sprawdz czy to leczenie nie zostalo dodane do tego pacjenta
        if (!leczenia.contains(leczenie)) {
            leczenia.add(leczenie);
        }
    }

    public void przegladajKalendarzWizyt() {
        ArrayList<Wizyta> wizyty = pobierzWizyty();
        //  System tworzy kalendarz na podstawie wizyt
    }

    private ArrayList<Wizyta> pobierzWizyty() {
        return leczenia.get(0).pobierzWizyty();
    }

    public boolean umowWizyte() {
        Leczenie leczenie = wybierzLeczenie();
        if (leczenie == null)
            leczenie = zalozLeczenie();

        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Wizyta.utworzWizyte(leczenie, lekarz, termin);
        return true;
    }

    public boolean umowBadanie() {
        Leczenie leczenie = wybierzLeczenie();
        if (leczenie == null)
            leczenie = zalozLeczenie();

        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Badanie.utworzBadanie(leczenie, lekarz, termin,"rodzaj_badania");
        return true;
    }

    public boolean umowKonsultacje() {
        Leczenie leczenie = wybierzLeczenie();
        if (leczenie == null)
            leczenie = zalozLeczenie();

        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Konsultacja.utworzKonsultacje(leczenie, lekarz, termin,false, "temat");
        return true;
    }

    private Leczenie wybierzLeczenie() {
        return null;
    }

    private Lekarz wybierzLekarza() {
        return null;
    }

    private Date wybierzTermin() {
        return null;
    }

    public Leczenie wyszukajLeczenie(String choroba) {
        Leczenie znalezioneLeczenie = null;
        for (Leczenie leczenie : leczenia) {
            if (leczenie.odczytajChorobe().equals(choroba)) {
                znalezioneLeczenie = leczenie;
                break;
            }
        }
        return znalezioneLeczenie;
    }

    public Leczenie zalozLeczenie() {
        return new Leczenie("choroba", this);
    }

    public void wyrejestrujKonto() {
        wyrejestrowany = true;
    }

    public String pobierzDanePacjenta() {
        return pobierzDaneOsobowe() + "\n" + plec + " ur:" + dataUrodzenia.toString() + "\nPESEL: " + PESEL;
    }
}
