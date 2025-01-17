public class Prowadzenie {

    private String celProwadzenia;
    private boolean czyAktywne;

    //  Asocjacja prowadzenia leczenia
    private Leczenie leczenie;

    //  Asocjacja lekarza prowadzacego prowadzacego prowadzenie
    private LekarzProwadzacy lekarzProwadzacy;

    public Prowadzenie(Leczenie leczenie, LekarzProwadzacy lekarzProwadzacy) {
        this.leczenie = leczenie;
        this.lekarzProwadzacy = lekarzProwadzacy;

        //  Dodanie prowadzenia do kontenera "prowadzenia" lekarza prowadzacego
        lekarzProwadzacy.dodajProwadzenie(this);
    }

    public boolean zakonczLeczenie() {
        return false;   // TODO: ustawic date zakonczenia leczenia
    }
}
