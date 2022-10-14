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
@ToString
@EqualsAndHashCode
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotNull
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryEntity")
    @ToString.Exclude
    @JsonIgnore
    private List<RecordEntity> recordEntities;

}
