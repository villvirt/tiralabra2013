
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
            int maara; //kuinka monte naapuria
            while(kasiteltava!=null){ //koko verkko läpi
                System.out.println("Kasiteltavana solmu "+kasiteltava.getKey());
                maara = (int)(Math.random()*solmujenMaara)+1; //kuinka monta naapuria
                for(int j=0; j<maara;j++){
                    int solmu = (int)(Math.random()*solmujenMaara)+1; //mikä solmu lisätään
                    while(solmu==Integer.parseInt(kasiteltava.getKey())){ //ei itseään naapuriksi
                         solmu = (int)(Math.random()*solmujenMaara)+1;
                    }
                     System.out.println("Lisattava solmu: "+solmu);
                     Solmu lisattava=verkko.listanAlku();
                     int pointer=0; //käydään lista läpi ja etsitään oikea solmu
                     while(pointer<solmu-1){
                         lisattava=lisattava.seuraavaListassa();
                        // System.out.println("lisattava"+lisattava);
                         pointer++;
                     }
                     System.out.println("Lisattiin solmu "+lisattava.getKey());
                     Solmu kopio = new Solmu(lisattava.getKey(),lisattava.getArvo());
                     kasiteltava.lisaaNaapuri(kopio);
                }
                kasiteltava=kasiteltava.seuraavaListassa();
             
            }
            Solmu pointer = verkko.listanAlku();
            while(pointer!=null){
                System.out.print(pointer+" ");
                System.out.println("Naapurit:" +pointer.naapuritToString());
                pointer=pointer.seuraavaListassa();
            }
        }
       
    }

