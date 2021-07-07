package org.callblog.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @ToString
@EntityListeners({AuditingEntityListener.class})    //@CreatedDate 를 사용하기 위함
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;

    @Email @NotEmpty
    private String email;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String password;

    private String name;

    @Embedded
    private CommonInfo commonInfo;

    @Builder
    public User(String email, String userId, String password, String name, CommonInfo commonInfo) {
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.commonInfo = commonInfo;
    }
}
