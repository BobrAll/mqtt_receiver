package bobr.rabbit_lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
public class RabbitController {
    private final AmqpTemplate template;

    @PostMapping
    ResponseEntity<String> sayHello(@RequestBody String message) {
        template.convertAndSend("myQueue", message);
        return ResponseEntity.ok("Successfully sent to queue");
    }
}
