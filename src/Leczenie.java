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

    //  Ekstensja klasy
    private static HashSet<Leczenie> wszystkieLeczenia = new HashSet<Leczenie>();

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

    public ArrayList<Wizyta> pobierzWizyty() {
        return wizyty;
    }

    //  Po 15 latach od daty zakonczenia leczenia
    public void zarchiwizuj() {
        czyZarchiwizowane = true;
    }

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

    public String odczytajChorobe() {
        return choroba;
    }

    public void ustawDateZakonczeniaLeczenia() {
        //  Ustawienie aktualnej daty jako data zakonczenia leczenia
        dataZakonczenia = new Date();
    }

    public Pacjent pokazPacjenta() {
        return pacjent;
    }

    public LekarzProwadzacy pokazLekarzaProwadzacego() {
        return prowadzenie.pokazLekarzaProwadzacego();
    }

    public Date pokazDateRozpoczecia() {
        return dataRozpoczecia;
    }

    public Date pokazDateZakonczenia() {
        return dataZakonczenia;
    }
}
