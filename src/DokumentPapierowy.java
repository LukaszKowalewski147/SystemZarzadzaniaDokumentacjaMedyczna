public class DokumentPapierowy extends Nosnik {

    private long numerDruku;

    private DokumentPapierowy(Dokument dokument, long numerDruku) {
        super(dokument);
        this.numerDruku = numerDruku;
    }

    public static DokumentPapierowy utworzDokumentPapierowy(Dokument dokument, long numerDruku) {
        if(dokument == null) {
            System.out.println("Dokument nie istnieje!");
            return null;
        }
        // Utworz nowy nosnik - dokument papierowy
        DokumentPapierowy dokumentPapierowy = new DokumentPapierowy(dokument, numerDruku);
        // Nadaj nosnik dla dokumentu
        try {
            dokument.nadajNosnik(dokumentPapierowy);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return dokumentPapierowy;
    }

    public void czyNosnikDostepny() {

    }
}
