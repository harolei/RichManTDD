package lei.yu;

public class RichManGamer {
    private int gamerPosition = 0;
    private String gamerName;
    private double balance = 1000;

    public RichManGamer(String gamerName) {
        this.gamerName = gamerName;
    }

    public String getGamerName() {
        return gamerName;
    }

    public int getGamerPosition() {
        return gamerPosition;
    }
    public void setGamerPosition(int position) {
        gamerPosition = position;
        if(gamerPosition>69)
            gamerPosition -= 70;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void minusBalance(double balance){
        this.balance -= balance;
    }
}
