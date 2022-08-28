
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
@Table(name = "habilidades_duras")
public class HardSkills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "habilidad_dura")
    private String hardSkill;
    
    @Column(name = "herramienta")
    private String technology;

    
    @Column(name = "maestría")
    private int mastery;

    public HardSkills() {
    }

    public HardSkills(String hardSkill, String technology, int mastery) {
        this.hardSkill = hardSkill;
        this.technology = technology;
        this.mastery = mastery;
    }
   
}
