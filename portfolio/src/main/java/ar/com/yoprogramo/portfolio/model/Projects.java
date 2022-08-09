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
@Table(name = "proyectos")
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "proyecto")
    private String project;
      
    @Column(name = "resumen")
    private String description;
    
    @Column(name = "enlace")
    private String address;
    
    @Column(name = "imagen_del_proyecto")
    private String projectImage;

    public Projects() {
    }

    public Projects(String project, String description, String address, String projectImage) {
        this.project = project;
        this.description = description;
        this.address = address;
        this.projectImage = projectImage;
    }
    
    
        
}
