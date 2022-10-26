/*
 * NAME <Nechitoaia Andrei David>
 * ID <180 6130>
 */
package Fractals;

//We import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener {

    //Create all variables needed
    JMenuItem toggleSettings;
    JMenuItem saveSetting;
    JMenuItem loadSetting;
    JMenuItem pythagorean;
    JMenuItem mandelbrot;
    JMenuItem pheonix;
    JMenuItem exit;
    JLabel label1;
    JLabel label2;

    //We create a label for every fractal's side panel
    CardLayout layout2 = new CardLayout();
    CardLayout layout = new CardLayout();
    JPanel cardPanel = new JPanel(layout);
    JPanel settingsFractal = new JPanel(layout2);
    

    public GUI(String title) {

        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 450));

        //we create a menu bar fro tools and fractals
        //in tools we have load, save and tiglle settings(side Pnels)
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //here we add subcategories to the menu
        JMenu fractalMenu = new JMenu("Fractals");
        JMenu tools = new JMenu("Tools");

        setSize(800, 450);
        JMenu fileMenu = new JMenu("File");

        //we add the menu bar
        menuBar.add(fileMenu);

        //for every subclass of the menu bar we add subclasses
        saveSetting = new JMenuItem("Save Settings");
        loadSetting = new JMenuItem("Load Settings");
        pythagorean = new JMenuItem("Pythagorean Tree");
        mandelbrot = new JMenuItem("MandelBrot set");
        pheonix = new JMenuItem("Pheonix");
        exit = new JMenuItem("Exit");

        toggleSettings = new JMenuItem("Toggle Settigs");

        //we add all action listeners
        saveSetting.addActionListener(this);
        loadSetting.addActionListener(this);
        exit.addActionListener(this);
        toggleSettings.addActionListener(this);
        pythagorean.addActionListener(this);
        pheonix.addActionListener(this);
        mandelbrot.addActionListener(this);

        fileMenu.add(saveSetting);
        fileMenu.add(loadSetting);
        fileMenu.add(exit);

        PythagorasTree fractal1 = new PythagorasTree();
        PhoenixSet fractal2 = new PhoenixSet();
        MandelbrotSet fractal3 = new MandelbrotSet();

        PyTreeSettings settingSlider = new PyTreeSettings();
        MandelBrotSettings settingSlider2 = new MandelBrotSettings();

        //we add a label for every fractal to be presented
        cardPanel.add(fractal1, "Fractal 1");
        cardPanel.add(fractal2, "Fractal 2");
        cardPanel.add(fractal3, "Fractal 3");

        settingsFractal.add(settingSlider, "S1");
        settingsFractal.add(settingSlider2, "S3");

        add(cardPanel);
        add(settingsFractal);

        //we use splitpane to choose between all labels of the fractals
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, settingsFractal, cardPanel);
        getContentPane().add(split);

        tools.add(toggleSettings);

        menuBar.add(tools);
        menuBar.add(fractalMenu);

        fractalMenu.add(pythagorean);
        fractalMenu.add(mandelbrot);
        fractalMenu.add(pheonix);

        pack();
        setVisible(true);
    }

    //for every button we have other action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadSetting) {
            File file = new File("Load.txt");
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String st;
                st = reader.readLine();
                PythagorasTree.angle = Integer.parseInt(st);

                st = reader.readLine();
                PythagorasTree.iterations = Integer.parseInt(st);

                st = reader.readLine();
                MandelbrotSet.comp = Integer.parseInt(st);
                } catch(FileNotFoundException f) {
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == saveSetting) {
            try{
                PrintWriter load = new PrintWriter("Load.txt");
                load.write(String.valueOf(PythagorasTree.angle));
                load.println();
                load.write(String.valueOf(PythagorasTree.iterations));
                load.println();
                load.write(String.valueOf(MandelbrotSet.comp));
                load.close();
            } catch (IOException f){
                System.out.println("Error");
                f.printStackTrace();
            }
        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == pythagorean) {
            layout.show(cardPanel, "Fractal 1");
            layout2.show(settingsFractal, "S1");
        }
        if (e.getSource() == pheonix) {
            layout.show(cardPanel, "Fractal 2");
            layout2.show(settingsFractal, "S2");
        }
        if (e.getSource() == mandelbrot) {
            layout.show(cardPanel, "Fractal 3");
            layout2.show(settingsFractal, "S3");
        }

    }

}