package dev.practice.order.domain.partner;

import com.google.common.base.Strings;
import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter // entity 도메인에는 setter를 하지 않는 것이 좋다(데이터의 변질을 방어하기 위함)
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Partner extends AbstractEntity {

    private static final String PREFIX_PARTNER_ENTITY = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"),
        DISABLE("비활성화");
        private final String desc;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        if (Strings.isNullOrEmpty(partnerName)) throw new RuntimeException("empty partnerName");
        if (Strings.isNullOrEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if (Strings.isNullOrEmpty(email)) throw new RuntimeException("empty email");


        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER_ENTITY);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }


}
