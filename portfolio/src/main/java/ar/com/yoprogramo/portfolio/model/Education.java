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
@Table(name = "estudios")

public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "carrera")
    private String degree;
    
    @Column(name = "fecha_egreso")
    private Year year;
    
    @Column(name = "establecimiento")
    private String institution;
    
    @Column(name = "completa")
    private Boolean finished;
    
    @Column(name = "logo_edu")
    private String logoEdu;

    public Education() {
    }

    public Education(String degree, Year year, String institution, Boolean finished, String logoEdu) {
        this.degree = degree;
        this.year = year;
        this.institution = institution;
        this.finished = finished;
        this.logoEdu = logoEdu;
    }
   
    
}
