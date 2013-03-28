package lei.yu;

import java.util.ArrayList;
import java.util.List;

public class RichManMap {
    private List<RichManLand> landsOnTheMap= new ArrayList<RichManLand>();

    public RichManMap() {
        setInitialLandKind();
    }

    public RichManLand getSpecifiedLandOnTheMap(int landIndex) {
        return landsOnTheMap.get(landIndex);
    }

    public void printMap(){
        for(int i=0;i<29;i++){
            System.out.print(landsOnTheMap.get(i).displayOnMap());
        }
        System.out.print("\n");
        for(int i=0;i<6;i++){
            System.out.print(landsOnTheMap.get(69-i).displayOnMap()+"                           ");
            System.out.print(landsOnTheMap.get(29+i).displayOnMap()+"\n");
        }
        for(int i=63;i>34;i--) {
            System.out.print(landsOnTheMap.get(i).displayOnMap());
        }
        System.out.print("\n");
    }

    private void setInitialLandKind() {
        setNormalLand();
        setSpecialLand();
    }

    private void setSpecialLand() {
        landsOnTheMap.set(0,new StartPoint());
        landsOnTheMap.set(14,new Hospital());
        landsOnTheMap.set(28,new ToolHouse());
        landsOnTheMap.set(35,new GiftHouse());
        landsOnTheMap.set(49,new Prison());
        landsOnTheMap.set(63,new MagicRoom());
        for(int i=64;i<70;i++){
            landsOnTheMap.set(i,new PointLand());
        }
    }

    private void setNormalLand() {
        for(int i=0;i<70;i++){
            landsOnTheMap.add(new NormalLand());
        }
    }
}
