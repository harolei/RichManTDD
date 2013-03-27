package lei.yu;

public abstract class RichManLand {
    public static String NORMAL_LAND = "0";
    public static String HOSPITAL = "H";
    public static String TOOL_HOUSE = "T";
    public static String GIFT_HOUSE = "G";
    public static String PRISON = "P";
    public static String MAGIC_ROOM = "M";
    public static String POINT_LAND = "$";
    public static String START_POINT = "S";

    public abstract String getLandKind();

}

class NormalLand extends RichManLand {
    public String getLandKind(){
        return RichManLand.NORMAL_LAND;
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

