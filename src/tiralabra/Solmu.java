package tiralabra;

public class Solmu {

    private String key;
    private int arvo;
    private Solmu seuraava;
    private Solmu edellinen;
    private Lista naapurit = new Lista();

    //konstruktorit
    public Solmu(String key, int arvo) {
        this.key = key;
        this.arvo = arvo;
    }
        public Solmu(String key) {
        this.key = key;

    }

    public Solmu(String key, Solmu seuraava, Solmu edellinen, int arvo) {
        this.key = key;
        this.seuraava = seuraava;
        this.edellinen = edellinen;
        this.arvo = arvo;
    }

    //solmun muokkaus
    public String getKey() {
        return key;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public void setKey(String uusi) {
        key = uusi;
    }

    //listan muokkaus
    public Solmu seuraavaListassa() {
        return seuraava;
    }

    public Solmu edellinenListassa() {
        return edellinen;
    }

    public void setSeuraava(Solmu seuraava) {
        this.seuraava = seuraava;
    }

    public void setEdellinen(Solmu edellinen) {
        this.edellinen = edellinen;
    }
    //naapurit

    public void lisaaNaapuri(Solmu naapuri) {
        naapurit.lisaaSolmu(naapuri);
    }

    public Lista Naapurit() {
        return naapurit;
    }

    public String naapuritToString() {
        String n = "";
        Solmu pointer = naapurit.listanAlku();
        if (pointer == null) {
            n = "Ei naapureita";
        } else {
            while (pointer != null) {
                n = n + pointer + " ";
                pointer = pointer.seuraavaListassa();
            }
        }
        return n;
    }

    //toString
    public String toString() {

        return "(key: " + key + " arvo: " + arvo + ")";
    }
}
