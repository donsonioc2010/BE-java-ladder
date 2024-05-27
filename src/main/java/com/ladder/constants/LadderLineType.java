package com.ladder.constants;

public enum LadderLineType {
    VERTICAL("|"),
    HORIZONTAL("-----"),
    EMPTY("     ");


    LadderLineType(String lineType) {
        this.lineType = lineType;
    }
    private final String lineType;

    public String getLineType() {
        return lineType;
    }
}
