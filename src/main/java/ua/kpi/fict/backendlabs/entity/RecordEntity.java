package ua.kpi.fict.backendlabs.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    private Instant recordTime;
    private Double moneySpent;

    @Transient
    private Long customerID;

    @Transient
    private Long categoryID;
}
