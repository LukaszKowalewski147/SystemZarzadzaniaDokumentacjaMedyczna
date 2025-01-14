public class Konsultacja extends Wizyta {

    private String online;
    private String wymaganeDokumenty;

    public Konsultacja(String online, String wymaganeDokumenty) {
        super();
        this.online = online;
        this.wymaganeDokumenty = wymaganeDokumenty;
    }
}
