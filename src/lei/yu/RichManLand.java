package lei.yu;

import java.util.ArrayList;
import java.util.List;

public abstract class RichManLand {
    public static String NORMAL_LAND = "0";
    public static String HOSPITAL = "H";
    public static String TOOL_HOUSE = "T";
    public static String GIFT_HOUSE = "G";
    public static String PRISON = "P";
    public static String MAGIC_ROOM = "M";
    public static String POINT_LAND = "$";
    public static String START_POINT = "S";

    private List<RichManGamer> gamerOnThisLand = new ArrayList<RichManGamer>();

    public abstract String getLandKind();

    public void addGamerOnLand(RichManGamer newComingGamer){
        gamerOnThisLand.add(newComingGamer);
    }

    public void removeGamerOnLand(){
        gamerOnThisLand.remove(0);
    }

    public String displayOnMap(){
        String displayOnMap;
        if(gamerOnThisLand.isEmpty()){
            displayOnMap = getLandKind();
        }
        else{
            displayOnMap = gamerOnThisLand.get(gamerOnThisLand.size()-1).getGamerName();
        }
        return displayOnMap;
    }

}

class NormalLand extends RichManLand {
    private RichManGamer landOwner = null;
    private int landLevel;
    private double price;

    public RichManGamer getLandOwner() {
        return landOwner;
    }

    public void setLandOwner(RichManGamer landOwner) {
        this.landOwner = landOwner;
    }

    public String getLandKind(){
        return RichManLand.NORMAL_LAND;
    }

    public int getLandLevel() {
        return landLevel;
    }

    public void setLandLevel(int landLevel) {
        this.landLevel = landLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Hospital extends RichManLand {
    public String getLandKind() {
        return RichManLand.HOSPITAL;
    }
}

class ToolHouse extends RichManLand {
    public String getLandKind() {
        return RichManLand.TOOL_HOUSE;
    }
}

class GiftHouse extends RichManLand {

    @Override
    public String getLandKind() {
        return RichManLand.GIFT_HOUSE;
    }
}

class Prison extends RichManLand {
    @Override
    public String getLandKind() {
        return RichManLand.PRISON;
    }
}

class MagicRoom extends RichManLand {
    @Override
    public String getLandKind() {
        return RichManLand.MAGIC_ROOM;
    }
}

class PointLand extends RichManLand {
    @Override
    public String getLandKind() {
        return RichManLand.POINT_LAND;
    }
}

class StartPoint extends RichManLand{
    @Override
    public String getLandKind() {
        return RichManLand.START_POINT;
    }
}

