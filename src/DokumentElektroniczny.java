public class DokumentElektroniczny extends Nosnik {

    private String podpisElektroniczny;

    private DokumentElektroniczny(Dokument dokument, String podpisElektroniczny) {
        super(dokument);
        this.podpisElektroniczny = podpisElektroniczny;
    }

    public static DokumentElektroniczny utworzDokumentElektroniczny(Dokument dokument, String podpisElektroniczny) {
        if (dokument == null) {
            System.out.println("Dokument nie istnieje!");
            return null;
        }
        // Utworz nowy nosnik - dokument elektroniczny
        DokumentElektroniczny dokumentElektroniczny = new DokumentElektroniczny(dokument, podpisElektroniczny);
        // Nadaj nosnik dla dokumentu
        try {
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
