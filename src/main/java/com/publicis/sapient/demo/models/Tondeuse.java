package com.publicis.sapient.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @AllArgsConstructor @NoArgsConstructor
public class Tondeuse {

    private String pelouse;
    private String tondeuseAvecOrientation;
    private String pivoterTondeuse;

}
