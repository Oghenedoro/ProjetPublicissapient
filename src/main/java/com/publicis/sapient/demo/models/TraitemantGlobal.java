package com.publicis.sapient.demo.models;

import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import com.publicis.sapient.demo.services.impl.APPServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class TraitemantGlobal {

    private Pelouse pelouse;
    private TondeusePosition tondeusePosition;
    private List<PivotisationTondeuse> listPivotages;


    public void executerPivotage() {
        APPServiceImpl servise  = new APPServiceImpl();
        for (PivotisationTondeuse pivotisationTondeuse : listPivotages) {
            servise.avancerTondeuse(tondeusePosition, pivotisationTondeuse, this.pelouse.getCoordonatesData());
        }
      }

    public String toString(){
        return tondeusePosition.getCoordonatesPoints().getX()
                + " "
                + tondeusePosition.getCoordonatesPoints().getY()
                + " "
                + tondeusePosition.getOrientationTondeuse().getOrientation();
    }
}
