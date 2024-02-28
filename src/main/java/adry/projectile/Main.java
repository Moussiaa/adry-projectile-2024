package adry.projectile;

public class Main {
    public static void main (String args[]) {
        ProjectileFrame frame = new ProjectileFrame();
        frame.getContentPane().add(new ProjectileGraph());
        frame.setVisible(true);
    }
}
