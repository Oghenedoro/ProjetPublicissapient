package com.publicis.sapient.demo.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public enum PivotisationTondeuse {

    DROITE('D', "Pivoter Droite"),GAUCHE('G', "Pivoter Gauche"),
    AVANCERTONDEUSE('A', "Avance tondeuse");

    @Getter
    private char pivoterTondeuse;
    @Getter
    private String pivoterName;


    PivotisationTondeuse(char pivotTondeuse, String pivoterName) {
        this.pivoterTondeuse = pivotTondeuse;
        this.pivoterName = pivoterName;
    }

}
