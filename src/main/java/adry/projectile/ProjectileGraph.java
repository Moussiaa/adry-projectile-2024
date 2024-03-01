package adry.projectile;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

public class ProjectileGraph extends JComponent {


    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // you can translate the origin to the middle of the screen with g.translate(); method.
        // Its two arguments are x and y, with -y translating downwards. to get to the middle of the screen use
        g.translate(0, getHeight());

        double prevX = 0;
        double prevY = 0;
        double seconds = projectile.getSeconds();

        for (double i = 0; i <= seconds; i += 0.05) {
            projectile.setSeconds(i);
            g.drawLine((int) prevX, (int) prevY, (int) projectile.getX(), (int) -projectile.getY());
            prevX = projectile.getX();
            prevY = -projectile.getY();
        }

        g.setColor(BLUE);
        g.fillOval((int) projectile.getInterceptX() / 2, (int) -projectile.getPeakY(), 10, 10);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // tell operating system to call paintComponent() again.
        repaint();
    }

}
