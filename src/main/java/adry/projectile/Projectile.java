package adry.projectile;

public class Projectile {

    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;




    // construct the class
    public Projectile(double angle, double velocity, double seconds) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - .5 * 9.8 * seconds * seconds;
    }

    //when projectile is at its highest
    public double getApex()
    {
        double v = velocity * Math.sin(radians);
        return v / 9.8;
    }
}
