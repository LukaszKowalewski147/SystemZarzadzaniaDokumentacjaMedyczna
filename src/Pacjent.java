import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Pacjent extends UzytkownikSystemu {

    private String plec;
    private Date dataUrodzenia;
    private long PESEL;
    private String adres;
    private String rodzajUbezpieczenia;
    private boolean wyrejestrowany = false;

    //  Asocjacja wielu leczen pacjenta
    private ArrayList<Leczenie> leczenia;

    //  Ekstensja klasy
    private static HashSet<Pacjent> wszyscyPacjenci = new HashSet<Pacjent>();

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

        //  Dodanie utworzonego pacjenta do ekstensji klasy
        wszyscyPacjenci.add(this);
    }

    //  Metoda dodajaca leczenie do kontenera "leczenia" wywolywana w konstruktorze leczenia
    public void dodajLeczenie(Leczenie leczenie) {
        //  Sprawdz czy to leczenie nie zostalo dodane do tego pacjenta
        if (!leczenia.contains(leczenie)) {
            leczenia.add(leczenie);
        }
    }

    //  Metoda wyszukujaca pacjenta po numerze PESEL
    public static Pacjent wyszukajPacjenta(long PESEL) {
        for (Pacjent pacjent : wszyscyPacjenci) {
            if (pacjent.PESEL == PESEL)
                return pacjent;
        }
        return null;
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

    public boolean umowBadanie(Skierowanie skierowanie) {
        Leczenie leczenie = wybierzLeczenie();
        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Badanie.utworzBadanie(leczenie, lekarz, termin, skierowanie);
        return true;
    }

    public boolean umowKonsultacje(boolean online, String temat) {
        Leczenie leczenie = wybierzLeczenie();
        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Konsultacja.utworzKonsultacje(leczenie, lekarz, termin, online, temat);
        return true;
    }

    private Leczenie wybierzLeczenie() {
        Leczenie leczenie = null;   //  [...] Logika biznesowa wyboru procesu leczenia
        if (leczenie == null)
            leczenie = zalozLeczenie();
        return leczenie;
    }

    private Lekarz wybierzLekarza() {
        //  [...] Logika biznesowa wyboru lekarza
        return null;
    }

    private Date wybierzTermin() {
        //  [...] Logika biznesowa wyboru terminu
        return null;
    }

    //  Metoda wyszukujaca leczenie po nazwie choroby
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
        //  [...] Logika biznesowa wyboru choroby
        String choroba = "choroba";

        return new Leczenie(choroba, this);
    }

    public void wyrejestrujKonto() {
        wyrejestrowany = true;
    }

    public String pobierzDanePacjenta() {
        return pobierzDaneOsobowe() + "\n" + plec + " ur:" + dataUrodzenia.toString() + "\nPESEL: " + PESEL;
    }
}
