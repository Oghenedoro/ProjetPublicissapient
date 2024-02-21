package com.publicis.sapient.demo;

import com.publicis.sapient.demo.executerLecture.LectureEtExecution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DataInputTest {

    static final String FILE_PATH = "./src/main/resources/";
   @Autowired
    private LectureEtExecution lectureEtExecution;

    private List<String> positionList = new ArrayList<>();

    @Test
    public void testInput() throws FileNotFoundException {
        positionList = lectureEtExecution.lancerTondeuseTraitement(new File(FILE_PATH + "fichierTondeuse.txt"));
        assertNotNull(positionList);
        assertTrue(positionList.size() == 2);
        assertTrue(positionList.contains("1 3 N"));
        assertTrue(positionList.contains("5 1 E"));
    }
}
