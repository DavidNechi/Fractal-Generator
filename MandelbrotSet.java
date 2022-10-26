/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

import java.awt.*;
import javax.swing.*;

public class MandelbrotSet extends JPanel {
    private int MAXITERATIONS = 255;

    public MandelbrotSet() {

    }

    int iterate(double x, double y) {

    
        double zReal = x;
        double zImag = y;

        /*
         * To save the previous z point: z(n-1)
         */
   
        int n = 0;
        while (n < MAXITERATIONS && zReal * zReal + zImag * zImag < 4.0) {
            double tmpReal = zReal;
            double tmpImag = zImag;

            // Mandelbrot drawn
            zReal = zReal * zReal - zImag * zImag + x;
            zImag = 2 * tmpReal * tmpImag + y;

            n++;
        }

        return n;
    }

    public static int comp = 1;

    //we calculate the fractal
    public void drawMandelbrot(Graphics g) {
        int maxX = this.getSize().width;
        int maxY = this.getSize().height;
        int currentPixel;
        for (double x = 0; x < maxX; x++) {
            for (double y = 0; y < maxY; y++) {
                currentPixel = MAXITERATIONS - comp * this.iterate((x - 800) / 300, (y - 400) / 300);
                g.setColor(new Color(currentPixel));
                g.drawRect((int) x, (int) y, 1, 1);
            }

        }
        repaint();
    }

    //we paint the fractal
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMandelbrot(g);
    }

}
