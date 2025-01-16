public abstract class Nosnik {
    
    private Dokument dokument;

    //  Chroniony konstruktor wywolywany tylko przez klasy dziedziczace
    protected Nosnik(Dokument dokument) {
        this.dokument = dokument;
    }
}
