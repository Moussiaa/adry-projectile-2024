package adry.projectile;


import adry.projectile.SimpleDocumentListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {
    private JTextField velocityField;
    private JTextField secondsField;
    private JSlider angleAdjuster;
    private JTextField xField;
    private JTextField yField;
    private JLabel interceptXLabel;
    private JLabel peakYLabel;


    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // format JFrame with layout and views
        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel blankSpace = new JLabel();
        JButton calculateButton = new JButton("Calculate");
        peakYLabel = new JLabel("Peak Y:");
        interceptXLabel = new JLabel("X Intercept:");

        // velocity
        velocityField = new JTextField();
        add(velocityLabel);
        add(velocityField);

        // JSlider to display angle from 0-90
        final int MIN = 0;
        final int MAX = 90;
        final int INITIAL = 45;
        angleAdjuster = new JSlider(MIN, MAX, INITIAL);
        angleAdjuster.setMajorTickSpacing(15);
        angleAdjuster.setPaintTicks(true);
        angleAdjuster.setPaintLabels(true);
        add(angleLabel);
        add(angleAdjuster);

        // seconds
        secondsField = new JTextField();
        add(secondsLabel);
        add(secondsField);

        // x & y
        JLabel xLabel = new JLabel("X");
        JLabel xEmpty = new JLabel();
        JLabel yLabel = new JLabel("Y");
        JLabel yEmpty = new JLabel();
        xField = new JTextField();
        yField = new JTextField();
        add(xLabel);
        add(xEmpty);
        add(yLabel);
        add(yEmpty);

        // add row that displays peak y
        add(peakYLabel);
        add(yField);

        // add row that displays x intercept
        add(interceptXLabel);
        add(xField);

        add(blankSpace);
        add(calculateButton);


        // add listeners
        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

        // slider
        angleAdjuster.getChangeListeners();
        angleAdjuster.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                calculate();
            }
        });

        // seconds
        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

        calculateButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Projectile projectile = new Projectile(
                                Double.parseDouble(velocityField.getText()),
                                angleAdjuster.getValue()
                        );
                        projectile.setSeconds(
                                Double.parseDouble(secondsField.getText())
                        );
                        interceptXLabel.setText(Double.toString(projectile.getX()));
                        peakYLabel.setText(Double.toString(projectile.getY()));
                        yField.setText(Double.toString(projectile.getPeakY()));
                        xField.setText(Double.toString(projectile.getInterceptX()));
                    }
                }
        );
    }


    public void calculate() {
        Projectile projectile = new Projectile(
                Double.parseDouble(velocityField.getText()),
                angleAdjuster.getValue()
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        interceptXLabel.setText(Double.toString(projectile.getX()));
        peakYLabel.setText(Double.toString(projectile.getY()));
        yField.setText(Double.toString(projectile.getPeakY()));
        xField.setText(Double.toString(projectile.getInterceptX()));
    }


}

// object oriented programming is when you describe your program in terms of objects and how they relate to each other.
// INHERITANCE (done above), POLYMORPHISM, ABSTRACTION, ENCAPSULATION (an objects member variables are private)
// classes are blueprints for objects, but they can also be extended.
// C = language to do things. Java = language to build things.
