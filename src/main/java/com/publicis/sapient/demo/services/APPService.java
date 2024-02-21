package com.publicis.sapient.demo.services;

import com.publicis.sapient.demo.enums.OrientationTondeuse;
import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import com.publicis.sapient.demo.models.CoordonatesPoints;
import com.publicis.sapient.demo.models.TondeusePosition;

public interface APPService {

    public CoordonatesPoints getTondeuseDirections(TondeusePosition position, CoordonatesPoints coordonatesPoints);
    public OrientationTondeuse moveRight(OrientationTondeuse orientation);
    public OrientationTondeuse moveLeft(OrientationTondeuse orientation);
    public void avancerTondeuse(TondeusePosition position, PivotisationTondeuse pivotisationTondeuse,CoordonatesPoints points);
 }