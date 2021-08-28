package net.sophy.api.security.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.sophy.api.user.domain.User;
import net.sophy.api.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 기능 처리하는 클래스
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(username+"에 해당하는 객체가 존자하지 않습니다."));
        return UserDetailsImpl.build(user.get());
    }
}
