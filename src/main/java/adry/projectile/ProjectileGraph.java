package adry.projectile;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

public class ProjectileGraph extends JComponent {


    public Projectile projectile;

    public ProjectileGraph() {
        this.projectile = new Projectile(31, 65);
        this.projectile.setSeconds(2.7);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // you can translate the origin to the middle of the screen with g.translate(); method.
        // Its two arguments are x and y, with -y translating downwards. to get to the required area use
        g.translate(30, getHeight() - 30);

        // Draw light gray graph paper lines
        g.setColor(Color.LIGHT_GRAY);
        int yLines = 0;
        while (yLines <= getHeight() - 30) {
            g.drawLine(0, -yLines, getWidth() - 30, -yLines);
            yLines += 30;
        }

        int xLines = 0;
        while (xLines <= getWidth() - 30) {
            g.drawLine(xLines, 0, xLines, -(getHeight() - 30));
            xLines += 30;
        }

        // make the x and y axes black
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, getWidth() - 30, 0);
        g.drawLine(0, 0, 0, -(getHeight() - 30));

        double prevX = projectile.getX();
        double prevY = projectile.getY();
        double seconds = projectile.getSeconds();

        for (double i = 0; i <= projectile.getApex() * 2 + 1; i += 0.05) {
            projectile.setSeconds(i);
            g.drawLine((int) prevX, (int) prevY, (int) projectile.getX(), (int) -projectile.getY());
            prevX = projectile.getX();
            prevY = -projectile.getY();
        }

        g.setColor(BLUE);
        g.fillOval((int) projectile.getInterceptX() / 2 - 3, (int) -projectile.getPeakY() - 3, 6, 6);

        // Display the Peak in blue text
        String peakText = "(" + projectile.getInterceptX() + ", " + -projectile.getPeakY() + ")";
        g.setColor(BLUE);
        g.drawString(peakText, getWidth() / 2 + 10, getHeight() / 2 + 20);


        // Display the Position at “seconds” as a red dot
        g.setColor(RED);
        g.fillOval((int) projectile.getX() - 3, (int) -projectile.getY() - 3, 6, 6);

        // Display the Position at “seconds” in red text
        String secondsText = "(" + projectile.getX() + ", " + projectile.getY() + ")";
        g.setColor(RED);
        g.drawString(secondsText, -getWidth() / 2 + 10, -getHeight() / 2 + 40);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tell operating system to call paintComponent() again.
        repaint();
    }

}
