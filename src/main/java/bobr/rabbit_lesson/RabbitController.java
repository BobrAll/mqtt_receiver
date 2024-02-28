package bobr.rabbit_lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class RabbitController {
    private final RabbitTemplate rabbitTemplate;
    private final Exchange appExchange;

    @Value("${spring.rabbitmq.rate-movie-routingKey}")
    private String spamRoutingKey;

    @PostMapping
    ResponseEntity<String> sayHello(@RequestBody String message) {
        System.out.printf("Try to send '%s'\n", message);
        rabbitTemplate.convertAndSend(appExchange.getName(), spamRoutingKey, message);
        return ResponseEntity.ok("Success");
    }
}
