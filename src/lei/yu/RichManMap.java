package lei.yu;

public class RichManMap {
    private LandsManager landsManager;
    public RichManMap(LandsManager landsManager) {
        this.landsManager = landsManager;
    }

    public void printMap(){
        for(int i=0;i<29;i++){
            System.out.print(landsManager.getLandsOnTheMap().get(i).displayOnMap());
        }
        System.out.print("\n");
        for(int i=0;i<6;i++){
            System.out.print(landsManager.getLandsOnTheMap().get(69-i).displayOnMap()+"                           ");
            System.out.print(landsManager.getLandsOnTheMap().get(29+i).displayOnMap()+"\n");
        }
        for(int i=63;i>34;i--) {
            System.out.print(landsManager.getLandsOnTheMap().get(i).displayOnMap());
        }
        System.out.print("\n");
    }

}
