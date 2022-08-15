package ar.com.yoprogramo.portfolio.dto;

import java.time.Year;

public class ExperienceDTO {

    private String job;
    

    private String institution;
    

    private String description;
    

    private Year started;
    

    private Year finished;
    

    private String logoExp;
    

    private Boolean continues;

    public ExperienceDTO() {
    }

    public ExperienceDTO(String job, String institution, String description, Year started, Year finished, String logoExp, Boolean continues) {
        this.job = job;
        this.institution = institution;
        this.description = description;
        this.started = started;
        this.finished = finished;
        this.logoExp = logoExp;
        this.continues = continues;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Year getStarted() {
        return started;
    }

    public void setStarted(Year started) {
        this.started = started;
    }

    public Year getFinished() {
        return finished;
    }

    public void setFinished(Year finished) {
        this.finished = finished;
    }

    public String getLogoExp() {
        return logoExp;
    }

    public void setLogoExp(String logoExp) {
        this.logoExp = logoExp;
    }

    public Boolean getContinues() {
        return continues;
    }

    public void setContinues(Boolean continues) {
        this.continues = continues;
    }
    
    
}
