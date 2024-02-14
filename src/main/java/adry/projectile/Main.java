package adry.projectile;

public class Main {
    public static void main (String args[]) {
        Projectile projectile1 = new Projectile(31.00, 65.00);
        projectile1.setSeconds(2.7);
        System.out.println("X: " + projectile1.getX());
        System.out.println("Y: " + projectile1.getY());
        System.out.println("Y Peak: " + projectile1.getPeakY());
        System.out.println("Apex: " + projectile1.getApex());

    }
}
