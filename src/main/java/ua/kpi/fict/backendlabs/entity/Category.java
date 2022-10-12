package ua.kpi.fict.backendlabs.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @NotNull
    private String categoryName;
}
