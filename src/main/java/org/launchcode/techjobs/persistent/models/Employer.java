package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Employer extends AbstractEntity {
@NotBlank(message = "Location must be provided")
    private String location;
public Employer() {}
    public Employer(String location) {
        this.location = location;
    }

}
