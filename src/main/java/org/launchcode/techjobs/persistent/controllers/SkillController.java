package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;
    @GetMapping("Skills")
    public String index(Model model) {
        model.addAttribute("Skills", skillRepository.findAll());
        return "skills/index";
    }


}
