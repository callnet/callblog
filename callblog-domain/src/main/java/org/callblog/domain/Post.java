package org.callblog.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter @Setter @NoArgsConstructor @ToString
@EntityListeners({AuditingEntityListener.class}) //@CreatedDate 를 사용하기 위함
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @NotEmpty(message = "타이틀은 필수입니다.")
    private String title;

    @NotEmpty(message = "내용은 필수입니다.")
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
