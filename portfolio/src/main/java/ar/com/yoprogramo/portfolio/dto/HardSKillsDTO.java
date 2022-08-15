package ar.com.yoprogramo.portfolio.dto;

public class HardSkillsDTO {
    
    private String hardSkill;
    
    private String technology;

    private int mastery;

    public HardSkillsDTO() {
    }

    public HardSkillsDTO(String hardSkill, String technology, int mastery) {
        this.hardSkill = hardSkill;
        this.technology = technology;
        this.mastery = mastery;
    }

    public String getHardSkill() {
        return hardSkill;
    }

    public void setHardSkill(String hardSkill) {
        this.hardSkill = hardSkill;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getMastery() {
        return mastery;
    }

    public void setMastery(int mastery) {
        this.mastery = mastery;
    }
    
    

    
}
