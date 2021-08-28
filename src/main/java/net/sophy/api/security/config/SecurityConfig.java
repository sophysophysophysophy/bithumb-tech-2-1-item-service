package net.sophy.api.security.config;

import lombok.RequiredArgsConstructor;
import net.sophy.api.security.domain.SecurityProvider;
import net.sophy.api.security.filter.SecurityFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// session / cookies 아닌 (staticless ) json token 방식 사용해야 함 ..
// config package : 이미 만들어져 있는 class , domain / filter : 실제 회사 정책 바탕으로 만들어야 하는 classes
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final SecurityProvider provider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        SecurityFilter filter = new SecurityFilter(provider);

//        .class -> complie 끝난것. complie 끝난 클래스 가져옴..
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}

// spring security 순서

