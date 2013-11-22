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
       int[][] verkko = new int[10][10];
       int[][] verkko2 = new int[5][5];
       int[][] verkko3 = new int[2][8];
        IDA ida = new IDA(verkko, 4, 9, 2, 7);
        ida = new IDA(verkko2, 4, 2, 2, 4);
       ida = new IDA(verkko3, 1, 3, 1, 5);
    }
}
