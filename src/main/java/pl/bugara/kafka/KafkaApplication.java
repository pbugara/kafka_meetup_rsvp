package pl.bugara.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import pl.bugara.kafka.producer.meetup.RsvpWebSocketHandler;

@SpringBootApplication
public class KafkaApplication {

    @Value("${meetup.rsvp.url}")
    private String meetupRsvpUrl;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializeWebsocketConnectionWithMeetup(RsvpWebSocketHandler rsvpWebSocketHandler) {
        return args -> {
            WebSocketClient rsvpSocketClient = new StandardWebSocketClient();
            rsvpSocketClient.doHandshake(
                    rsvpWebSocketHandler, meetupRsvpUrl
            );
        };
    }
}

