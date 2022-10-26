/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

import java.awt.GridLayout;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PheonixSettings extends JPanel implements ChangeListener{

    JSlider numberC;
    JSlider numberP;
    JLabel textC;
    JLabel textP;

    public PheonixSettings() {
        setVisible(true);
        setPreferredSize(new Dimension(200, 800));
        setBackground(Color.white);

        textC = new JLabel();
        textC.setText("C");

        textP = new JLabel();
        textP.setText("P");

        numberC = new JSlider(0, 1,0);
        numberC.setValue(1);
        // numberC.setMajorTickSpacing();
        numberC.setPaintTicks(true);

        numberP = new JSlider(-3, -2, -1);
        numberP.setValue(1);
        // numberP.setMajorTickSpacing(10000);
        numberP.setPaintTicks(true);

        numberC.addChangeListener(this);
        numberP.addChangeListener(this);


        add(textC);
        add(numberC);

        add(textP);
        add(numberP);

        setLayout(new GridLayout(0,1));

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        PhoenixSet.C = numberC.getValue();
        PhoenixSet.P = numberP.getValue();
    }
    
}
