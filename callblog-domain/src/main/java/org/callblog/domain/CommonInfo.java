package org.callblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
@Embeddable
public class CommonInfo {

    @CreatedDate    //@Embeddable 타입에서 사용할 경우 exception 발생으로 주석처리함
    private LocalDateTime regDate;

    private String regId;

    @LastModifiedDate
    private LocalDateTime updDate;

    private String updId;
}
