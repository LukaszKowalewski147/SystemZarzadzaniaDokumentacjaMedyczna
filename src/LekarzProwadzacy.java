import java.util.ArrayList;

public class LekarzProwadzacy extends Lekarz {

    private String numerPierwszegoKontaktu;

    //  Asocjacja wielu prowadzen lekarza prowadzacego
    private ArrayList<Prowadzenie> prowadzenia;

    public LekarzProwadzacy(String imie, String nazwisko, String numerTelefonu,
                            String email, String godzinyPracy, String numerPWZ,
                            String specjalizacja, String numerGabinetu,
                            String numerPierwszegoKontaktu) {
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy, numerPWZ, specjalizacja, numerGabinetu);
        this.numerPierwszegoKontaktu = numerPierwszegoKontaktu;
    }

    //  Metoda dodajaca prowadzenie do kontenera "prowadzenia" wywolywana w konstruktorze prowadzenia
    public void dodajProwadzenie(Prowadzenie prowadzenie) {
        // Sprawdz czy to prowadzenie nie zostalo dodane do tego lekarza prowadzacego
        if (!prowadzenia.contains(prowadzenie)) {
            prowadzenia.add(prowadzenie);
        }
    }

    public void zakonczLeczenie() {

    }
}