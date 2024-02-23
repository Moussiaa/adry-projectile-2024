package adry.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // HOMEWORK:
        // Draw a graph that tracks the path of a projectile's arc (series of lines).
        // Add a blue dot at the peak.
        // PR needs a screenshot attached to the description field.

        // you can translate the origin to the middle of the screen with g.translate(); method. Its two arguments are x,y,
        // with -y translating downwards. to get to the middle of the screen use
        //g.translate(0, getHeight());
        g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.PINK);
        g.drawLine(getWidth()/2, -getHeight()/2, getWidth(), getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.ORANGE);
        g.fillRect(400, -400, 25, 25);
        g.setColor(Color.GREEN);
        g.drawOval(200, -200, 50, 50);

        g.fillOval(
                (int) projectile.getX(),
                (int) -projectile.getY(),
                10,
                10
        );
    }

    // create just a setter
    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // now tell operating system to call paintComponent() again.
        repaint();
    }
}
