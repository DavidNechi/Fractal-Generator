/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PyTreeSettings extends JPanel implements ChangeListener {

    JSlider angleSlide;
    JSlider iterationSlide;

    JSlider backroundColorR;
    JSlider backroundColorG;
    JSlider backroundColorB;

    JLabel angleTxt;
    JLabel iterationTxt;

    JLabel backroundTextR;
    JLabel backroundTextG;
    JLabel backroundTextB;

    JComboBox comboBox;
    int comboBoxSelected = 0;

    public PyTreeSettings() {
      
        setVisible(true);
        setPreferredSize(new Dimension(200, 800));
        setBackground(Color.white);

        String[] chooseShape = { "Backround", "Square", "Triangle", "LineColor" };
        comboBox = new JComboBox<>(chooseShape);
        add(comboBox);


        //We use slider for every settings of the tree
        //We set the initial, maximum adn minimum positions
        angleTxt = new JLabel();
        angleTxt.setText("Angle");

        iterationTxt = new JLabel();
        iterationTxt.setText("Iterations");

        backroundTextR = new JLabel();
        backroundTextR.setText("RED");

        backroundTextG = new JLabel();
        backroundTextG.setText("GREEN");

        backroundTextB = new JLabel();
        backroundTextB.setText("BLUE");

        angleSlide = new JSlider(0, 90, 45);
        angleSlide.setValue(45);
        angleSlide.setMajorTickSpacing(10);
        angleSlide.setPaintTicks(true);


        iterationSlide = new JSlider(1, 20, 10);
        iterationSlide.setValue(10);
        iterationSlide.setMajorTickSpacing(2);
        iterationSlide.setPaintTicks(true);

        backroundColorR = new JSlider(1, 256, 10);
        backroundColorR.setValue(10);
        backroundColorR.setMajorTickSpacing(20);
        backroundColorR.setPaintTicks(true);

        backroundColorG = new JSlider(1, 256, 10);
        backroundColorG.setValue(10);
        backroundColorG.setMajorTickSpacing(20);
        backroundColorG.setPaintTicks(true);

        backroundColorB = new JSlider(1, 256, 10);
        backroundColorB.setValue(10);
        backroundColorB.setMajorTickSpacing(20);
        backroundColorB.setPaintTicks(true);

        angleSlide.addChangeListener(this);
        iterationSlide.addChangeListener(this);
        backroundColorR.addChangeListener(this);
        backroundColorG.addChangeListener(this);
        backroundColorB.addChangeListener(this);

        //We add text to know which slider is used
        add(angleTxt);
        add(angleSlide);

        add(iterationTxt);
        add(iterationSlide);

        add(backroundTextR);
        add(backroundColorR);

        add(backroundTextG);
        add(backroundColorG);

        add(backroundTextB);
        add(backroundColorB);

        setLayout(new GridLayout(0, 1));

        comboBox.addActionListener(new ActionListener() {

            //we add a method to save the numbers ion sliders
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBox) {
                    comboBoxSelected = comboBox.getSelectedIndex();
                }

            }

        });

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        PythagorasTree.angle = angleSlide.getValue();
        PythagorasTree.iterations = iterationSlide.getValue();
        if (iterationSlide.getValue() == 0) {
            PythagorasTree.iterations = 16;
        }

        if (comboBoxSelected == 0) {
            PythagorasTree.backgroundColor = new Color(backroundColorR.getValue(), backroundColorG.getValue(),
                    backroundColorB.getValue());
        }
        if (comboBoxSelected == 1) {
            PythagorasTree.squareColor = new Color(backroundColorR.getValue(), backroundColorG.getValue(),
                    backroundColorB.getValue());
        }
        if (comboBoxSelected == 2) {
            PythagorasTree.triangleColor = new Color(backroundColorR.getValue(), backroundColorG.getValue(),
                    backroundColorB.getValue());
        }
        if (comboBoxSelected == 3) {
            PythagorasTree.lineColor = new Color(backroundColorR.getValue(), backroundColorG.getValue(),
                    backroundColorB.getValue());
        }

    }
}