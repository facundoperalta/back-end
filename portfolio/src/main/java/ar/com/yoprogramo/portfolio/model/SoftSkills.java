package ar.com.yoprogramo.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "habilidades_blandas")
public class SoftSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "habilidad_blanda")
    private String softSkill;
    
    @Column(name = "maestría")
    private int mastery;

    public SoftSkills() {
    }

    public SoftSkills(String softSkill, int mastery) {
        this.softSkill = softSkill;
        this.mastery = mastery;
    }
    
}
