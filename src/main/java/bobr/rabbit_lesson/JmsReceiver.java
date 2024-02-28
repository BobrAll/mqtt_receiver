package bobr.rabbit_lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@EnableRabbit

@Component
@RequiredArgsConstructor
public class JmsReceiver {
    static int counter = 0;

    @JmsListener(destination = "queue")
    public void receiveMessage(@Payload String message) {
        System.out.println("Counter: " + ++counter);
    }
}
