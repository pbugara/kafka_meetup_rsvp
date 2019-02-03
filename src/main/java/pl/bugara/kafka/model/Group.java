package pl.bugara.kafka.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Group {
    private String group_city;
    private String group_country;
    private Long group_id;
    private String group_name;
    private BigDecimal group_lon;
    private BigDecimal group_lat;
    private String group_urlname;
    private List<GroupTopic> group_topics;
}
