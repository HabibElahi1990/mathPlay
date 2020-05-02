public class ResultGame {
    private String name;
    private String time;
    private Integer right;
    private Integer wrongs;

    public ResultGame() {
    }

    public ResultGame(String name, String time, Integer right, Integer wrongs) {
        this.name = name;
        this.time = time;
        this.right = right;
        this.wrongs = wrongs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getWrongs() {
        return wrongs;
    }

    public void setWrongs(Integer wrongs) {
        this.wrongs = wrongs;
    }

    @Override
    public String toString() {
        return "ResultGame{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", right=" + right +
                ", wrongs=" + wrongs +
                '}';
    }
}
