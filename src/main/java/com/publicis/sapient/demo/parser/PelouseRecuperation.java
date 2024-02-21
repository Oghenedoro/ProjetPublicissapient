package com.publicis.sapient.demo.parser;

import com.publicis.sapient.demo.constants.AppConstants;
import com.publicis.sapient.demo.models.CoordonatesPoints;
import com.publicis.sapient.demo.models.Pelouse;
import org.springframework.stereotype.Component;

@Component
public class PelouseRecuperation {

    public static Pelouse recupererTondeusePosition(String coordinatePonits) {

        String[] arrayPoints =  coordinatePonits.split(AppConstants.SPACE_POINTS_ARRAY);
        CoordonatesPoints coordonatesPoints = new CoordonatesPoints(Integer.valueOf(arrayPoints[0]),Integer.valueOf(arrayPoints[1]));
        Pelouse pelouse = new Pelouse(coordonatesPoints);

        return pelouse;
    }

}
