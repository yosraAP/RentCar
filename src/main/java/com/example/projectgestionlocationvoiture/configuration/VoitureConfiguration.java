package com.example.projectgestionlocationvoiture.configuration;

import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VoitureConfiguration {
    //@Bean
    CommandLineRunner commandLineRunner (VoitureRepository voitureRepository){
    return args -> {
        Voiture voiture1 = new Voiture(2022,126000,"disponible","audi A4","audiA42022.png","AUDIA415255",1200);
        Voiture voiture2 = new Voiture(2021,110000,"disponible","audi A3","audiA32021.jpg","AUDIA325825",1500);
        Voiture voiture3 = new Voiture(2020,126000,"disponible","Mercedes C300","mercedesC3002020.jpg","MerceC23012354",1700);
        Voiture voiture4 = new Voiture(2022,126000,"disponible","BMW X6","bmwX62022.png","BMW5255",2500);
        Voiture voiture5 = new Voiture(2018,126000,"disponible","volkswagen jetta","VWjetta2018.jpg","VWjet25658",1000);
        Voiture voiture6 = new Voiture(2022,126000,"disponible","audi Q5","audiQ52022.jpg","AUDIQ515255",2250);

        voitureRepository.saveAll(List.of(voiture1,voiture2,voiture3,voiture4,voiture5,voiture6));
    };
}
}
