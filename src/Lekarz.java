public class Lekarz extends Pracownik {

    private String numerPWZ;
    private String specjalizacja;
    private String numerGabinetu;

    public Lekarz(String imię, String nazwisko, String numerTelefonu,
                  String email, String godzinyPracy, String numerPWZ,
                  String specjalizacja, String numerGabinetu) {
        super(imię, nazwisko, numerTelefonu, email, godzinyPracy);
        this.numerPWZ = numerPWZ;
        this.specjalizacja = specjalizacja;
        this.numerGabinetu = numerGabinetu;
    }

    public void wyświetlPubliczneDaneOsobowe() {

    }
}
