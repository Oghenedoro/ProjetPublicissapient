package com.publicis.sapient.demo.services.impl;

import com.publicis.sapient.demo.constants.AppConstants;
import com.publicis.sapient.demo.enums.OrientationTondeuse;
import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import com.publicis.sapient.demo.models.CoordonatesPoints;
import com.publicis.sapient.demo.models.TondeusePosition;
import com.publicis.sapient.demo.services.APPService;
import org.springframework.stereotype.Service;
import static com.publicis.sapient.demo.enums.OrientationTondeuse.*;

@Service
public class APPServiceImpl implements APPService {

    @Override
    public CoordonatesPoints getTondeuseDirections(TondeusePosition position, CoordonatesPoints coordonatesPoints) {

        CoordonatesPoints lastcoordinateReaches = null;
        int x,y;
        switch (position.getOrientationTondeuse()){
            case NORTH -> {
                x = position.getCoordonatesPoints().getX();
                y = position.getCoordonatesPoints().getY() + 1;
            }

            case EAST -> {
                x = position.getCoordonatesPoints().getX() + 1;
                y = position.getCoordonatesPoints().getY();
            }
            case SOUTH -> {
                x = position.getCoordonatesPoints().getX();
                y = position.getCoordonatesPoints().getY() - 1;
            }
            case WEST -> {
                x = position.getCoordonatesPoints().getX() - 1;
                y = position.getCoordonatesPoints().getY();
            }
            default -> throw new RuntimeException(AppConstants.POSITION_NOTCORRECTE);
        }
        lastcoordinateReaches = new CoordonatesPoints(x, y);
        if(lastcoordinateReaches != null){
            return lastcoordinateReaches;
        }
        return position.getCoordonatesPoints();
    }

    @Override
    public OrientationTondeuse moveRight(OrientationTondeuse orientation) {

        OrientationTondeuse nextOrientation = null;
        switch (orientation){
            case NORTH -> nextOrientation = EAST;
            case EAST -> nextOrientation = SOUTH;
            case SOUTH -> nextOrientation = WEST;
            case WEST -> nextOrientation = NORTH;
        }
        return nextOrientation;
    }

    @Override
    public OrientationTondeuse moveLeft(OrientationTondeuse orientation) {

        OrientationTondeuse nextOrientation = null;
        switch (orientation){

            case NORTH -> nextOrientation = WEST;
            case WEST -> nextOrientation = SOUTH;
            case SOUTH -> nextOrientation = EAST;
            case EAST -> nextOrientation = NORTH;

            default -> throw new RuntimeException(AppConstants.ORIENTATION_NOTCORRECTE);
        }
        return nextOrientation;
    }

    @Override
    public void avancerTondeuse(TondeusePosition position, PivotisationTondeuse pivotisationTondeuse, CoordonatesPoints points) {

        switch (pivotisationTondeuse){

            case AVANCERTONDEUSE -> position.setCoordonatesPoints(getTondeuseDirections(position,points));
            case DROITE -> position.setOrientationTondeuse(moveRight(position.getOrientationTondeuse()));
            case GAUCHE -> position.setOrientationTondeuse(moveLeft(position.getOrientationTondeuse()));

            default -> throw new RuntimeException(AppConstants.PIVOTAGE_NOTCORRECTE);
        }
    }

}
