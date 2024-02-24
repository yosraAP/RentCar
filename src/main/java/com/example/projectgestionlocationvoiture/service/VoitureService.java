package com.example.projectgestionlocationvoiture.service;

import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public void save(Voiture voiture) {

        voitureRepository.save(voiture);
    }

    public List<Voiture> listsAll() {

        return voitureRepository.findAll();
    }

    public List<Voiture> getVoitureByPrice(float price){
        return this.voitureRepository.findVoitureByPrice(price);

    }

    public List<Voiture> getVoitureByStatus(String status){
        return this.voitureRepository.findVoitureByStatus(status);

    }

    /**
     * Verifier d'abord si le Voiture existe dans la bd avant de le supprimer
     *
     * @param idVoiture du Voiture
     */
    public void deleteByidVoiture(int idVoiture) {
        if (voitureRepository.existsById(idVoiture)) {
            voitureRepository.deleteById(idVoiture);
        }

    }

    public Voiture getVoitureByIdVoiture(int voiture){
        return this.voitureRepository.findVoitureByIdVoiture(voiture);
    }

    public void updateVoitureStatus(Integer idVoiture, String Status) {
        if (voitureRepository.existsById(idVoiture)) {
            Voiture voiture =  voitureRepository.findById(idVoiture).get();
            voiture.setStatus(Status);
            }

    }

}
