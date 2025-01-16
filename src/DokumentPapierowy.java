public class DokumentPapierowy extends Nosnik {

    private long numerDruku;

    //  Prywatny konstruktor dostepny tylko z metody utworzDokumentElektroniczny()
    private DokumentPapierowy(Dokument dokument, long numerDruku) {
        //  Wywolanie konstruktora klasy nadrzednej Nosnik
        super(dokument);

        this.numerDruku = numerDruku;
    }

    //  Metoda tworzaca dokument papierowy
    public static DokumentPapierowy utworzDokumentPapierowy(Dokument dokument, long numerDruku) {
        //  Sprawdzenie czy dokument istnieje
        if (dokument == null) {
            System.out.println("Dokument nie istnieje!");
            return null;
        }
        //  Utworz nowy nosnik - dokument papierowy
        DokumentPapierowy dokumentPapierowy = new DokumentPapierowy(dokument, numerDruku);
        try {
            //  Nadaj nosnik dla dokumentu
            dokument.nadajNosnik(dokumentPapierowy);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return dokumentPapierowy;
    }

    public boolean czyNosnikDostepny() {
        return false;
    }
}
