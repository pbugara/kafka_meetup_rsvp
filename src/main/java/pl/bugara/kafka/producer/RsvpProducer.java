package pl.bugara.kafka.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;

@Component
@EnableBinding(Source.class)
public class RsvpProducer {

    private static final int MESSAGE_TIMEOUT = 10_000;

    private final Source source;

    public RsvpProducer(Source source) {
        this.source = source;
    }

    public void sendRsvpMeessage(WebSocketMessage<?> message) {
        source.output()
                .send(MessageBuilder.withPayload(message.getPayload())
                    .build(),
                        MESSAGE_TIMEOUT);
    }
}

