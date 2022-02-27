package dev.practice.order.infra;

import dev.practice.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {
    @Override
    public void sendEmail(String email, String title, String desc) {
        log.info("sendEmail");
    }

    @Override
    public void sendKakao(String phoneNo, String desc) {
        log.info("sendKakao");
    }

    @Override
    public void sendSms(String phoneNo, String desc) {
        log.info("sendSms");
    }
}
