package tiralabra;

public class IDA {
    //tähän ida* kunhan saadaan verkko toimimaan

    public Solmu node;
    public int g;
    public int f;
<<<<<<< Updated upstream
    public int heuristiikka[][];
    public String reitti[][]; 
=======
    public String reitti[][];
>>>>>>> Stashed changes

    public IDA(String[][] verkko, int maali_i, int maali_j, int alku_i, int alku_j) {

<<<<<<< Updated upstream
        heuristiikka = laskeHeuristiikka(verkko, maali_i, maali_j);
        reitti = new String[verkko.length][verkko[0].length];
        reitti[maali_i][maali_j]="m";
        int bound = h(alku_i, alku_j);
        System.out.println("");
            int t = search(alku_i, alku_j, 0, bound, maali_i, maali_j);
           /* if (t == 999999999) {
                System.out.println("Ei löytynyt");
            }
            if (t == -1) {*/
            reitti[alku_i][alku_j]="s";
                for (int i = 0; i < verkko.length; i++) {
                    for (int j = 0; j < verkko[0].length; j++) {
                        if (reitti[i][j] == null) {
                            System.out.print("[ ]");
                        }
                        else{
                            System.out.print("[" + reitti[i][j] + "]");
                        }
                    }
                    System.out.println();
                }
          //  }
            
            System.out.println(t);
            bound = t;
        
    }

    private int search(int node_i, int node_j, int g, int bound, int maali_i, int maali_j) {
        int t;
        f = g + h(node_i, node_j);
=======
        reitti = verkko;
        reitti[maali_i][maali_j] = "m";
        double bound = heuristiikka(reitti, alku_i, alku_j, maali_i, maali_j);
        System.out.println("");
        for(int i  =0;i<1000;i++){
        double t = search(alku_i, alku_j, 0, bound, maali_i, maali_j);
        bound=t;
        if(t==-1){
            break;
        }
        }
        /*
         * if (t == 999999999) { System.out.println("Ei löytynyt"); } if (t ==
         * -1) {
         */
        reitti[alku_i][alku_j] = "s"; //tulostetaa reitti
        for (int i = 0; i < verkko.length; i++) {
            for (int j = 0; j < verkko[0].length; j++) {
                if (reitti[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + reitti[i][j] + "]");
                }
            }
            System.out.println();
        }
        //  }


    }

    private double search(int node_i, int node_j, int g, double bound, int maali_i, int maali_j) {  //hakualgoritmi
        f = g + heuristiikka(reitti, node_i, node_j, maali_i, maali_j);
>>>>>>> Stashed changes
        if (f > bound) {
            return f;
        }
                    reitti[node_i][node_j] = "x";
        if (node_i == maali_i && node_j == maali_j) {
            reitti[node_i][node_j] = "m";
            return -1;
        }
      

<<<<<<< Updated upstream
        int min = 999999999;  //close enuf
=======
        double min = Double.POSITIVE_INFINITY ;  //close enuf
        // Bugaaaaa
>>>>>>> Stashed changes
        for (int i = 0; i < 4; i++) {  //ylös, oikea, alas, vasen
            if (i == 0) {
                if (node_i - 1 >= 0) {
                    t = search(node_i - 1, node_j, g + 1, bound, maali_i, maali_j);
                    if (t == -1) {
                        reitti[node_i][node_j] = "x";
                        return -1;
                    }
                    if (t < min) {
                        min = t;
                    }
                }
                if(min==-1){
                    return min;
                }
            }
            if (i == 1) {
                if (node_j + 1 < heuristiikka[0].length) {
                    t = search(node_i, node_j + 1, g + 1, bound, maali_i, maali_j);
                    if (t == -1) {
                        reitti[node_i][node_j] = "x";
                        return -1;
                    }
                    if (t < min) {
                        min = t;
                    }
                }
                if(min==-1){
                    return min;
                }
            }
            if (i == 2) {
                if (node_i + 1 < heuristiikka.length) {
                    t = search(node_i + 1, node_j, g + 1, bound, maali_i, maali_j);
                    if (t == -1) {
                        reitti[node_i][node_j] = "x";
                        return -1;
                    }
                    if (t < min) {
                        min = t;
                    }
                }
                if(min==-1){
                    return min;
                }
            }
            if (i == 3) {
                if (node_j - 1 >= 0) {
                    t = search(node_i, node_j - 1, g + 1, bound, maali_i, maali_j);
                    if (t == -1) {
                        reitti[node_i][node_j] = "x";
                        return -1;
                    }
                    if (t < min) {
                        min = t;
                    }
                }
                if(min==-1){
                    return min;
                }
            }
        }
        return min;
    }

<<<<<<< Updated upstream
    private int[][] laskeHeuristiikka(int[][] verkko, int maali_i, int maali_j) {
        for (int i = 0; i < verkko.length; i++) {
            for (int j = 0; j < verkko[0].length; j++) {
                verkko[i][j] = Math.abs(maali_i - i) + Math.abs(maali_j - j);
=======
    private double etene(double min, int node_i, int node_j, int g, double bound, int maali_i, int maali_j) {
        double t = search(node_i, node_j, g + 1, bound, maali_i, maali_j);
        if (t == -1) {

            return -1;
        }
        if (t < min) {
            min = t;
        }
        return min;
>>>>>>> Stashed changes

                System.out.print("[" + verkko[i][j] + "]");

            }
            System.out.println();
        }
<<<<<<< Updated upstream
        return verkko;
    }

    private int h(int node_x, int node_y) {
        return heuristiikka[node_x][node_y];
=======
        if(reitti[node_i][node_j]=="r"){
            return false;
        }

        return true;
    }

    private int heuristiikka(String[][]verkko, int node_i, int node_j, int maali_i, int maali_j) {   //palauttaa halutun arvon
        
        return Math.abs(maali_i - node_i) + Math.abs(maali_j - node_j);
>>>>>>> Stashed changes
    }
}
