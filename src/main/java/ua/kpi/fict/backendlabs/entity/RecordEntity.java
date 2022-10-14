package ua.kpi.fict.backendlabs.entity;

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

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

//    public void setCategory(Category category) {
//        this.category = category;
//    }
}
