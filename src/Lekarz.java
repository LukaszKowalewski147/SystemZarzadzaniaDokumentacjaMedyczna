import java.util.ArrayList;
import java.util.HashSet;

public class Lekarz extends Pracownik {

    private String numerPWZ;
    private String specjalizacja;
    private String numerGabinetu;

    //  Asocjacja wielu wizyt lekarza
    private ArrayList<Wizyta> wizyty;

    //  Ekstensja klasy
    private static HashSet<Lekarz> wszyscyLekarze = new HashSet<Lekarz>();

    public Lekarz(String imie, String nazwisko, String numerTelefonu,
                  String email, String godzinyPracy, String numerPWZ,
                  String specjalizacja, String numerGabinetu) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerPWZ = numerPWZ;
        this.specjalizacja = specjalizacja;
        this.numerGabinetu = numerGabinetu;

        //  Dodanie utworzonego lekarza do ekstensji klasy
        wszyscyLekarze.add(this);
    }

    //  Metoda dodajaca wizyte do kontenera "wizyty" wywolywana w konstruktorze wizyty
    public void dodajWizyte(Wizyta wizyta) {
        //  Sprawdz czy ta wizyta nie zostala dodana do tego lekarza
        if (!wizyty.contains(wizyta)) {
            wizyty.add(wizyta);
        }
    }

    //  Metoda wyszukujaca lekarza po numerzePWZ
    public static Lekarz wyszukajLekarza(String numerPWZ) {
        for (Lekarz lekarz : wszyscyLekarze) {
            if (lekarz.numerPWZ.equals(numerPWZ))
                return lekarz;
        }
        return null;
    }

    public String wyswietlPubliczneDaneOsobowe() {
        return pobierzDanePracownika() + "\n spec: " + specjalizacja + " gab: " + numerGabinetu + "\nnr PWZ: " + numerPWZ;
    }
}
