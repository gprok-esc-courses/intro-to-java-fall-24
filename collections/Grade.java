package collections;

public class Grade {
    private String name;
    private int score;

    public Grade(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
