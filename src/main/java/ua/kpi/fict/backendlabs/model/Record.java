package ua.kpi.fict.backendlabs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer recordID;
    private Integer userID;
    private Integer categoryID;
    private Instant recordTime;
    private MonetaryAmount moneySpent;
}
