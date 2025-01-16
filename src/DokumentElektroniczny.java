public class DokumentElektroniczny extends Nosnik {

    private String podpisElektroniczny;

    //  Prywatny konstruktor dostepny tylko z metody utworzDokumentElektroniczny()
    private DokumentElektroniczny(Dokument dokument, String podpisElektroniczny) {
        //  Wywolanie konstruktora klasy nadrzednej Nosnik
        super(dokument);

        this.podpisElektroniczny = podpisElektroniczny;
    }

    //  Metoda tworzaca dokument elektroniczny
    public static DokumentElektroniczny utworzDokumentElektroniczny(Dokument dokument, String podpisElektroniczny) {
        //  Sprawdzenie czy dokument istnieje
        if (dokument == null) {
            System.out.println("Dokument nie istnieje!");
            return null;
        }
        //  Utworz nowy nosnik - dokument elektroniczny
        DokumentElektroniczny dokumentElektroniczny = new DokumentElektroniczny(dokument, podpisElektroniczny);
        try {
            //  Nadaj nosnik dla dokumentu
            dokument.nadajNosnik(dokumentElektroniczny);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return dokumentElektroniczny;
    }

    public void podpisz() {

    }
}
