package ua.kpi.fict.backendlabs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Instant recordTime;
    private Double moneySpent;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public void setCategory(Category category) {
//        this.category = category;
//    }
}
