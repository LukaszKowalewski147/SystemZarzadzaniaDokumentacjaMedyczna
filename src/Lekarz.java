public class Lekarz extends Pracownik {

    private String numerPWZ;
    private String specjalizacja;
    private String numerGabinetu;

    public Lekarz(String imie, String nazwisko, String numerTelefonu,
                  String email, String godzinyPracy, String numerPWZ,
                  String specjalizacja, String numerGabinetu) {
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);
        this.numerPWZ = numerPWZ;
        this.specjalizacja = specjalizacja;
        this.numerGabinetu = numerGabinetu;
    }

    public void wyswietlPubliczneDaneOsobowe() {

    }
}
