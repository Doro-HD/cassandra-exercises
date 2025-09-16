package cassandra.echo.solution;

public class Parrot {
    private String name;

    public Parrot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void repeat(String word) {
        System.out.print(this.name);
        System.out.print(": ");
        System.out.println(word);
    }
}
