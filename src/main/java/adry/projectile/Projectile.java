package adry.projectile;

public class Projectile {

    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private static final double GRAVITY = 9.8;

  // construct the class
    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) { this.seconds = seconds; }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {

        return Math.sin(radians) * velocity * seconds - (.5 * GRAVITY * (seconds * seconds));
    }

    // highest Y value of the Projectile
    public double getPeakY() {
        return (velocity * (Math.sin(radians)) * (velocity * Math.sin(radians)) / (2 * GRAVITY));
    }

    // when projectile is at its highest
    public double getApex() {
        return (velocity * Math.sin(radians)) / GRAVITY;
    }

    // value of x when it crosses the x-axis
    public double getXIntercept() {
        return (2 * velocity * velocity * Math.sin(radians) * Math.cos(radians)) / GRAVITY;
    }

}
