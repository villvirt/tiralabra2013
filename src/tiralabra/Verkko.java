
package tiralabra;

public class Verkko {
    public Verkko(){
        int solmujenMaara=10;
     Lista verkko = new Lista();
       for(int i=solmujenMaara; i>0; i--){
           //tehdään verkon solmut
            Solmu s = new Solmu(Integer.toString(i),(int)(Math.random()*solmujenMaara)+1 );
            verkko.lisaaSolmu(s);
       }
        System.out.println(verkko);
            //luodaan yhteydet
            Solmu kasiteltava=verkko.listanAlku();
            int maara;
            while(kasiteltava!=null){
                System.out.println("Kasiteltavana solmu "+kasiteltava);
                 maara = 1;
               // System.out.println("maara" +maara);
                for(int j=0; j<maara;j++){
                    int solmu = (int)(Math.random()*solmujenMaara)+1;
                    //int solmu=3;
                     System.out.println("Lisattava solmu: "+solmu);
                     Solmu lisattava=verkko.listanAlku();
                     int a=0;
                     while(a<solmu-1){
                         lisattava=lisattava.seuraavaListassa();
                        // System.out.println("lisattava"+lisattava);
                         a++;
                     }
                     System.out.println("Lisattiin solmu "+lisattava);
                     kasiteltava.lisaaNaapuri(lisattava);
                }
                kasiteltava=kasiteltava.seuraavaListassa();
             
            }
        }
       
    }

