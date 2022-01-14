package org.springframework.samples.petclinic.vacination;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;
    @Autowired
    private PetService petService;

    private static final String VIEW = "vaccination/createOrUpdateVaccinationForm";

    @GetMapping(path="/create")
    public String createVaccination(ModelMap modelmap) {
		Vaccination vaccination = new Vaccination();
		modelmap.put("vaccination", vaccination);
        List<Vaccine> lv = vaccinationService.getAllVaccines();
        modelmap.put("vaccines", lv);
        List<Pet> lp = petService.findAllPets();
        modelmap.put("pets", lp);
		return VIEW;
	}
    
}
