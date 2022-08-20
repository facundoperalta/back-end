package ar.com.yoprogramo.portfolio.service;

import ar.com.yoprogramo.portfolio.model.Education;
import ar.com.yoprogramo.portfolio.repository.EducationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService implements IEducationService{
    
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> getEducations() {
        List<Education> educationList = educationRepository.findAll();
        return educationList;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        return education;
    }

    
}
