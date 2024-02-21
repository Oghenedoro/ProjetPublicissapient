package com.publicis.sapient.demo.executerLecture;

import com.publicis.sapient.demo.constants.AppConstants;
import com.publicis.sapient.demo.enums.PivotisationTondeuse;
import com.publicis.sapient.demo.models.TraitemantGlobal;
import com.publicis.sapient.demo.models.Tondeuse;
import com.publicis.sapient.demo.parser.PelouseRecuperation;
import com.publicis.sapient.demo.parser.PivoterTondeuseRecuperation;
import com.publicis.sapient.demo.parser.TondeusePositionRecuperation;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Service
public class LectureEtExecution {

    public List<String> lancerTondeuseTraitement(File file) throws FileNotFoundException {
        List<String> listePositions = new ArrayList<String>();
        if (!file.isFile()) {
            throw new RuntimeException(AppConstants.FILE_NOT_FOUND);
        } else {
            Tondeuse parserTondeuse = new Tondeuse();
            Scanner scanner = new Scanner(file);
            try {
                if (scanner.hasNext()) {
                    parserTondeuse.setPelouse(scanner.nextLine());
                }
                if (!scanner.hasNext()) {
                    throw new RuntimeException(AppConstants.POSITION_NOTCORRECTE);
                }
                while (scanner.hasNext()) {
                    parserTondeuse.setTondeuseAvecOrientation(scanner.nextLine());

                    if (scanner.hasNext()) {
                        parserTondeuse.setPivoterTondeuse(scanner.nextLine());
                        listePositions.add(parserExecuter(parserTondeuse));
                    } else {
                        throw new RuntimeException(AppConstants.DATA_NOTCORRECT);
                    }
                }
                return listePositions;

            } finally {
                 {
                     closeReader(scanner);
                }
            }
        }
    }

    private String parserExecuter(Tondeuse paserTondeuse){

        TraitemantGlobal traitemantGlobal = new TraitemantGlobal();
        traitemantGlobal.setPelouse(PelouseRecuperation.recupererTondeusePosition(paserTondeuse.getPelouse()));
        traitemantGlobal.setTondeusePosition(TondeusePositionRecuperation.recupererTondeusePositionAvecOrientation(paserTondeuse.getTondeuseAvecOrientation()));
        List<PivotisationTondeuse> listPivoter = PivoterTondeuseRecuperation.recupererListDePivotage(paserTondeuse.getPivoterTondeuse());
        traitemantGlobal.setListPivotages(listPivoter);
        traitemantGlobal.executerPivotage();
        System.out.println(traitemantGlobal);
         return traitemantGlobal.toString();
    }
    private void closeReader(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ignored) {}
        }
    }
}


