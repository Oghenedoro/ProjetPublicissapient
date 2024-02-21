package com.publicis.sapient.demo.enums;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum OrientationTondeuse {
    NORTH('N',"NORTH"),EAST('E',"EAST"),WEST('W',"WEST"),
    SOUTH('S',"SOUTH");

    @Getter
    private char orientation;
    @Getter
    private String orientationName;

    private OrientationTondeuse(char orientation,String orientationName) {
        this.orientation = orientation;
        this.orientationName = orientationName;
    }

    public static OrientationTondeuse getOrientationTondeuse(char orientation){

        for(OrientationTondeuse orientationTondeuse: OrientationTondeuse.values()){
            if(orientationTondeuse.getOrientation() == orientation){
                return orientationTondeuse;
            }
        }
        return null;
    }
}
