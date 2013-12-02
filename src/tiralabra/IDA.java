package tiralabra;

public class IDA {
    //tähän ida* kunhan saadaan verkko toimimaan
    private int f;
    private String reitti[][];
    private Lista jono;
    private Lista nopeinReitti;

    public IDA(String[][] verkko, int maali_i, int maali_j, int alku_i, int alku_j) {
        jono = new Lista();
        nopeinReitti = new Lista();
        reitti = verkko;
        double bound = heuristiikka(reitti, alku_i, alku_j, maali_i, maali_j);
        for(int i=0; i<8; i++){
        double t = search(alku_i, alku_j, 0, bound, maali_i, maali_j);
        if(t==-1){
            break;
        }
        bound = t;        
        }
       /* for (int i = 0; i < verkko.length; i++) {
            for (int j = 0; j < verkko[0].length; j++) {
                if (reitti[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + reitti[i][j] + "]");
                }
            }
            System.out.println();
        }*/
       

    }

    private double search(int node_i, int node_j, int g, double bound, int maali_i, int maali_j) {  //hakualgoritmi
        f = g + heuristiikka(reitti, node_i, node_j, maali_i, maali_j);
        if (f > bound) {
            return f;
        }
       reitti[node_i][node_j] = "x";
       jono.lisaaSolmu(new Solmu(node_i+"+"+node_j));
        if (node_i == maali_i && node_j == maali_j) {
            return -1;
        }

        double min = Double.POSITIVE_INFINITY;  //close enuf
        for (int i = 0; i < 4; i++) {  //ylös, oikea, alas, vasen
            if (i == 0) {
                min = etene(min, node_i - 1, node_j, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    break;
                }
            }
            if (i == 1) {
                min = etene(min, node_i, node_j + 1, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    break;
                }
            }
            if (i == 2) {
                min = etene(min, node_i + 1, node_j, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    break;
                }
            }
            if (i == 3) {
                min = etene(min, node_i, node_j - 1, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    break;
                }
            }
        }
        return min;
    }

    private double etene(double min, int node_i, int node_j, int g, double bound, int maali_i, int maali_j) {
        if (node_i >= 0 && node_i < reitti.length && node_j >= 0 && node_j < reitti[0].length && reitti[node_i][node_j] != "r") {
            double t = search(node_i, node_j, g + 1, bound, maali_i, maali_j);
            if (t == -1) {
                return -1;
            }
            if (t < min) {
                min = t;
            }
        }
        return min;

    }

    private int heuristiikka(String[][] verkko, int node_i, int node_j, int maali_i, int maali_j) {   //palauttaa halutun arvon
        return Math.abs(maali_i - node_i) + Math.abs(maali_j - node_j);
    }
    public Lista palautaJono(){
        return jono;
    }
    public Lista palautaNopeinReitti(){
        return nopeinReitti;
    }
}
