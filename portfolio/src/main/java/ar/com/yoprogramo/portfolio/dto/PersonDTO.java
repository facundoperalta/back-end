package ar.com.yoprogramo.portfolio.dto;

import java.util.Date;

public class PersonDTO {
    
    private String firstName;
    
    private String lastName;
    
    private Date birthDate;
    
    private String place;
    
    private String occupation;
    
    private String profileImage;
    
    private String about;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, Date birthDate, String place, String occupation, String profileImage, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.place = place;
        this.occupation = occupation;
        this.profileImage = profileImage;
        this.about = about;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
        
}
