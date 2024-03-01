package adry.projectile;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

public class ProjectileGraph extends JComponent {


    private Projectile projectile = new Projectile(0, 0);

    // HOMEWORK:
    // Draw a graph that tracks the path of a projectile's arc (series of lines).
    // Add a blue dot at the peak.
    // PR needs a screenshot attached to the description field.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // you can translate the origin to the middle of the screen with g.translate(); method. Its two arguments are x,y,
        // with -y translating downwards. to get to the middle of the screen use
        g.translate(0, getHeight());

        double prevX = 0;//projectile.getX();
        double prevY = 0;//projectile.getY();
        double seconds = projectile.getSeconds();


        for (double i = 0; i <= seconds; i+=0.000005) {
            projectile.setSeconds(i);
            g.drawLine((int) prevX, (int) prevY, (int) projectile.getX(), (int)-projectile.getY());
            prevX = projectile.getX();
            prevY = -projectile.getY();
        }

        g.setColor(BLUE);
        g.fillOval((int)projectile.getInterceptX()/2, (int)-projectile.getPeakY(), 10, 10);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // now tell operating system to call paintComponent() again.
        repaint();
    }

}
       /* g.translate(0, getHeight());
        //g.setColor(Color.BLUE);

        for(double i = 0; i < projectile.getInterceptX(); i+= .05) {
            double x = projectile.getX();
            double y = projectile.getY();
            g.drawLine((int) x, (int) -y, (int) projectile.getX(), (int) projectile.getY());
        }


   }



       // create just a setter
    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;

        // now tell operating system to call paintComponent() again.
        repaint();
    }


}

/*Draw projectile path;

       int startX = - getWidth() / 2 + 50;
       int startY = getHeight() / 2 - 50;
       int endX = getWidth() / 2 - 50;
       int endY = startY; // Projectile ends at the same height

       // Draw the initial line
       g.drawLine(startX, startY, endX, endY);

       // Calculate and draw points along the projectile's arc
       double timeStep = 0.05; // Time step for simulation
       double prevX = startX;
       double prevY = startY;
       double time = projectile.getSeconds();
       for (double i = 0; i <= time; i += timeStep) {
           projectile.setSeconds(i);
           double x = startX + projectile.getX();
           double y = startY - projectile.getY();
           g.drawLine((int) prevX, (int) prevY, (int) x, (int) y);
           prevX = x;
           prevY = y;
           System.out.println("printed" + projectile.getInterceptX());
   }

// Draw blue dot at the peak
// double peakX = startX + projectile.getInterceptX();
// double peakY = startY - projectile.getPeakY();
// g.setColor(Color.BLUE);
//g.fillOval((int) peakX - 5, (int) peakY - 5, 10, 10);
//        g.drawString("(100, 100)", 100, -100);
//        g.setColor(Color.PINK);
//        g.drawLine(getWidth()/2, -getHeight()/2, getWidth(), getHeight());
//        g.drawRect(200, -200, 50, 50);
//        g.setColor(Color.ORANGE);
//        g.fillRect(400, -400, 25, 25);
//        g.drawOval(getHeight(), -getWidth(), 1000, 1000); */