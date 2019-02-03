package pl.bugara.kafka.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rsvp")
@Data
public class MeetupRSVP {
    private Venue venue;
    private String visibility;
    private String response;
    private Integer guests;
    private Member member;
    private Integer rsvp_id;
    private Long mtime;
    private Event event;
    private Group group;
}
