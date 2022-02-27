package dev.practice.order.domain.notification;

// 알림 관련 서비스를 정의
public interface NotificationService {
    void sendEmail(String email, String title, String desc);
    void sendKakao(String phoneNo, String desc);
    void sendSms(String phoneNo, String desc);
}
