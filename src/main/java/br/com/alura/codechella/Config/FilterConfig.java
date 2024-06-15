package br.com.alura.codechella.Config;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
public class FilterConfig implements Filter {

    private final String CORRELATION_ID = "X-trace-id";

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        MDC.put (CORRELATION_ID, httpRequest.getHeader (CORRELATION_ID));
        log.info ("intercept incoming request and set MDC context information");
        filterChain.doFilter (servletRequest, servletResponse);

    }
}

