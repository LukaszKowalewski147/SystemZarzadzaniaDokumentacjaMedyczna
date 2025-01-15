public class LekarzProwadzacy extends Lekarz {

    private String numerPierwszegoKontaktu;

    public LekarzProwadzacy(String imie, String nazwisko, String numerTelefonu,
                            String email, String godzinyPracy, String numerPWZ,
                            String specjalizacja, String numerGabinetu,
                            String numerPierwszegoKontaktu) {
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy, numerPWZ, specjalizacja, numerGabinetu);
        this.numerPierwszegoKontaktu = numerPierwszegoKontaktu;
    }

    public void zakonczLeczenie() {

    }
}