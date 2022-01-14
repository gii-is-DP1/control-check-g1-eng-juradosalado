package org.springframework.samples.petclinic.vacination;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;

    public List<Vaccination> getAll(){
        return vaccinationRepository.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return vaccinationRepository.findAllVaccines();
    }

    public Vaccine getVaccine(String typeName) {
        return vaccinationRepository.findVaccineByName(typeName);
    }

    @Transactional
    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {
        PetType petVaccinated = p.getVaccinatedPet().getType();
        PetType vaccineType = p.getVaccine().petType;
        if(petVaccinated.equals(vaccineType)){
           vaccinationRepository.save(p);
        }else{
            
        } 
        return p;   
    }

    
}
