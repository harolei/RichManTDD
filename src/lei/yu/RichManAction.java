package lei.yu;

public class RichManAction {
    private RichManMap richManMap = new RichManMap();

    public void setGamerMoveOnTheMap(int steps, RichManGamer gamer){
        gamer.setGamerPosition(gamer.getGamerPosition()+steps);
        richManMap.getSpecifiedLandOnTheMap(gamer.getGamerPosition()).addGamerOnLand(gamer);
    }

    public void removeGamerOnCurrentLandBeforeMove(RichManGamer gamer){
        richManMap.getSpecifiedLandOnTheMap(gamer.getGamerPosition()).removeGamerOnLand();
    }

    public void buySpecifiedLand(int landIndex, RichManGamer gamer) {
        NormalLand soldLand = (NormalLand)richManMap.getSpecifiedLandOnTheMap(landIndex);
        soldLand.setLandOwner(gamer);
    }

    public RichManMap getRichManMap() {
        return richManMap;
    }
}
