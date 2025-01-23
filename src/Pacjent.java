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

    //  Publiczny konstruktor
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

    //  Metoda tworzaca wizyte
    public boolean umowWizyte() {
        Leczenie leczenie = wybierzLeczenie();
        if (leczenie == null)
            leczenie = zalozLeczenie();

        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Wizyta.utworzWizyte(leczenie, lekarz, termin);
        return true;
    }

    //  Metoda tworzaca badanie
    public boolean umowBadanie(Skierowanie skierowanie) {
        Leczenie leczenie = wybierzLeczenie();
        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Badanie.utworzBadanie(leczenie, lekarz, termin, skierowanie);
        return true;
    }

    //  Metoda tworzaca konsultacje
    public boolean umowKonsultacje(boolean online, String temat) {
        Leczenie leczenie = wybierzLeczenie();
        Lekarz lekarz = wybierzLekarza();
        Date termin = wybierzTermin();

        Konsultacja.utworzKonsultacje(leczenie, lekarz, termin, online, temat);
        return true;
    }

    //  Prywatna metoda wybierajaca leczenie lub tworzaca je jesli nie istnieje
    private Leczenie wybierzLeczenie() {
        Leczenie leczenie = null;   //  [...] Logika biznesowa wyboru procesu leczenia
        if (leczenie == null)
            leczenie = zalozLeczenie();
        return leczenie;
    }

    //  Prywatna metoda wybierajaca lekarza
    private Lekarz wybierzLekarza() {
        //  [...] Logika biznesowa wyboru lekarza
        return null;
    }

    //  Prywatna metoda wybierajaca termin
    private Date wybierzTermin() {
        //  [...] Logika biznesowa wyboru terminu
        return null;
    }

    //  Metoda wyszukujaca leczenie pacjenta po nazwie choroby
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

    //  Metoda tworzaca leczenie
    public Leczenie zalozLeczenie() {
        //  [...] Logika biznesowa wyboru choroby
        String choroba = "choroba";

        return new Leczenie(choroba, this);
    }

    //  Metoda wyrejestrowujaca konto pacjenta
    public void wyrejestrujKonto() {
        wyrejestrowany = true;
    }

    //  Metoda zwracajaca dane pacjenta
    public String pobierzDanePacjenta() {
        return pobierzDaneOsobowe() + "\n" + plec + " ur:" + dataUrodzenia.toString() + "\nPESEL: " + PESEL +
                "\nAdres: " + adres + "\nTyp ubezpieczenia: " + rodzajUbezpieczenia;
    }

    //  Metoda dostepu do flagi "wyrejestrowany"
    public boolean czyWyrejestrowany() {
        return wyrejestrowany;
    }
}
