package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.SoftSkills;
import java.util.List;


public interface ISoftSkillsService {

    public List<SoftSkills> getSoftSkills();
    
    public void saveSoftSkills(SoftSkills softSkills);
    
    public void deleteSoftSkills(Long id);
    
    public SoftSkills findSoftSkills(Long id);

    
}
