package tiralabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Tiralabra {

    //testaillaan
    public static void main(String[] args) {
        System.out.println("Graafinen käyttöliittymä?");
        System.out.println("k/e");
        Scanner scanner = new Scanner(System.in);
        String vastaus = scanner.nextLine();
        if (vastaus.equals("k")) {
            GUI g = new GUI();
            g.setVisible(true);
            g.setLocationRelativeTo(null);
            g.setTitle("IDA*");
            g.setResizable(false);
            g.pack();
            g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            System.out.println("Anna korkeus");
            int kor = 2;
            int lev = 2;
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Anna luku");
                    scanner.next(); // discard
                    continue;
                }
                kor = scanner.nextInt();
                if (kor <= 1) {
                    System.out.print("Pituuden tulee olla 2 tai yli");
                    continue;
                }
                break;
            }
            System.out.println("Anna leveys");
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Anna luku");
                    scanner.next(); // discard
                    continue;
                }
                lev = scanner.nextInt();
                if (lev <= 1) {
                    System.out.print("Pituuden tulee olla 2 tai yli");
                    continue;
                }
                break;
            }
            String[][] verkko = new String[kor][lev];
            int maali_i = rnd(verkko.length);
            int maali_j = rnd(verkko[0].length);
            int alku_i = rnd(verkko.length);
            int alku_j = rnd(verkko[0].length);
            while (alku_i == maali_i && alku_j == maali_j) {
                alku_i = rnd(verkko.length);
                alku_j = rnd(verkko[0].length);
            }
            System.out.print("Maali i:" + maali_i);
            System.out.println(" j:" + maali_j);
            System.out.print("Alku i:" + alku_i);
            System.out.println(" j:" + alku_j);
            for (int i = 0; i < verkko.length; i++) {
                for (int j = 0; j < verkko[0].length; j++) {
                    if (!(i == maali_i && i == alku_i) || !(i == alku_i && j == alku_j)) {
                        int kivi = rnd(4);
                        if (kivi == 3) {
                            verkko[i][j] = "r";

                        }
                    }
                }
            }
            /*
             * for (int i = 0; i < verkko.length; i++) { for (int j = 0; j <
             * verkko[0].length; j++) { if (verkko[i][j] == null) {
             * System.out.print("[ ]"); } else { System.out.print("[" +
             * verkko[i][j] + "]"); } } System.out.println(""); }
             * System.out.println("");
             */
            IDA ida = new IDA(verkko, maali_i, maali_j, alku_i, alku_j, false);

            System.exit(0);
        }
    }

    private static int rnd(int vali) {
        return (int) (Math.random() * vali);
    }
}
