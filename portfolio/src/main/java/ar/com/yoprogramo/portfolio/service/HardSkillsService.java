package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.HardSkills;
import ar.com.yoprogramo.portfolio.repository.HardSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillsService implements IHardSkillsService{
    
    @Autowired
    private HardSkillsRepository hardSkillsRepository;

    @Override
    public List<HardSkills> getHardSkills() {
        List<HardSkills> hardSkillsList = hardSkillsRepository.findAll();
        return hardSkillsList;
    }

    @Override
    public void saveHardSkills(HardSkills hardSkills) {
        hardSkillsRepository.save(hardSkills);
        
    }

    @Override
    public void deleteHardSkills(Long id) {
        hardSkillsRepository.deleteById(id);
    }

    @Override
    public HardSkills findHardSkills(Long id) {
        HardSkills hardSkills = hardSkillsRepository.findById(id).orElse(null);
        return hardSkills;
    }
    
}
