package com.publicis.sapient.demo;

import com.publicis.sapient.demo.executerLecture.LectureEtExecution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
public class DemoApplication {


	static final String FILE_PATH = "./src/main/resources/";
    static File file = new File(FILE_PATH+"fichierTondeuse.txt");
	private static LectureEtExecution lectureEtExecution;
	protected static List<String> listResultats;


	public DemoApplication(LectureEtExecution lectureEtExecution) {
		this.lectureEtExecution = lectureEtExecution;
	}

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
			listResultats = lectureEtExecution.lancerTondeuseTraitement(file);
	}

}