package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("Skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("Skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("Add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "skills/add";
    }

    @PostMapping("Add")
    public String processAddSkillForm(@Valid @ModelAttribute Skill newSkill,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:/skills";
    }

    @GetMapping("/skills/{id}")
    public String displayViewSkill(Model model, @PathVariable int employerId) {

        Optional optSkill = skillRepository.findById(employerId);
        {
            if (optSkill.isPresent()) {
                Skill skill = (Skill) optSkill.get();
                model.addAttribute("skill", skill);
                return "skills/view";
            } else {
                return "skills/not found";
            }
        }

    }
}

