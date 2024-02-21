package com.publicis.sapient.demo.parser;

import com.publicis.sapient.demo.enums.OrientationTondeuse;
import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import org.springframework.stereotype.Component;

@Component
public class ParserTondeuseData {

    public static boolean parseTondeuseAvecOrientation(String data){

        StringBuilder builder = new StringBuilder();
        builder.append(OrientationTondeuse.NORTH.getOrientation())
                .append("|").append(OrientationTondeuse.EAST.getOrientation())
                .append("|").append(OrientationTondeuse.WEST.getOrientation())
                .append("|").append(OrientationTondeuse.SOUTH.getOrientation());
        return data.matches("(\\d+) (\\d+) (" + builder.toString()+")");
        }

    public static boolean parserPivoterTondeuse(String pivoterDirection){
        StringBuilder builder = new StringBuilder("");
        builder.append("(").append(PivotisationTondeuse.DROITE.getPivoterTondeuse())
                .append("|").append(PivotisationTondeuse.GAUCHE.getPivoterTondeuse())
                .append("|").append(PivotisationTondeuse.AVANCERTONDEUSE.getPivoterTondeuse())
                .append(")+");

        return pivoterDirection.matches(builder.toString());
    }

    public static boolean parsePelouse(String positionPelouse){
        return positionPelouse.matches("(\\d+) (\\d+)");
    }
}
