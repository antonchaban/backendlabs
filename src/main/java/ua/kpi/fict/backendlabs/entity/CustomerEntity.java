package ua.kpi.fict.backendlabs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotNull
    private String username;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerEntity")
    @ToString.Exclude
    @JsonIgnore
    private List<RecordEntity> recordEntities;

    public void setRecordEntities(List<RecordEntity> recordEntities) {
        this.recordEntities = recordEntities;
    }
}
