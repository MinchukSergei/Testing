package calculator;


public class Greeter {
    private int count;

    public Greeter() {
        this(1);
    }

    public Greeter(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("> 0");
        }
        this.count = count;
    }

    public String getGreeting() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("Hello ");
        }
        return sb.toString();
    }
}
