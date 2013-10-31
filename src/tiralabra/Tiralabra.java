/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

/**
 *
 * @author Blackstorm
 */
public class Tiralabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista l = new Lista();
       for(int i=1; i<=10; i++){
            Solmu s = new Solmu(Integer.toString((int)(Math.random()*10)+1),(int)(Math.random()*10)+1 );
            l.lisaaSolmu(s);
        }
        System.out.println(l);
        
    }
}
