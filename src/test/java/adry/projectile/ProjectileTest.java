package adry.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {
    @Test
    void getX() {
        // given
        Projectile projectile = new Projectile(31.00, 20.00, 2.70);

        // when
        double actual = projectile.getX();

        // then
        assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {
        // given
        Projectile projectile = new Projectile(31.00, 20.00, 2.70);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(-7.90, actual, 0.01);
    }

    @Test
    public void getApex() {
        // given
        Projectile projectile = new Projectile(31.00, 20.00, 2.70);
        // when
        double actual = projectile.getApex();
        // then
        assertEquals(1.05109811206, actual, 0.01);
    }


}