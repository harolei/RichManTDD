package lei.yu;

import java.util.ArrayList;
import java.util.List;

public class LandsManager {
    private List<RichManLand> landsOnTheMap= new ArrayList<RichManLand>();

    public LandsManager(){
        initialLandKind();
        initialLandPrice();
    }

    public List<RichManLand> getLandsOnTheMap() {
        return landsOnTheMap;
    }

    private void initialLandKind() {
        setNormalLand();
        setSpecialLand();
    }

    private void initialLandPrice() {
        NormalLand land;
        for(int i=1;i<28;i++){
            if(i==14){}
            else{
                land = (NormalLand)landsOnTheMap.get(i);
                land.setPrice(200);
            }
        }
        for(int i=29;i<35;i++){
            land = (NormalLand)landsOnTheMap.get(i);
            land.setPrice(500);
        }
        for(int i=36;i<63;i++){
            if(i==49){}
            else{
                land = (NormalLand)landsOnTheMap.get(i);
                land.setPrice(300);
            }
        }
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

    public RichManLand getSpecifiedLandOnTheMap(int landIndex) {
        return landsOnTheMap.get(landIndex);
    }

}
