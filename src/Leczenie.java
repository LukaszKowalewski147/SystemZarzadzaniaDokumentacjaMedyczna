import java.util.Date;

public class Leczenie {

    private String choroba;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;

    //  Asocjacja leczenia pacjenta
    private Pacjent pacjent;

    //  Asocjacja prowadzenia leczenia
    private Prowadzenie prowadzenie;

    public Leczenie(String choroba, Pacjent pacjent, Prowadzenie prowadzenie) {
        this.choroba = choroba;
        this.pacjent = pacjent;
        this.prowadzenie = prowadzenie;
    }

    public void zarchiwizuj() {

    }

    public void generujRaport() {

    }
}
