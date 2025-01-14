public class Recepcjonista extends Pracownik {

    private String numerStanowiska;

    public Recepcjonista(String imię, String nazwisko, String numerTelefonu,
                         String email, String godzinyPracy, String numerStanowiska) {
        super(imię, nazwisko, numerTelefonu, email, godzinyPracy);
        this.numerStanowiska = numerStanowiska;
    }

    public void rejestrujKonto() {

    }
}
