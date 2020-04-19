package com.jobseeker.logic.service;

import com.jobseeker.dto.Skill;
import com.jobseeker.dto.mapper.SkillMapper;
import com.jobseeker.persistence.SkillRepository;
import com.jobseeker.persistence.entity.SkillEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Autowired
    private SkillRepository skillRepository;


    @Transactional
    public Skill createNewSkill(Skill skill) {
        return saveSkillToDb(skillMapper.toEntity(skill));
    }

    @Transactional
    public Skill updateSkill(Skill updatedSkill, long id) {
        Skill skillById = findSkillById(id);
        if (skillById == null) return null;
        skillById.setSkill(updatedSkill.getSkill());
        skillById.setDescription(updatedSkill.getDescription());
        skillById.setSeniority(updatedSkill.getSeniority());
        return saveSkillToDb(skillMapper.toEntity(skillById));
    }

    @Transactional(readOnly = true)
    public Skill findSkillById(long skillId) {
        Optional<SkillEntity> optSkillEntity = skillRepository.findById(skillId);
        return optSkillEntity
                .map(skillMapper::toSkill)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Skill> findAllSkills() {
        return skillMapper.toSkill(skillRepository.findAll());
    }

    @Transactional
    public boolean deleteSkill(long skillId) {
        Skill skillById = findSkillById(skillId);
        if (skillById == null) {
            return false;
        }
        skillRepository.delete(skillMapper.toEntity(skillById));
        return true;
    }



    private Skill saveSkillToDb(SkillEntity skillEntity) {
        SkillEntity savedSkill = skillRepository.save(skillEntity);
        return skillMapper.toSkill(skillEntity);
    }

}
