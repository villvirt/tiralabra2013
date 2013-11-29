
package tiralabra;

public class Tiralabra {

    //testaillaan
    public static void main(String[] args) {
      String[][] verkko = new String[10][10];
       /*String[][] verkko2 = new String[][]{{" "," "," "," "," "},
                                           {" "," "," "," "," "},
                                           {" "," "," ","r"," "},
                                           {" "," "," ","r"," "},
                                           {" "," "," ","r","r"}
    };
       String[][] verkko3 = new String[2][8];
       
        IDA ida = new IDA(verkko, 4, 9, 2, 7);      //verkko,maali_i,maali_j,alku_i,alku_j
        ida = new IDA(verkko2, 4, 2, 2, 4);
       ida = new IDA(verkko3, 1, 3, 1, 5);*/
       
       verkko = new String[rnd(5)+2][rnd(5)+2];
       int maali_i=rnd(verkko.length);
       int maali_j=rnd(verkko[0].length);
       int alku_i=rnd(verkko.length);
       int alku_j=rnd(verkko[0].length);
        System.out.println(maali_i);
        System.out.println(maali_j);
        System.out.println(alku_i);
        System.out.println(alku_j);
       for(int i=0;i<verkko.length;i++){
           for(int j=0; j<verkko[0].length;j++){
               if(!(i==maali_i && i==alku_i) || !(i==alku_i && j==alku_j)){
                   int kivi=rnd(4);
                   if(kivi==3){
                       verkko[i][j]="r";
                       
                   }
               }
           }
       }
       IDA ida = new IDA(verkko,maali_i,maali_j,alku_i,alku_j);
    }
    private static int rnd(int vali){    
    return (int)(Math.random() * vali);
    }
}
