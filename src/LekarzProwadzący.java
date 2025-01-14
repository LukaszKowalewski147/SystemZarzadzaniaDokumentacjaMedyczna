public class LekarzProwadzący extends Lekarz {

    private String numerPierwszegoKontaktu;

    public LekarzProwadzący(String imię, String nazwisko, String numerTelefonu,
                            String email, String godzinyPracy, String numerPWZ,
                            String specjalizacja, String numerGabinetu,
                            String numerPierwszegoKontaktu) {
        super(imię, nazwisko, numerTelefonu, email, godzinyPracy, numerPWZ, specjalizacja, numerGabinetu);
        this.numerPierwszegoKontaktu = numerPierwszegoKontaktu;
    }

    public void zakończLeczenie() {

    }
}