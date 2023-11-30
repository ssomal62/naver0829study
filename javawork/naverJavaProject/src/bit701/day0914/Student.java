package bit701.day0914;

public class Student {

    private String name;
    private int Score;
    private String blood;
    public Student(){

    }
    public Student(String name, int score, String blood) {
        this.name = name;
        Score = score;
        this.blood = blood;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood.toUpperCase();
    }
}
