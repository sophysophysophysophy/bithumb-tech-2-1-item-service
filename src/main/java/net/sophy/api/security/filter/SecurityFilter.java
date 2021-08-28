package net.sophy.api.security.filter;

import lombok.RequiredArgsConstructor;
import net.sophy.api.security.domain.SecurityProvider;
import net.sophy.api.security.exception.SecurityRuntimeException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final SecurityProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = provider.resolveToken(request);
        try {
            if(token != null && provider.validateToken(token)) {        // 인증 조건이 맞으면
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.clearContext();       //기존의 것 지우고
                SecurityContextHolder.getContext().setAuthentication(auth);    // 새로 발급한 토큰 등록

            }
        } catch (SecurityRuntimeException ex) {
            //this is very important, since it guarantees the user is not authenticated at all
            SecurityContextHolder.clearContext();
            response.sendError(ex.getHttpStatus().value(), ex.getMessage());
            return;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);        //계속 체크
    }
}
