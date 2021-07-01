package org.callblog.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @ToString
@EntityListeners({AuditingEntityListener.class}) //@CreatedDate 를 사용하기 위함
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    private String title;

    private String contents;

    @Embedded
    private CommonInfo commonInfo;

//    @CreationTimestamp
//    private LocalDateTime regDate;

//    @UpdateTimestamp
//    private LocalDateTime updDate;

    @Builder
    public Post(String title, String contents, CommonInfo commonInfo) {
        this.title = title;
        this.contents = contents;
        this.commonInfo = commonInfo;
    }
}
