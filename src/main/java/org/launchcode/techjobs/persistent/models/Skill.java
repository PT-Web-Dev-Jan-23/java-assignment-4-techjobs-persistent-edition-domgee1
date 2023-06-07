package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Skill extends AbstractEntity {
    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 400)
    private String description;

}