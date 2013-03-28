package lei.yu;

public class RichManAction {
    private RichManMap richManMap = new RichManMap();

    public void setGamerMoveOnTheMap(int steps, RichManGamer gamer){
        gamer.setGamerPosition(gamer.getGamerPosition()+steps);
        richManMap.getSpecifiedLandOnTheMap(gamer.getGamerPosition()).addGamerOnLand(gamer);
    }
}
