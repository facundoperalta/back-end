package ar.com.yoprogramo.portfolio.dto;

public class ProjectsDTO {
    
    private String project;
      
    private String description;
    
    private String address;
    
    private String projectImage;

    public ProjectsDTO() {
    }

    public ProjectsDTO(String project, String description, String address, String projectImage) {
        this.project = project;
        this.description = description;
        this.address = address;
        this.projectImage = projectImage;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    
}
