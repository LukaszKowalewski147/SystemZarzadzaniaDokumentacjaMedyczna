public abstract class Nosnik {

    //  Dokument z ktorym powiazany jest nosnik (kompozycja nosnika w dokumencie)
    private Dokument dokument;

    //  Chroniony konstruktor wywolywany tylko przez klasy dziedziczace
    protected Nosnik(Dokument dokument) {
        this.dokument = dokument;
    }
}
