package ua.kpi.fict.backendlabs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Long ID;
    private Integer userID;
    private Integer categoryID;
    private Instant recordTime;
    private MonetaryAmount moneySpent;
}
