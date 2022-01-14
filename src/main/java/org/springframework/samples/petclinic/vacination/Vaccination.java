package org.springframework.samples.petclinic.vacination;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="vaccinations")
public class Vaccination extends BaseEntity{
    @Column(name = "date", nullable = false)  
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate date;
    
    
    @ManyToOne(optional=false)
    @JoinColumn(name="vaccinated_pet_id")
    private Pet vaccinatedPet;   

    @ManyToOne
    @JoinColumn(name="vaccine_id")
    Vaccine vaccine;
}
