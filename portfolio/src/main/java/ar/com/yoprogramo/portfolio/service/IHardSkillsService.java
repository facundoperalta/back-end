package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.HardSkills;
import java.util.List;


public interface IHardSkillsService {
    public List<HardSkills> getHardSkills();
    
    public void saveHardSkills(HardSkills hardSkills);
    
    public void deleteHardSkills(Long id);
    
    public HardSkills findHardSkills(Long id);
    
}
