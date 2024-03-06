package adry.projectile;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JSlider angleAdjuster;
    private final JTextField fieldX;
    private final JTextField fieldY;
    private final JLabel interceptXlabel = new JLabel("X Intercept:");
    private final JLabel peakYlabel;
    private final JTextField valueX;
    private final JTextField valueY;
    private final ProjectileGraph graph = new ProjectileGraph();


    public ProjectileFrame() {
        setSize(800, 800);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout()); // set a borderlayout to allow multiple areas
        // tells JFrame to use this JPanel component and everything below it
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        // format JFrame with layout and views
        west.setLayout(new GridLayout(8, 2)); // designate it to w area

        // velocity
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocityField = new JTextField();
        west.add(velocityField);

        // angle
        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        // JSlider to display angle from 0-90
        final int min = 0;
        final int max = 90;
        final int initial = 45;
        angleAdjuster = new JSlider(min, max, initial);
        angleAdjuster.setMajorTickSpacing(15);
        angleAdjuster.setPaintTicks(true);
        angleAdjuster.setPaintLabels(true);
        west.add(angleAdjuster);

        // seconds
        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField();
        west.add(secondsField);

        // x & y
        JLabel labelX = new JLabel("X");
        valueX = new JTextField();
        west.add(labelX);
        west.add(valueX);
        JLabel labelY = new JLabel("Y");
        valueY = new JTextField();
        west.add(labelY);
        west.add(valueY);

        // row that displays peak y
        peakYlabel = new JLabel("Peak Y:");
        west.add(peakYlabel);
        fieldY = new JTextField();
        west.add(fieldY);

        // row that displays x intercept
        west.add(interceptXlabel);
        fieldX = new JTextField();
        west.add(fieldX);

        // calculate button
        JLabel blankSpace = new JLabel();
        west.add(blankSpace);
        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

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
                        calculate();
                    }
                }
        );

        main.add(graph, BorderLayout.CENTER);
    }

    public void calculate() {
        try {
            Projectile projectile = new Projectile(
                    angleAdjuster.getValue(),
                    Double.parseDouble(velocityField.getText())
            );
            projectile.setSeconds(
                    Double.parseDouble(secondsField.getText())
            );
            valueX.setText(Double.toString(projectile.getX()));
            valueY.setText(Double.toString(projectile.getY()));
            fieldY.setText(Double.toString(projectile.getPeakY()));
            fieldX.setText(Double.toString(projectile.getInterceptX()));
            graph.setProjectile(projectile);
        } catch (Exception e) {
            // ignore
        }
    }
}



