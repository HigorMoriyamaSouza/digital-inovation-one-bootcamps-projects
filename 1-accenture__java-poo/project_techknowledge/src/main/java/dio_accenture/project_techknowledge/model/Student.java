package dio_accenture.project_techknowledge.model;

import java.util.LinkedHashSet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "studentId")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "name", nullable = false, length = 50)
    @Size(min = 10, max = 50)
    @NotBlank
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    @Size(min = 10, max = 50)
    @NotBlank
    @Email
    private String email;

    @Column(name = "subscribedContents", nullable = false)
    private LinkedHashSet<Content> subscribedContents = new LinkedHashSet<>();

    @Column(name = "finishedContents", nullable = false)
    private LinkedHashSet<Content> finishedContents = new LinkedHashSet<>();

    public void bootcampInscription() {}
    public void advance() {}
    public double calcTotalXP() {return 1.3;}
    public void showCourses() {}
    
}
