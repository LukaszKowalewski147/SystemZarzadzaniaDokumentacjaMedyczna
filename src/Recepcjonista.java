public class Recepcjonista extends Pracownik {

    private String numerStanowiska;

    public Recepcjonista(String imie, String nazwisko, String numerTelefonu,
                         String email, String godzinyPracy, String numerStanowiska) {
        //  Wywolanie konstruktora klasy nadrzednej Pracownik
        super(imie, nazwisko, numerTelefonu, email, godzinyPracy);

        this.numerStanowiska = numerStanowiska;
    }

    public void rejestrujKonto() {

    }
}
