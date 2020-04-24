package com.jobseeker.controller;

import com.jobseeker.dto.Skill;
import com.jobseeker.logic.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/web")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(path = "/skills", produces = "application/json")
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> allSkills = skillService.findAllSkills();
        return new ResponseEntity<>(allSkills, HttpStatus.OK);
    }

    @GetMapping(path = "/skills/{id}", produces = "application/json")
    public ResponseEntity<Skill> getSkillById(@PathVariable long id) {
        Skill skillById = skillService.findSkillById(id);
        return new ResponseEntity<>(skillById, HttpStatus.OK);
    }

    @PostMapping(path = "/skills", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Skill> createNewSkill(@RequestBody Skill skill) {
        Skill savedSkill = skillService.createNewSkill(skill);
        return new ResponseEntity<>(savedSkill, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/skills/{id}")
    public boolean deleteSkillById(@PathVariable long id) {
        return skillService.deleteSkill(id);
    }

    // =================================  user's skills  ================================================


}
