package net.sophy.api.user.domain;

import lombok.Data;
import net.sophy.api.order.domain.Order;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 8, message = "8자리 이상 입력하세요.")       //보안 정책 : policy (backend에서 결정하여 상의)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "reg_date")
    private String regDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

//    LAZY : 호출할 때만 실행 , EAGER : 즉시실행. 접속권한은 즉시 판단이 필요하기에.
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;
}
