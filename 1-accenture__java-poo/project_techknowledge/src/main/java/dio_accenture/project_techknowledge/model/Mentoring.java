package dio_accenture.project_techknowledge.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "mentoring")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "mentoringId", callSuper = false)
public class Mentoring extends Content{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentoringId;

    @Column(name = "startDate", nullable = false)
    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @Override
    public double calcTotalXP() { 
        return 1.0; 
    }

}
