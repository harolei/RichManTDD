package lei.yu;

import java.util.ArrayList;
import java.util.List;

public class RichManMap {
    private List<RichManLand> landsOnTheMap= new ArrayList<RichManLand>();

    public RichManMap() {
        setInitialLandKind();
    }

    public String printMap(){
        String map = "";
        for(int i=0;i<29;i++){
            map += landsOnTheMap.get(i).getLandKind();
        }
        map += "\n" + landsOnTheMap.get(69).getLandKind() + "                           " + landsOnTheMap.get(29).getLandKind();
        map += "\n" + landsOnTheMap.get(68).getLandKind() + "                           " + landsOnTheMap.get(30).getLandKind();
        map += "\n" + landsOnTheMap.get(67).getLandKind() + "                           " + landsOnTheMap.get(31).getLandKind();
        map += "\n" + landsOnTheMap.get(66).getLandKind() + "                           " + landsOnTheMap.get(32).getLandKind();
        map += "\n" + landsOnTheMap.get(65).getLandKind() + "                           " + landsOnTheMap.get(33).getLandKind();
        map += "\n" + landsOnTheMap.get(64).getLandKind() + "                           " + landsOnTheMap.get(34).getLandKind() + "\n";

        for(int i=63;i>34;i--) {
            map += landsOnTheMap.get(i).getLandKind();
        }
        return map;
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
