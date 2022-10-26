/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;


public class PhoenixSet extends JPanel{

    private final int MAXITERATIONS = 255;

    // initial constants
    public static double C = 0.56667;
    public static double P = -0.8;

    int iterate(double x, double y) {

        double zReal = y;
        double zImag = x;

        double zPrevRe = 0;
        double zPrevIm = 0;

        int n = 0;
        while (n < MAXITERATIONS && zReal * zReal + zImag * zImag < 4.0) {
            double tmpReal = zReal;
            double tmpImag = zImag;

            zReal = zReal * zReal - zImag * zImag + C + P * zPrevRe;
            zImag = 2 * tmpReal * tmpImag + P * zPrevIm;

            zPrevRe = tmpReal;
            zPrevIm = tmpImag;
            n++;
        }
        return n;
    }

    public void drawPhoenix(Graphics g){
        int maxX = this.getSize().width;
        int maxY = this.getSize().height;
        int currentPixel;
        for(double x = 0; x < maxX; x++) {
            for(double y = 0; y < maxY; y++) {
                currentPixel = this.iterate((x-700)/400 , (y-300)/400);
                int pixel = MAXITERATIONS - currentPixel;
                g.setColor(new Color(pixel, pixel, pixel));

                // g.setColor(new Color(currentPixel));

                g.drawRect((int) x, (int) y, 1, 1);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPhoenix(g);
    }

}


