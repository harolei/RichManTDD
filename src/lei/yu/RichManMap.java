package lei.yu;

import java.util.ArrayList;
import java.util.List;

public class RichManMap {
    private List<RichManLand> landsOnTheMap;

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
        landsOnTheMap = new ArrayList<RichManLand>();
        for(int i=0;i<70;i++){
            landsOnTheMap.add(new RichManLand());
            landsOnTheMap.get(i).setLandKind("0");
        }
        landsOnTheMap.get(0).setLandKind("S");
        landsOnTheMap.get(14).setLandKind("H");
        landsOnTheMap.get(28).setLandKind("T");
        landsOnTheMap.get(35).setLandKind("G");
        landsOnTheMap.get(49).setLandKind("P");
        landsOnTheMap.get(63).setLandKind("M");
        for(int i=64;i<70;i++){
            landsOnTheMap.get(i).setLandKind("$");
        }
    }
}
