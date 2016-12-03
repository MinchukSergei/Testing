package calculator;


public class Calculator {
    public int add(int one, int two) {
        return one + two;
    }

    public int sub(int one, int two) {
        return one - two;
    }

    public int div(int one, int two) {
        if (two == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return one / two;
    }

    public int mul(int one, int two) {
        return one * two;
    }
}
