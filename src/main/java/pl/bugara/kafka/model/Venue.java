package pl.bugara.kafka.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Venue {
    private String venue_name;
    private BigDecimal lon;
    private BigDecimal lat;
    private Integer venue_id;
}
