package calculator;


import org.junit.Assert;
import org.junit.Test;

public class GreeterTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeContsr() {
        new Greeter(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroContsr() {
        new Greeter(0);
    }

    @Test
    public void defaultContsr() {
        Greeter g = new Greeter();
        String res = g.getGreeting();
        Assert.assertEquals("Hello ", res);
    }

    @Test
    public void usualContsr() {
        Greeter g = new Greeter(5);
        String res = g.getGreeting();
        Assert.assertEquals("Hello Hello Hello Hello Hello ", res);
    }
}
