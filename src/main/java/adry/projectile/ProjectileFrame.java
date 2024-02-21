package adry.projectile;


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
    private JTextField fieldX;
    private JTextField fieldY;
    private JLabel interceptXlabel;
    private JLabel peakYlabel;


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
        peakYlabel = new JLabel("Peak Y:");
        interceptXlabel = new JLabel("X Intercept:");

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
        JLabel labelX = new JLabel("X");
        JLabel emptyX = new JLabel();
        add(labelX);
        add(emptyX);
        JLabel yLabel = new JLabel("Y");
        JLabel emptyY = new JLabel();
        add(yLabel);
        add(emptyY);
        fieldX = new JTextField();
        fieldY = new JTextField();

        // add row that displays peak y
        add(peakYlabel);
        add(fieldY);

        // add row that displays x intercept
        add(interceptXlabel);
        add(fieldX);

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
                        interceptXlabel.setText(Double.toString(projectile.getX()));
                        peakYlabel.setText(Double.toString(projectile.getY()));
                        fieldY.setText(Double.toString(projectile.getPeakY()));
                        fieldX.setText(Double.toString(projectile.getInterceptX()));
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
        interceptXlabel.setText(Double.toString(projectile.getX()));
        peakYlabel.setText(Double.toString(projectile.getY()));
        fieldY.setText(Double.toString(projectile.getPeakY()));
        fieldX.setText(Double.toString(projectile.getInterceptX()));
    }


}

// object oriented programming is when you describe your program in terms of objects and how they relate to each other.
// INHERITANCE (done above), POLYMORPHISM, ABSTRACTION, ENCAPSULATION (an objects member variables are private)
// classes are blueprints for objects, but they can also be extended.
// C = language to do things. Java = language to build things.
