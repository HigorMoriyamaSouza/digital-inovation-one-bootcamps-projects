package dio_accenture.project_techknowledge.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bootcamp")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "bootcampId")
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bootcampId;

    @Column(name = "name", nullable = false, length = 50)
    @Size(min = 10, max = 50)
    @NotBlank
    private String name;
    
    @Column(name = "desc", nullable = false, length = 200)
    @Lob
    @Size(min = 10, max = 200)
    @NotBlank
    private String desc;

    @Column(name = "startDate", nullable = false)
    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate = LocalDate.now();

    @Column(name = "finalDate", nullable = false)
    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate finalDate = startDate.plusDays(45);
    
    @Column(name = "content", nullable = false)    
    private LinkedHashSet<Content> content = new LinkedHashSet<>(); 
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private LinkedHashSet<Student> subscribedStudents = new LinkedHashSet<>(); 

}
