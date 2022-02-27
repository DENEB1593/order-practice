package dev.practice.order.domain.partner;


// 도메인대한 서비스 요구사항을 정의한다
// 인터페이스를 통해 도메인의 서비스를 파악할 수 있도록 정의해야 한다

public interface PartnerService {
    // Command -Criteria --- Info
    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);
}
