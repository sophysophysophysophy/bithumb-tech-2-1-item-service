package net.sophy.api.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.sophy.api.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
//속성 처리하는 클래스
@RequiredArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {
//    커스터마이징한 속성들
    private final long actorId;
    private final String username;
    private final String email;
    private final String name;

//    두 속성은 spring security의 UserDatails에서 관리
    @JsonIgnore
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    @Builder
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getUserId(),            //정책에 따라 커스텀 속성들은 변경 가능
                                    user.getUsername(),
                                    user.getEmail(),
                                    user.getName(),
                                    user.getPassword(),
                                    authorities);
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
