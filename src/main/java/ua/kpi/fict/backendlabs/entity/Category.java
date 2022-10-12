package ua.kpi.fict.backendlabs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Category {
    private Long ID;
    private String categoryName;
}
