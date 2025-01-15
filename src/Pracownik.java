public abstract class Pracownik extends UzytkownikSystemu {

    private String email;
    private String godzinyPracy;

    public Pracownik(String imie, String nazwisko, String numerTelefonu,
                     String email, String godzinyPracy) {
        super(imie, nazwisko, numerTelefonu);
        this.email = email;
        this.godzinyPracy = godzinyPracy;
    }
}
