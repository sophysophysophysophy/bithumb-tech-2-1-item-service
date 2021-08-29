package net.sophy.api.security.config;

import lombok.RequiredArgsConstructor;
import net.sophy.api.security.domain.SecurityProvider;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final SecurityProvider provider;

    @Bean PasswordEncoder encoder() { return new BCryptPasswordEncoder(); }
    @Bean AuthenticationManager manager() throws Exception { return super.authenticationManagerBean(); }
    @Bean ModelMapper mapper() { return new ModelMapper(); }


    @Override
    public void configure(WebSecurity web) throws Exception {

//        ** -> dir , * -> file
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/", "/h2-console/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();   // 뚫렸. 무력화시켜야함.

//        세션 : 무상태
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/users/signup").permitAll()
                .antMatchers("/users/signin").permitAll()
                .antMatchers("/users/findAll").permitAll()
                .antMatchers("/h2-console/**/**").permitAll()
                .anyRequest().authenticated();

        http.exceptionHandling().accessDeniedPage("/login");
//        http.apply(new SecurityConfig(provider));

    }
}
