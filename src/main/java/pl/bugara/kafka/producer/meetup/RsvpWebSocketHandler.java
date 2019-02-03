package pl.bugara.kafka.producer.meetup;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import pl.bugara.kafka.producer.RsvpProducer;

@Component
public class RsvpWebSocketHandler extends AbstractWebSocketHandler {

    private RsvpProducer producer;

    public RsvpWebSocketHandler(RsvpProducer producer) {
        this.producer = producer;
    }

    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message) {
        System.out.println(message.getPayload());
        producer.sendRsvpMeessage(message);
    }
}
