package ar.com.yoprogramo.portfolio.dto;

public class SoftSkillsDTO {
    
    private String softSkill;
    
    private int mastery;

    public SoftSkillsDTO() {
    }

    public SoftSkillsDTO(String softSkill, int mastery) {
        this.softSkill = softSkill;
        this.mastery = mastery;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public int getMastery() {
        return mastery;
    }

    public void setMastery(int mastery) {
        this.mastery = mastery;
    }
    
}
