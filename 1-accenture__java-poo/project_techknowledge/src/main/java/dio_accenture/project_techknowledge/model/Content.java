package dio_accenture.project_techknowledge.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Content {
    
    @Column(name = "title", nullable = false, length = 100)
    @Size(min = 10, max = 100)
    @NotBlank
    private String title;    
    
    @Column(name = "desc", nullable = false, length = 200)
    @Size(min = 10, max = 200)
    @NotBlank
    private String desc;

    public abstract double calcTotalXP();
}
