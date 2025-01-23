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
    //  Wizyty ktore powiazane sa z leczeniem (kompozycja wizyt w leczeniu)
    private ArrayList<Wizyta> wizyty;

    //  Ekstensja klasy
    private static HashSet<Leczenie> wszystkieLeczenia = new HashSet<Leczenie>();

    //  Publiczny konstruktor
    public Leczenie(String choroba, Pacjent pacjent) {
        this.choroba = choroba;
        this.pacjent = pacjent;
        czyZarchiwizowane = false;
        wizyty = new ArrayList<Wizyta>();

        //  Dodanie leczenia do kontenera "leczenia" pacjenta
        pacjent.dodajLeczenie(this);

        //  Dodanie utworzonego leczenia do ekstensji klasy
        wszystkieLeczenia.add(this);
    }

    //  Metoda ustawiajaca prowadzenie leczenia
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

    //  Metoda wyszukujaca leczenie po pacjencie, chorobie i dacie rozpoczecia
    public static Leczenie wyszukajLeczenie(Pacjent pacjent, String choroba, Date dataRozpoczecia) {
        for (Leczenie leczenie : wszystkieLeczenia) {
            if (leczenie.pacjent.equals(pacjent)) {
                if (leczenie.choroba.equals(choroba)) {
                    if (leczenie.dataRozpoczecia.equals(dataRozpoczecia))
                        return leczenie;
                }
            }
        }
        return null;
    }

    //  Metoda wyszukujaca wszystkie leczenia jednego pacjenta
    public static ArrayList<Leczenie> wyszukajLeczeniaPacjenta(Pacjent pacjent) {
        ArrayList<Leczenie> leczeniaPacjenta = new ArrayList<>();
        for (Leczenie leczenie : wszystkieLeczenia) {
            if (leczenie.pacjent.equals(pacjent))
                leczeniaPacjenta.add(leczenie);
        }
        return leczeniaPacjenta;
    }

    //  Metoda dostepu do wszystkich wizyt powiazanych z leczeniem
    public ArrayList<Wizyta> pobierzWizyty() {
        return wizyty;
    }

    //  Metoda archiwizujaca leczenie 15 latach od daty zakonczenia leczenia
    public void zarchiwizuj() {
        czyZarchiwizowane = true;
    }

    //  Metoda generujaca raport z leczenia
    public String generujRaport() {
        String iloscWizyt = "Ilosc wizyt: " + wizyty.size() + "\n";
        StringBuilder wizytyInfo = new StringBuilder();
        StringBuilder dokumentyInfo = new StringBuilder();

        for (Wizyta wizyta : wizyty) {
            wizytyInfo.append(wizyta.pobierzInformacjeOWizycie());
            StringBuilder dokumentyWizytyInfo = new StringBuilder();
            ArrayList<Dokument> dokumentyWizyty = wizyta.pobierzDokumenty();
            for (Dokument dokument : dokumentyWizyty) {
                dokumentyWizytyInfo.append(dokument.pobierzOpis());
            }
            dokumentyInfo.append(dokumentyWizytyInfo);
        }
        return iloscWizyt + wizytyInfo + dokumentyInfo;
    }

    //  Metoda ustawiajaca date zakonczenia leczenia
    public void ustawDateZakonczeniaLeczenia() {
        //  Ustawienie aktualnej daty jako data zakonczenia leczenia
        dataZakonczenia = new Date();
    }

    //  Metoda dostepu do pacjenta powiazanego z leczeniem
    public Pacjent pokazPacjenta() {
        return pacjent;
    }

    //  Metoda dostepu do lekarza prowadzacego powiazanego z leczeniem
    public LekarzProwadzacy pokazLekarzaProwadzacego() {
        return prowadzenie.pokazLekarzaProwadzacego();
    }

    //  Metoda dostepu do nazwy choroby
    public String odczytajChorobe() {
        return choroba;
    }

    //  Metoda dostepu do daty rozpoczecia leczenia
    public Date pokazDateRozpoczecia() {
        return dataRozpoczecia;
    }

    //  Metoda dostepu do daty zakonczenia leczenia
    public Date pokazDateZakonczenia() {
        return dataZakonczenia;
    }

    //  Metoda dostepu do flagi "czyZarchiwizowane"
    public boolean czyZarchiwizowane() {
        return czyZarchiwizowane;
    }
}
