import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Wizyta {

    private static int maksymalneSpoznienie = 15;      //w minutach

    private StatusWizyty statusWizyty = StatusWizyty.ZAPLANOWANA;
    private Date termin;
    private short ocena = -1;

    //  Asocjacja jednego lekarza przeprowadzajacego wizyte
    private Lekarz lekarz;

    //  Leczenie w ktorym skomponowana jest wizyta
    private Leczenie leczenie;

    //  Ekstensja klasy Dokument
    private static HashSet<Dokument> wszystkieDokumenty = new HashSet<Dokument>();
    //  Kompozycja wielu dokumentow jednej wizyty
    private ArrayList<Dokument> dokumenty;

    //  Ekstensja klasy
    private static HashSet<Wizyta> wszystkieWizyty = new HashSet<Wizyta>();

    //  Chroniony konstruktor wywolywany przez metode utworzWizyte() i klasy dziedziczace
    protected Wizyta(Leczenie leczenie, Lekarz lekarz, Date termin) {
        this.leczenie = leczenie;
        this.lekarz = lekarz;
        this.termin = termin;
        dokumenty = new ArrayList<Dokument>();

        //  Dodanie wizyty do kontenera "wizyty" lekarza
        lekarz.dodajWizyte(this);
    }

    //  Metoda tworzaca wizyte i dodajaca ja do leczenia
    public static Wizyta utworzWizyte(Leczenie leczenie, Lekarz lekarz, Date termin) {
        if (leczenie == null) {
            System.out.println("Leczenie nie istnieje!");
            return null;
        }
        //  Utworz nowa wizyte
        Wizyta wizyta = new Wizyta(leczenie, lekarz, termin);
        //  Dodaj wizyte do leczenia
        try {
            leczenie.dodajWizyte(wizyta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return wizyta;
    }

    //  Metoda dodajaca dokument do kontenera "dokumenty" wywolywana podczas tworzenia dokumentu
    public void dodajDokument(Dokument dokument) throws Exception {
        //  Sprawdz czy ten dokument nie zostal dodany do tej wizyty
        if (!dokumenty.contains(dokument)) {
            //  Sprawdz czy ten dokument nie zostal dodany do innej wizyty
            if (wszystkieDokumenty.contains(dokument)) {
                throw new Exception("Ten dokument jest juz powiazany z inna wizyta!");
            }
            dokumenty.add(dokument);
            //  Zapamietaj na liscie wszystkich dokumentow (przeciwdziala wspoldzielniu dokumentow)
            wszystkieDokumenty.add(dokument);
        }
    }

    //  Metoda obliczajaca srednia ocen ze wszystkich wizyt posiadajacych ocene
    public static float obliczSredniaOcen() {
        float srednia = -1.0f;
        float sumaOcen = 0;
        int iloscOcen = 0;

        for (Wizyta wizyta : wszystkieWizyty) {
            if (wizyta.ocena < 0)
                continue;
            sumaOcen += wizyta.ocena;
            ++iloscOcen;
        }
        if (iloscOcen > 0)
            srednia = sumaOcen / iloscOcen;

        return srednia;
    }

    //  Metoda ustawiajaca ocene wizyty
    public void ocenWizyte(short ocena) {
        this.ocena = ocena;
    }

    //  Metoda wyboru i tworzenia dokumentu
    public void wystawDokument() {
        Dokument dokument = null;

        int typDokumentu = 0;   //  [...] Logika biznesowa wyboru typu dokumentu

        String nazwaJednostkiMedycznej = "nazwa_jednostki_medycznej";
        switch (typDokumentu) {
            case 0:
                dokument = Skierowanie.utworzSkierowanie(this, termin, nazwaJednostkiMedycznej, "typ_badania", null);
                break;
            case 1:
                dokument = WynikBadania.utworzWynikBadania(this, termin, nazwaJednostkiMedycznej, "typ_badania", "opis");
                break;
            case 2:
                dokument = Diagnoza.utworzDiagnoze(this, termin, nazwaJednostkiMedycznej, new String[]{"bol", "skurcz"});
                break;
            case 3:
                dokument = Recepta.utworzRecepte(this, termin, nazwaJednostkiMedycznej, null, "dawkowanie", "lek1,lek2");
                break;
            case 4:
                dokument = Zalecenie.utworzZalecenie(this, termin, nazwaJednostkiMedycznej, "porada_medyczna");
                break;
        }

        if (dokument == null)
            return;

        //  Obowiazkowy wybor nosnika dokumnetu
        dokument.wybierzNosnik();
    }

    //  Metoda zwracajaca informacje o wizycie
    public String pobierzInformacjeOWizycie() {
        String danePacjenta = leczenie.pokazPacjenta().pobierzDanePacjenta();
        String daneLekarza = lekarz.wyswietlPubliczneDaneOsobowe();
        String status = statusWizyty.toString();
        return "PACJENT: " + danePacjenta + "\nLEKARZ: " + daneLekarza +
                "\nTermin: " + termin + "\n Status: " + status;
    }

    //  Metoda zwracajaca wszystkie dokumenty powiazane z wizyta
    public ArrayList<Dokument> pobierzDokumenty() {
        return dokumenty;
    }

    //  Metoda rozpoczynajaca wizyte
    public void rozpocznijWizyte() {
        zmienStatusWizyty(StatusWizyty.W_TRAKCIE);
    }

    //  Metoda odwolujaca wizyte
    public void odwolajWizyte() {
        zmienStatusWizyty(StatusWizyty.ODWOLANA);
    }

    //  Metoda zaznaczajaca nieobecnosc pacjenta
    public void oznaczNieobecnoscPacjenta() {
        zmienStatusWizyty(StatusWizyty.NIEZREALIZOWANA);
    }

    //  Metoda konczaca wizyte
    public void zakonczWizyte() {
        zmienStatusWizyty(StatusWizyty.ZREALIZOWANA);
    }

    //  Metoda dostepu do lekarza przeprowadzajacego wizyte
    public Lekarz pokazLekarza() {
        return lekarz;
    }

    //  Metoda dostepu do leczenia powiazanego z wizyta
    public Leczenie pokazLeczenie() {
        return leczenie;
    }

    //  Prywatna metoda zmieniajaca status wizyty
    private void zmienStatusWizyty(StatusWizyty status) {
        statusWizyty = status;
    }
}
