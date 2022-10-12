package ua.kpi.fict.backendlabs.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Integer categoryID; // todo'


    @ManyToMany(mappedBy = "records")
    private List<Category> categories;
    private Instant recordTime;
    private Double moneySpent;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
