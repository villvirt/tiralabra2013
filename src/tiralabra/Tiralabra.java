
package tiralabra;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Tiralabra {

    //testaillaan
    public static void main(String[] args) {
        GUI g = new GUI();
        g.setVisible(true);
        g.setLocationRelativeTo(null);
        g.setTitle("IDA*");
        g.setResizable(false);
        g.pack();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     /*String[][] verkko = new String[10][10];
      String[][] verkko2 = new String[][]{ {" "," "," "," "," "},
                                           {" "," ","r","r","r"},
                                           {" "," ","r"," "," "},
                                           {" "," ","r"," "," "},
                                           {" "," ","r","r","r"}
    };
       String[][] verkko3 = new String[2][8];
       
        IDA ida = new IDA(verkko, 4, 9, 2, 7);      //verkko,maali_i,maali_j,alku_i,alku_j
       ida = new IDA(verkko2, 4, 1, 2, 4);
     //  ida = new IDA(verkko3, 1, 3, 1, 5);
       
       verkko = new String[rnd(19)+2][rnd(19)+2];
       int maali_i=rnd(verkko.length);
       int maali_j=rnd(verkko[0].length);
       int alku_i=rnd(verkko.length);
       int alku_j=rnd(verkko[0].length);
        System.out.print("Maali i:"+ maali_i);
        System.out.println(" j:"+maali_j);
        System.out.print("Alku i:"+alku_i);
        System.out.println(" j:"+alku_j);
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
       for(int i=0;i<verkko.length;i++){
           for(int j=0; j<verkko[0].length;j++){
               if(verkko[i][j]==null){
                   System.out.print("[ ]");
               }
               else{
               System.out.print("["+verkko[i][j]+"]");
               }
           }
           System.out.println("");
           }
        System.out.println("");
        ida = new IDA(verkko,maali_i,maali_j,alku_i,alku_j);*/
    }
    private static int rnd(int vali){    
    return (int)(Math.random() * vali);
    }
}
