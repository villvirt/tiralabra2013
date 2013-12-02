package tiralabra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame implements ActionListener {

    private JButton[][] solmut;
    private Lista reitti;
    private int i = 20; //verkon koko
    private int j = 20;
    private int alku_i = -1;
    private int alku_j = -1;
    private int maali_i = -1;
    private int maali_j = -1;
    private Solmu s;
    private JButton etene;
    private JButton etsi;
    private JButton reset;
    //final JButton random;
    //SIISTI TÄMÄ!!!

    public GUI() {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        this.setLayout(new BorderLayout());  //layout missä mahdollista sano north, west yms.
        JPanel reittiPaneeli = new JPanel(); //paneeli reiteille
        GridLayout grid = new GridLayout(20, 20);
        reittiPaneeli.setLayout(grid);
        solmut = new JButton[i][j];  //solmut
        for (int i = 0; i < solmut.length; i++) {
            for (int j = 0; j < solmut[0].length; j++) {

                solmut[i][j] = new JButton(i + "+" + j);
                solmut[i][j].setPreferredSize(new Dimension(20, 20)); //koko
                reittiPaneeli.add(i + "+" + j, solmut[i][j]);
                solmut[i][j].addActionListener(this);
                solmut[i][j].setBackground(Color.WHITE);
                solmut[i][j].setForeground(Color.WHITE);
                solmut[i][j].setOpaque(true);
            }
        }
        this.add(reittiPaneeli, "West");

        //paneeli napeille
        JPanel nappiPaneeli = new JPanel();
        this.add(nappiPaneeli, "East");
        nappiPaneeli.setLayout(new BoxLayout(nappiPaneeli, BoxLayout.Y_AXIS)); //top to bottom
        etsi = new JButton("Etsi");
        etsi.addActionListener(this);
        nappiPaneeli.add(etsi);
        etene = new JButton("Etene");
        etene.addActionListener(this);
        nappiPaneeli.add(etene);
        reset = new JButton("Reset");
        reset.addActionListener(this);
        nappiPaneeli.add(reset);


    }

    public void actionPerformed(ActionEvent e) {
        String nappi = e.getActionCommand();
        if (onkoNumero(nappi.charAt(0))) {  //jos "solmu"
            int[] koordinaatit = jaaKoordinaatti(nappi);

            int i = koordinaatit[0];
            int j = koordinaatit[1];
            if (solmut[i][j].getBackground()
                    == Color.RED) {
                solmut[i][j].setBackground(Color.BLUE);  //solmusta tulee lähtö
                solmut[i][j].setForeground(Color.BLUE);
                repaint();
            } else if (solmut[i][j].getBackground() == Color.BLUE) {
                solmut[i][j].setBackground(Color.GREEN);  //solmusta tulee maali
                solmut[i][j].setForeground(Color.GREEN);
                repaint();
            } else if (solmut[i][j].getBackground() == Color.GREEN) {
                solmut[i][j].setBackground(Color.WHITE);  //solmusta tulee kuljettava ruutu
                solmut[i][j].setForeground(Color.WHITE);
                repaint();
            } else if (solmut[i][j].getBackground() == Color.WHITE) {
                solmut[i][j].setBackground(Color.RED);  //solmusta tulee este
                solmut[i][j].setForeground(Color.RED);
                repaint();
            }

        } else if (nappi.equals("Reset")) {
            for (int i = 0; i < solmut.length; i++) {
                for (int j = 0; j < solmut[0].length; j++) {
                    solmut[i][j].setBackground(Color.WHITE);
                    solmut[i][j].setForeground(Color.WHITE);
                    alku_i = -1;
                    alku_j = -1;
                    maali_i = -1;
                    maali_j = -1;

                }
            }
            repaint();
        } else if (nappi.equals("Etene")) {


            int[] koordinaatit = jaaKoordinaatti(s.getKey());
            solmut[koordinaatit[0]][koordinaatit[1]].setBackground(Color.BLACK);
            solmut[koordinaatit[0]][koordinaatit[1]].setForeground(Color.BLACK);
            if(s.edellinenListassa()!=null && !s.edellinenListassa().getKey().equals(s.getKey())){
            int[] edellisetKoordinaatit = jaaKoordinaatti(s.edellinenListassa().getKey());
                solmut[edellisetKoordinaatit[0]][edellisetKoordinaatit[1]].setBackground(Color.BLUE);
                solmut[edellisetKoordinaatit[0]][edellisetKoordinaatit[1]].setForeground(Color.BLUE);
            }
            if (s.seuraavaListassa() == null) {
                etene.setEnabled(false);
                
                while(!(koordinaatit[0] ==alku_i && koordinaatit[1]==alku_j)){
                   koordinaatit = jaaKoordinaatti(s.getKey());
                   solmut[koordinaatit[0]][koordinaatit[1]].setBackground(Color.ORANGE);
                    solmut[koordinaatit[0]][koordinaatit[1]].setForeground(Color.ORANGE);
                    s = s.edellinenListassa();
                }
            } else if(s.seuraavaListassa()!=null){
                s = s.seuraavaListassa();
            }

        } else if (nappi.equals("Etsi")) {


            String[][] verkko = new String[solmut.length][solmut[0].length];

            for (int i = 0; i < solmut.length; i++) {
                for (int j = 0; j < solmut[0].length; j++) {
                    if (solmut[i][j].getBackground().equals(Color.RED)) {
                        verkko[i][j] = "r";
                    }
                    if (solmut[i][j].getBackground().equals(Color.BLUE)) {
                        alku_i = i;
                        alku_j = j;
                    }
                    if (solmut[i][j].getBackground().equals(Color.GREEN)) {
                        maali_i = i;
                        maali_j = j;
                    }
                }
            }
            if(alku_i==-1){
              JOptionPane.showMessageDialog(this, "Anna alkupiste", "HUOM!", JOptionPane.ERROR_MESSAGE);
            }
            else if(maali_i==-1){
             JOptionPane.showMessageDialog(this, "Anna maali", "HUOM!", JOptionPane.ERROR_MESSAGE);
            }
            else{
            IDA ida = new IDA(verkko, maali_i, maali_j, alku_i, alku_j);
            reitti = ida.palautaReitti();
            s = reitti.listanAlku();
            }
            /*
             * Solmu s = reitti.listanAlku(); int g=260; int b=-5; Color vari =
             * new Color(0,255,0); while (s != null) { System.out.println(s);
             * int[] koordinaatit = jaaKoordinaatti(s.getKey());
             * if(koordinaatit[0]==alku_i && koordinaatit[1]==alku_j){
             * System.out.println("vaihdetaan varia"); vari=new
             * Color(0,g-10,b+10); } else if(koordinaatit[0]==maali_i &&
             * koordinaatit[1]==maali_j){
             *
             * }
             * else
             * if(solmut[koordinaatit[0]][koordinaatit[1]].getBackground().equals(Color.WHITE)){
             * solmut[koordinaatit[0]][koordinaatit[1]].setBackground(vari);
             * solmut[koordinaatit[0]][koordinaatit[1]].setForeground(vari); }
             * s=s.seuraavaListassa();
            }
             */

        }


    }

    private int[] jaaKoordinaatti(String koordinaatti) {
        int[] koordinaatit = new int[2];
        koordinaatit[0] = Integer.parseInt(koordinaatti.substring(0, koordinaatti.lastIndexOf('+')));
        koordinaatit[1] = Integer.parseInt(koordinaatti.substring(koordinaatti.lastIndexOf('+') + 1));
        return koordinaatit;
    }

    private boolean onkoNumero(char c) {
        if (Character.getNumericValue(c) < 0 || Character.getNumericValue(c) > 9) {
            return false;
        }
        return true;
    }
}
