import java.util.ArrayList;

public class Lekarz extends Pracownik {

    private String numerPWZ;
    private String specjalizacja;
    private String numerGabinetu;

    //  Asocjacja wielu wizyt lekarza
    private ArrayList<Wizyta> wizyty;

    public Lekarz(String imie, String nazwisko, String numerTelefonu,
                  String email, String godzinyPracy, String numerPWZ,
                  String specjalizacja, String numerGabinetu) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerPWZ = numerPWZ;
        this.specjalizacja = specjalizacja;
        this.numerGabinetu = numerGabinetu;
    }

    //  Metoda dodajaca wizyte do kontenera "wizyty" wywolywana w konstruktorze wizyty
    public void dodajWizyte(Wizyta wizyta) {
        //  Sprawdz czy ta wizyta nie zostala dodana do tego lekarza
        if (!wizyty.contains(wizyta)) {
            wizyty.add(wizyta);
        }
    }

    public String wyswietlPubliczneDaneOsobowe() {
        return pobierzDanePracownika() + "\n spec: " + specjalizacja + " gab: " + numerGabinetu + "\nnr PWZ: " + numerPWZ;
    }
}
