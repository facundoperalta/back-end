package ar.com.yoprogramo.portfolio.dto;

import java.time.Year;

public class EducationDTO {
    
    private String degree;
    
    private Year year;
    
    private String institution;
    
    private Boolean finished;
    
    private String logoEdu;

    public EducationDTO() {
    }

    public EducationDTO(String degree, Year year, String institution, Boolean finished, String logoEdu) {
        this.degree = degree;
        this.year = year;
        this.institution = institution;
        this.finished = finished;
        this.logoEdu = logoEdu;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public String getLogoEdu() {
        return logoEdu;
    }

    public void setLogoEdu(String logoEdu) {
        this.logoEdu = logoEdu;
    }
    
    
    
}
