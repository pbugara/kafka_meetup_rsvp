package pl.bugara.kafka.model;

import lombok.Data;

@Data
public class Member {
    private Long member_id;
    private String photo;
    private String member_name;
}
