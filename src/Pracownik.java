public abstract class Pracownik extends UżytkownikSystemu {

    private String email;
    private String godzinyPracy;

    public Pracownik(String imię, String nazwisko, String numerTelefonu,
                     String email, String godzinyPracy) {
        super(imię, nazwisko, numerTelefonu);
        this.email = email;
        this.godzinyPracy = godzinyPracy;
    }
}
