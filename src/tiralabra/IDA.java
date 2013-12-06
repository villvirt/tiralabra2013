package tiralabra;

public class IDA {
    //tähän ida* kunhan saadaan verkko toimimaan
    private int f;
    private String reitti[][];
    private Lista jono;
    private Lista nopeinReitti;

    public IDA(String[][] verkko, int maali_i, int maali_j, int alku_i, int alku_j, boolean graafinen) {
        jono = new Lista();
        nopeinReitti = new Lista();
        reitti = verkko;
       hae( verkko, maali_i,  maali_j,  alku_i,  alku_j);
       if(!graafinen){
           print();
       }
        
     
       
    }
    private void hae(String[][] verkko, int maali_i, int maali_j, int alku_i, int alku_j){
           double bound = heuristiikka(alku_i, alku_j, maali_i, maali_j);
         for(int i=0; i<100; i++){  //jokin aikaraja etsinnälle
        double t = search(alku_i, alku_j, 0, bound, maali_i, maali_j);
        if(t==-1){
           reitti[alku_i][alku_j]="A";
            break;
        }
        
        bound = t;        
        }      

    }
    private double search(int node_i, int node_j, int g, double bound, int maali_i, int maali_j) {  //hakualgoritmi
        f = g + heuristiikka(node_i, node_j, maali_i, maali_j);
        if (f > bound) {
            return f;
        }
       reitti[node_i][node_j] = "x";
       jono.lisaaSolmu(new Solmu(node_i+"+"+node_j));
        if (node_i == maali_i && node_j == maali_j) {
            reitti[maali_i][maali_j]="M";
            return -1;
        }

        double min = Double.POSITIVE_INFINITY;  
        for (int i = 0; i < 4; i++) {  //ylös, oikea, alas, vasen
            if (i == 0) {
                min = etene(min, node_i - 1, node_j, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                   reitti[node_i][node_j] = "o";
                    break;
                }
            }
            if (i == 1) {
                min = etene(min, node_i, node_j + 1, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    reitti[node_i][node_j] = "o";
                    break;
                }
            }
            if (i == 2) {
                min = etene(min, node_i + 1, node_j, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    reitti[node_i][node_j] = "o";
                    break;
                }
            }
            if (i == 3) {
                min = etene(min, node_i, node_j - 1, g, bound, maali_i, maali_j);
                if (min == -1) {
                    nopeinReitti.lisaaSolmu(new Solmu(node_i+"+"+node_j));
                    reitti[node_i][node_j] = "o";
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

    private int heuristiikka(int node_i, int node_j, int maali_i, int maali_j) {   //palauttaa halutun arvon
        return Math.abs(maali_i - node_i) + Math.abs(maali_j - node_j);
    }
    public Lista palautaJono(){
        return jono;
    }
    public Lista palautaNopeinReitti(){
        return nopeinReitti;
    }
    private void print(){
               for (int i = 0; i < reitti.length; i++) {
            for (int j = 0; j < reitti[0].length; j++) {
                if (reitti[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + reitti[i][j] + "]");
                }
            }
            System.out.println();
        }
    }
}
