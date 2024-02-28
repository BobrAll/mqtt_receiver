package bobr.rabbit_lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class JmsReceiver {

    @JmsListener(destination = "queue")
    public void receiveMessage(byte[] bytes) {
        System.out.printf("Received message: [%s]\n", new String(bytes));
    }
}
