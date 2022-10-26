/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import javax.swing.JSlider;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class MandelBrotSettings extends JPanel implements ChangeListener {
    JLabel complexityText;
    JSlider complexity;

    public MandelBrotSettings() {
        setVisible(true);
        setPreferredSize(new Dimension(200, 800));
        setBackground(Color.white);

        //We create a slider for the complexity of the fractal going up to astronomical numbers
        complexityText = new JLabel();
        complexityText.setText("Complexity");

        complexity = new JSlider(1, 100000, 1);
        complexity.setValue(1);
        complexity.setMajorTickSpacing(10000);
        complexity.setPaintTicks(true);

        complexity.addChangeListener(this);

        add(complexityText);
        add(complexity);
        setLayout(new GridLayout(0, 1));

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        MandelbrotSet.comp = complexity.getValue();
        repaint();
    }

}
