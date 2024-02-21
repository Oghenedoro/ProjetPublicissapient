package com.publicis.sapient.demo.parser;

import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PivoterTondeuseRecuperation {

    public static List<PivotisationTondeuse> recupererListDePivotage(String pivotage) {

        List<PivotisationTondeuse> listPivotages = new ArrayList<>();
        for(char myPivot: pivotage.toCharArray()){
            listPivotages.add(getPivoterTondeuse(myPivot));
        }
        return listPivotages;
    }

    public static PivotisationTondeuse getPivoterTondeuse(char pivoter){
        for(PivotisationTondeuse pivotisationTondeuse : PivotisationTondeuse.values()){
            if(pivotisationTondeuse.getPivoterTondeuse() == pivoter){
                return pivotisationTondeuse;
            }
        }
        return null;
    }
}
