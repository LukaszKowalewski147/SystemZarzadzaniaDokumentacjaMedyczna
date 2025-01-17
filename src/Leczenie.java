import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Leczenie {

    private String choroba;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    private boolean czyZarchiwizowane;

    //  Asocjacja leczenia jednego pacjenta
    private Pacjent pacjent;

    //  Asocjacja prowadzenia jednego leczenia
    private Prowadzenie prowadzenie;

    //  Ekstensja klasy Wizyty
    private static HashSet<Wizyta> wszystkieWizyty = new HashSet<Wizyta>();
    //  Kompozycja wielu wizyt jednego leczenia
    private ArrayList<Wizyta> wizyty;

    public Leczenie(String choroba, Pacjent pacjent) {
        this.choroba = choroba;
        this.pacjent = pacjent;
        czyZarchiwizowane = false;
        wizyty = new ArrayList<Wizyta>();

        //  Dodanie leczenia do kontenera "leczenia" pacjenta
        pacjent.dodajLeczenie(this);
    }

    public void ustawProwadzenie(Prowadzenie prowadzenie) {
        this.prowadzenie = prowadzenie;
    }

    //  Metoda dodajaca wizyte do kontenera "wizyty" wywolywana podczas tworzenia wizyty, badania lub konsultacji
    public void dodajWizyte(Wizyta wizyta) throws Exception {
        //  Sprawdz czy ta wizyta nie zostala dodana do tego leczenia
        if (!wizyty.contains(wizyta)) {
            //  Sprawdz czy ta wizyta nie zostala dodana do innego leczenia
            if (wszystkieWizyty.contains(wizyta)) {
                throw new Exception("Ta wizyta jest juz powiazana z innym leczeniem!");
            }
            wizyty.add(wizyta);
            //  Zapamietaj na liscie wszystkich wizyt (przeciwdziala wspoldzielniu wizyt)
            wszystkieWizyty.add(wizyta);
        }
    }

    public ArrayList<Wizyta> pobierzWizyty() {
        return wizyty;
    }

    //  Po 15 latach od daty zakonczenia leczenia
    public void zarchiwizuj() {
        czyZarchiwizowane = true;
    }

    public String generujRaport() {
        return "raport";
    }

    public String odczytajChorobe() {
        return choroba;
    }
}
