public abstract class Pracownik extends UzytkownikSystemu {

    private String email;
    private String godzinyPracy;

    public Pracownik(String imie, String nazwisko, String numerTelefonu,
                     String email, String godzinyPracy) {
        //  Wywolanie konstruktora klasy nadrzednej UzytkownikSystemu
        super(imie, nazwisko, numerTelefonu);

        this.email = email;
        this.godzinyPracy = godzinyPracy;
    }

    protected String pobierzDanePracownika() {
        return pobierzDaneOsobowe() + "\nemail: " + email + "\ngodziny pracy: " + godzinyPracy;
    }
}
