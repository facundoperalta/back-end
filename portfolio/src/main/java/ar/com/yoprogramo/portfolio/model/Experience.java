package ar.com.yoprogramo.portfolio.model;

import java.time.Year;
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
@Table(name = "experiencia_laboral")

public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "trabajo")
    private String job;
    
    @Column(name = "establecimiento")
    private String institution;
    
    @Column(name = "resumen", length=2048)
    private String description;
    
    @Column(name = "fecha_inicio")
    private Year started;
    
    @Column(name = "fecha_fin")
    private Year finished;
    
    @Column(name = "logo_exp")
    private String logoExp;
    
    @Column(name = "actual")
    private Boolean continues;

    public Experience() {
    }

    public Experience(String job, String institution, String description, Year started, Year finished, String logoExp, Boolean continues) {
        this.job = job;
        this.institution = institution;
        this.description = description;
        this.started = started;
        this.finished = finished;
        this.logoExp = logoExp;
        this.continues = continues;
    }
     
}
