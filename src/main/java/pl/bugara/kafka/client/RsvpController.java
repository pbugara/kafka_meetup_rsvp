package pl.bugara.kafka.client;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bugara.kafka.model.MeetupRSVP;
import reactor.core.publisher.Flux;

@RestController
public class RsvpController {

    private final ReactiveMongoTemplate mongoTemplate;

    public RsvpController(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping(value = "/rsvps", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MeetupRSVP> getAllMeetupRsvps() {
        return mongoTemplate.tail(
                new Query(), MeetupRSVP.class).share();
    }
}
