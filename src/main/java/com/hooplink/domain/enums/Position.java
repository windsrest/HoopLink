package com.hooplink.domain.enums;

public enum Position {
    PG("포인트가드"),
    SG("슈팅가드"),
    SF("스몰포워드"),
    PF("파워포워드"),
    C("센터");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
