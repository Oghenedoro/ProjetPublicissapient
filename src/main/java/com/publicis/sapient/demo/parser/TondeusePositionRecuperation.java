package com.publicis.sapient.demo.parser;

import com.publicis.sapient.demo.constants.AppConstants;
import com.publicis.sapient.demo.enums.OrientationTondeuse;
import com.publicis.sapient.demo.models.CoordonatesPoints;
import com.publicis.sapient.demo.models.TondeusePosition;
//import com.publicis.sapient.demo.services.TondeusePositionInt;
import org.springframework.stereotype.Component;

@Component
public class TondeusePositionRecuperation {

    public static TondeusePosition recupererTondeusePositionAvecOrientation(String positionPoints) {

        String[] arrayPoints = positionPoints.split(AppConstants.SPACE_POINTS_ARRAY);
        CoordonatesPoints coordonatesPoints = new CoordonatesPoints(Integer.valueOf(arrayPoints[0]),Integer.valueOf(arrayPoints[1]));
        OrientationTondeuse orientation  = OrientationTondeuse.getOrientationTondeuse(arrayPoints[2].charAt(0));

        return new TondeusePosition(coordonatesPoints, orientation);
    }
}
