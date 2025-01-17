public class Lekarz extends Pracownik {

    private String numerPWZ;
    private String specjalizacja;
    private String numerGabinetu;

    // TODO: asocjacja 1 do wielu z wizytą, do dodania

    public Lekarz(String imie, String nazwisko, String numerTelefonu,
                  String email, String godzinyPracy, String numerPWZ,
                  String specjalizacja, String numerGabinetu) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerPWZ = numerPWZ;
        this.specjalizacja = specjalizacja;
        this.numerGabinetu = numerGabinetu;
    }

    public String wyswietlPubliczneDaneOsobowe() {
        return "dane osobowe"; // TODO: dane ma zwracac
    }
}
