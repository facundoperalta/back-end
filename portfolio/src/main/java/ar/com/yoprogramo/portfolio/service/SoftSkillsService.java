package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.SoftSkills;
import ar.com.yoprogramo.portfolio.repository.SoftSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillsService implements ISoftSkillsService{
    @Autowired
    SoftSkillsRepository softSkillsRepository;

    @Override
    public List<SoftSkills> getSoftSkills() {
        List<SoftSkills> softSkillsList = softSkillsRepository.findAll();
        return softSkillsList;
    }

    @Override
    public void saveSoftSkills(SoftSkills softSkills) {
        softSkillsRepository.save(softSkills);
    }

    @Override
    public void deleteSoftSkills(Long id) {
        softSkillsRepository.deleteById(id);
    }

    @Override
    public SoftSkills findSoftSkills(Long id) {
        SoftSkills softSkills = softSkillsRepository.findById(id).orElse(null);
        return softSkills;
    }
    
}
