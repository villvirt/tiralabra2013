package tiralabra;

public class Lista {

    private Solmu alku;
    private Solmu loppu;

    public Lista() {
    }

    public void lisaaSolmu(Solmu lisattava) {
        //tyhjä lista
        if (alku == null) {
            alku = lisattava;
            loppu = lisattava;
        } //lisätään loppuun
        else {
            lisattava.setEdellinen(loppu);
            loppu.setSeuraava(lisattava);
            loppu = lisattava;
        }
    }

    public Solmu listanAlku() {
        return alku;
    }

    public void poistaSolmu(Solmu poistettava) {
        Solmu edellinen = poistettava.edellinenListassa();
        Solmu seuraava = poistettava.seuraavaListassa();
        //solmu on listan alussa
        if (edellinen == null) {
            //listassa vain yksi solmu
            if (seuraava == null) {
                alku = null;
            } else {
                seuraava = alku;
            }
        } //solmu listan lopussa
        else if (seuraava == null) {
            edellinen.setSeuraava(null);
        } else {
            edellinen.setSeuraava(seuraava);
            seuraava.setEdellinen(edellinen);
        }
    }

    public String toString() {
        if (alku == null) {
            return "Lista tyhja";
        } else {
            String listaus = alku.toString();
            Solmu pointer = alku.seuraavaListassa();
            while (pointer != null) {
                listaus = listaus + " - " + pointer;
                pointer = pointer.seuraavaListassa();
            }
            return listaus;
        }
    }
}
