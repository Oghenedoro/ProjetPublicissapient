package com.publicis.sapient.demo.models;

import com.publicis.sapient.demo.enums.OrientationTondeuse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode @AllArgsConstructor
public class TondeusePosition {

    private CoordonatesPoints coordonatesPoints;
    private OrientationTondeuse orientationTondeuse;
}
