package lei.yu;

public class RichManGamer {
    private int gamerPosition = 0;
    private String gamerName;

    public RichManGamer(String gamerName) {
        this.gamerName = gamerName;
    }

    public String getGamerName() {
        return gamerName;
    }

    public int getGamerPosition() {
        return gamerPosition;
    }
    public void setGamerPosition(int steps) {
        gamerPosition += steps;
        if(gamerPosition>69)
            gamerPosition -= 70;
    }
}
