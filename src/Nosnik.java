public abstract class Nosnik {

    //  Dokument w ktorym skomponowany jest nosnik
    private Dokument dokument;

    //  Chroniony konstruktor wywolywany tylko przez klasy dziedziczace
    protected Nosnik(Dokument dokument) {
        this.dokument = dokument;
    }
}
