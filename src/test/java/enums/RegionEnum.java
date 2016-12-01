package enums;


public enum RegionEnum {
    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    private String region;

    RegionEnum(String region) {
        this.region = region;
    }

    public String getRegionType() {
        return region;
    }
    public static RegionEnum getRegion(String regionString) {
        for (final RegionEnum regionEnum : RegionEnum.values()) {
            if (regionEnum.getRegionType().trim().equalsIgnoreCase(regionString)) {
                return regionEnum;
            }
        }

        return null;
    }
}
