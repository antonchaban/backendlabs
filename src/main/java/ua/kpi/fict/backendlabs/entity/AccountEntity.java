package ua.kpi.fict.backendlabs.entity;


import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private Double currentMoney;

    @OneToOne(mappedBy = "accountEntity")
    private CustomerEntity customerEntity;
}
