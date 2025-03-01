package com.discushub.discusHub.infra.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(urlPatterns = "/api/**")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Requisicion recebida en: " + LocalDateTime.now());
        filterChain.doFilter(servletRequest, servletResponse);
    }

}