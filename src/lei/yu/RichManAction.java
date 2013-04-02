package lei.yu;

public class RichManAction {
    private LandsManager landsManager = new LandsManager();
    private RichManMap richManMap = new RichManMap(landsManager);

    public void setGamerMoveOnTheMap(int steps, RichManGamer gamer){
        gamer.setGamerPosition(gamer.getGamerPosition()+steps);
        landsManager.getSpecifiedLandOnTheMap(gamer.getGamerPosition()).addGamerOnLand(gamer);
    }

    public void removeGamerOnCurrentLandBeforeMove(RichManGamer gamer){
        landsManager.getSpecifiedLandOnTheMap(gamer.getGamerPosition()).removeGamerOnLand();
    }

    public void buySpecifiedLand(int landIndex, RichManGamer gamer) {
        NormalLand soldLand = (NormalLand)landsManager.getSpecifiedLandOnTheMap(landIndex);
        soldLand.setLandOwner(gamer);
        gamer.minusBalance(soldLand.getPrice());
    }

    public LandsManager getLandsManager() {
        return landsManager;
    }

    public RichManMap getRichManMap() {
        return richManMap;
    }

    public void upgradeCurrentLand(RichManGamer gamer) {
        NormalLand upgradeCurrentLand = (NormalLand)landsManager.getSpecifiedLandOnTheMap(gamer.getGamerPosition());
        upgradeCurrentLand.setLandLevel(upgradeCurrentLand.getLandLevel()+1);
    }

    public boolean checkIfTheGamerIsOnItOwnLand(RichManGamer gamer, NormalLand currentLand) {
        boolean result = false;
        if(currentLand.getLandOwner().equals(gamer))
            result = true;
        return result;
    }

    public void payTools(RichManGamer gamer, NormalLand currentLand) {
        double tools = currentLand.getPrice()*(currentLand.getLandLevel()+1)*0.5;
        gamer.minusBalance(tools);
        currentLand.getLandOwner().addBalance(tools);
    }
}
