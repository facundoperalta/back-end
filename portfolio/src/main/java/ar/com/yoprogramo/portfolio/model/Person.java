package ar.com.yoprogramo.portfolio.model;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "persona")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    @NotNull
    private String firstName;
    
    @Column(name = "apellido")
    @NotNull
    private String lastName;
    
    @Column(name = "fecha_de_nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    
    @Column(name = "lugar_de_residencia")
    private String place;
    
    @Column(name = "puesto")
    private String occupation;
    
    @Column(name = "foto_de_perfil")
    private String profileImage;
    
    @Column(name = "acerca_de_mi", length=2048)
    private String about;

    public Person() {
    }

    public Person(String firstName, String lastName, Date birthDate, String place, String occupation, String profileImage, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.place = place;
        this.occupation = occupation;
        this.profileImage = profileImage;
        this.about = about;
    }
    
    
    
    
    
}
