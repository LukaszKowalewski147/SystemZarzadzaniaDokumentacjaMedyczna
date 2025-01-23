public abstract class UzytkownikSystemu {

    private String imie;
    private String nazwisko;
    private String numerTelefonu;

    //  Chroniony konstruktor
    protected UzytkownikSystemu(String imie, String nazwisko, String numerTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
    }

    //  Metoda zwracajaca dane osobowe uzytkownika systemu
    protected String pobierzDaneOsobowe() {
        return imie + " " + nazwisko + "\ntel: " + numerTelefonu;
    }
}
