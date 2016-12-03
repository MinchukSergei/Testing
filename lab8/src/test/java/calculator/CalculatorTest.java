package calculator;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void prepare() {
        calculator = new Calculator();
    }

    @Test
    public void addPosTest() {
        int res = calculator.add(1, 2);
        Assert.assertEquals(3, res);
    }

    @Test
    public void addNegTest() {
        int res = calculator.add(-1, -2);
        Assert.assertEquals(-3, res);
    }

    @Test
    public void addBorder() {
        int res = calculator.add(Integer.MAX_VALUE, 1);
        Assert.assertEquals(Integer.MIN_VALUE, res);
    }

    @Test
    public void subPosTest() {
        int res = calculator.sub(3, 0);
        Assert.assertEquals(3, res);
    }

    @Test
    public void subNegTest() {
        int res = calculator.sub(-1, -4);
        Assert.assertEquals(3, res);
    }

    @Test
    public void subBorder() {
        int res = calculator.sub(Integer.MIN_VALUE, 1);
        Assert.assertEquals(Integer.MAX_VALUE, res);
    }

    @Test
    public void dividend0Test() {
        int res = calculator.div(0, 3);
        Assert.assertEquals(0, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void delimeter0Test() {
        calculator.div(3, 0);
    }

    @Test
    public void div62Test() {
        int res = calculator.div(6, 2);
        Assert.assertEquals(3, res);
    }

    @Test
    public void div72Test() {
        int res = calculator.div(7, 2);
        Assert.assertEquals(3, res);
    }

    @Test
    public void mulPosTest() {
        int res = calculator.mul(3, 0);
        Assert.assertEquals(0, res);
    }

    @Test
    public void mulNegTest() {
        int res = calculator.mul(-1, -3);
        Assert.assertEquals(3, res);
    }

    @Test
    public void mulBorder() {
        int res = calculator.mul(Integer.MIN_VALUE, 2);
        Assert.assertEquals(0, res);
    }
}
