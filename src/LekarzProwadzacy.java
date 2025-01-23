import java.util.ArrayList;

public class LekarzProwadzacy extends Lekarz {

    private String numerPierwszegoKontaktu;

    //  Asocjacja wielu prowadzen lekarza prowadzacego
    private ArrayList<Prowadzenie> prowadzenia;

    // Publiczny konstruktor
    public LekarzProwadzacy(String imie, String nazwisko, String numerTelefonu,
                            String email, String godzinyPracy, String numerPWZ,
                            String specjalizacja, String numerGabinetu,
                            String numerPierwszegoKontaktu) {
        //  Wywolanie konstruktora klasy nadrzednej Lekarz
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy, numerPWZ, specjalizacja, numerGabinetu);

        this.numerPierwszegoKontaktu = numerPierwszegoKontaktu;
        prowadzenia = new ArrayList<Prowadzenie>();
    }

    //  Metoda dodajaca prowadzenie do kontenera "prowadzenia" wywolywana w konstruktorze prowadzenia
    public void dodajProwadzenie(Prowadzenie prowadzenie) {
        //  Sprawdz czy to prowadzenie nie zostalo dodane do tego lekarza prowadzacego
        if (!prowadzenia.contains(prowadzenie)) {
            prowadzenia.add(prowadzenie);
        }
    }

    //  Metoda dostepu do numeru pierwszego kontaktu
    public String pokazNumerPierwszegoKontaktu() {
        return numerPierwszegoKontaktu;
    }
}