package enums;


public enum Region {
    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    private String region;

    Region(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}
