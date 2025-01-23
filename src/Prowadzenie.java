public class Prowadzenie {

    private String celProwadzenia;
    private boolean czyAktywne;

    //  Asocjacja prowadzenia leczenia
    private Leczenie leczenie;

    //  Asocjacja lekarza prowadzacego prowadzacego prowadzenie
    private LekarzProwadzacy lekarzProwadzacy;

    //  Publiczny konstruktor
    public Prowadzenie(Leczenie leczenie, LekarzProwadzacy lekarzProwadzacy, String celProwadzenia) {
        this.leczenie = leczenie;
        this.lekarzProwadzacy = lekarzProwadzacy;
        this.celProwadzenia = celProwadzenia;
        czyAktywne = true;

        //  Dodanie prowadzenia do kontenera "prowadzenia" lekarza prowadzacego
        lekarzProwadzacy.dodajProwadzenie(this);
    }

    //  Metoda zakanczajaca leczenie
    public boolean zakonczLeczenie() {
        leczenie.ustawDateZakonczeniaLeczenia();
        czyAktywne = false;
        return true;
    }

    //  Metoda dostepu do prowadzonego leczenia
    public Leczenie pokazLeczenie() {
        return leczenie;
    }

    //  Metoda dostepu do lekarza prowadzacego
    public LekarzProwadzacy pokazLekarzaProwadzacego() {
        return lekarzProwadzacy;
    }

    //  Metoda dostepu do celu prowadzenia
    public String pokazCelProwadzenia() {
        return celProwadzenia;
    }

    //  Metoda dostepu do flagi "czyAktywne"
    public boolean czyAktywne() {
        return czyAktywne;
    }
}
